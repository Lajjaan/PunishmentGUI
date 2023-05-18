package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.menu.Menu;

public class IpBanGUI extends Menu {

    public IpBanGUI(Player player, Player target) {
        super(player, target, "ipban");
    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

        switch (event.getRawSlot()) {
            case 0:
                // ipBan 1d
                ipBan(1);
                break;
            case 1:
                // ipBan 3d
                ipBan(3);
                break;
            case 2:
                // ipBan 7d
                ipBan(7);
                break;
            case 3:
                // ipBan 14d
                ipBan(14);
                break;
            case 4:
                // ipBan 24d
                ipBan(24);
                break;
            case 5:
                // ipBan 31d
                ipBan(31);
                break;
            case 6:
                // ipBan 45d
                ipBan(45);
                break;
            case 7:
                // ipBan 95d
                ipBan(95);
                break;
            case 8:
                // perm ipBan
                ipBan(0);
                break;
            case 14:
                // Gå tillbaka
                PunishGUI punishGUI = new PunishGUI(player, target);
                punishGUI.open();
                break;
        }

    }
}
