package com.ashindigo.guihelpful.gui;

import com.ashindigo.guihelpful.api.CommandInfo;
import com.ashindigo.guihelpful.api.CommandListManager;
import com.ashindigo.guihelpful.widgets.WLabelButton;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandSource;

import java.util.function.BiConsumer;

public class HelpfulGui extends LightweightGuiDescription {
    public HelpfulGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        BiConsumer<CommandInfo<? extends CommandSource>, WLabelButton> configurator = (CommandInfo<? extends CommandSource> command, WLabelButton button) -> {
            button.setText(command.getCommandNode().getName());
            button.setOnClick(() -> MinecraftClient.getInstance().openScreen(new CommandInfoScreen(new CommandInfoGui(command))));
        };
        WListPanel<CommandInfo<? extends CommandSource>, WLabelButton> list = new WListPanel<>(CommandListManager.getCommands(), WLabelButton.class, WLabelButton::new, configurator);
        root.add(list, 0, 0, 14, 14);
        // TODO Adding a text field messes up the list, probably need to make a bug report to the libgui devs
        // WTextField searchField = new WTextField();
        //root.add(searchField, 0, 0, 14, 0);
//            WGridPanel gridPanel = new WGridPanel();
//            root.add(gridPanel, 0, 1, 14, 14);
//            WTextField searchField = new WTextField();
//            root.add(searchField, 0, 0, 14, 14);
//            gridPanel.add(searchField, 0, 0, 14, 0);
//            gridPanel.add(list, 0, 0, 14, 14); // I need to figure the units this uses

        root.validate(this);

    }
}
