package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.menu.Menu;

public class MuteGUI extends Menu {

    public MuteGUI(Player player, Player target) {
        super(player, target, "mute");
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
