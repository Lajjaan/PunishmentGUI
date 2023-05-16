package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public class BanGUI extends Menu {

    @Override
    public String title() {
        return "&c&lBan: " + target.getName();
    }

    @Override
    public int size() {
        return 18;
    }

    public BanGUI(Player player, Player target) {
        super(player, target);
    }

    @Override
    protected void createComponents() {

        // BAN 1d
        ItemStack ban1 = ItemUtils.createItem(Material.YELLOW_CONCRETE, 1, TextUtils.color("&b&lBAN 1d"), "", 0);
        inventory.setItem(0, ban1);
        
        // BAN 3d
        ItemStack ban2 = ItemUtils.createItem(Material.YELLOW_CONCRETE, 1, TextUtils.color("&b&lBAN 3d"), "", 0);
        inventory.setItem(1, ban2);

        // BAN 7d
        ItemStack ban3 = ItemUtils.createItem(Material.YELLOW_CONCRETE, 1, TextUtils.color("&b&lBAN 7d"), "", 0);
        inventory.setItem(2, ban3);

        //BAN 14d
        ItemStack ban4 = ItemUtils.createItem(Material.ORANGE_CONCRETE, 1, TextUtils.color("&b&lBAN 14d"), "", 0);
        inventory.setItem(3, ban4);

        // BAN 24d
        ItemStack ban5 = ItemUtils.createItem(Material.ORANGE_CONCRETE, 1, TextUtils.color("&b&lBAN 24d"), "", 0);
        inventory.setItem(4, ban5);

        // BAN 31d
        ItemStack ban6 = ItemUtils.createItem(Material.ORANGE_CONCRETE, 1, TextUtils.color("&b&lBAN 31d"), "", 0);
        inventory.setItem(5, ban6);

        // BAN 45d
        ItemStack ban7 = ItemUtils.createItem(Material.RED_CONCRETE, 1, TextUtils.color("&b&lBAN 45d"), "", 0);
        inventory.setItem(6, ban7);

        // BAN 95d
        ItemStack ban8 = ItemUtils.createItem(Material.RED_CONCRETE, 1, TextUtils.color("&b&lBAN 95d"), "", 0);
        inventory.setItem(7, ban8);

        // PERM BAN
        ItemStack perm = ItemUtils.createItem(Material.TNT, 1, TextUtils.color("&b&lPERMBAN"), "", 0);
        inventory.setItem(8, perm);

        // TARGET
        ItemStack targetHead = ItemUtils.getPlayerHead(target, "&c" + target.getName());
        inventory.setItem(13, targetHead);

        // BACK
        ItemStack close = ItemUtils.createItem(Material.BARRIER, 1, "&cBack", "", 0);
        inventory.setItem(14, close);

        ItemUtils.filler(Material.LIGHT_BLUE_STAINED_GLASS_PANE, inventory);

    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

        switch (event.getRawSlot()) {
            case 0:
                // Ban 1d
                ban(1);
                break;
            case 1:
                // Ban 3d
                ban(3);
                break;
            case 2:
                // Ban 7d
                ban(7);
                break;
            case 3:
                // Ban 14d
                ban(14);
                break;
            case 4:
                // Ban 24d
                ban(24);
                break;
            case 5:
                // Ban 31d
                ban(31);
                break;
            case 6:
                // Ban 45d
                ban(45);
                break;
            case 7:
                // Ban 95d
                ban(95);
                break;
            case 8:
                // Permban
                ban(0);
                break;
            case 14:
                // Gå tillbaka
                PunishGUI punishGUI = new PunishGUI(player, target);
                punishGUI.open();
                break;
        }

    }

}
