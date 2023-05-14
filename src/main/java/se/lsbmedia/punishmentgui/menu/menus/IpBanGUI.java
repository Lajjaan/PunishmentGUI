package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public class IpBanGUI extends Menu {

    @Override
    public String title() {
        return "&4&lIP Ban: &c" + target.getName();
    }

    @Override
    public int size() {
        return 18;
    }

    public IpBanGUI(Player player, Player target) {
        super(player, target);
    }

    @Override
    protected void createComponents() {
        // ipban 1d
        ItemStack ipban1 = ItemUtils.createItem(Material.ENDER_PEARL, 1, TextUtils.color("&b&lIP BAN 1d"), "", 0);
        inventory.setItem(0, ipban1);

        // ipban 3d
        ItemStack ipban2 = ItemUtils.createItem(Material.ENDER_PEARL, 1, TextUtils.color("&b&lIP BAN3d"), "", 0);
        inventory.setItem(1, ipban2);

        // ipban 7d
        ItemStack ipban3 = ItemUtils.createItem(Material.ENDER_PEARL, 1, TextUtils.color("&b&lIP BAN 7d"), "", 0);
        inventory.setItem(2, ipban3);

        // ipban 14d
        ItemStack ipban4 = ItemUtils.createItem(Material.ENDER_EYE, 1, TextUtils.color("&b&lIP BAN 14d"), "", 0);
        inventory.setItem(3, ipban4);

        // ipban 24d
        ItemStack ipban5 = ItemUtils.createItem(Material.ENDER_EYE, 1, TextUtils.color("&b&lIP BAN 24d"), "", 0);
        inventory.setItem(4, ipban5);

        // ipban 31d
        ItemStack ipban6 = ItemUtils.createItem(Material.ENDER_EYE, 1, TextUtils.color("&b&lIP BAN 31d"), "", 0);
        inventory.setItem(5, ipban6);

        // ipban 45d
        ItemStack ipban7 = ItemUtils.createItem(Material.SLIME_BALL, 1, TextUtils.color("&b&lIP BAN 45d"), "", 0);
        inventory.setItem(6, ipban7);

        // ipban 95d
        ItemStack ipban8 = ItemUtils.createItem(Material.SLIME_BALL, 1, TextUtils.color("&b&lIP BAN 95d"), "", 0);
        inventory.setItem(7, ipban8);

        // PERM ipban
        ItemStack perm = ItemUtils.createItem(Material.TNT, 1, TextUtils.color("&b&lPERM IP BAN"), "", 0);
        inventory.setItem(8, perm);

        // TARGET
        ItemStack targetHead = ItemUtils.getPlayerHead(target, "&c" + target.getName());
        inventory.setItem(13, targetHead);

        // CLOSE
        ItemStack close = ItemUtils.createItem(Material.BARRIER, 1, "&cClose", "", 0);
        inventory.setItem(14, close);
    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

    }
}
