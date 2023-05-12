package se.lsbmedia.punishmentgui.utils;

import org.bukkit.ChatColor;

public class TextUtils {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}