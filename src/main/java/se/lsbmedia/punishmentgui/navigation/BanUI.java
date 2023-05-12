package se.lsbmedia.punishmentgui.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.TextUtils;

import java.util.Arrays;

public class BanUI implements InventoryHolder {
    private final Player target, punisher;
    private final Inventory invBan;

    public BanUI(Player target, Player punisher){
        this.target = target;
        this.punisher = punisher;
        this.invBan = Bukkit.createInventory(this, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "BAN" + ChatColor.RED + target.getName());

        // BAN 1d
        ItemStack ban1 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 1d"), "", 0);
        invBan.setItem(0, ban1);

        // BAN 3d
        ItemStack ban2 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 3d"), "", 0);
        invBan.setItem(10, ban2);

        // BAN 5d
        ItemStack ban3 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 5d"), "", 0);
        invBan.setItem(2, ban3);

        // BAN 7d
        ItemStack ban4 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 7d"), "", 0);
        invBan.setItem(12, ban4);

        // BAN 24d
        ItemStack ban5 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 24d"), "", 0);
        invBan.setItem(4, ban5);

        // BAN 31d
        ItemStack ban6 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 31d"), "", 0);
        invBan.setItem(14, ban6);

        // BAN 45d
        ItemStack ban7 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 45d"), "", 0);
        invBan.setItem(6, ban7);

        // BAN 92d
        ItemStack ban8 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 92d"), "", 0);
        invBan.setItem(16, ban8);

        // PERM BAN
        ItemStack perm = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lPERMBAN"), "", 0);
        invBan.setItem(8, perm);


        // CLOSE
        ItemStack close = ItemUtils.createItem(Material.REDSTONE, 1, TextUtils.color("&cStäng menyn för att få smegma"), "", 0);
        invBan.setItem(26, close);


    }

    public void showPunisher(){
        punisher.openInventory(invBan);
    }

    public Player getPunisher() {
        return punisher;
    }

    public Player getTarget() {
        return target;
    }

    @Override public Inventory getInventory()
    {
        return this.invBan;
    }
}