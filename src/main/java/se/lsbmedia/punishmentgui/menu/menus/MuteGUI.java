package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public class MuteGUI extends Menu {

    @Override
    public String title() {
        return "&f&lMute: &c" + target.getName();
    }

    @Override
    public int size() {
        return 18;
    }

    public MuteGUI(Player player, Player target) {
        super(player, target);
    }

    @Override
    protected void createComponents() {
        // mute 1d
        ItemStack mute1 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMUTE 1d"), "", 0);
        inventory.setItem(0, mute1);

        // mute 3d
        ItemStack mute2 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMUTE 3d"), "", 0);
        inventory.setItem(1, mute2);

        // mute 7d
        ItemStack mute3 = ItemUtils.createItem(Material.PAPER, 1, TextUtils.color("&b&lMUTE 7d"), "", 0);
        inventory.setItem(2, mute3);

        // mute 14d
        ItemStack mute4 = ItemUtils.createItem(Material.BOOK, 1, TextUtils.color("&b&lMUTE 14d"), "", 0);
        inventory.setItem(3, mute4);

        // mute 24d
        ItemStack mute5 = ItemUtils.createItem(Material.BOOK, 1, TextUtils.color("&b&lMUTE 24d"), "", 0);
        inventory.setItem(4, mute5);

        // mute 31d
        ItemStack mute6 = ItemUtils.createItem(Material.BOOK, 1, TextUtils.color("&b&lMUTE 31d"), "", 0);
        inventory.setItem(5, mute6);

        // mute 45d
        ItemStack mute7 = ItemUtils.createItem(Material.WRITABLE_BOOK, 1, TextUtils.color("&b&lMUTE 45d"), "", 0);
        inventory.setItem(6, mute7);

        // mute 95d
        ItemStack mute8 = ItemUtils.createItem(Material.WRITABLE_BOOK, 1, TextUtils.color("&b&lMUTE 95d"), "", 0);
        inventory.setItem(7, mute8);

        // PERM mute
        ItemStack perm = ItemUtils.createItem(Material.TNT, 1, TextUtils.color("&b&lPERM MUTE"), "", 0);
        inventory.setItem(8, perm);

        // TARGET
        ItemStack targetHead = ItemUtils.getPlayerHead(target, "&c" + target.getName());
        inventory.setItem(13, targetHead);

        // CLOSE
        ItemStack close = ItemUtils.createItem(Material.BARRIER, 1, "&cClose", "", 0);
        inventory.setItem(14, close);

        ItemUtils.filler(Material.LIGHT_BLUE_STAINED_GLASS_PANE, inventory);

    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

        switch (event.getRawSlot()) {
            case 0:
                // mute 1d
                mute(1);
                break;
            case 1:
                // mute 3d
                mute(3);
                break;
            case 2:
                // mute 7d
                mute(7);
                break;
            case 3:
                // mute 14d
                mute(14);
                break;
            case 4:
                // mute 24d
                mute(24);
                break;
            case 5:
                // mute 31d
                mute(31);
                break;
            case 6:
                // mute 45d
                mute(45);
                break;
            case 7:
                // mute 95d
                mute(95);
                break;
            case 8:
                // Permmute
                mute(0);
                break;
            case 14:
                // Gå tillbaka
                PunishGUI punishGUI = new PunishGUI(player, target);
                punishGUI.open();
                break;
        }

    }
}
