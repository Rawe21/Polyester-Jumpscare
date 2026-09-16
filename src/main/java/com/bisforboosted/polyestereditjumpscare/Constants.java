package com.bisforboosted.polyestereditjumpscare;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Constants {
    public static final String MOD_ID = "polyestereditjumpscare";

    public static final Identifier WITHERED_FOXY_JUMPSCARE_1 =
            Identifier.of(MOD_ID, "jumpscare_hud");

    public static final Identifier JUMPSCARE_SOUND_ID = Identifier.of(MOD_ID, "jumpscare");
    public static final SoundEvent JUMPSCARE_SOUND = SoundEvent.of(JUMPSCARE_SOUND_ID);

    public static void registerSounds() {
        Registry.register(Registries.SOUND_EVENT, JUMPSCARE_SOUND_ID, JUMPSCARE_SOUND);
    }
}
