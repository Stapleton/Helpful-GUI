package com.ashindigo.guihelpful.gui;

import com.ashindigo.guihelpful.api.CommandCategory;
import com.ashindigo.guihelpful.api.CommandInfo;
import com.ashindigo.guihelpful.widgets.WLabelButton;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

import java.util.function.BiConsumer;

public class CommandCategoryGui extends LightweightGuiDescription {

    public CommandCategoryGui(CommandCategory commandCategory) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        BiConsumer<CommandInfo, WLabelButton> configurator = (CommandInfo command, WLabelButton button) -> {
            button.setText(command.getName());
            button.setOnClick(() -> MinecraftClient.getInstance().openScreen(new HelpfulScreen(new CommandInfoGui(command, this))));
        };
        WListPanel<CommandInfo, WLabelButton> list = new WListPanel<>(commandCategory.getCommands(), WLabelButton.class, WLabelButton::new, configurator);
        root.add(list, 0, 0, 14, 14);
        WButton back = new WButton(new LiteralText("Back"));
        back.setOnClick(() -> MinecraftClient.getInstance().openScreen(new HelpfulScreen(new HelpfulCategoryGui())));
        root.add(back, 0, 15, 14, 7);
        root.validate(this);
    }
}
