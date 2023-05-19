package se.lsbmedia.punishmentgui.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {

    public static String color(String message) {
        if (message == null) {
            return "text";
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static Object replacePlaceholder(List<String> textList, String text, Player player, Player target) {

        String[] placeholders = {"%player%", "%target%"};
        String[] replacements = {player.getName(), target.getName()};

        if (text != null) {
            for (int i = 0; i < placeholders.length; i++) {
                text = text.replace(placeholders[i], replacements[i]);
            }
            return text;
        } else if (textList != null) {
            List<String> replacedList = new ArrayList<>();
            for (String string : textList) {
                for (int i = 0; i < placeholders.length; i++) {
                    string = string.replace(placeholders[i], replacements[i]);
                }
                replacedList.add(string);
            }
            return replacedList;
        } else {
            return null;
        }
    }

}