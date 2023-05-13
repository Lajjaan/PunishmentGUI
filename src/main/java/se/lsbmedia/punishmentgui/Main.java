package se.lsbmedia.punishmentgui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import se.lsbmedia.punishmentgui.menu.MenuEventHandler;

public final class Main extends JavaPlugin implements Listener {


    // When the program starts, the command is registered.
    @Override
    public void onEnable() {
        getCommand("punish").setExecutor(new PunishCommand(this));
        getServer().getPluginManager().registerEvents(new MenuEventHandler(), this);
       // getServer().getPluginManager().registerEvents(new PunishListener(this), this);


    }

}



