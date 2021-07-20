package fr.devteam.plugin.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;

@SuppressWarnings("unused")
public class blockSkullDropWood extends BukkitRunnable{

	private Main main;
	private Skull s;
	private Random r;
	private Block b;

	public blockSkullDropWood(Main main, Skull s, Random r, Block b, Player player) {
		this.main = main;
		this.s = s;
		this.r = r;
		this.b = b;
	}


	@Override
	public void run() {
			int aleaNumber_b = r.nextInt(31);
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.OAK_PLANKS, aleaNumber_b));
	}
}
