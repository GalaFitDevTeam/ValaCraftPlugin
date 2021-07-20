package fr.devteam.plugin.events;

import java.util.Random;

import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;
@SuppressWarnings("unused")
public class blockSkullDropMobs extends BukkitRunnable{


	private Main main;
	private Skull s;
	private Random r;
	private Block b;

	public blockSkullDropMobs(Main main, Skull s, Random r, Block b, Player player) {
		this.main = main;
		this.s = s;
		this.r = r;
		this.b = b;
	}

	@Override
	public void run() {
		int alea_b = r.nextInt(4);

		switch (alea_b) {
		case 0:
			b.getWorld().spawnEntity(b.getLocation(), EntityType.CREEPER);
			break;

		case 1:
			b.getWorld().spawnEntity(b.getLocation(), EntityType.SPIDER);
			break;

		case 2:
			b.getWorld().spawnEntity(b.getLocation(), EntityType.SKELETON);
			break;

		default:
			b.getWorld().spawnEntity(b.getLocation(), EntityType.ZOMBIE);
			break;
		}

	}

}
