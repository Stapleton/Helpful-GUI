package com.ashindigo.guihelpful.widgets;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;

/**
 * Custom Version of WButton that'll give me more control over the label
 */
public class WLabelButton extends WButton {

    private String text;

    /**
     * Set the buttons text
     * @param text The buttons label
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Overridden paintForeground that'll show my label
     * @param x X Coordinate
     * @param y Y Coordinate
     * @param mouseX Mouse X
     * @param mouseY Mouse y
     */
    @Override
    public void paintForeground(int x, int y, int mouseX, int mouseY) {
        super.paintForeground(x, y, mouseX, mouseY);
        if (text != null) {
            int color = 0xE0E0E0;
            if (!isEnabled()) {
                color = 0xA0A0A0;
            } else if ((mouseX >= x && mouseY >= y && mouseX < x + getWidth() && mouseY < y + getHeight())) {
                color = 0xFFFFA0;
            }

            ScreenDrawing.drawCenteredWithShadow(text, x + (getWidth() / 2), y + ((20 - 8) / 2), color);
        }
    }

}
