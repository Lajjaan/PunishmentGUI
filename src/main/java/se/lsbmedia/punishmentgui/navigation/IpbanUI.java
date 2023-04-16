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

public class IpbanUI implements InventoryHolder {
    private final Player target, punisher;
    private final Inventory inv2;

    public IpbanUI(Player target, Player punisher) {
        this.target = target;
        this.punisher = punisher;
        this.inv2 = Bukkit.createInventory(this, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "IP-BAN" + ChatColor.RED + target.getName());

        // IP-BAN
        ItemStack ipban = new ItemStack(Material.RED_CANDLE);
        ItemMeta ipbanMeta = ipban.getItemMeta();
        ipbanMeta.setDisplayName(ChatColor.DARK_RED + "IP-BAN");
        ipbanMeta.setLore(Arrays.asList(ChatColor.GRAY + "Permanently ip-ban a player!"));
        ipban.setItemMeta(ipbanMeta);

        inv2.setItem(10, ipban);

        // CLOSE
        ItemStack close = new ItemStack(Material.RED_DYE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.DARK_RED + "close");
        close.setItemMeta(closeMeta);

        inv2.setItem(26, close);


    }

    public void showPunisher(){
        punisher.openInventory(inv2);
    }

    public Player getPunisher() {
        return punisher;
    }

    public Player getTarget() {
        return target;
    }

    @Override public Inventory getInventory()
    {
        return this.inv2;
    }
}