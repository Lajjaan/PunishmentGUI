package se.lsbmedia.punishmentgui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.checkerframework.checker.guieffect.qual.UI;
import se.lsbmedia.punishmentgui.navigation.BanUI;
import se.lsbmedia.punishmentgui.navigation.IpbanUI;
import se.lsbmedia.punishmentgui.navigation.MuteUI;
import se.lsbmedia.punishmentgui.navigation.PunishGUI;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public class PunishListener implements Listener {

    private Main main;

    PunishListener(Main main) {
        this.main = main;
    }

    // What happens when the GUI is opened
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if (e.getView().getTitle().equals(TextUtils.color("&b&lPunish: &c" + PunishGUI.getTarget().getName()))) {

            e.getWhoClicked().sendMessage("hej1");

            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                e.getWhoClicked().sendMessage("hej2");
                Player player = (Player) e.getWhoClicked();
                // What happens if you click on one of the start menu's options.

                switch (e.getRawSlot()) {
                    case 10: // IP-BAN
                        player.sendMessage("hej3");
                        player.sendMessage("Din lurk!");
                        IpbanUI ipbanUI = new IpbanUI(PunishGUI.getTarget(), PunishGUI.getPunisher());
                        ipbanUI.showPunisher();
                        break;
                    case 12: // BAN
                        // BanUI banUI = new BanUI(punishGUI.getTarget(), punishGUI.getPunisher());
                        // banUI.showPunisher();
                        break;

                    case 13: // MUTE
                        // MuteUI muteUI = new MuteUI(punishGUI.getTarget(), punishGUI.getPunisher());
                        // muteUI.showPunisher();
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
            }

        }

        /*else if (e.getView().getTitle().endsWith(ChatColor.AQUA.toString() + ChatColor.BOLD + "BAN")) {
            Player player = (Player) e.getWhoClicked();
            switch (e.getRawSlot()) {
                case 0: // e.getName...
                    player.performCommand("ban " + PunishGUI.getTarget().getName() + " 1d");
                    player.closeInventory();
                    break;
                case 26:
                    player.closeInventory();
                    break;
            }
        }
         */
    }

}