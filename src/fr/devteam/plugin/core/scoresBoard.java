package fr.devteam.plugin.core;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.md_5.bungee.api.ChatColor;

public class scoresBoard {

	public static void createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("HubScoreboard-1","dummy",
                ChatColor.translateAlternateColorCodes('&', " &c<< &bValaCraft &c>> "));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore(ChatColor.RED+"ValaCoin: " + Coin.getCoin(player));
        score.setScore(3);
        Score score2 = obj.getScore(ChatColor.AQUA+"Jouer en ligne: "+ChatColor.DARK_AQUA+Bukkit.getOnlinePlayers().size());
        score2.setScore(2);
        Score score3 = obj.getScore(ChatColor.AQUA+"Entités tuées: "+ChatColor.DARK_AQUA+player.getStatistic(Statistic.MOB_KILLS));
        score3.setScore(1);
        Score score4 = obj.getScore(ChatColor.AQUA+"Morts Totales: "+ChatColor.DARK_AQUA+player.getStatistic(Statistic.DEATHS));
        score4.setScore(0);
        player.setScoreboard(board);
    }
	
	public static void createtag(Player player) {
		int playerheal = (int) player.getHealth();
		String playerhs = String.valueOf(playerheal);
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("HubScoreboard-1","dummy",
                ChatColor.translateAlternateColorCodes('&', " &c<< &bValaCraft &c>> "));
        obj.setDisplaySlot(DisplaySlot.BELOW_NAME);
        Score score = obj.getScore(playerhs);
        score.isScoreSet();
    }
	
}
