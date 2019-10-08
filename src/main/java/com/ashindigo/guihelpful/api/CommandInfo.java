package com.ashindigo.guihelpful.api;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.server.command.CommandSource;

public class CommandInfo<S extends CommandSource> {

    private final CommandNode<? extends CommandSource> commandNode;
    private final CommandDispatcher<S> dispatcher;

    public CommandInfo(CommandNode<? extends CommandSource> commandNode, CommandDispatcher<S> dispatcher) {
        this.commandNode = commandNode;
        this.dispatcher = dispatcher;
    }

    public CommandNode<? extends CommandSource> getCommandNode() {
        return commandNode;
    }

    public CommandDispatcher<S> getDispatcher() {
        return dispatcher;
    }

//    public String[] getUsage() {
//        return dispatcher.getAllUsage((CommandNode<S>) commandNode, source, false);
//    }
}
