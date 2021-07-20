package fr.devteam.plugin.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;

import fr.devteam.plugin.Main;

public class ImageMapYML {

	private UUID imageImageUUID;
	private File configFile;
	private org.bukkit.configuration.file.YamlConfiguration yamlConfiguration;
	
	public ImageMapYML(UUID imageImageUUID) {
		this.imageImageUUID = imageImageUUID;
		this.configFile = new File(Main.IMAGES_MAP_DIR, imageImageUUID.toString() + ".yml");
		this.yamlConfiguration = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(configFile);
	}
	
	public void write(ImageMap imageMap) {
		final ConfigurationSection config = this.yamlConfiguration.createSection("image");
		
		config.set("uuid", imageMap.getUuid().toString());
		config.set("path", imageMap.getPath());
		config.set("ids", imageMap.getMapIds());
		
		save();
	}
	
	public ImageMap read() {
		final ConfigurationSection config = this.yamlConfiguration.createSection("image");
		
		final String uuidStr = config.getString("uuid");
		final String path = config.getString("path");
		final ArrayList<Short> ids = (ArrayList<Short>)config.getShortList("ids");
		
		return new ImageMap(UUID.fromString(uuidStr), path, ids);
	}
	
	private void save() {
		try {
			yamlConfiguration.save(configFile);
		}catch (IOException e) {
			Main.INSTANCE.getLogger().severe("Cannot save image map Config file: " + imageImageUUID.toString() + ".yml");
		}
	}
	
}
