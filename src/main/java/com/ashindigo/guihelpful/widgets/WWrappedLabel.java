package com.ashindigo.guihelpful.widgets;

import io.github.cottonmc.cotton.gui.client.LibGuiClient;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.text.Text;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * Custom WLabel that supports word wrapping
 */
public class WWrappedLabel extends WLabel {
    private final int width;

    public WWrappedLabel(Text descT, int color, int width) {
        super(descT, color);
        this.width = width;
    }

    @Override
    public void paintBackground(int x, int y) {
        String translated = text.asFormattedString();
        String[] split = WordUtils.wrap(translated, width).split(SystemUtils.LINE_SEPARATOR);
        for (int i = 0; i < split.length; i++) {
            ScreenDrawing.drawString(split[i], x, y + (10 * i), LibGuiClient.config.darkMode ? darkmodeColor : color);
        }
    }
}
