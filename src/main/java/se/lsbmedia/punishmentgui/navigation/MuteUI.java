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

public class MuteUI implements InventoryHolder {
    private final Player target, punisher;
    private final Inventory invMute;

    public MuteUI(Player target, Player punisher){
        this.target = target;
        this.punisher = punisher;
        this.invMute = Bukkit.createInventory(this, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "MUTE" + ChatColor.RED + target.getName());

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