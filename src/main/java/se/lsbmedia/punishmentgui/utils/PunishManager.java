package se.lsbmedia.punishmentgui.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import se.lsbmedia.punishmentgui.Main;

import java.nio.charset.StandardCharsets;

public class PunishManager {

    private final Main main = Main.getInstance();
    private final Player player, target;

    public PunishManager(Player player, Player target) {
        this.player = player;
        this.target = target;
    }

    public void punishPlayer(String punishType, String durationType, int duration) {

        String command = punishType + " " + target.getName();

        if (duration >= 1) {
            command = command + " " + duration + " " + durationType;
        }

        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        byte[] commandData = command.getBytes(StandardCharsets.UTF_8);
        out.writeShort(commandData.length);
        out.write(commandData);

        player.sendPluginMessage(main, "punishment_namespace:punish_channel", out.toByteArray());
    }

}
