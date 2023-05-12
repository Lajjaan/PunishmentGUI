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