package se.lsbmedia.punishmentgui;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import se.lsbmedia.punishmentgui.navigation.PunishCommand;
import se.lsbmedia.punishmentgui.navigation.PunishListener;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        getCommand("punish").setExecutor(new PunishCommand(this));
        Bukkit.getPluginManager().registerEvents(new PunishListener(this), this);


    }



}



