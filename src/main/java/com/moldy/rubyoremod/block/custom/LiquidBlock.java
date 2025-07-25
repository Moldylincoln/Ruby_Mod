package com.moldy.rubyoremod.block.custom;

import com.moldy.rubyoremod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LiquidBlock extends Block {
    public LiquidBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.SLIME_ATTACK, SoundSource.BLOCKS);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == Items.MAGMA_BLOCK) {
                itemEntity.setItem(new ItemStack(Items.LAVA_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.SNOWBALL) {
                itemEntity.setItem(new ItemStack(Items.POWDER_SNOW_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.HEART_OF_THE_SEA) {
                itemEntity.setItem(new ItemStack(Items.WATER_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.CAMPFIRE) {
                itemEntity.setItem(new ItemStack(Items.LAVA_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.SNOW) {
                itemEntity.setItem(new ItemStack(Items.POWDER_SNOW_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.SNOW_BLOCK) {
                itemEntity.setItem(new ItemStack(Items.POWDER_SNOW_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.ICE) {
                itemEntity.setItem(new ItemStack(Items.WATER_BUCKET, itemEntity.getItem().getCount()));
            }

            if(itemEntity.getItem().getItem() == Items.MAGMA_CUBE_SPAWN_EGG) {
                itemEntity.setItem(new ItemStack(Items.LAVA_BUCKET, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);

    }
}
