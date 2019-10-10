package com.ashindigo.guihelpful.api;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.server.command.CommandSource;
import net.minecraft.text.TranslatableText;

public class CommandInfo<S extends CommandSource> {

    private final String name;
    private final String[] usage;

    public CommandInfo(String name, String[] usage) {
        this.name = name;
        this.usage = usage;
        DescriptionManager.addEntry(getName(), new TranslatableText("command." + getName() + ".description"));
    }

    public CommandInfo(CommandNode<S> commandNode, CommandDispatcher<S> dispatcher, S source) {
        this(commandNode.getName(), dispatcher.getAllUsage(commandNode, source, false));
    }

    public String getName() {
        return name;
    }

    public String[] getUsage() {
        return usage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommandInfo) {
            return getName().equals(((CommandInfo) obj).getName());
        }
        return false;
    }

}
