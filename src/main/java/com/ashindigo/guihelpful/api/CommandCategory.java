package com.ashindigo.guihelpful.api;

import com.google.common.collect.ImmutableList;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class CommandCategory {

    private final ArrayList<CommandInfo> commands = new ArrayList<>();
    private Text name;

    public CommandCategory(Text name) {
        this.name = name;
    }

    public Text getName() {
        return name;
    }

    public void addCommand(CommandInfo info) {
        commands.add(info);
    }

    public ImmutableList<CommandInfo> getCommands() {
        return ImmutableList.copyOf(commands);
    }
}
