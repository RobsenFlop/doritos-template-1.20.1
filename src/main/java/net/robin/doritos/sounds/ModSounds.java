package net.robin.doritos.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.robin.doritos.ThundyzDoritos;

public class ModSounds {
    public static final SoundEvent CHANEL_BAG = registerSoundEvent("chanel_bag");
    public static final SoundEvent LAYS_EAT = registerSoundEvent("lays");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ThundyzDoritos.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds(){
        ThundyzDoritos.LOGGER.info("Registering Sounds for " + ThundyzDoritos.MOD_ID);
    }
}
