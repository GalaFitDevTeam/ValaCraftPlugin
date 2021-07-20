package fr.devteam.plugin.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Competence implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity player = event.getEntity();
		if(player.hasPermission("competence.noFall")) {
			if(event.getCause() == DamageCause.FALL) {
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		ItemStack bouf = new ItemStack(Material.PORKCHOP);
		ItemMeta bMeta = bouf.getItemMeta();
		Player player = event.getEntity();
		Player killer = player.getKiller();
		DamageCause deathCause = player.getLastDamageCause().getCause();

		bMeta.setDisplayName("§4" + player.getName() + " §6Steak");
		bMeta.setCustomModelData(11);
		bouf.setItemMeta(bMeta);
		net.minecraft.server.v1_16_R3.ItemStack boufs = CraftItemStack.asNMSCopy(bouf);

		if(deathCause == DamageCause.ENTITY_ATTACK) {
			if(player.hasPermission("competence.zombie")) {
				player.getWorld().dropItem(player.getLocation(), CraftItemStack.asBukkitCopy(boufs));
				Bukkit.broadcastMessage("§cLe zombie " + killer.getName() + " a tuer §6" + player.getName());
			}
		}
	}
	@EventHandler
	public void zombieEatEvent(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();
		
		if(!player.hasPermission("competence.zombie")) {
			if(item.getItemMeta().getCustomModelData() == 11) {
				Random random1 = new Random();
				int t;
				t = random1.nextInt(20*20);
				Random random = new Random();
				int p;
				p = random.nextInt(15);
				player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, t, p));
			}
		}
	}
	

	
	/*@EventHandler
	public void OnBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(player.hasPermission("competence.build")) {
			if(event.getBlock().getType().equals(Material.LEGACY_LOG) || event.getBlock().getType().equals(Material.LEGACY_LOG_2)) {
				if(event.getBlock().getLocation().equals(event.getBlock().getY() + 1)) {
					
				}
			}
		}
	}*/
}