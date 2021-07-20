package fr.devteam.plugin.events;

import org.bukkit.Sound;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;

@SuppressWarnings("unused")
public class JoinLaunch extends BukkitRunnable{
	
	private BossBar Bar;
	private Main main;
	private Player player;
	private int level;
	private float xp;

	private int timer = 10;
	public JoinLaunch(Main main, Player player, int level, float xp, BossBar Bar) {
		this.main = main;
		this.player = player;
		this.level = level;
		this.xp = xp;
		this.Bar = Bar;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		double timerp = 0.+timer;
		
		player.setLevel(timer);
		String Timer2 = String.valueOf(timer);
		Bar.setTitle(Timer2);
		
		if(timer == 10){
			Bar.setProgress(1);
		}
		if(timer == 9){
			Bar.setProgress(0.9);
		}
		if(timer == 8){
			Bar.setProgress(0.8);
		}
		if(timer == 7){
			Bar.setProgress(0.7);
		}
		if(timer == 6){
			Bar.setProgress(0.6);
		}
		if(timer == 5){
			Bar.setProgress(0.5);
		}
		if(timer == 4){
			Bar.setProgress(0.4);
		}
		if(timer == 3){
			Bar.setProgress(0.3);
		}
		if(timer == 2){
			Bar.setProgress(0.2);
		}
		if(timer == 1){
			Bar.setProgress(0.1);
		}
		

		
		if(timer == 0) {
			player.setLevel(level);
			player.setExp(xp);
			player.sendMessage("§2tu est maintenant login §b" + player.getDisplayName() + "§2!");
			player.removePotionEffect(PotionEffectType.BLINDNESS);
			Bar.removePlayer(player);
			main.Join.remove(player);
			player.playSound(player.getLocation(), Sound.BLOCK_CHAIN_BREAK, 1, 1);
			cancel();
		}

		
		
		timer --;
	}
}
