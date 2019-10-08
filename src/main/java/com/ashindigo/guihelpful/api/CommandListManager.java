package com.ashindigo.guihelpful.api;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;

import java.util.ArrayList;

public class CommandListManager {

    private static final ArrayList<CommandInfo<? extends CommandSource>> commands = new ArrayList<>();

    public static ImmutableList<CommandInfo<? extends CommandSource>> getCommands() {
        return ImmutableList.copyOf(commands);
    }

    public static void addEntry(CommandInfo<? extends CommandSource> command) {
        commands.add(command);
    }

    public static void initMainList() {
        if (MinecraftClient.getInstance().getServer() != null) {
            for (CommandNode<? extends CommandSource> node : MinecraftClient.getInstance().getServer().getCommandManager().getDispatcher().getRoot().getChildren()) {
                CommandInfo<ServerCommandSource> commandInfo = new CommandInfo<>(node, MinecraftClient.getInstance().getServer().getCommandManager().getDispatcher());
                commands.add(commandInfo);
            }
        }
    }
}
