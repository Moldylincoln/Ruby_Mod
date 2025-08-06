package com.moldy.rubyoremod.datagen;

import com.moldy.rubyoremod.RubyOreMod;
import com.moldy.rubyoremod.block.ModBlocks;
import com.moldy.rubyoremod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RubyOreMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LIQUID_BLOCK.get())
                .add(ModBlocks.OPAL_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.URANIUM_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.PLATINUM_BLOCK.get())
                // NONBLOCKS
                .add(ModBlocks.RUBY_STAIRS.get())
                .add(ModBlocks.RUBY_SLAB.get())
                .add(ModBlocks.RUBY_PRESSURE_PLATE.get())
                .add(ModBlocks.RUBY_BUTTON.get())
                .add(ModBlocks.RUBY_FENCE.get())
                .add(ModBlocks.RUBY_FENCE_GATE.get())
                .add(ModBlocks.RUBY_WALL.get())
                .add(ModBlocks.RUBY_DOOR.get())
                .add(ModBlocks.RUBY_TRAPDOOR.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LIQUID_BLOCK.get())
                .add(ModBlocks.OPAL_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.URANIUM_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.PLATINUM_BLOCK.get())
                //NONBLOCKS
                .add(ModBlocks.RUBY_STAIRS.get())
                .add(ModBlocks.RUBY_SLAB.get())
                .add(ModBlocks.RUBY_PRESSURE_PLATE.get())
                .add(ModBlocks.RUBY_BUTTON.get())
                .add(ModBlocks.RUBY_FENCE.get())
                .add(ModBlocks.RUBY_FENCE_GATE.get())
                .add(ModBlocks.RUBY_WALL.get())
                .add(ModBlocks.RUBY_DOOR.get())
                .add(ModBlocks.RUBY_TRAPDOOR.get())
                .add(ModBlocks.RUBY_LAMP.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get());


        tag(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.RUBY_WALL.get());

        tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRET_FOR_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_RUBY_TOOL);

    }
}
