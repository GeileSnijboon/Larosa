package net.snijboon.larosa.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.snijboon.larosa.Larosa;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(Larosa.MOD_ID, "overworld"), 5));
    }
}
