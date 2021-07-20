package fr.devteam.plugin.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.devteam.plugin.Main;

public class Coin {

	public static Coin instance;

	private static FileConfiguration getConfig = Main.INSTANCE.getConfig();

	public static Coin getInstance(){ return instance; }

	public static int getCoin(Player player)
	{
		return getConfig.getInt("coin.player."+player.getName());
	}

	public static void setCoin(Player player, double coin)
	{
		getConfig.set("coin.player."+player.getName(), coin);
	}

	public static void addCoin(Player player, double coin)
	{
		getConfig.set("coin.player."+player.getName(), getConfig.getInt("coin.player."+player.getName())+coin);
	}
	
	public static void removeCoin(Player player, double coin)
	{
		getConfig.set("coin.player."+player.getName(), getConfig.getInt("coin.player."+player.getName())-coin);
	}

	public void initCoin(Player player)
	{
		if(player.hasPlayedBefore()) {
			getConfig.set("coin.player."+player.getName(), getConfig.getInt("coin.addCoinWhenJoin"));
		}
	}
}
