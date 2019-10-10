package com.ashindigo.guihelpful.api;

import com.google.common.collect.ImmutableList;
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
}
