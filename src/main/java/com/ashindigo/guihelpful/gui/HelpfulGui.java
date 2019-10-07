package com.ashindigo.guihelpful.gui;

import com.ashindigo.guihelpful.widgets.WLabelButton;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.ServerCommandSource;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class HelpfulGui extends LightweightGuiDescription {
    public HelpfulGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        if (MinecraftClient.getInstance().getServer() != null) {
            CommandDispatcher<ServerCommandSource> dispatcher = MinecraftClient.getInstance().getServer().getCommandManager().getDispatcher();
            BiConsumer<CommandNode<ServerCommandSource>, WLabelButton> configurator = (CommandNode<ServerCommandSource> command, WLabelButton button) -> {
                button.setText(command.getName());
                button.setOnClick(() -> MinecraftClient.getInstance().openScreen(new CommandInfoScreen(new CommandInfoGui(dispatcher, command))));
            };
            ArrayList<CommandNode<ServerCommandSource>> cmdList = new ArrayList<>(dispatcher.getRoot().getChildren());
            WListPanel<CommandNode<ServerCommandSource>, WLabelButton> list = new WListPanel<>(cmdList, WLabelButton.class, WLabelButton::new, configurator);
            // TODO Adding a text field messes up the list, probably need to make a bug report to the libgui devs
            // WTextField searchField = new WTextField();
            //root.add(searchField, 0, 0, 14, 0);
            root.add(list, 0, 0, 14, 14);
//            WGridPanel gridPanel = new WGridPanel();
//            root.add(gridPanel, 0, 1, 14, 14);
//            WTextField searchField = new WTextField();
//            root.add(searchField, 0, 0, 14, 14);
//            gridPanel.add(searchField, 0, 0, 14, 0);
//            gridPanel.add(list, 0, 0, 14, 14); // I need to figure the units this uses
        }
        root.validate(this);

    }
}
