package de.rollocraft.rcpvplobbysystem.Listner;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListner implements Listener{

    @EventHandler(priority = EventPriority.HIGH)
    public void onGetHunger(EntityDamageEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) return;
        event.setCancelled(true);
    }
}

