package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.menu.Menu;

public class PlayersGUI extends Menu {

    public PlayersGUI(Player player, Player target) {
        super(player, target, "players");
    }

    @Override
    protected void handleClick(InventoryClickEvent event) {

    }
}
