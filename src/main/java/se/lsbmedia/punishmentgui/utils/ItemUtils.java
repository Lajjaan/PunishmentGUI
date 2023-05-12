package se.lsbmedia.punishmentgui.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemUtils {

    public static ItemStack createItem(Material material, int amount, String name, List<String> lore, int data) {

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(data);
        itemMeta.setDisplayName(TextUtils.color(name));
        List<String> tempLore = new ArrayList<>();
        if (lore != null) {
            for (String s : lore) {
                tempLore.add(TextUtils.color(s));
            }
            itemMeta.setLore(tempLore);
        }
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(Material material, int amount, String name, String lore, int data) {

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(data);
        itemMeta.setDisplayName(TextUtils.color(name));
        if (lore != null) {
            itemMeta.setLore(Collections.singletonList(TextUtils.color(lore)));
        }
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }



}

