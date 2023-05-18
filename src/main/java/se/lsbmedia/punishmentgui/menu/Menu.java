package se.lsbmedia.punishmentgui.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.Main;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.TextUtils;

import java.util.Collections;
import java.util.List;

public abstract class Menu implements InventoryHolder {

    protected Main main = Main.getInstance();
    protected FileConfiguration config = main.getConfig();

    protected String menuName;
    protected Player player, target;
    protected Inventory inventory;

    public Menu(Player player, Player target, String menuName) {

        this.menuName = menuName;
        this.player = player;
        this.target = target;
        String title = (String) TextUtils.replacePlaceholder(null, config.getString(menuName + ".title"), player, target);

        inventory = Bukkit.createInventory(
                this,
                config.getInt(menuName + ".size"),
                TextUtils.color(title));
        setItems();
    }

    protected void setItems() {
        ConfigurationSection itemsSection = config.getConfigurationSection(menuName + ".items");
        if (itemsSection != null) {
            for (String key : itemsSection.getKeys(false)) {
                ConfigurationSection itemSection = itemsSection.getConfigurationSection(key);
                if (itemSection != null) {

                    ItemStack item;

                    int slot = itemSection.getInt("slot");
                    int duration = itemSection.getInt("duration");
                    String name = (String) TextUtils.replacePlaceholder(null, itemSection.getString("name"), player, target);
                    Material material = Material.valueOf(itemSection.getString("material"));
                    int amount = itemSection.getInt("amount");
                    List<String> lore = (List<String>) TextUtils.replacePlaceholder(itemSection.getStringList("lore"), null, player, target);

                    if (material == Material.PLAYER_HEAD) {
                        item = ItemUtils.getPlayerHead(target, name, lore);
                    } else {
                        item = ItemUtils.createItem(material, amount, name, lore, 0);
                    }

                    inventory.setItem(slot, item);
                    ItemUtils.filler(Material.LIGHT_BLUE_STAINED_GLASS_PANE, inventory);

                }
            }
        }
    }

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
