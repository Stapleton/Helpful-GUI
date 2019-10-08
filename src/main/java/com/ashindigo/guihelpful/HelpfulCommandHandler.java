package com.ashindigo.guihelpful;

import com.ashindigo.guihelpful.api.DescriptionManager;
import com.ashindigo.guihelpful.gui.HelpfulShowAllGui;
import com.ashindigo.guihelpful.gui.HelpfulShowAllScreen;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;

@SuppressWarnings("unused")
public class HelpfulCommandHandler implements ClientCommandPlugin {

    private static boolean ranOnce = false;

    private static int run(CommandContext<CottonClientCommandSource> source) {
        MinecraftClient.getInstance().openScreen(new HelpfulShowAllScreen(new HelpfulShowAllGui()));
        return 1;
    }

    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> clientDispatcher) {
        clientDispatcher.register(ArgumentBuilders.literal("helpful").executes(
                HelpfulCommandHandler::run
        ));
        DescriptionManager.addEntry("helpful", new TranslatableText("command.helpful.description"));
    }
}
