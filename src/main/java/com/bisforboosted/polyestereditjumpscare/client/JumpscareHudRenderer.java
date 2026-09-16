package com.bisforboosted.polyestereditjumpscare.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public class JumpscareHudRenderer {

    private static final int WIDTH = 320;
    private static final int HEIGHT = 180;

    public static void render(DrawContext context, RenderTickCounter tickCounter) {
        if (!JumpscareManager.isActive()) return;

        Identifier texture = JumpscareAssets.frame(JumpscareManager.getCurrentFrame());

        int screenWidth = context.getScaledWindowWidth();
        int screenHeight = context.getScaledWindowHeight();

        int x = (screenWidth - WIDTH) / 2;
        int y = (screenHeight - HEIGHT) / 2;

        context.drawTexture(texture, x, y, 0f, 0f, WIDTH, HEIGHT, WIDTH, HEIGHT);
    }
}
