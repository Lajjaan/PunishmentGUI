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

import java.util.Arrays;

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

                Inventory inv = Bukkit.createInventory(player, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "PunishmentGUI");

                // IP-BAN
                ItemStack ipban = new ItemStack(Material.RED_CANDLE);
                ItemMeta ipbanMeta = ipban.getItemMeta();
                ipbanMeta.setDisplayName(ChatColor.DARK_RED + "IP-BAN");
                ipbanMeta.setLore(Arrays.asList(ChatColor.GRAY + "Permanently ip-ban a player!"));
                ipban.setItemMeta(ipbanMeta);

                inv.setItem(10, ipban);

                // BAN
                ItemStack ban = new ItemStack(Material.ORANGE_CANDLE);
                ItemMeta banMeta = ban.getItemMeta();
                banMeta.setDisplayName(ChatColor.GOLD + "BAN");
                banMeta.setLore(Arrays.asList(ChatColor.GRAY + "Temporarily ban a player!"));
                ban.setItemMeta(banMeta);

                inv.setItem(12, ban);

                // MUTE
                ItemStack mute = new ItemStack(Material.YELLOW_CANDLE);
                ItemMeta muteMeta = mute.getItemMeta();
                muteMeta.setDisplayName(ChatColor.YELLOW + "MUTE");
                muteMeta.setLore(Arrays.asList(ChatColor.GRAY + "Mute a player," + ChatColor.GRAY + " either temporarily or permanently!"));
                mute.setItemMeta(muteMeta);

                inv.setItem(13, mute);

                // KICK
                ItemStack kick = new ItemStack(Material.CANDLE);
                ItemMeta kickMeta = kick.getItemMeta();
                kickMeta.setDisplayName(ChatColor.WHITE + "KICK");
                kickMeta.setLore(Arrays.asList(ChatColor.GRAY + "Kick a player!"));
                kick.setItemMeta(kickMeta);

                inv.setItem(14, kick);

                // UNBAN
                ItemStack unban = new ItemStack(Material.LIME_CANDLE);
                ItemMeta unbanMeta = unban.getItemMeta();
                unbanMeta.setDisplayName(ChatColor.GREEN + "UNBAN");
                unbanMeta.setLore(Arrays.asList(ChatColor.GRAY + "Unban a player!"));
                unban.setItemMeta(unbanMeta);

                inv.setItem(16, unban);

                // CLOSE
                ItemStack close = new ItemStack(Material.RED_DYE);
                ItemMeta closeMeta = close.getItemMeta();
                closeMeta.setDisplayName(ChatColor.DARK_RED + "close");
                close.setItemMeta(closeMeta);

                inv.setItem(26, close);


                player.openInventory(inv);

            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }
        }
        return false;
    }
}