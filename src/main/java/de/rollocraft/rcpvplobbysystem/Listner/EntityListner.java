package de.rollocraft.rcpvplobbysystem.Listner;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EntityListner implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntity(PlayerInteractEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
            event.setCancelled(true);
        }
    }
}