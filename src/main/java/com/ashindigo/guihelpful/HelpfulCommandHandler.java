package com.ashindigo.guihelpful;

import com.ashindigo.guihelpful.gui.HelpfulGui;
import com.ashindigo.guihelpful.gui.HelpfulScreen;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;

@SuppressWarnings("unused")
public class HelpfulCommandHandler implements ClientCommandPlugin {

    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
        dispatcher.register(ArgumentBuilders.literal("helpful").executes(
                HelpfulCommandHandler::run // In its own method for organization sake might merge later if it stays as a one liner
        ));
    }

    private static int run(CommandContext<CottonClientCommandSource> source) {
        MinecraftClient.getInstance().openScreen(new HelpfulScreen(new HelpfulGui()));

        return 1;
    }
}
