package com.bisforboosted.polyestereditjumpscare.client;

import com.bisforboosted.polyestereditjumpscare.Constants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class FabricHudHook implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Constants.registerSounds();

        HudRenderCallback.EVENT.register(JumpscareHudRenderer::render);

        JumpscareManager.register();
        JumpscareCommand.register();
    }
}
