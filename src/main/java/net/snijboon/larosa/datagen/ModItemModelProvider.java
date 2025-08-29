package net.snijboon.larosa.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Larosa.MOD_ID, existingFileHelper);
    }

    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PLACEHOLDER_ITEM);

        simpleItem(ModItems.RAW_OCEANIC_ORE);
        simpleItem(ModItems.OCEANIC_INGOT);
        simpleItem(ModItems.ABYSSAL_FRAGMENT);
        simpleItem(ModItems.ABYSSAL_HEART);
        simpleItem(ModItems.GUARDIANS_SOUL);
        simpleItem(ModItems.ABYSSAL_DIVING_GEAR);
        simpleItem(ModItems.DIVING_GEAR);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Larosa.MOD_ID,"item/" + item.getId().getPath()));
    }
}
