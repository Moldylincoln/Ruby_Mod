package com.moldy.rubyoremod.item;

import com.moldy.rubyoremod.RubyOreMod;
import com.moldy.rubyoremod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RubyOreMod.MODID);

    public static final RegistryObject<CreativeModeTab> MINERALS_ITEMS_TAB = CREATIVE_MODE_TABS.register("minerals_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.rubyoremod.ruby_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.OPAL.get());
                        output.accept(ModItems.PLATINUM.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.URANIUM.get());
                        output.accept(ModItems.CORN.get());
                        output.accept(ModItems.UPGRADER.get());
                        output.accept(ModItems.DOWNGRADER.get());

                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_PICKAXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_HOE.get());
                        output.accept(ModItems.RUBY_HAMMER.get());

                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());
                        output.accept(ModItems.RUBY_HORSE_ARMOR.get());

                        output.accept(ModItems.RUBY_BOW.get());
                        output.accept(ModItems.FLASHBACKS_MUSIC_DISC.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MINERALS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("minerals_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK.get()))
                    .withTabsBefore(MINERALS_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.rubyoremod.ruby_block"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.OPAL_BLOCK.get());
                        output.accept(ModBlocks.PLATINUM_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.URANIUM_BLOCK.get());
                        output.accept(ModBlocks.LIQUID_BLOCK.get());
                        //
                        output.accept(ModBlocks.RUBY_STAIRS.get());
                        output.accept(ModBlocks.RUBY_SLAB.get());

                        output.accept(ModBlocks.RUBY_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.RUBY_BUTTON.get());

                        output.accept(ModBlocks.RUBY_FENCE.get());
                        output.accept(ModBlocks.RUBY_FENCE_GATE.get());
                        output.accept(ModBlocks.RUBY_WALL.get());

                        output.accept(ModBlocks.RUBY_DOOR.get());
                        output.accept(ModBlocks.RUBY_TRAPDOOR.get());
                        //
                        output.accept(ModBlocks.RUBY_LAMP.get());

                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
