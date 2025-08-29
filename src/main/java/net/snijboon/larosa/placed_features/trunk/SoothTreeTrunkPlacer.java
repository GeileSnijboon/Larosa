package net.snijboon.larosa.placed_features.trunk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class SoothTreeTrunkPlacer extends TrunkPlacer {
    public static final Codec<SoothTreeTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance).apply(instance, SoothTreeTrunkPlacer::new));

    public SoothTreeTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacers.SOOTH_TREE_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level,
                                                            BiConsumer<BlockPos, BlockState> replacer,
                                                            RandomSource random,
                                                            int height,
                                                            BlockPos startPos,
                                                            TreeConfiguration config) {

        List<FoliagePlacer.FoliageAttachment> foliagePoints = new ArrayList<>();
        BlockPos.MutableBlockPos pos = startPos.mutable();

        // Build vertical trunk
        for (int y = 0; y < height; y++) {
            this.placeLog(level, replacer, random, pos, config);


            // Thicker base (only on ground level, never floating)
            if (y == 0) {
                for (Direction dir : Direction.Plane.HORIZONTAL) {
                    if (random.nextFloat() < 0.4f) {
                        this.placeLog(level, replacer, random, pos.relative(dir), config);
                    }
                }
            }

            pos.move(0, 1, 0);
        }

        // Foliage on top of trunk
        foliagePoints.add(new FoliagePlacer.FoliageAttachment(pos, 2, false));
        return foliagePoints;
    }
}