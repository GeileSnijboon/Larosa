package net.snijboon.larosa.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Larosa.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.OCEANIC_ORE);
        blockWithItem(ModBlocks.PLACEHOLDER_BLOCK);

        blockWithItem(ModBlocks.ABYSSAL_STONE);
        blockWithItem(ModBlocks.DEEP_ABYSSAL_STONE);

        logBlock(((RotatedPillarBlock) ModBlocks.SOOTH_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.SOOTH_WOOD.get()), blockTexture(ModBlocks.SOOTH_LOG.get()), blockTexture(ModBlocks.SOOTH_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SOOTH_LOG.get()), blockTexture(ModBlocks.STRIPPED_SOOTH_LOG.get()),
                new ResourceLocation(Larosa.MOD_ID, "block/stripped_sooth_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SOOTH_WOOD.get()), blockTexture(ModBlocks.STRIPPED_SOOTH_LOG.get()), blockTexture(ModBlocks.STRIPPED_SOOTH_LOG.get()));

        blockItem(ModBlocks.SOOTH_LOG);
        blockItem(ModBlocks.SOOTH_WOOD);
        blockItem(ModBlocks.STRIPPED_SOOTH_LOG);
        blockItem(ModBlocks.STRIPPED_SOOTH_WOOD);

        blockWithItem(ModBlocks.SOOTH_PLANKS);

        leavesBlock(ModBlocks.SOOTH_LEAVES);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Larosa.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
