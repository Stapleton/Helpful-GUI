package com.ashindigo.guihelpful.api;

import com.google.common.collect.ImmutableMap;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.util.HashMap;

public class DescriptionManager {

    private static final HashMap<String, Text> descMap = new HashMap<>();

    public static ImmutableMap<String, Text> getDescMap() {
        return ImmutableMap.copyOf(descMap);
    }

    public static void addEntry(String commandName, Text desc) {
        descMap.put(commandName, desc);
    }

    public static Text getDesc(String key) {
        return descMap.getOrDefault(key, new LiteralText("Description not found!"));
    }
}
