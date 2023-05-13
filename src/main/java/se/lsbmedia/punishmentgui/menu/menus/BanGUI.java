package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;

public class BanGUI extends Menu {

    public BanGUI(Player player, Player target, int size, String title) {
        super(player, target, size, title);
    }

    @Override
    protected void createComponents() {

    }

    @Override
    protected void handleClick(Player player, ItemStack clickedItem) {

    }
}
