package se.lsbmedia.punishmentgui.menu.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import se.lsbmedia.punishmentgui.menu.Menu;
import se.lsbmedia.punishmentgui.utils.ItemUtils;

public class PlayersGUI extends Menu {

    private final int MAX_ITEMS_PER_PAGE = 28;
    private int currentPage = 1;
    private final String[] allPlayers;

    public PlayersGUI(Player player, Player target) {
        super(player, target, "players-gui");
        main.sendPluginMessage(player);
        allPlayers = main.getAllPlayers();
    }

    @Override
    protected void setItems() {
        super.setItems();

        Player[] onlinePlayers = new Player[allPlayers.length];
        for (int i = 0; i < allPlayers.length; i++) {
            onlinePlayers[i] = Bukkit.getPlayerExact(allPlayers[i]);
        }

        int totalPages = (int) Math.ceil((double) onlinePlayers.length / MAX_ITEMS_PER_PAGE);

        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        int startIndex = (currentPage - 1) * MAX_ITEMS_PER_PAGE;
        int endIndex = Math.min(startIndex + MAX_ITEMS_PER_PAGE, onlinePlayers.length);

        for (int i = startIndex; i < endIndex; i++) {
            Player onlinePlayer = onlinePlayers[i];
            ItemStack headItem = ItemUtils.getPlayerHead(onlinePlayer, onlinePlayer.getName(), null);
            inventory.addItem(headItem);
        }

        if (totalPages > 1) {
            if (currentPage > 1) {
                ItemStack previousPageItem = ItemUtils.createItem(Material.ARROW, 1, "Föregående sida", null, 0);
                inventory.setItem(inventory.getSize() - 2, previousPageItem);
            }

            if (currentPage < totalPages) {
                ItemStack nextPageItem = ItemUtils.createItem(Material.ARROW, 1, "Nästa sida", null, 0);
                inventory.setItem(inventory.getSize() - 1, nextPageItem);
            }
        }
    }

    @Override
    protected void handleClick(InventoryClickEvent event) {
        if (event.getRawSlot() == inventory.getSize() - 2 && currentPage > 1) {
            currentPage--;
            setItems();
            player.openInventory(inventory);
        }
        else if (event.getRawSlot() == inventory.getSize() - 1 && currentPage < Math.ceil((double) Bukkit.getOnlinePlayers().size() / MAX_ITEMS_PER_PAGE)) {
            currentPage++;
            setItems();
            player.openInventory(inventory);
        }
    }
}
