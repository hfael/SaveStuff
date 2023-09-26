package fr.fael.savestuff.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.fael.savestuff.commands.SaveStuffCommands;
import fr.fael.savestuff.function.SaveStuffFunction;

public class SaveStuff extends JavaPlugin{
	
	static Plugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new SaveStuffListeners(), this);
		getCommand("savestuff").setExecutor(new SaveStuffCommands());
		super.onEnable();
	}
	public static Plugin getPlugin() {
		return plugin;
	}
	
	

	final File file = new File(this.getDataFolder(), "config.yml");
	public static String prefix = SaveStuffFunction.prefix;
	
	public static void Save(Player player, String num) throws IOException {
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		final ConfigurationSection confsec = config.getConfigurationSection("stuff");
		final String str = (String) num;
		if(confsec.getString(str) == null) {
			config.set("stuff." + num, player.getInventory().getContents());
			config.set("stuff.saved" + num, "Oui");
			config.save(file);
	        player.sendMessage(SaveStuffFunction.prefix + "§7Vous avez sauvegardé l'inventaire §6" + num + "§7.");
	        return;
		}else {
	        player.sendMessage(SaveStuffFunction.prefix + "§cErreur, vous avez déjà sauvegardé l'inventaire §e" + num +"§c.");
		}
	}
	@SuppressWarnings("unchecked")
	public static void GetStuff(Player player, String num) throws IOException {
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		ItemStack[] content = ((List<ItemStack>) config.get("stuff." + num)).toArray(new ItemStack[0]);
        player.closeInventory();
        player.getInventory().clear();
        player.getInventory().setContents(content);
        player.updateInventory();
        
        player.sendMessage(SaveStuffFunction.prefix + "§7Vous avez reçu l'inventaire §6" + num + "§7.");
		
	}
	public static void DeleteStuff(Player player, String num) throws IOException {
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("stuff.saved" + num, "Non");
		config.set("stuff." + num, null);
		config.save(file);
        player.closeInventory();
        
        player.sendMessage(SaveStuffFunction.prefix + "§7Vous avez supprimé l'inventaire §6" + num + "§7.");
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void SeeStuff(Player player, String num) throws IOException {
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		ItemStack[] content = ((List<ItemStack>) config.get("stuff." + num)).toArray(new ItemStack[0]);
        player.closeInventory();

		Inventory inv = Bukkit.createInventory(null, 5*9, SaveStuffFunction.menuName);
		
		
		ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
		ItemMeta paneMeta = glassPane.getItemMeta();
		paneMeta.setDisplayName("§0");

		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName("§cRetour");

        inv.setContents(content);
        glassPane.setItemMeta(paneMeta);
        arrow.setItemMeta(arrowMeta);

        player.openInventory(inv);
        
		for(int i = 37; i != 45; i++) {
			inv.setItem(i, glassPane);
		}
		inv.setItem(36, arrow);
	
        player.updateInventory();
        
		
	}
}
