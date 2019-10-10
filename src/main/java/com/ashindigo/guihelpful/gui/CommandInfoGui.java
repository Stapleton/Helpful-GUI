package com.ashindigo.guihelpful.gui;

import com.ashindigo.guihelpful.api.CommandInfo;
import com.ashindigo.guihelpful.api.DescriptionManager;
import com.ashindigo.guihelpful.widgets.WWrappedLabel;
import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiConsumer;

public class CommandInfoGui extends LightweightGuiDescription {

    public CommandInfoGui(CommandInfo commandInfo, GuiDescription prevGui) {
        if (MinecraftClient.getInstance().getNetworkHandler() != null) {
            WGridPanel root = new WGridPanel();
            setRootPanel(root);
            root.setSize(512, 240);
            BiConsumer<String, WTextField> configurator = (String str, WTextField textField) -> {
                textField.setEditable(false);
                textField.setMaxLength(256);
                textField.setText(str);
            };
            ArrayList<String> list = new ArrayList<>();
            Collections.sort(list);
            Arrays.stream(commandInfo.getUsage()).map(str -> "" + commandInfo.getName() + " " + str).forEach(list::add); // Fancy lambdas
            WListPanel<String, WTextField> info = new WListPanel<>(list, WTextField.class, WTextField::new, configurator);
            root.add(info, 0, 0, 29, 12);
            Text descT = DescriptionManager.getDesc(commandInfo.getName());
            WWrappedLabel desc = new WWrappedLabel(descT, 0x404040, 105);
            root.add(desc, 0, 12);
            WButton back = new WButton(new LiteralText("Back"));
            back.setOnClick(() -> MinecraftClient.getInstance().openScreen(new HelpfulScreen(prevGui)));
            root.add(back, 8, 14, 14, 7);
            root.validate(this);
        }
    }
}
