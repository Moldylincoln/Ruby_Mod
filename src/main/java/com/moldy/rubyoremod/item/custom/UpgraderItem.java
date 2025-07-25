package com.moldy.rubyoremod.item.custom;

import com.moldy.rubyoremod.block.ModBlocks;
import com.moldy.rubyoremod.component.ModDataComponentTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class UpgraderItem extends Item {
    private static final Map<Block, Block> UPGRADE_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.DIRT, Blocks.GRASS_BLOCK),
                    Map.entry(Blocks.IRON_BLOCK, ModBlocks.PLATINUM_BLOCK.get()),
                    Map.entry(ModBlocks.PLATINUM_BLOCK.get(), Blocks.GOLD_BLOCK),
                    Map.entry(Blocks.GOLD_BLOCK, ModBlocks.SAPPHIRE_BLOCK.get()),
                    Map.entry(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.RUBY_BLOCK.get()),
                    Map.entry(ModBlocks.RUBY_BLOCK.get(), Blocks.DIAMOND_BLOCK),
                    Map.entry(Blocks.DIAMOND_BLOCK, Blocks.EMERALD_BLOCK),
                    Map.entry(Blocks.EMERALD_BLOCK, Blocks.NETHERITE_BLOCK),
                    Map.entry(Blocks.NETHERITE_BLOCK, ModBlocks.URANIUM_BLOCK.get()),
                    Map.entry(ModBlocks.URANIUM_BLOCK.get(), ModBlocks.OPAL_BLOCK.get())
            );

    public UpgraderItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(UPGRADE_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), UPGRADE_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(10, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.rubyoremod.upgrader.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.rubyoremod.upgrader"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}