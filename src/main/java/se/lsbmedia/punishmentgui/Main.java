package se.lsbmedia.punishmentgui;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import se.lsbmedia.punishmentgui.command.PunishCommand;
import se.lsbmedia.punishmentgui.menu.MenuEventHandler;

public final class Main extends JavaPlugin implements Listener {


    // When the program starts, the commands and events gets registered.
    @Override
    public void onEnable() {

        registerCommands();
        registerEvents();

    }

    private void registerCommands() {
        getCommand("punish").setExecutor(new PunishCommand(this));
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new MenuEventHandler(), this);
    }

}



