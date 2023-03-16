package se.lsbmedia.punishmentgui.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import se.lsbmedia.punishmentgui.Main;

import java.util.HashMap;

public class PunishListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        e.getInventory();
        if (e.getCurrentItem() != null) {
            if (e.getView().getTitle().endsWith("PunishmentGUI")) {
                e.setCancelled(true);

                Player player = (Player) e.getWhoClicked();

                switch (e.getRawSlot()) {
                    case 10: // IP-BAN
                        InventoryUtils.ipBan((Player) e.getWhoClicked());
                        break;
                    case 12: // BAN
                        InventoryUtils.ban((Player) e.getWhoClicked());
                        break;

                    case 13: // MUTE

                        break;

                    case 14: // KICK

                        break;

                    case 16: // UNBAN

                        break;

                    case 26: // CLOSE
                        player.closeInventory();
                        break;

                    default:
                        return;
                }

            } else if (e.getView().getTitle().endsWith(ChatColor.AQUA.toString() + ChatColor.BOLD + "BAN")); {
                Player player = (Player) e.getWhoClicked();
                switch (e.getRawSlot()) {
                    case 0: // e.getName...
                        player.performCommand("");
                        player.closeInventory();
                        break;
                    case 26:
                        player.closeInventory();
                        break;

                }
            }
        }


    }

}
