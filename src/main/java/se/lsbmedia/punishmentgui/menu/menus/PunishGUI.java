package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;

public class PunishGUI extends Menu {


    public PunishGUI(Player player, Player target, int size, String title) {
        super(player, target, size, title);
    }

    @Override
    protected void createComponents() {
        ItemStack ban = ItemUtils.createItem(Material.RED_WOOL, 1, "Ban", "", 0);
        inventory.setItem(0, ban);
    }

    @Override
    protected void handleClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getType() == Material.RED_WOOL) {
            BanGUI banGUI = new BanGUI(player, target, 9, "&cBan " + target.getDisplayName());
            banGUI.open();
        }
    }

}
