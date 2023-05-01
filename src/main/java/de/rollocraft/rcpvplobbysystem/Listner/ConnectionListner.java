package de.rollocraft.rcpvplobbysystem.Listner;

import com.sun.tools.javac.code.Type;
import de.rollocraft.rcpvplobbysystem.Ulity.PlayerScoreboard;
import de.rollocraft.rcpvplobbysystem.Ulity.Tablist;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ConnectionListner implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        event.getPlayer().getInventory().clear();

        ItemStack i = new ItemStack(Material.COMPASS);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName("Server Selector");
        i.setItemMeta(im);

        event.setJoinMessage("");
        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setHealth(20);

        PlayerScoreboard.showScoreboard(p);
        Bukkit.getOnlinePlayers().forEach(all -> PlayerScoreboard.updateTab(p));

    }

    @EventHandler
    public void onLeft(PlayerQuitEvent event) {
        event.setQuitMessage("");

    }
}