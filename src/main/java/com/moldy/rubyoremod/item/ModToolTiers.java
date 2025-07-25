package com.moldy.rubyoremod.item;

import com.moldy.rubyoremod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier RUBY = new ForgeTier(3500, 14, 8, 25,
            ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get()),
            ModTags.Blocks.INCORRET_FOR_RUBY_TOOL);
}
