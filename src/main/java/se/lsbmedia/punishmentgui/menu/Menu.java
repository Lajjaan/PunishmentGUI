package se.lsbmedia.punishmentgui.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Menu {

    protected Player player, target;
    protected Inventory inventory;

    public Menu(Player player, Player target, int size, String title) {

        this.player = player;
        this.target = target;
        player.closeInventory();
        inventory = Bukkit.createInventory(null, size, title);
        createComponents();
        player.openInventory(inventory);

    }

    protected abstract void createComponents();

    protected abstract void handleClick(Player player, ItemStack clickedItem);

    protected void openNewGUI(Menu gui) {
        player.closeInventory();
        gui.open(player);
    }

    protected void open(Player player) {
        player.openInventory(inventory);
    }

    @EventHandler
    protected void onClick(InventoryClickEvent event) {

        if (!event.getInventory().equals(inventory)) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null) {
            handleClick(player, clickedItem);
        }

        event.setCancelled(true);

    }

}
