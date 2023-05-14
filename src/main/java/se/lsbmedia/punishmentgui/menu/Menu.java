package se.lsbmedia.punishmentgui.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public abstract class Menu implements InventoryHolder {

    public abstract String title();
    public abstract int size();

    protected Player player, target;
    protected Inventory inventory;

    public Menu(Player player, Player target) {

        this.player = player;
        this.target = target;
        inventory = Bukkit.createInventory(this, size(), TextUtils.color(title()));
        createComponents();

    }

    protected abstract void createComponents();

    public void open() {
        player.openInventory(inventory);
    }

    protected abstract void handleClick(InventoryClickEvent event);

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
