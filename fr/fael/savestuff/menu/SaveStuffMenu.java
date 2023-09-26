package fr.fael.savestuff.menu;



import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.fael.savestuff.function.SaveStuffFunction;
import fr.fael.savestuff.main.SaveStuff;

public class SaveStuffMenu {
	
	public SaveStuffMenu(Player player) {
		OpenMenu(player, "Principale");
	}

	@SuppressWarnings("deprecation")
	private void OpenMenu(Player player, String string) {
		Inventory inv = Bukkit.createInventory(null, 5*9, SaveStuffFunction.menuName);
		

		ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
		ItemMeta paneMeta = glassPane.getItemMeta();
		paneMeta.setDisplayName("§0");
		
		ItemStack dontHaveStuff = new ItemStack(Material.INK_SACK, 1, DyeColor.SILVER.getData());
		ItemMeta dontHaveStuffMeta = dontHaveStuff.getItemMeta();
		dontHaveStuffMeta.setDisplayName("§7Aucun équipement");
		
		ItemStack watchStuff = new ItemStack(Material.EYE_OF_ENDER, 1);
		ItemMeta watchMeta = watchStuff.getItemMeta();
		watchMeta.setDisplayName("§eVoir l'équipement");
		
		ItemStack takeStuff = new ItemStack(Material.INK_SACK, 1, DyeColor.PURPLE.getData());
		ItemMeta takeMeta = takeStuff.getItemMeta();
		takeMeta.setDisplayName("§aPrendre l'équipement");

		ItemStack deleteStuff = new ItemStack(Material.INK_SACK, 1, DyeColor.ORANGE.getData());
		ItemMeta deleteMeta = deleteStuff.getItemMeta();
		deleteMeta.setDisplayName("§cSupprimer l'équipement");
		
		glassPane.setItemMeta(paneMeta);
		dontHaveStuff.setItemMeta(dontHaveStuffMeta);
		deleteStuff.setItemMeta(deleteMeta);

		inv.setItem(9, glassPane);
		inv.setItem(17, glassPane);
		inv.setItem(18, glassPane);
		inv.setItem(26, glassPane);
		inv.setItem(27, glassPane);
		inv.setItem(35, glassPane);
		
		for(int i = 0; i != 9; i++) {
			inv.setItem(i, glassPane);
		}
		for(int i = 36; i != 45; i++) {
			inv.setItem(i, glassPane);
		}
		
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		final ConfigurationSection confsec = config.getConfigurationSection("stuff.");
		final String hasStuff1 = confsec.getString("saved1");
		final String hasStuff2 = confsec.getString("saved2");
		final String hasStuff3 = confsec.getString("saved3");
		final String hasStuff4 = confsec.getString("saved4");
		final String hasStuff5 = confsec.getString("saved5");
		if(hasStuff1.equalsIgnoreCase("Oui")) {
			watchStuff.setItemMeta(watchMeta);
			takeStuff.setItemMeta(takeMeta);
			inv.setItem(11, takeStuff);
			inv.setItem(20, watchStuff);
			inv.setItem(29, deleteStuff);
		}else {
			inv.setItem(20, dontHaveStuff);
		}
		if(hasStuff2.equalsIgnoreCase("Oui")) {
			inv.setItem(12, takeStuff);
			inv.setItem(21, watchStuff);
			inv.setItem(30, deleteStuff);
		}else {
			inv.setItem(21, dontHaveStuff);
		}
		if(hasStuff3.equalsIgnoreCase("Oui")) {
			inv.setItem(13, takeStuff);
			inv.setItem(22, watchStuff);
			inv.setItem(31, deleteStuff);
		}else {
			inv.setItem(22, dontHaveStuff);
		}
		if(hasStuff4.equalsIgnoreCase("Oui")) {
			inv.setItem(14, takeStuff);
			inv.setItem(23, watchStuff);
			inv.setItem(32, deleteStuff);
		}else {
			inv.setItem(23, dontHaveStuff);
		}
		if(hasStuff5.equalsIgnoreCase("Oui")) {
			inv.setItem(15, takeStuff);
			inv.setItem(24, watchStuff);
			inv.setItem(33, deleteStuff);
		}else {
			inv.setItem(24, dontHaveStuff);
		}


		player.openInventory(inv);
		player.updateInventory();
	}
}
