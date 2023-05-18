package se.lsbmedia.punishmentgui.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

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

    public static void filler(Material material, Inventory inventory) {
        ItemStack fillerItem = createItem(material, 1, " ", null, 0);
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, fillerItem);
            }
        }
    }

    public static ItemStack getPlayerHead(Player player, String name, List<String> lore) {
        ItemStack head = createItem(Material.PLAYER_HEAD, 1, name, lore, 0);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(player);
        head.setItemMeta(meta);
        return head;
    }

}

