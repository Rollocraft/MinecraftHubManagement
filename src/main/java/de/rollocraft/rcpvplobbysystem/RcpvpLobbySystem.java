package de.rollocraft.rcpvplobbysystem;

import de.rollocraft.rcpvplobbysystem.Listner.*;
import de.rollocraft.rcpvplobbysystem.Ulity.PlayerScoreboard;
import de.rollocraft.rcpvplobbysystem.Ulity.Tablist;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class RcpvpLobbySystem extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListner(),this);
        pluginManager.registerEvents(new BlockListner(),this);
        pluginManager.registerEvents(new ItemListner(),this);
        pluginManager.registerEvents(new EntityListner(),this);
        pluginManager.registerEvents(new HungerListner(), this);
        pluginManager.registerEvents(new WeatherListner(), this);
        pluginManager.registerEvents(new DamageListner(), this);
        pluginManager.registerEvents(new PlayerScoreboard(), this);
        pluginManager.registerEvents(new Tablist(), this);

    }

}
