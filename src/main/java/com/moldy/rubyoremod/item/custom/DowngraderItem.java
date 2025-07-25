package com.moldy.rubyoremod.item.custom;

import com.moldy.rubyoremod.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
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

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class DowngraderItem extends Item {
    private static final Map<Block, Block> DOWNGRADE_MAP =
            Map.ofEntries(
                    Map.entry(ModBlocks.OPAL_BLOCK.get(), ModBlocks.URANIUM_BLOCK.get()),
                    Map.entry(ModBlocks.URANIUM_BLOCK.get(), Blocks.NETHERITE_BLOCK),
                    Map.entry(Blocks.NETHERITE_BLOCK, Blocks.EMERALD_BLOCK),
                    Map.entry(Blocks.EMERALD_BLOCK, Blocks.DIAMOND_BLOCK),
                    Map.entry(Blocks.DIAMOND_BLOCK, ModBlocks.RUBY_BLOCK.get()),
                    Map.entry(ModBlocks.RUBY_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get()),
                    Map.entry(ModBlocks.SAPPHIRE_BLOCK.get(), Blocks.GOLD_BLOCK),
                    Map.entry(Blocks.GOLD_BLOCK, ModBlocks.PLATINUM_BLOCK.get()),
                    Map.entry(ModBlocks.PLATINUM_BLOCK.get(), Blocks.IRON_BLOCK),
                    Map.entry(Blocks.IRON_BLOCK, Blocks.DIRT)
            );

    public DowngraderItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(DOWNGRADE_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), DOWNGRADE_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(10, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.rubyoremod.downgrader.shift_down"));
        } else {
            tooltip.add(Component.translatable("tooltip.rubyoremod.downgrader"));
        }
    }
}
