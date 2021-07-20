package fr.devteam.plugin.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;
import fr.devteam.plugin.helpers.ImageHelper;
import fr.devteam.plugin.helpers.RenderHelper;
import net.md_5.bungee.api.ChatColor;

public class TaskRenderImage extends BukkitRunnable {

	private Player player;
	private String path;

	public TaskRenderImage(Player player, String path) {
		this.player = player;
		this.path = path;
	}


	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void run() {
		try {

			final ArrayList<Short>mapsIds = new ArrayList<>();
			final BufferedImage image = ImageHelper.getImage(path);
			final int row = image.getHeight() / 128;
			final int cols = image.getWidth() / 128;
			
			MapView map;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < row; j++) {
					map = Bukkit.createMap(player.getWorld());
					map = RenderHelper.resetRenderers(map);
					map.setScale(MapView.Scale.FARTHEST);
					map.setUnlimitedTracking(false);
					map.addRenderer(new ImageMapRenderer(image.getSubimage(j * 128, i * 128, 128, 128)));
					
					mapsIds.add((short) map.getId());
				}
			}
			
			for(short id : mapsIds) {
				player.getInventory().addItem(new ItemStack(Material.MAP, 1, id));
			}
			
			final ImageMap imageMap = new ImageMap(UUID.randomUUID(), path, mapsIds);
			final ImageMapYML imageMapYML = new ImageMapYML(imageMap.getUuid());
			
			imageMapYML.write(imageMap);
			
		//Main.IMAGE_MAP_MANAGER.addImageMap(ImageMap);
		player.sendMessage(ChatColor.GREEN + "Rendu Terminé");

	} catch (IOException e) {
		Main.INSTANCE.getLogger().warning("Impossible de charger l'image " + path + ".");
		Main.INSTANCE.getLogger().warning(e.getMessage());
	}
}
}
