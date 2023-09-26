package fr.fael.savestuff.function;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.fael.savestuff.main.SaveStuff;

public class SaveStuffFunction {

	public static String prefix = "§9SaveStuff §8» ";
	public static String menuName = "§9SaveStuff §8- §eInventaires";
	
	public static void initPlayer(Player player) throws IOException {
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stuff.saved1", "Non");
		config.set("stuff.saved2", "Non");
		config.set("stuff.saved3", "Non");
		config.set("stuff.saved4", "Non");
		config.set("stuff.saved5", "Non");
		config.save(file);
	}
}
