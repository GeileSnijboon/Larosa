package net.snijboon.larosa.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.block.custom.ModFlammableRotatedPillarBlock;
import net.snijboon.larosa.fluid.ModFluids;
import net.snijboon.larosa.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Larosa.MOD_ID);


    public static final RegistryObject<Block> PLACEHOLDER_BLOCK = registerBlock("placeholder_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> OCEANIC_ORE = registerBlock("oceanic_ore",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5).sound(SoundType.DEEPSLATE)));

    //abyss
    public static final RegistryObject<Block> ABYSSAL_GRASS = registerBlock("abyssal_grass",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> ABYSSAL_STONE = registerBlock("abyssal_stone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6).sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> DEEP_ABYSSAL_STONE = registerBlock("deep_abyssal_stone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(8).sound(SoundType.CALCITE)));

    public static final RegistryObject<Block> SOOTH_LOG = registerBlock("sooth_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3)));
    public static final RegistryObject<Block> SOOTH_WOOD = registerBlock("sooth_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3)));
    public static final RegistryObject<Block> STRIPPED_SOOTH_LOG = registerBlock("stripped_sooth_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3)));
    public static final RegistryObject<Block> STRIPPED_SOOTH_WOOD = registerBlock("stripped_sooth_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3)));

    public static final RegistryObject<Block> SOOTH_PLANKS = registerBlock("sooth_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> SOOTH_LEAVES = registerBlock("sooth_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).lightLevel(state -> 15)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });


    public static final RegistryObject<LiquidBlock> ABYSSAL_WATER_BLOCK = BLOCKS.register("abyssal_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ABYSSAL_WATER, BlockBehaviour.Properties.of().noLootTable().replaceable().noCollission().strength(100).sound(SoundType.EMPTY)));


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
