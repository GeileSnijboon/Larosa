package net.snijboon.larosa.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.block.ModBlocks;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Larosa.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_OCEANIC_ORE.get()))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_OCEANIC_ORE.get());
                        pOutput.accept(ModItems.OCEANIC_INGOT.get());

                        pOutput.accept(ModItems.ABYSSAL_FRAGMENT.get());
                        pOutput.accept(ModItems.ABYSSAL_HEART.get());
                        pOutput.accept(ModItems.GUARDIANS_SOUL.get());

                        pOutput.accept(ModItems.ABYSSAL_DIVING_GEAR.get());
                        pOutput.accept(ModItems.DIVING_GEAR.get());

                        pOutput.accept(ModBlocks.OCEANIC_ORE.get());

                        pOutput.accept(ModBlocks.PLACEHOLDER_BLOCK.get());
                        pOutput.accept(ModItems.PLACEHOLDER_ITEM.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ABYSS_TAB = CREATIVE_MODE_TABS.register("abyss_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ABYSSAL_GRASS.get()))
                    .title(Component.translatable("creativetab.abyss_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ABYSSAL_GRASS.get());
                        pOutput.accept(ModBlocks.ABYSSAL_STONE.get());
                        pOutput.accept(ModBlocks.DEEP_ABYSSAL_STONE.get());

                        pOutput.accept(ModBlocks.SOOTH_LOG.get());
                        pOutput.accept(ModBlocks.SOOTH_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_SOOTH_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_SOOTH_WOOD.get());
                        pOutput.accept(ModBlocks.SOOTH_LEAVES.get());
                        pOutput.accept(ModBlocks.SOOTH_PLANKS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
