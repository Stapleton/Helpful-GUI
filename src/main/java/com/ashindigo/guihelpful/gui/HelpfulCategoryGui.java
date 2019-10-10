package com.ashindigo.guihelpful.gui;

import com.ashindigo.guihelpful.api.CommandCategory;
import com.ashindigo.guihelpful.api.CommandCategoryManager;
import com.ashindigo.guihelpful.widgets.WLabelButton;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import net.minecraft.client.MinecraftClient;

import java.util.function.BiConsumer;

public class HelpfulCategoryGui extends LightweightGuiDescription {

    public HelpfulCategoryGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        BiConsumer<CommandCategory, WLabelButton> configurator = (CommandCategory commandCategory, WLabelButton button) -> {
            button.setText(commandCategory.getName().asFormattedString());
            button.setOnClick(() -> MinecraftClient.getInstance().openScreen(new HelpfulScreen(new CommandCategoryGui(commandCategory))));
        };
        WListPanel<CommandCategory, WLabelButton> list = new WListPanel<>(CommandCategoryManager.getCategoryList().values().asList(), WLabelButton.class, WLabelButton::new, configurator);
        root.add(list, 0, 0, 14, 14);
        root.validate(this);
    }
}
