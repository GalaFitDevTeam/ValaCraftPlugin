package fr.devteam.plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.devteam.plugin.commands.CommandMap;
import fr.devteam.plugin.commands.commandAddCoin;
import fr.devteam.plugin.commands.commandFlyspeed;
import fr.devteam.plugin.commands.commandHat;
import fr.devteam.plugin.commands.commandHead;
import fr.devteam.plugin.commands.commandReload;
import fr.devteam.plugin.commands.commandRemoveCoin;
import fr.devteam.plugin.commands.commandSetCoin;
import fr.devteam.plugin.commands.commandSetSpawn;
import fr.devteam.plugin.commands.commandShop;
import fr.devteam.plugin.commands.commandSkull;
import fr.devteam.plugin.commands.commandSpawn;
import fr.devteam.plugin.commands.commandStat;
import fr.devteam.plugin.commands.competence.commandFly;
import fr.devteam.plugin.core.DataLoader;
import fr.devteam.plugin.core.ImageMapManager;
import fr.devteam.plugin.core.scoresBoard;
import fr.devteam.plugin.events.Competence;
import fr.devteam.plugin.events.JoinEvent;
import fr.devteam.plugin.events.blockSkullPlaced;
import fr.devteam.plugin.events.chatEvent;
import fr.devteam.plugin.events.customItems;
import fr.devteam.plugin.events.dragonSpawnEvent;
import fr.devteam.plugin.events.drinkWater;
import fr.devteam.plugin.events.gunsEvent;
import fr.devteam.plugin.events.mobDropHeadevent;
import fr.devteam.plugin.events.noPortalEvent;
import fr.devteam.plugin.events.shop;
import fr.devteam.plugin.events.spawnerBreak;
import fr.devteam.plugin.events.tpGui;


public class Main extends JavaPlugin {

	public static File IMAGES_DIR;
	public static File IMAGES_MAP_DIR;
	public static Main INSTANCE;
	public static ImageMapManager IMAGE_MAP_MANAGER;
	public static tpGui TP_GUI;
	public static shop SHOP;
	
	public static ArrayList<Player> Join = new ArrayList<Player>();
	//faire un system de competence
	
	@Override
	public void onEnable(){
		
		TP_GUI = new tpGui();
		SHOP = new shop();
		
		//---------------Map debut---------------
		
		INSTANCE = this;
		IMAGES_DIR = new File(getDataFolder(), "images");
		IMAGES_MAP_DIR = new File(getDataFolder(), "maps");
		IMAGE_MAP_MANAGER = new ImageMapManager();
		
		try {
			DataLoader.loadMaps();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//----------------Map fin----------------
		saveConfig();
		saveDefaultConfig();
		System.out.println("[Plugin] --> plugin on");
		PluginManager pm = getServer().getPluginManager();
		getCommand("head").setExecutor(new commandSkull());
		pm.registerEvents(new drinkWater(), this);
		pm.registerEvents(new Competence(),this);
		pm.registerEvents(new blockSkullPlaced(this), this);
		getCommand("fly").setExecutor(new commandFly());
		pm.registerEvents(new noPortalEvent(), this);
		getCommand("mystat").setExecutor(new commandStat());
		pm.registerEvents(new tpGui(), this);
		//getCommand("tpgui").setExecutor(new commandOpenTpGui());
		pm.registerEvents(new dragonSpawnEvent(), this);
		getCommand("skull").setExecutor(new commandHead());
		getCommand("setspawn").setExecutor(new commandSetSpawn(this));
		getCommand("spawn").setExecutor(new commandSpawn(this));
		pm.registerEvents(new JoinEvent(this), this);
		getCommand("flyspeed").setExecutor(new commandFlyspeed());
		pm.registerEvents(new gunsEvent(this), this);
		getCommand("map").setExecutor(new CommandMap());
		getCommand("reloadseri").setExecutor(new commandReload(this));
		pm.registerEvents(new chatEvent(), this);
		getCommand("hat").setExecutor(new commandHat());
		pm.registerEvents(new spawnerBreak(), this);
		pm.registerEvents(new customItems(), this);
		pm.registerEvents(new mobDropHeadevent(), this);
		getCommand("addcoin").setExecutor(new commandAddCoin());
		getCommand("removecoin").setExecutor(new commandRemoveCoin());
		getCommand("setcoin").setExecutor(new commandSetCoin());
		getCommand("shop").setExecutor(new commandShop());
		

		if(!Bukkit.getOnlinePlayers().isEmpty())
            for(Player online:Bukkit.getOnlinePlayers()) {
            	scoresBoard.createBoard(online);
            }
		
	}
	
	@Override
	public void onDisable() {
		saveConfig();
		saveDefaultConfig();
	}
	
}
