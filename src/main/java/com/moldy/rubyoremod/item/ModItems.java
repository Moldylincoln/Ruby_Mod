package com.moldy.rubyoremod.item;

import com.moldy.rubyoremod.RubyOreMod;
import com.moldy.rubyoremod.item.custom.DowngraderItem;
import com.moldy.rubyoremod.item.custom.HammerItem;
import com.moldy.rubyoremod.item.custom.ModFoodProperties;
import com.moldy.rubyoremod.item.custom.UpgraderItem;
import com.moldy.rubyoremod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RubyOreMod.MODID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL = ITEMS.register("opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UPGRADER = ITEMS.register("upgrader",
            () -> new UpgraderItem(new Item.Properties().stacksTo(1).durability(50)));
    public static final RegistryObject<Item> DOWNGRADER = ITEMS.register("downgrader",
            () -> new DowngraderItem(new Item.Properties().stacksTo(1).durability(150)));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CORN)));

    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 3, -2.4f))));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.RUBY, 1, -2.8f))));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.RUBY, 2, -3.0f))));

    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.RUBY, 7, 0f))));

    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.RUBY, 0, -3f))));



    public static final RegistryObject<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(ModToolTiers.RUBY, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.RUBY, 7, -3.5f))));




    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                        new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));

    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50))));

    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50))));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50))));



    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> RUBY_BOW = ITEMS.register("ruby_bow",
            () -> new BowItem(new Item.Properties().durability(500)));


    public static final RegistryObject<Item> FLASHBACKS_MUSIC_DISC = ITEMS.register("flashbacks_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.FLASHBACKS_KEY).stacksTo(1)));

    public static void register(IEventBus eventbus)
    {
        ITEMS.register(eventbus);
    }
}
