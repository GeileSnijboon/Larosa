package net.snijboon.larosa.placed_features.foliage;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;

public class ModFoliagePlacers {
    // Deferred register bound to foliage placer registry
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Larosa.MOD_ID);

    // Register our custom placer
    public static final RegistryObject<FoliagePlacerType<SoothTreeFoliagePlacer>> SOOTH_TREE_FOLIAGE =
            FOLIAGE_PLACERS.register("sooth_tree_foliage",
                    () -> new FoliagePlacerType<>(SoothTreeFoliagePlacer.CODEC));
}
