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

public class HelpfulShowAllGui extends LightweightGuiDescription {
    public HelpfulShowAllGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        BiConsumer<CommandInfo<? extends CommandSource>, WLabelButton> configurator = (CommandInfo<? extends CommandSource> command, WLabelButton button) -> {
            button.setText(command.getName());
            button.setOnClick(() -> MinecraftClient.getInstance().openScreen(new HelpfulScreen(new CommandInfoGui(command, this))));
        };
        WListPanel<CommandInfo<? extends CommandSource>, WLabelButton> list = new WListPanel<>(CommandListManager.getCommands(), WLabelButton.class, WLabelButton::new, configurator);
        root.add(list, 0, 0, 14, 14);
        root.validate(this);
    }
}
