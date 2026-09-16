package com.bisforboosted.polyestereditjumpscare.client;

import com.bisforboosted.polyestereditjumpscare.Constants;
import net.minecraft.util.Identifier;

public class JumpscareAssets {

    // this took too much time
    // TODO set to actual frame count once i export the real png sequence
    public static final int FRAME_COUNT = 100;
    public static final int TICKS_PER_FRAME = 4; // ~5fps

    public static Identifier frame(int index) {
        return Identifier.of(Constants.MOD_ID,
                "textures/gui/jumpscare/frame_" + pad(index + 1) + ".png");
    }

    private static String pad(int i) {
        return String.format("%04d", i);
    }
}
