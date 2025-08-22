package net.snijboon.larosa.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation ABYSSAL_WATER_OVERLAY_RL = new ResourceLocation(Larosa.MOD_ID, "misc/in_abyssal_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Larosa.MOD_ID);

    public static final RegistryObject<FluidType> ABYSSAL_WATER_FLUID_TYPE = register("abyssal_water_fluid",
            FluidType.Properties.create().density(1).viscosity(1).canSwim(false).canDrown(false).canHydrate(false));

    public static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, ABYSSAL_WATER_OVERLAY_RL,
                0xA1000820, new Vector3f(0f, 0f, 0f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
