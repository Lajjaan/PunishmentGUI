package se.lsbmedia.punishmentgui;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import se.lsbmedia.punishmentgui.command.PunishCommand;
import se.lsbmedia.punishmentgui.command.ReloadCommand;
import se.lsbmedia.punishmentgui.menu.MenuEventHandler;

public final class Main extends JavaPlugin implements PluginMessageListener {

    private static Main instance;
    private String[] allPlayers;

    // When the program starts, the commands and events gets registered.
    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        instance = this;
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerOutgoingPluginChannel(this, "punishment_namespace:punish_channel");

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        //make sure to unregister the registered channels in case of a reload
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
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

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        allPlayers = input.readUTF().split(", ");
    }

    public void sendPluginMessage(Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerList");
        out.writeUTF("ALL");
        player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
    }

    public String[] getAllPlayers() {
        return allPlayers;
    }
}



