package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.menu.Menu;

public class BanGUI extends Menu {

    public BanGUI(Player player, Player target) {
        super(player, target, "ban");
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
