package com.ashindigo.guihelpful.gui;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class CommandInfoGui extends LightweightGuiDescription {

    public CommandInfoGui(CommandDispatcher<ServerCommandSource> dispatcher, CommandNode<ServerCommandSource> command) {
        if (MinecraftClient.getInstance().getServer() != null) {
            WGridPanel root = new WGridPanel();
            setRootPanel(root);
            root.setSize(512, 240);
            BiConsumer<String, WTextField> configurator = (String str, WTextField textField) -> {
                textField.setEditable(false);
                textField.setMaxLength(256);
                textField.setText(str);
            };
            ArrayList<String> list = new ArrayList<>();
            for (String str : dispatcher.getAllUsage(command, MinecraftClient.getInstance().getServer().getCommandSource(), false)) {
                list.add("/" + command.getName() + " " + str);
            }
            WListPanel<String, WTextField> info = new WListPanel<>(list, WTextField.class, WTextField::new, configurator);
            root.add(info, 0, 0, 29, 12);
            WButton exec = new WButton(new LiteralText("Run"));
            root.add(exec, 0, 13, 14, 14);
            WButton back = new WButton(new LiteralText("Back"));
            back.setOnClick(() -> MinecraftClient.getInstance().openScreen(new HelpfulScreen(new HelpfulGui())));
            root.add(back, 15, 13, 14, 14);
            root.validate(this);
        }
    }
}
