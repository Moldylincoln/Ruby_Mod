package com.moldy.rubyoremod.datagen;

import com.moldy.rubyoremod.RubyOreMod;
import com.moldy.rubyoremod.block.ModBlocks;
import com.moldy.rubyoremod.block.custom.RubyLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RubyOreMod.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.SECRET_RUBY);
        blockWithItem(ModBlocks.OPAL_BLOCK);
        blockWithItem(ModBlocks.LIQUID_BLOCK);
        blockWithItem(ModBlocks.PLATINUM_BLOCK);
        blockWithItem(ModBlocks.URANIUM_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        // NON BLOCKS \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/
        stairsBlock(ModBlocks.RUBY_STAIRS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        slabBlock(ModBlocks.RUBY_SLAB.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        buttonBlock(ModBlocks.RUBY_BUTTON.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        pressurePlateBlock(ModBlocks.RUBY_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        fenceBlock(ModBlocks.RUBY_FENCE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceGateBlock(ModBlocks.RUBY_FENCE_GATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        wallBlock(ModBlocks.RUBY_WALL.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.RUBY_DOOR.get(), modLoc("block/ruby_door_bottom"), modLoc("block/ruby_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.RUBY_TRAPDOOR.get(), modLoc("block/ruby_trapdoor"), true, "cutout");

        blockItem(ModBlocks.RUBY_STAIRS);
        blockItem(ModBlocks.RUBY_SLAB);
        blockItem(ModBlocks.RUBY_PRESSURE_PLATE);
        blockItem(ModBlocks.RUBY_FENCE_GATE);
        blockItem(ModBlocks.RUBY_TRAPDOOR, "_bottom");

        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.RUBY_LAMP.get()).forAllStates(state -> {
            if(state.getValue(RubyLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(RubyOreMod.MODID, "block/" + "ruby_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(RubyOreMod.MODID, "block/" + "ruby_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.RUBY_LAMP.get(), models().cubeAll("ruby_lamp_on",
                ResourceLocation.fromNamespaceAndPath(RubyOreMod.MODID, "block/" + "ruby_lamp_on")));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("rubyoremod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("rubyoremod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}

