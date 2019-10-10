package com.ashindigo.guihelpful.api;

import com.ashindigo.guihelpful.HelpfulCommandHandler;
import com.google.common.collect.ImmutableMap;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandCategoryManager {
    private static final HashMap<Identifier, CommandCategory> categoryList = new HashMap<>();

    private static final ArrayList<String> clientNames = new ArrayList<>();
    
    public static final Identifier VANILLACATEGORY = new Identifier(HelpfulCommandHandler.MODID, "vanilla");
    public static final Identifier CLIENTCATEGORY = new Identifier(HelpfulCommandHandler.MODID, "client");

    public static void initMainCategories() {
        categoryList.clear();
        CommandCategory vanillaCategory = new CommandCategory(new TranslatableText("command.category.vanilla"));
        addCategory(VANILLACATEGORY, vanillaCategory);
        CommandCategory clientCategory = new CommandCategory(new TranslatableText("command.category.client"));
        addCategory(CLIENTCATEGORY, clientCategory);
        setupVanillaCategory();
        setupClientCategory();
    }

    public static void addCategory(Identifier key, CommandCategory category) {
        if (!categoryList.containsKey(key)) {
            categoryList.put(key, category);
        }
    }

    public static void addCommandToCategory(Identifier key, CommandInfo info) {
        if (categoryList.containsKey(key)) {
            categoryList.put(key, categoryList.get(key).addCommand(info));
        }
    }

    public static CommandCategory getCategory(Identifier key) {
        return categoryList.get(key);
    }

    public static ImmutableMap<Identifier, CommandCategory> getCategoryList() {
        return ImmutableMap.copyOf(categoryList);
    }

    private static void setupVanillaCategory() {
        // I refuse to comment on this
        ArrayList<String> vanillaNameList = new ArrayList<>();
        vanillaNameList.add("advancement");
        vanillaNameList.add("ban");
        vanillaNameList.add("ban-ip");
        vanillaNameList.add("banlist");
        vanillaNameList.add("bossbar");
        vanillaNameList.add("classroommode");
        vanillaNameList.add("clear");
        vanillaNameList.add("clone");
        vanillaNameList.add("data");
        vanillaNameList.add("datapack");
        vanillaNameList.add("debug");
        vanillaNameList.add("defaultgamemode");
        vanillaNameList.add("deop");
        vanillaNameList.add("difficulty");
        vanillaNameList.add("effect");
        vanillaNameList.add("enchant");
        vanillaNameList.add("execute");
        vanillaNameList.add("experience");
        vanillaNameList.add("fill");
        vanillaNameList.add("forceload");
        vanillaNameList.add("function");
        vanillaNameList.add("gamemode");
        vanillaNameList.add("gamerule");
        vanillaNameList.add("give");
        vanillaNameList.add("help");
        vanillaNameList.add("immutableworld");
        vanillaNameList.add("kick");
        vanillaNameList.add("kill");
        vanillaNameList.add("list");
        vanillaNameList.add("locate");
        vanillaNameList.add("loot");
        vanillaNameList.add("me");
        vanillaNameList.add("mixer");
        vanillaNameList.add("mobevent");
        vanillaNameList.add("msg");
        vanillaNameList.add("op");
        vanillaNameList.add("pardon");
        vanillaNameList.add("particle");
        vanillaNameList.add("playsound");
        vanillaNameList.add("publish");
        vanillaNameList.add("recipe");
        vanillaNameList.add("reload");
        vanillaNameList.add("remove");
        vanillaNameList.add("resupply");
        vanillaNameList.add("replaceitem");
        vanillaNameList.add("save");
        vanillaNameList.add("save-all");
        vanillaNameList.add("save-off");
        vanillaNameList.add("save-on");
        vanillaNameList.add("say");
        vanillaNameList.add("schedule");
        vanillaNameList.add("scoreboard");
        vanillaNameList.add("seed");
        vanillaNameList.add("setblock");
        vanillaNameList.add("setidletimeout");
        vanillaNameList.add("setmaxplayers");
        vanillaNameList.add("setworldspawn");
        vanillaNameList.add("spawnpoint");
        vanillaNameList.add("spectate");
        vanillaNameList.add("spreadplayers");
        vanillaNameList.add("stop");
        vanillaNameList.add("stopsound");
        vanillaNameList.add("summon");
        vanillaNameList.add("tag");
        vanillaNameList.add("team");
        vanillaNameList.add("teleport");
        vanillaNameList.add("teammsg");
        vanillaNameList.add("tell");
        vanillaNameList.add("tellraw");
        vanillaNameList.add("testfor");
        vanillaNameList.add("testforblock");
        vanillaNameList.add("testforblocks");
        vanillaNameList.add("tickingarea");
        vanillaNameList.add("time");
        vanillaNameList.add("title");
        vanillaNameList.add("toggledownfall");
        vanillaNameList.add("tp");
        vanillaNameList.add("transferserver");
        vanillaNameList.add("trigger");
        vanillaNameList.add("w");
        vanillaNameList.add("weather");
        vanillaNameList.add("whitelist");
        vanillaNameList.add("worldborder");
        vanillaNameList.add("worldbuilder");
        vanillaNameList.add("wsserver");
        vanillaNameList.add("xp");
        CommandListManager.getCommands().stream().filter(info -> vanillaNameList.contains(info.getName())).forEach(info -> addCommandToCategory(VANILLACATEGORY, info));
    }

    private static void setupClientCategory() {
        CommandListManager.getCommands().stream().filter(info -> clientNames.contains(info.getName())).forEach(info -> addCommandToCategory(CLIENTCATEGORY, info));
    }

    public static void addClientCommandName(String name) {
        clientNames.add(name);
    }
}
