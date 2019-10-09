package com.ashindigo.guihelpful.api;

import net.minecraft.text.TranslatableText;

import java.util.ArrayList;

public class CommandCategoryManager {
    private static final ArrayList<CommandCategory> categoryList = new ArrayList<>();

    // Figure out way to determine vanilla commands
    public static void initMainCategories() {
        CommandCategory vanillaCategory = new CommandCategory(new TranslatableText("command.category.vanilla"));
        //miscCategory.addCommand(CommandListManager.getCommands());
        addCategory(vanillaCategory);
    }

    public static void addCategory(CommandCategory category) {
        if (!categoryList.contains(category)) {
            categoryList.add(category);
        }
    }

    public static ArrayList<CommandCategory> getCategoryList() {
        return categoryList;
    }
}
