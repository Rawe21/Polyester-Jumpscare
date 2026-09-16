package com.bisforboosted.polyestereditjumpscare.client;

import com.bisforboosted.polyestereditjumpscare.Constants;
import com.bisforboosted.polyestereditjumpscare.JumpscareConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;

import java.util.Random;

public class JumpscareManager {
    private static final Random RANDOM = new Random();

    private static int currentFrame = -1;
    private static int ticksUntilNextFrame = 0;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(JumpscareManager::onTick);
    }

    private static void onTick(MinecraftClient client) {
        if (client.player == null || client.world == null) return;

        if (isActive()) {
            advancePlayback();
            return;
        }

        int chance = Math.max(1, JumpscareConfig.chanceOneIn);
        if (RANDOM.nextInt(chance) == 0) {
            trigger(client);
        }
    }

    private static void advancePlayback() {
        ticksUntilNextFrame--;
        if (ticksUntilNextFrame <= 0) {
            currentFrame++;
            ticksUntilNextFrame = JumpscareAssets.TICKS_PER_FRAME;
        }
        if (currentFrame >= JumpscareAssets.FRAME_COUNT) {
            stop();
        }
    }

    private static void trigger(MinecraftClient client) {
        currentFrame = 0;
        ticksUntilNextFrame = JumpscareAssets.TICKS_PER_FRAME;
        client.getSoundManager().play(
                PositionedSoundInstance.master(Constants.JUMPSCARE_SOUND, 1.0f));
    }

    private static void stop() {
        currentFrame = -1;
    }

    public static boolean isActive() {
        return currentFrame >= 0 && currentFrame < JumpscareAssets.FRAME_COUNT;
    }

    public static int getCurrentFrame() {
        return currentFrame;
    }
}
