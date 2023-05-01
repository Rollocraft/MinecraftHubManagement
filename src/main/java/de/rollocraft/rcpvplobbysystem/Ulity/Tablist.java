package de.rollocraft.rcpvplobbysystem.Ulity;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Tablist implements Listener {
    public static void setTab(Player p) {
        Scoreboard board = p.getScoreboard();

        Team owner = board.registerNewTeam("0000Owner");
        Team admin = board.registerNewTeam("0001Admin");
        Team mod = board.registerNewTeam("0002Mod");
        Team player = board.registerNewTeam("0003Player");

        owner.setPrefix("§4[Owner] §f");
        admin.setPrefix("§c[Admin] §f");
        mod.setPrefix("§6[Mod] §f");

        Bukkit.getOnlinePlayers().forEach(all ->{
            if (all.hasPermission("P.Owner")) {
                owner.addEntry(all.getName());

            } else if (all.hasPermission("P.Admin")) {
                admin.addEntry(all.getName());

            } else if (all.hasPermission("P.Mod")) {
                admin.addEntry(all.getName());

            } else {
                player.addEntry(all.getName());
            }

            p.setScoreboard(board);
        });
    }

    public static void updateTab(Player p) {
        Scoreboard board1 = p.getScoreboard();

        Team owner = board1.getTeam("0000Owner");
        Team admin = board1.getTeam("0001Admin");
        Team mod = board1.getTeam("0002Mod");
        Team player = board1.getTeam("0003Player");

        if (owner == null || admin == null || mod == null || player == null) {
            setTab(p);
        }

        Bukkit.getOnlinePlayers().forEach(all ->{
            if (all.hasPermission("P.Owner")) {
                owner.addEntry(all.getName());

            } else if (all.hasPermission("P.Admin")) {
                admin.addEntry(all.getName());

            } else if (all.hasPermission("P.Mod")) {
                mod.addEntry(all.getName());

            } else {
                player.addEntry(all.getName());
            }
        });
        p.setScoreboard(board1);
    }
}

