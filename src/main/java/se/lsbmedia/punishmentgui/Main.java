package se.lsbmedia.punishmentgui;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import se.lsbmedia.punishmentgui.command.PunishCommand;
import se.lsbmedia.punishmentgui.command.ReloadCommand;
import se.lsbmedia.punishmentgui.menu.MenuEventHandler;

import java.nio.charset.StandardCharsets;

public final class Main extends JavaPlugin {

    private static Main instance;

    // When the program starts, the commands and events gets registered.
    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        instance = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this, "punishment_namespace:punish_channel");

        registerCommands();
        registerEvents();
    }

    private void registerCommands() {
        getCommand("punish").setExecutor(new PunishCommand());
        getCommand("punishreload").setExecutor(new ReloadCommand());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new MenuEventHandler(), this);
    }

    public static Main getInstance() {
        return instance;
    }


    public void punishPlayer(Player player, Player target, String punishType, int days) {

        String command = punishType + " " + target.getName();

        if (days >= 1) {
            command = command + " " + days + " d";
        }

        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        byte[] commandData = command.getBytes(StandardCharsets.UTF_8);
        out.writeShort(commandData.length);
        out.write(commandData);

        player.sendPluginMessage(this, "punishment_namespace:punish_channel", out.toByteArray());
    }

}



