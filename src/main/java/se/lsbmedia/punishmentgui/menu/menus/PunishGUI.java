package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;

public class PunishGUI extends Menu {


    @Override
    public String title() {
        return "&b&lPunish: &c" + target.getName();
    }

    @Override
    public int size() {
        return 9;
    }

    public PunishGUI(Player player, Player target) {
        super(player, target);
    }

    @Override
    protected void createComponents() {

        ItemStack mute = ItemUtils.createItem(Material.BOOK, 1, "&eMute", "", 0);
        inventory.setItem(3, mute);

        ItemStack ban = ItemUtils.createItem(Material.WOODEN_AXE, 1, "&6Ban", "", 0);
        inventory.setItem(4, ban);

        ItemStack ipBan = ItemUtils.createItem(Material.ENDER_EYE, 1, "&cIP Ban", "", 0);
        inventory.setItem(5, ipBan);

        ItemStack allPlayers = ItemUtils.getPlayerHead(player, "&bAll Players");
        inventory.setItem(7, allPlayers);

        ItemStack close = ItemUtils.createItem(Material.BARRIER, 1, "&cClose", "", 0);
        inventory.setItem(8, close);

        ItemUtils.filler(Material.LIGHT_BLUE_STAINED_GLASS_PANE, inventory);
    }

    @Override
    protected void handleClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        switch (event.getRawSlot()) {
            case 3:
                new MuteGUI(player, target).open();
                break;
            case 4:
                new BanGUI(player, target).open();
                break;
            case 5:
                new IpBanGUI(player, target).open();
                break;
            case 7:
                new PlayersGUI(player, target).open();
                break;
            case 8:
                player.closeInventory();
                break;
        }
    }

}
