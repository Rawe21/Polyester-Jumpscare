package com.bisforboosted.polyestereditjumpscare.client;

import com.bisforboosted.polyestereditjumpscare.JumpscareConfig;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class JumpscareCommand {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) ->
                dispatcher.register(literal("jumpscarechance")
                        .executes(ctx -> {
                            sendFeedback("current chance: 1 in " + JumpscareConfig.chanceOneIn);
                            return 1;
                        })
                        .then(argument("oneIn", IntegerArgumentType.integer(1))
                                .executes(ctx -> {
                                    int value = IntegerArgumentType.getInteger(ctx, "oneIn");
                                    JumpscareConfig.chanceOneIn = value;
                                    sendFeedback("set to 1 in " + value);
                                    return 1;
                                }))));
    }

    private static void sendFeedback(String message) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.player.sendMessage(Text.literal(message), false);
        }
    }
}
