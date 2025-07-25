package com.moldy.rubyoremod.sound;

import com.moldy.rubyoremod.RubyOreMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RubyOreMod.MODID);

    public static final RegistryObject<SoundEvent> SECRET_SOUND = registerSoundEvent("secret_sound");

    public static final ForgeSoundType SECRET = new ForgeSoundType(1f, 1f,
            ModSounds.SECRET_SOUND, ModSounds.SECRET_SOUND, ModSounds.SECRET_SOUND, ModSounds.SECRET_SOUND, ModSounds.SECRET_SOUND);



    public static final RegistryObject<SoundEvent> FLASHBACKS = registerSoundEvent("flashbacks");
    public static final ResourceKey<JukeboxSong> FLASHBACKS_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(RubyOreMod.MODID, "flashbacks"));



    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(RubyOreMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
