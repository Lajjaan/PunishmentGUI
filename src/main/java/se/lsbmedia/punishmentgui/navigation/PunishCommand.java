package se.lsbmedia.punishmentgui.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import se.lsbmedia.punishmentgui.Main;

public class PunishCommand implements CommandExecutor {

    private Main main;

    public PunishCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("punish.use")) {



            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }
        }
        return false;
    }
}