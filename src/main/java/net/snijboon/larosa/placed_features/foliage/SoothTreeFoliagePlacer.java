package net.snijboon.larosa.placed_features.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;

public class SoothTreeFoliagePlacer extends FoliagePlacer {
    public static final Codec<SoothTreeFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance).apply(instance, SoothTreeFoliagePlacer::new));

    public SoothTreeFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.SOOTH_TREE_FOLIAGE.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world,
                                 FoliageSetter foliageSetter,
                                 RandomSource random,
                                 TreeConfiguration config,
                                 int trunkHeight,
                                 FoliageAttachment node,
                                 int foliageHeight,
                                 int radius,
                                 int offset) {

        BlockPos center = node.pos();

        // Big dome canopy that scales with trunk height
        for (int y = 0; y <= foliageHeight; y++) {
            int layerRadius = radius + 3 + (trunkHeight / 4) - (y / 2);
            if (layerRadius < 2) layerRadius = 2;

            for (int dx = -layerRadius; dx <= layerRadius; dx++) {
                for (int dz = -layerRadius; dz <= layerRadius; dz++) {
                    double dist = Math.sqrt(dx * dx + dz * dz);

                    if (dist <= layerRadius) {
                        BlockPos leafPos = center.offset(dx, y, dz);

                        // hollow canopy: skip some leaves
                        if (random.nextFloat() < 0.20f) continue;

                        // Only place if near trunk/leaves (to avoid decay)
                        boolean nearSupport = false;
                        for (BlockPos check : BlockPos.betweenClosed(
                                leafPos.offset(-1, -1, -1), leafPos.offset(1, 1, 1))) {
                            if (world.isStateAtPosition(check,
                                    state -> state.is(config.trunkProvider.getState(random, leafPos).getBlock()) ||
                                            state.is(config.foliageProvider.getState(random, leafPos).getBlock()))) {
                                nearSupport = true;
                                break;
                            }
                        }

                        if (nearSupport) {
                            placeLeaf(world, foliageSetter, random, config, leafPos);

                            // Hanging willow leaves from the edge
                            if (Math.abs(dx) >= layerRadius - 1 || Math.abs(dz) >= layerRadius - 1) {
                                if (random.nextFloat() < 0.7f) { // denser hangs
                                    int hangLength = 2 + random.nextInt(4); // 2–5 long
                                    for (int h = 1; h <= hangLength; h++) {
                                        placeLeaf(world, foliageSetter, random, config, leafPos.below(h));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void placeLeaf(LevelSimulatedReader world,
                           FoliageSetter foliageSetter,
                           RandomSource random,
                           TreeConfiguration config,
                           BlockPos pos) {
        BlockState leafState = config.foliageProvider.getState(random, pos);

        // Make sure leaves are persistent
        if (leafState.hasProperty(LeavesBlock.PERSISTENT)) {
            leafState = leafState.setValue(LeavesBlock.PERSISTENT, true);
        }

        foliageSetter.set(pos, leafState);
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return 5 + random.nextInt(3); // 5–7 layers for a big dome
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}