package fr.devteam.plugin.events;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.devteam.plugin.Main;
import fr.devteam.plugin.core.scoresBoard;

public class JoinEvent implements Listener {

	private Main main;

	public JoinEvent(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		Player online = (Player) Bukkit.getOnlinePlayers();
		
		scoresBoard.createBoard(online);
		
		int level = player.getLevel();
		float xp = player.getExp();

		org.bukkit.Location location = new org.bukkit.Location(Bukkit.getWorld("world"), -35, 64, -248);
		player.teleport(location);
		Bukkit.broadcastMessage("§bSalut " + player.getDisplayName() + "!");

		Main.Join.add(player);

		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999999, 999999999, true));

		player.setLevel(0);
		player.setExp(0);

		BossBar Bar = Bukkit.createBossBar("salut", BarColor.RED, BarStyle.SOLID, BarFlag.CREATE_FOG);
		Bar.addPlayer(player);

		new JoinLaunch(main, player, level, xp, Bar).runTaskTimer(main, 0, 20);
		new maladie(main, player, level, xp, Bar).runTaskTimer(main, 0, 1200);



	}
	@SuppressWarnings("static-access")
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if (main.Join.contains(event.getPlayer())) {
			event.setCancelled(true);
		}
	}
}
