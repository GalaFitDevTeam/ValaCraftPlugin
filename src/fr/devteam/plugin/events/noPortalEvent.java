package fr.devteam.plugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class noPortalEvent implements Listener {



	@EventHandler
	public void onPortalCreate(PortalCreateEvent event) {
		
		event.setCancelled(true);
		event.getEntity().sendMessage("tu ne peut pas en créer");
	}
}
