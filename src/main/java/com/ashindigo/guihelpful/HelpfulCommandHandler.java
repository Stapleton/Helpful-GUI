package com.ashindigo.guihelpful;

import com.ashindigo.guihelpful.api.DescriptionManager;
import com.ashindigo.guihelpful.gui.HelpfulCategoryGui;
import com.ashindigo.guihelpful.gui.HelpfulCategoryScreen;
import com.ashindigo.guihelpful.gui.HelpfulShowAllGui;
import com.ashindigo.guihelpful.gui.HelpfulShowAllScreen;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.TranslatableText;

@SuppressWarnings("unused")
public class HelpfulCommandHandler implements ClientCommandPlugin {

    private static boolean ranOnce = false;

    private static int runAll(CommandContext<CottonClientCommandSource> source) {
        MinecraftClient.getInstance().openScreen(new HelpfulShowAllScreen(new HelpfulShowAllGui()));
        return 1;
    }

    private static int runCategory(CommandContext<CottonClientCommandSource> cottonClientCommandSourceCommandContext) {
        MinecraftClient.getInstance().openScreen(new HelpfulCategoryScreen(new HelpfulCategoryGui()));
        return 1;
    }

    @Override
    public void registerCommands(CommandDispatcher<CottonClientCommandSource> clientDispatcher) {
        LiteralArgumentBuilder<CottonClientCommandSource> argumentBuilder = ArgumentBuilders.literal("helpful").executes(HelpfulCommandHandler::runCategory);
        argumentBuilder.then(ArgumentBuilders.literal("all").executes(HelpfulCommandHandler::runAll));
        clientDispatcher.register(argumentBuilder);
        DescriptionManager.addEntry("helpful", new TranslatableText("command.helpful.description"));
    }
}
