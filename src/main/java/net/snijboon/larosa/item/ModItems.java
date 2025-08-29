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

    //all ores and ingots
    public static  final RegistryObject<Item> RAW_OCEANIC_ORE = ITEMS.register("raw_oceanic_ore",
            () -> new Item(new Item.Properties()));
    public static  final RegistryObject<Item> OCEANIC_INGOT = ITEMS.register("oceanic_ingot",
            () -> new Item(new Item.Properties()));

    //mob drops
    public static  final RegistryObject<Item> ABYSSAL_FRAGMENT = ITEMS.register("abyssal_fragment",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static  final RegistryObject<Item> GUARDIANS_SOUL = ITEMS.register("guardians_soul",
            () -> new Item(new Item.Properties().stacksTo(1)));

    //abyss
    public static  final RegistryObject<Item> ABYSSAL_HEART = ITEMS.register("abyssal_heart",
            () -> new Item(new Item.Properties().stacksTo(1)));

    //diving gear
    public static  final RegistryObject<Item> DIVING_GEAR = ITEMS.register("diving_gear",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static  final RegistryObject<Item> ABYSSAL_DIVING_GEAR = ITEMS.register("abyssal_diving_gear",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static  final RegistryObject<Item> ABYSSAL_WATER_BUCKET = ITEMS.register("abyssal_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ABYSSAL_WATER, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
