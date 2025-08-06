package com.moldy.rubyoremod.potion;

import com.moldy.rubyoremod.RubyOreMod;
import com.moldy.rubyoremod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, RubyOreMod.MODID);

    public static final RegistryObject<Potion> SPIDEY_POTION = POTIONS.register("spider_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SPIDER_EFFECT.getHolder().get(), 500, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
