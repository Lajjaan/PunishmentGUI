package se.lsbmedia.punishmentgui.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class InventoryUtils {

    private InventoryUtils() {

    }

    public static void ipBan(Player player) {

        Inventory inv2 = Bukkit.createInventory(player, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "IP-BAN");

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


        player.openInventory(inv2);


    }

    // BAN GUI
    public static void ban(Player player) {

        Inventory invBan = Bukkit.createInventory(player, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "BAN");

        // BAN 1d
        ItemStack ban1 = new ItemStack(Material.PAPER);
        ItemMeta banMeta = ban1.getItemMeta();
        banMeta.setDisplayName(ChatColor.AQUA + "BAN 1d");
        banMeta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 1 day!"));
        ban1.setItemMeta(banMeta);

        invBan.setItem(0, ban1);

        // BAN 3d
        ItemStack ban2 = new ItemStack(Material.PAPER);
        ItemMeta ban2Meta = ban2.getItemMeta();
        ban2Meta.setDisplayName(ChatColor.AQUA + "BAN 3d");
        ban2Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 3 days!"));
        ban2.setItemMeta(ban2Meta);

        invBan.setItem(10, ban2);

        // BAN 5d
        ItemStack ban3 = new ItemStack(Material.PAPER);
        ItemMeta ban3Meta = ban3.getItemMeta();
        ban3Meta.setDisplayName(ChatColor.AQUA + "BAN 5d");
        ban3Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 5 days!"));
        ban3.setItemMeta(ban3Meta);

        invBan.setItem(2, ban3);

        // BAN 7d
        ItemStack ban4 = new ItemStack(Material.PAPER);
        ItemMeta ban4Meta = ban4.getItemMeta();
        ban4Meta.setDisplayName(ChatColor.AQUA + "BAN 7d");
        ban4Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 7 days!"));
        ban4.setItemMeta(ban4Meta);

        invBan.setItem(12, ban4);

        // BAN 24d
        ItemStack ban5 = new ItemStack(Material.PAPER);
        ItemMeta ban5Meta = ban5.getItemMeta();
        ban5Meta.setDisplayName(ChatColor.AQUA + "BAN 24d");
        ban5Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 24 days!"));
        ban5.setItemMeta(ban5Meta);

        invBan.setItem(4, ban5);

        // BAN 31d
        ItemStack ban6 = new ItemStack(Material.PAPER);
        ItemMeta ban6Meta = ban6.getItemMeta();
        ban6Meta.setDisplayName(ChatColor.AQUA + "BAN 31d");
        ban6Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 31 days!"));
        ban6.setItemMeta(ban6Meta);

        invBan.setItem(14, ban6);

        // BAN 45d
        ItemStack ban7 = new ItemStack(Material.PAPER);
        ItemMeta ban7Meta = ban7.getItemMeta();
        ban7Meta.setDisplayName(ChatColor.AQUA + "BAN 45d");
        ban7Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 45 days!"));
        ban7.setItemMeta(ban7Meta);

        invBan.setItem(6, ban7);

        // BAN 92d
        ItemStack ban8 = new ItemStack(Material.PAPER);
        ItemMeta ban8Meta = ban8.getItemMeta();
        ban8Meta.setDisplayName(ChatColor.AQUA + "BAN 92d");
        ban8Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban the player for 92 days!"));
        ban8.setItemMeta(ban8Meta);

        invBan.setItem(16, ban8);

        // PERM BAN
        ItemStack perm = new ItemStack(Material.POWERED_RAIL);
        ItemMeta permMeta = perm.getItemMeta();
        permMeta.setDisplayName(ChatColor.AQUA + "PERMANENTLY BAN");
        permMeta.setLore(Arrays.asList(ChatColor.GRAY + "Ban the player forever!"));
        perm.setItemMeta(permMeta);

        invBan.setItem(8, perm);


        // CLOSE
        ItemStack close = new ItemStack(Material.RED_DYE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.DARK_RED + "close");
        close.setItemMeta(closeMeta);

        invBan.setItem(26, close);


        player.openInventory(invBan);

    }

    // MUTE
    public static void mute(Player player) {

        Inventory invMute = Bukkit.createInventory(player, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "MUTE");

        // MUTE 1h
        ItemStack mute1 = new ItemStack(Material.PAPER);
        ItemMeta muteMeta = mute1.getItemMeta();
        muteMeta.setDisplayName(ChatColor.AQUA + "MUTE 1h");
        muteMeta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 1 hour!"));
        mute1.setItemMeta(muteMeta);

        invMute.setItem(0, mute1);

        // MUTE 3h
        ItemStack mute2 = new ItemStack(Material.PAPER);
        ItemMeta mute2Meta = mute2.getItemMeta();
        mute2Meta.setDisplayName(ChatColor.AQUA + "MUTE 2h");
        mute2Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 2 hour!"));
        mute2.setItemMeta(mute2Meta);

        invMute.setItem(10, mute2);

        // MUTE 12h
        ItemStack mute3 = new ItemStack(Material.PAPER);
        ItemMeta mute3Meta = mute3.getItemMeta();
        mute3Meta.setDisplayName(ChatColor.AQUA + "MUTE 12h");
        mute3Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 12 hour!"));
        mute3.setItemMeta(mute3Meta);

        invMute.setItem(2, mute3);

        // MUTE 1d
        ItemStack mute4 = new ItemStack(Material.PAPER);
        ItemMeta mute4Meta = mute4.getItemMeta();
        mute4Meta.setDisplayName(ChatColor.AQUA + "MUTE 1d");
        mute4Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 1 day!"));
        mute4.setItemMeta(mute4Meta);

        invMute.setItem(12, mute4);

        // MUTE 3d
        ItemStack mute5 = new ItemStack(Material.PAPER);
        ItemMeta mute5Meta = mute5.getItemMeta();
        mute5Meta.setDisplayName(ChatColor.AQUA + "MUTE 3d");
        mute5Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 3 days!"));
        mute5.setItemMeta(mute5Meta);

        invMute.setItem(4, mute5);

        // MUTE 7d
        ItemStack mute6 = new ItemStack(Material.PAPER);
        ItemMeta mute6Meta = mute6.getItemMeta();
        mute6Meta.setDisplayName(ChatColor.AQUA + "MUTE 7d");
        mute6Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 7 days!"));
        mute6.setItemMeta(mute6Meta);

        invMute.setItem(14, mute6);

        // MUTE 24d
        ItemStack mute7 = new ItemStack(Material.PAPER);
        ItemMeta mute7Meta = mute7.getItemMeta();
        mute7Meta.setDisplayName(ChatColor.AQUA + "MUTE 24d");
        mute7Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 24 days!"));
        mute7.setItemMeta(mute7Meta);

        invMute.setItem(6, mute7);

        // MUTE 45d
        ItemStack mute8 = new ItemStack(Material.PAPER);
        ItemMeta mute8Meta = mute8.getItemMeta();
        mute8Meta.setDisplayName(ChatColor.AQUA + "MUTE 45d");
        mute8Meta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily mute the player for 45 days!"));
        mute8.setItemMeta(mute8Meta);

        invMute.setItem(16, mute8);

        // PERM-MUTE
        ItemStack permMute = new ItemStack(Material.PAPER);
        ItemMeta permMuteMeta = permMute.getItemMeta();
        permMuteMeta.setDisplayName(ChatColor.AQUA + "PERMANENTLY MUTE");
        permMuteMeta.setLore(Arrays.asList(ChatColor.GRAY + "Mute the player forever!"));
        permMute.setItemMeta(permMuteMeta);

        invMute.setItem(8, mute8);

        // CLOSE
        ItemStack close = new ItemStack(Material.RED_DYE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.DARK_RED + "close");
        close.setItemMeta(closeMeta);

        invMute.setItem(26, close);


        player.openInventory(invMute);
    }
}

