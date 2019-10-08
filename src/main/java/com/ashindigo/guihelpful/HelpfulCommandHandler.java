package com.ashindigo.guihelpful;

import com.ashindigo.guihelpful.api.DescriptionManager;
import com.ashindigo.guihelpful.gui.HelpfulGui;
import com.ashindigo.guihelpful.gui.HelpfulScreen;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.CommandNode;
import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandSource;
import net.minecraft.server.network.ServerLoginNetworkHandler;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class HelpfulCommandHandler implements ClientCommandPlugin {

    private static boolean ranOnce = false;

    private static int run(CommandContext<CottonClientCommandSource> source) {
        MinecraftClient.getInstance().openScreen(new HelpfulScreen(new HelpfulGui()));
        return 1;
    }

    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> clientDispatcher) {
        clientDispatcher.register(ArgumentBuilders.literal("helpful").executes(
                HelpfulCommandHandler::run
        ));
    }
}
