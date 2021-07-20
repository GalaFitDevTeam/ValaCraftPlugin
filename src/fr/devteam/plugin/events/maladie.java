package fr.devteam.plugin.events;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;

@SuppressWarnings("unused")
public class maladie extends BukkitRunnable{

	
	private BossBar Bar;
	private Main main;
	private Player player;
	private int level;
	private float xp;
	
	public maladie(Main main, Player player, int level, float xp, BossBar Bar) {
		this.main = main;
		this.player = player;
		this.level = level;
		this.xp = xp;
		this.Bar = Bar;
	}

	@Override
	public void run() {

		Random r = new Random();
		if(player.getGameMode().equals(GameMode.SURVIVAL)) {
			int alea = r.nextInt(13);
			int aleanumber = r.nextInt(10);
			switch (alea) {
			case 0:
				player.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, 9999999, 999999999, true));
				break;
			case 1:
				player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, aleanumber, 999999999, true));
				break;
			case 2:
				player.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, 9999999, 999999999, true));
				break;
			case 3:
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 9999999, 999999999, true));
				break;
			case 4:
				player.removePotionEffect(PotionEffectType.HUNGER);
				break;
			case 5:
				player.removePotionEffect(PotionEffectType.UNLUCK);
				break;
			case 6:
				player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				break;
			case 7:
				player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				break;
			case 8:
				player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				break;
			case 9:
				player.removePotionEffect(PotionEffectType.UNLUCK);
				break;
			case 10:
				player.removePotionEffect(PotionEffectType.UNLUCK);
				break;
			case 11:
				player.removePotionEffect(PotionEffectType.UNLUCK);
				break;
			case 12:
				player.removePotionEffect(PotionEffectType.HUNGER);
				break;

			}
		}
	}
}
