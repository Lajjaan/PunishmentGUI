package se.lsbmedia.punishmentgui.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import se.lsbmedia.punishmentgui.Main;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class PunishCommand implements CommandExecutor {

    private Main main;

    public PunishCommand(Main main) {
        this.main = main;
    }

                //              /punish <player>


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("punish.use")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    PunishGUI gui = new PunishGUI(target, (Player) sender);
                    if (Bukkit.getPlayer(args[0]) != null) {

                        gui.showPunisher();

                    } else {
                        player.sendMessage(ChatColor.RED + "This player is not online!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid usage!" + "\n" + ChatColor.GRAY + "Correct usage: /punish <player>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }
        }
        return true;
    }
}