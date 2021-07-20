package fr.devteam.plugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.devteam.plugin.core.scoresBoard;

public class mobDropHeadevent implements Listener {

	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		Entity entity = event.getEntity();
		
		if(entity.getLastDamageCause().getCause().equals(DamageCause.ENTITY_EXPLOSION)) {
			EntityType entitydead = entity.getType();
			
			if(entitydead == EntityType.CREEPER) {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.CREEPER_HEAD));
			}
			if(entitydead == EntityType.ZOMBIE) {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.ZOMBIE_HEAD));
			}
			if(entitydead == EntityType.SKELETON) {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.SKELETON_SKULL));
			}
			if(entitydead == EntityType.WITHER) {
				entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.WITHER_SKELETON_SKULL));
			}
			
			if(!Bukkit.getOnlinePlayers().isEmpty())
	            for(Player online:Bukkit.getOnlinePlayers()) {
	            	scoresBoard.createtag(online);
	        }
		}
	}
}
