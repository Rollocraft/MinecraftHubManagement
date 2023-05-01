package de.rollocraft.rcpvplobbysystem.Ulity;



import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.*;
import org.bukkit.ChatColor;

public class PlayerScoreboard implements Listener {

    public static void showScoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();


        Objective objective = board.registerNewObjective(ChatColor.DARK_AQUA + "R" + ChatColor.AQUA + "c" + ChatColor.LIGHT_PURPLE + "P" + ChatColor.DARK_PURPLE + "v" + ChatColor.LIGHT_PURPLE + "P", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore(ChatColor.BLUE + "Player").setScore(6);
        objective.getScore(ChatColor.WHITE + "  - " + p.getName()).setScore(5);
        objective.getScore(ChatColor.RED + "").setScore(4);
        objective.getScore(ChatColor.GOLD + "Level").setScore(3);
        objective.getScore(ChatColor.GREEN + "  -> Soon  ").setScore(2);
        objective.getScore(ChatColor.GREEN + "").setScore(1);
        objective.getScore(ChatColor.GOLD + "").setScore(0);

        p.setScoreboard(board);


    }
    public static void setTab(Player p) {
        Scoreboard board = p.getScoreboard();

        Team owner = board.registerNewTeam("0000Owner");
        Team builder = board.registerNewTeam("0001Builder");
        Team player = board.registerNewTeam("0002Player");

        owner.setPrefix("§4[Owner] §f");
        builder.setPrefix("§6[Builder] §f");

        Bukkit.getOnlinePlayers().forEach(all ->{
            if (all.hasPermission("P.Owner")) {
                owner.addEntry(all.getName());

            } else if (all.hasPermission("P.Builder")) {
                builder.addEntry(all.getName());

            } else {
                player.addEntry(all.getName());
            }

            p.setScoreboard(board);
        });
    }
    public static void updateTab(Player p) {
        Scoreboard board1 = p.getScoreboard();

        Team owner = board1.getTeam("0000Owner");
        Team builder = board1.getTeam("0001Builder");
        Team player = board1.getTeam("0002Player");

        if (owner == null || builder == null || player == null) {
            setTab(p);
            return;
        }

        Bukkit.getOnlinePlayers().forEach(all ->{
            if (all.hasPermission("P.Owner")) {
                owner.addEntry(all.getName());

            } else if (all.hasPermission("P.Builder")) {
                builder.addEntry(all.getName());

            } else {
                player.addEntry(all.getName());
            }
        });
        p.setScoreboard(board1);
    }
}
