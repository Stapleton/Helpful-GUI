package com.ashindigo.guihelpful.api;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.server.command.CommandSource;
import net.minecraft.text.TranslatableText;

public class CommandInfo<S extends CommandSource> {

    private final CommandNode<? extends CommandSource> commandNode;
    private final CommandDispatcher<S> dispatcher;

    public CommandInfo(CommandNode<? extends CommandSource> commandNode, CommandDispatcher<S> dispatcher) {
        this.commandNode = commandNode;
        this.dispatcher = dispatcher;
        DescriptionManager.addEntry(commandNode.getName(), new TranslatableText("command." + commandNode.getName() + ".description"));
    }

    public CommandNode<? extends CommandSource> getCommandNode() {
        return commandNode;
    }

    public CommandDispatcher<S> getDispatcher() {
        return dispatcher;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommandInfo) {
            return commandNode.equals(((CommandInfo) obj).getCommandNode());
        }
        return false;
    }

}
