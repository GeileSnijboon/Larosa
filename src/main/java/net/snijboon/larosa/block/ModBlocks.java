package net.snijboon.larosa.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.block.custom.AbyssalEndPortal;
import net.snijboon.larosa.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Larosa.MOD_ID);


    public static final RegistryObject<Block> PLACEHOLDER_BLOCK = registerBlock("placeholder_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> OCEANIC_ORE = registerBlock("oceanic_ore",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.DEEPSLATE)));




    public static final RegistryObject<Block> ABYSSAL_END_PORTAL_BLOCK = registerBlock("abyssal_end_portal_block",
            () -> new AbyssalEndPortal(BlockBehaviour.Properties.of().noLootTable().noOcclusion().instabreak().sound(SoundType.SCULK_CATALYST)));


    private static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
