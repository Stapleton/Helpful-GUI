package com.ashindigo.guihelpful.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;

public class HelpfulCategoryGui extends LightweightGuiDescription {
    public HelpfulCategoryGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
    }
}
