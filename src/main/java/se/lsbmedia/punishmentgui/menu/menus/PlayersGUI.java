package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.menu.Menu;

public class PlayersGUI extends Menu {

    @Override
    public String title() {
        return "&b&lPunish - Players";
    }

    @Override
    public int size() {
        return 9;
    }

    public PlayersGUI(Player player, Player target) {
        super(player, target);
    }

    @Override
    protected void createComponents() {

    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

    }
}
