package se.lsbmedia.punishmentgui.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import se.lsbmedia.punishmentgui.Main;
import se.lsbmedia.punishmentgui.utils.TextUtils;

public class ReloadCommand implements CommandExecutor {

    //       Command:     /punish <player>
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Checks if the executor is a player or not, (we don't want the console able to execute the command):
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        // Checks if the player has the right permission:
        if (!player.hasPermission("punish.use")) {
            player.sendMessage(ChatColor.RED + "No permission.");
        }

        Main.getInstance().reloadConfig();
        player.sendMessage(TextUtils.color("&aPunishmentGUI has been reloaded."));

        return true;
    }

}
