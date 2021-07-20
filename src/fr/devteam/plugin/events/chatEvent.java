package fr.devteam.plugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatEvent implements Listener {

	@EventHandler
	public void OnChatEvent(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		event.setFormat("§4["+player.getName()+"]§r "+ ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	}
	
}
