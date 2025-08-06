package com.moldy.rubyoremod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record TntTouchEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<TntTouchEnchantmentEffect> CODEC = MapCodec.unit(TntTouchEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if(pEnchantmentLevel == 1) {
            spawnPrimedTNT(pLevel, pEntity.getX(), pEntity.getY(), pEntity.getZ(), 1,15);
        }

        if(pEnchantmentLevel == 2) {
            spawnPrimedTNT(pLevel, pEntity.getX(), pEntity.getY(), pEntity.getZ(), 2,10);
        }

        if(pEnchantmentLevel == 3) {
            spawnPrimedTNT(pLevel, pEntity.getX(), pEntity.getY(), pEntity.getZ(), 4,5);
        }
    }

    private void spawnPrimedTNT(ServerLevel level, double x, double y, double z, int count, int fuseTicks) {
        for (int i = 0; i < count; i++) {
            PrimedTnt tnt = EntityType.TNT.create(level);
            if (tnt != null) {
                tnt.setPos(x, y, z);
                tnt.setFuse(fuseTicks); // Explode in 5 ticks
                level.addFreshEntity(tnt);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}