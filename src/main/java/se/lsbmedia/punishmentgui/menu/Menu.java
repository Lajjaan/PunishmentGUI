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
import se.lsbmedia.punishmentgui.menu.menus.*;
import se.lsbmedia.punishmentgui.utils.ItemUtils;
import se.lsbmedia.punishmentgui.utils.PunishManager;
import se.lsbmedia.punishmentgui.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu implements InventoryHolder {

    protected Main main = Main.getInstance();
    protected FileConfiguration config = main.getConfig();
    protected PunishManager punishManager;

    protected String menuName;
    protected Player player, target;
    protected Inventory inventory;

    private final List<String> typeList = new ArrayList<>();
    private final List<String> durationTypeList = new ArrayList<>();
    private final List<Integer> slots = new ArrayList<>();
    private final List<Integer> durations = new ArrayList<>();

    public Menu(Player player, Player target, String menuName) {

        punishManager = new PunishManager(player, target);

        this.menuName = menuName;
        this.player = player;
        this.target = target;
        String title = (String) TextUtils.replacePlaceholder(null, config.getString(menuName + ".title"), player, target);
        int size = config.getInt(menuName + ".size");

        inventory = Bukkit.createInventory(
                this,
                size,
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

                    String type = itemSection.getString("type");
                    String durationType = itemSection.getString("duration-type");
                    String message = itemSection.getString("message");
                    int duration = itemSection.getInt("duration");

                    typeList.add(type);
                    durationTypeList.add(durationType);
                    slots.add(slot);
                    durations.add(duration);
                }
            }
        }
    }

    public void open() {
        player.openInventory(inventory);
    }

    protected void handleClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();

        if (slots.contains(slot)) {
            int index = slots.indexOf(slot);
            if (index < typeList.size() && index < durationTypeList.size()) {
                String type = typeList.get(index);
                String durationType = durationTypeList.get(index);
                int duration = durations.get(index);

                switch (type) {
                    case "mute":
                    case "ban":
                    case "ipban":
                        punishManager.punishPlayer(type, durationType, duration);
                        break;
                    case "back":
                    case "punish-gui":
                        new PunishGUI(player, target).open();
                        break;
                    case "mute-gui":
                        new MuteGUI(player, target).open();
                        break;
                    case "ban-gui":
                        new BanGUI(player, target).open();
                        break;
                    case "ip-ban-gui":
                        new IpBanGUI(player, target).open();
                        break;
                    case "players-gui":
                        new PlayersGUI(player, target).open();
                        break;
                    case "close":
                        player.closeInventory();
                        break;
                    case "none":
                        break;
                }
            }
        }
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
