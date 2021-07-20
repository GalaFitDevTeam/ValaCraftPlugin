package fr.devteam.plugin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class dragonSpawnEvent implements Listener {


	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void dragonSpawn(EntitySpawnEvent event) {
		if(event.getEntity().getWorld().equals("world_the_end")) {
			if(event.getEntity().equals(EntityType.ENDER_DRAGON)) {
				event.setCancelled(true);
				Bukkit.broadcastMessage("ouou je suis relou");
			}
		}
	}
}
