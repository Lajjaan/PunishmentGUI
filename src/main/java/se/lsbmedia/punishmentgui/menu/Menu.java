package se.lsbmedia.punishmentgui.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import se.lsbmedia.punishmentgui.Main;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public abstract class Menu implements InventoryHolder {

    protected Main main = Main.getInstance();

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

    protected void ban(int days) {
        main.punishPlayer(player, target, "tempban", days);
    }
    protected void mute(int days) {
        main.punishPlayer(player, target, "tempmute", days);
    }
    protected void ipBan(int days) {
        main.punishPlayer(player, target, "tempipban", days);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
