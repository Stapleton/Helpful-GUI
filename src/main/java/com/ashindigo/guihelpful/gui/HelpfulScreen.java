package com.ashindigo.guihelpful.gui;

import com.ashindigo.guihelpful.api.DescriptionManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.ClientCottonScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandSource;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;

public class HelpfulScreen extends ClientCottonScreen {
    private static boolean ranOnce = false;

    public HelpfulScreen(GuiDescription description) {
        super(description);
        if (!ranOnce) {
            CommandDispatcher<CommandSource> dispatcher = MinecraftClient.getInstance().getNetworkHandler().getCommandDispatcher();
            if (dispatcher != null) {
                ArrayList<CommandNode<CommandSource>> cmdList = new ArrayList<>(dispatcher.getRoot().getChildren());
                for (CommandNode<CommandSource> cmd : cmdList) {
                    DescriptionManager.addEntry(cmd.getName(), new TranslatableText("command." + cmd.getName() + ".description"));
                }
                ranOnce = true;
            }
        }
    }
}
