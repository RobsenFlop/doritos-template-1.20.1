package net.robin.doritos.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.robin.doritos.ThundyzDoritos;

public class ModSounds extends SoundEvents {

    public static SoundEvent THUNDY_PLUSH = register("thundy_plush");
    public static SoundEvent LAYS_EAT = register("lays");
    public static SoundEvent CHANEL_BAG = register("chanel_bag");



    private static SoundEvent register(String id) {
        return register(new Identifier(ThundyzDoritos.MOD_ID, id));
    }

    private static SoundEvent register(Identifier id) {
        return register(id, id);
    }

    private static SoundEvent register(Identifier id, Identifier soundId) {
        return (SoundEvent)Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
    public static void registerSounds(){System.out.println("Registering Mod Sounds for " + ThundyzDoritos.MOD_ID);}

}
