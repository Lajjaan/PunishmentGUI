package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.menu.Menu;

public class PunishGUI extends Menu {

    public PunishGUI(Player player, Player target) {
        super(player, target, "punish");
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
