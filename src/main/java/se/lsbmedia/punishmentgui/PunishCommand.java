package se.lsbmedia.punishmentgui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import se.lsbmedia.punishmentgui.menu.menus.PunishGUI;

public class PunishCommand implements CommandExecutor {

    private Main main;

    public PunishCommand(Main main) {
        this.main = main;
    }

                //       Command:     /punish <player>


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        // Checks if the executor is a player or not, (we don't want the console able to execute the command):
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Checks if the player has the right permission:
            if (player.hasPermission("punish.use")) {
                // Checks if the command is the correct length:
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    //PunishGUI gui = new PunishGUI(target, (Player) sender);
                    if (Bukkit.getPlayer(args[0]) != null) {
                        // Opens the start menu:
                        PunishGUI gui = new PunishGUI(player, target, 9, "Punish " + target.getDisplayName());
                        gui.open();

                    } else {
                        // Player not online:
                        player.sendMessage(ChatColor.RED + "This player is not online!");
                    }
                } else {
                    // Incorrect use of the command:
                    player.sendMessage(ChatColor.RED + "Invalid usage!" + "\n" + ChatColor.GRAY + "Correct usage: /punish <player>");
                    return true;
                }
            } else {
                // Missing permission:
                player.sendMessage(ChatColor.RED + "No permission.");
                return true;
            }
        }
        return true;
    }

}