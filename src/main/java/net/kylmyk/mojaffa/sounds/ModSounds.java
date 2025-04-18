package net.kylmyk.mojaffa.sounds;

import net.kylmyk.mojaffa.JaffaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

// ModSounds.java
public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(Registries.SOUND_EVENT, JaffaMod.MOD_ID);

    public static final RegistryObject<SoundEvent> JONUT_SOUND =
            registryObjectEvent("jonut_music");

    public static RegistryObject<SoundEvent> registryObjectEvent(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(JaffaMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}

