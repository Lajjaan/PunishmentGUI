package se.lsbmedia.punishmentgui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    // When the program starts, the command is registered.
    @Override
    public void onEnable() {
        getCommand("punish").setExecutor(new PunishCommand(this));
        Bukkit.getPluginManager().registerEvents(new PunishListener(this), this);


    }



}



