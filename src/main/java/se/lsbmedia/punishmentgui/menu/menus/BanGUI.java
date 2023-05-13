package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public class BanGUI extends Menu {

    public BanGUI(Player player, Player target, int size, String title) {
        super(player, target, size, title);
    }

    @Override
    protected void createComponents() {

        // BAN 1d
        ItemStack ban1 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 1d"), "", 0);
        inventory.setItem(0, ban1);

        // BAN 3d
        ItemStack ban2 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 3d"), "", 0);
        inventory.setItem(1, ban2);

        // BAN 7d
        ItemStack ban3 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 7d"), "", 0);
        inventory.setItem(2, ban3);

        // BAN 24d
        ItemStack ban4 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 24d"), "", 0);
        inventory.setItem(3, ban4);

        // BAN 31d
        ItemStack ban5 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 31d"), "", 0);
        inventory.setItem(4, ban5);

        // BAN 45d
        ItemStack ban6 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 45d"), "", 0);
        inventory.setItem(5, ban6);

        // BAN 95d
        ItemStack ban7 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lBAN 95d"), "", 0);
        inventory.setItem(6, ban7);

        // PERM BAN
        ItemStack perm = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lPERMBAN"), "", 0);
        inventory.setItem(7, perm);

        // CLOSE
        ItemStack close = ItemUtils.createItem(Material.REDSTONE, 1, "&cStäng menyn för att få smegma", "", 0);
        inventory.setItem(8, close);

    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

        switch (event.getRawSlot()) {
            case 0:
                // Ban 1d
            case 1:
                // Ban 3d
            case 2:
                // Ban 7d
            case 3:
                // Ban 24d
            case 4:
                // Ban 31d
            case 5:
                // Ban 45d
            case 6:
                // Ban 95d
            case 7:
                // Permban
            case 8:
                // Gå tillbaka
                player.closeInventory();

        }


    }

}
