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

public class MuteUI implements InventoryHolder {
    private final Player target, punisher;
    private final Inventory invMute;

    public MuteUI(Player target, Player punisher){
        this.target = target;
        this.punisher = punisher;
        this.invMute = Bukkit.createInventory(this, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "MUTE" + ChatColor.RED + target.getName());

        // MUTE 1d
        ItemStack mute1 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 1d"), "", 0);
        invMute.setItem(0, mute1);

        // Mute 3d
        ItemStack mute2 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 3d"), "", 0);
        invMute.setItem(10, mute2);

        // Mute 5d
        ItemStack mute3 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 5d"), "", 0);
        invMute.setItem(2, mute3);

        // Mute 7d
        ItemStack mute4 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 7d"), "", 0);
        invMute.setItem(12, mute4);

        // Mute 24d
        ItemStack mute5 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 24d"), "", 0);
        invMute.setItem(4, mute5);

        // Mute 31d
        ItemStack mute6 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 31d"), "", 0);
        invMute.setItem(14, mute6);

        // Mute 45d
        ItemStack mute7 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 45d"), "", 0);
        invMute.setItem(6, mute7);

        // Mute 92d
        ItemStack mute8 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMute 92d"), "", 0);
        invMute.setItem(16, mute8);

        // PERM Mute
        ItemStack perm = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lPERMMute"), "", 0);
        invMute.setItem(8, perm);


        // CLOSE
        ItemStack close = ItemUtils.createItem(Material.REDSTONE, 1, TextUtils.color("&cStäng menyn för att få smegma"), "", 0);
        invMute.setItem(26, close);


    }

    public void showPunisher(){
        punisher.openInventory(invMute);
    }

    public Player getPunisher() {
        return punisher;
    }

    public Player getTarget() {
        return target;
    }

    @Override public Inventory getInventory()
    {
        return this.invMute;
    }
}