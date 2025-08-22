package net.snijboon.larosa.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.block.ModBlocks;
import net.snijboon.larosa.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Larosa.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_ABYSSAL_WATER = FLUIDS.register("abyssal_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ABYSSAL_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ABYSSAL_WATER = FLUIDS.register("flowing_abyssal_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ABYSSAL_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties ABYSSAL_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ABYSSAL_WATER_FLUID_TYPE, SOURCE_ABYSSAL_WATER, FLOWING_ABYSSAL_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ABYSSAL_WATER_BLOCK).bucket(ModItems.ABYSSAL_WATER_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
