package se.lsbmedia.punishmentgui.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class Menu implements Listener {

    Player punisher, target;

    public Menu(Player punisher, Player target) {

        this.punisher = punisher;
        this.target = target;

    }

    public abstract void handleClick();

    @EventHandler
    protected void onClick(InventoryClickEvent event) {



    }

}
