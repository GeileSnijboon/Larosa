package net.snijboon.larosa.placed_features.trunk;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;

public class ModTrunkPlacers {
    // Deferred register bound to trunk placer registry
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Larosa.MOD_ID);

    // Register our custom placer
    public static final RegistryObject<TrunkPlacerType<SoothTreeTrunkPlacer>> SOOTH_TREE_TRUNK_PLACER =
            TRUNK_PLACERS.register("sooth_tree_trunk_placer",
                    () -> new TrunkPlacerType<>(SoothTreeTrunkPlacer.CODEC));
}
