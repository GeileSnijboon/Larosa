package net.snijboon.larosa.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snijboon.larosa.Larosa;
import net.snijboon.larosa.fluid.ModFluids;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Larosa.MOD_ID);

    public static  final RegistryObject<Item> PLACEHOLDER_ITEM = ITEMS.register("placeholder_item",
            () -> new Item(new Item.Properties()));
    public static  final RegistryObject<Item> RAW_OCEANIC_ORE = ITEMS.register("raw_oceanic_ore",
            () -> new Item(new Item.Properties()));



    public static  final RegistryObject<Item> ABYSSAL_WATER_BUCKET = ITEMS.register("abyssal_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ABYSSAL_WATER, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
