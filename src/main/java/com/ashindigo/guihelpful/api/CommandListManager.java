package com.ashindigo.guihelpful.api;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.server.command.CommandSource;

import java.util.ArrayList;

public class CommandListManager {

    private static final ArrayList<CommandInfo<? extends CommandSource>> commands = new ArrayList<>();

    public static ImmutableList<CommandInfo<? extends CommandSource>> getCommands() {
        return ImmutableList.copyOf(commands);
    }

    public static void addEntry(CommandInfo<? extends CommandSource> command) {
        if (!commands.contains(command)) {
            commands.add(command);
        }
    }

    public static void initMainList(CommandDispatcher<CommandSource> dispatcher) {
        commands.clear();
        for (CommandNode<? extends CommandSource> node : dispatcher.getRoot().getChildren()) {
            CommandInfo<CommandSource> commandInfo = new CommandInfo<>(node, dispatcher);
            addEntry(commandInfo);
        }
    }
}
