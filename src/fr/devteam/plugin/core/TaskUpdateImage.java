package fr.devteam.plugin.core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.map.MapView;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;
import fr.devteam.plugin.helpers.ImageHelper;
import fr.devteam.plugin.helpers.RenderHelper;

public class TaskUpdateImage extends BukkitRunnable {

	private ImageMap imageMap;
	
	public void TaskRenderImage(ImageMap imageMap) {
		this.imageMap = imageMap;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			final BufferedImage image = ImageHelper.getImage(imageMap.getPath());
			final int cols = image.getWidth() / 128;
			final int row = image.getHeight() / 128;
 
 
			MapView map;
			int index = 0;
			for(int j = 0; j < cols; j++) {
				for(int i = 0; i < row; i++) {
					map = Bukkit.getMap(imageMap.getMapIds().get(index));
					map = RenderHelper.resetRenderers(map);
					map.setScale(MapView.Scale.FARTHEST);
					map.setUnlimitedTracking(false);
					map.addRenderer(new ImageMapRenderer(image.getSubimage(j * 128, i * 128, 128, 128)));
 
					index ++;
				}
			}
 
		
		} catch (IOException e) {
			Main.INSTANCE.getLogger().warning("Impossible de charger l'image" + imageMap.getPath() + ".");
			Main.INSTANCE.getLogger().warning(e.getMessage());
		}
	}


}
