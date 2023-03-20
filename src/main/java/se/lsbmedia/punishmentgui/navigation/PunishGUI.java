package se.lsbmedia.punishmentgui.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

class PunishGUI implements InventoryHolder {
    private final Player target, punisher;
    private final Inventory inv;

    public PunishGUI(Player target, Player punisher){
        this.target = target;
        this.punisher = punisher;
        this.inv = Bukkit.createInventory(punisher, 9, "Controll Management");

        // Straffare
        ItemStack getPunisher = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta getPunisherMeta = getPunisher.getItemMeta();
        getPunisherMeta.setDisplayName(ChatColor.DARK_RED + "Punisher");
        getPunisher.setItemMeta(getPunisherMeta);

        inv.setItem(2, getPunisher);

        // Gärningsman
        ItemStack getTarget = new ItemStack(Material.IRON_AXE);
        ItemMeta getTargetMeta = getTarget.getItemMeta();
        getTargetMeta.setDisplayName(ChatColor.DARK_RED + "Mr. Target");
        getTarget.setItemMeta(getTargetMeta);

        inv.setItem(4, getTarget);
    }

    public void showPunisher(){
        punisher.openInventory(inv);
    }

    @Override public void getInventory(){
        return this.inv;
    }
}