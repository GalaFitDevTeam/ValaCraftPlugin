package fr.devteam.plugin.core;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import fr.devteam.plugin.Main;

public class DataLoader {

	public static void loadMaps() throws IOException{
		final File imagesDir = Main.IMAGES_DIR;
		final File imagesMapDir = Main.IMAGES_MAP_DIR;
		
		if (!imagesDir.exists()) {
			if (!imagesDir.mkdirs()) {
				throw new IOException("Cannot create images directory.");
			}
		}
		if (!imagesMapDir.exists()) {
			if (!imagesMapDir.mkdirs()) {
				throw new IOException("Cannot create images maps directory.");
			}
		}
		
		final File[] files = imagesMapDir.listFiles();
		
		if (files != null) {
			ImageMap imageMap;
			ImageMapYML imageMapYML;
			
			for(File file : files) {
				if (file.getName().endsWith(".yml")) {
					imageMapYML = new ImageMapYML(UUID.fromString(file.getName().replaceAll(".yml", "")));
					imageMap = imageMapYML.read();
					
					Main.IMAGE_MAP_MANAGER.addImageMap(imageMap);
					
					new TaskUpdateImage().runTaskAsynchronously(Main.INSTANCE);
				}
			}
			
		}
		
	}
}
