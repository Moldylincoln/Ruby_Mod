package com.moldy.rubyoremod.datagen;

import com.moldy.rubyoremod.RubyOreMod;
import com.moldy.rubyoremod.block.ModBlocks;
import com.moldy.rubyoremod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_block_from_ruby");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get())).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_from_ruby_block");




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPAL_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL.get()), has(ModItems.OPAL.get())).save(pRecipeOutput, RubyOreMod.MODID + ":opal_block_from_opal");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPAL.get(), 9)
                .requires(ModBlocks.OPAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OPAL_BLOCK.get()), has(ModBlocks.OPAL_BLOCK.get())).save(pRecipeOutput, RubyOreMod.MODID + ":opal_from_opal_block");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATINUM_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PLATINUM.get())
                .unlockedBy(getHasName(ModItems.PLATINUM.get()), has(ModItems.PLATINUM.get())).save(pRecipeOutput, RubyOreMod.MODID + ":plat_block_from_plat");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPAL.get(), 9)
                .requires(ModBlocks.PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PLATINUM_BLOCK.get()), has(ModBlocks.PLATINUM_BLOCK.get())).save(pRecipeOutput, RubyOreMod.MODID + ":plat_from_plat_block");



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get())).save(pRecipeOutput, RubyOreMod.MODID + ":sapphire_block_from_sapphire");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get())).save(pRecipeOutput, RubyOreMod.MODID + ":sapphire_from_sapphire_block");




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.URANIUM_BLOCK.get())
                .pattern("UUU")
                .pattern("UUU")
                .pattern("UUU")
                .define('U', ModItems.URANIUM.get())
                .unlockedBy(getHasName(ModItems.URANIUM.get()), has(ModItems.URANIUM.get())).save(pRecipeOutput, RubyOreMod.MODID + ":uranium_block_from_uranium");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.URANIUM.get(), 9)
                .requires(ModBlocks.URANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.URANIUM_BLOCK.get()), has(ModBlocks.URANIUM_BLOCK.get())).save(pRecipeOutput, RubyOreMod.MODID + ":uranium_from_uranium_block");




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIQUID_BLOCK.get())
                .pattern(" W ")
                .pattern("LIE")
                .pattern(" W ")
                .define('W', Items.WATER_BUCKET)
                .define('L', Items.POWDER_SNOW_BUCKET)
                .define('I', Items.IRON_BLOCK)
                .define('E', Items.LAVA_BUCKET)

                .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK)).save(pRecipeOutput, RubyOreMod.MODID + ":liquid_block_from_liquids");

        stairBuilder(ModBlocks.RUBY_BLOCK.get(), Ingredient.of(ModItems.RUBY.get())).group("ruby")
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB.get(), ModItems.RUBY.get());


        buttonBuilder(ModBlocks.RUBY_BUTTON.get(), Ingredient.of(ModItems.RUBY.get())).group("ruby")
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.RUBY_PRESSURE_PLATE.get(), ModItems.RUBY.get());

        fenceBuilder(ModBlocks.RUBY_FENCE.get(), Ingredient.of(ModItems.RUBY.get())).group("ruby")
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.RUBY_FENCE_GATE.get(), Ingredient.of(ModItems.RUBY.get())).group("ruby")
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL.get(), ModItems.RUBY.get());

        doorBuilder(ModBlocks.RUBY_DOOR.get(), Ingredient.of(ModItems.RUBY.get())).group("ruby")
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.RUBY_TRAPDOOR.get(), Ingredient.of(ModItems.RUBY.get())).group("ruby")
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('N', Items.NETHERITE_SWORD)
                .define('R', ModItems.RUBY.get())

                .unlockedBy(getHasName(Items.NETHERITE_SWORD), has(Items.NETHERITE_SWORD)).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_sword_from_netherite_ruby");
        //shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('N', Items.NETHERITE_SHOVEL)
                .define('R', ModItems.RUBY.get())

                .unlockedBy(getHasName(Items.NETHERITE_SHOVEL), has(Items.NETHERITE_SHOVEL)).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_shovel_from_netherite_ruby");
        //pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('N', Items.NETHERITE_PICKAXE)
                .define('R', ModItems.RUBY.get())

                .unlockedBy(getHasName(Items.NETHERITE_PICKAXE), has(Items.NETHERITE_PICKAXE)).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_pickaxe_from_netherite_ruby");
        //hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('N', Items.NETHERITE_HOE)
                .define('R', ModItems.RUBY.get())

                .unlockedBy(getHasName(Items.NETHERITE_HOE), has(Items.NETHERITE_HOE)).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_hoe_from_netherite_ruby");
        //axe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('N', Items.NETHERITE_AXE)
                .define('R', ModItems.RUBY.get())

                .unlockedBy(getHasName(Items.NETHERITE_AXE), has(Items.NETHERITE_AXE)).save(pRecipeOutput, RubyOreMod.MODID + ":ruby_axe_from_netherite_ruby");
    }
}
