package fr.fael.savestuff.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import fr.fael.savestuff.function.SaveStuffFunction;
import fr.fael.savestuff.menu.SaveStuffMenu;

public class SaveStuffListeners implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) throws IOException{
		Player player = event.getPlayer();
		final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
		if(!file.exists()) {
			System.out.println("Premiere connexion depuis l'ajout de SaveStuff pour " + player.getName());
			SaveStuffFunction.initPlayer(player);
		}
	}
	@EventHandler
	public void onInvClick(InventoryClickEvent event) throws IOException {
		Player player = (Player) event.getWhoClicked();
		String inv = player.getOpenInventory().getTitle();
		ItemStack current = event.getCurrentItem();
		if(current != null && inv.equalsIgnoreCase(SaveStuffFunction.menuName)) {
			event.setCancelled(true);
			final File file = new File(SaveStuff.getPlugin().getDataFolder(), "PlayerData/" + player.getUniqueId() + ".yml");
			final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			final ConfigurationSection confsec = config.getConfigurationSection("stuff");
			if(event.getSlot() == 36) {
				if(current.getType() == Material.ARROW) {
					new SaveStuffMenu(player);
				}
			}
			//********************************************************
			if(event.getSlot() == 11) {
				final String hasStuff1 = confsec.getString("1");
				if(hasStuff1 != null) {
					SaveStuff.GetStuff(player, "1");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 12) {
				final String hasStuff2 = confsec.getString("2");
				if(hasStuff2 != null) {
					SaveStuff.GetStuff(player, "2");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 13) {
				final String hasStuff3 = confsec.getString("3");
				if(hasStuff3 != null) {
					SaveStuff.GetStuff(player, "3");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 14) {
				final String hasStuff4 = confsec.getString("4");
				if(hasStuff4 != null) {
					SaveStuff.GetStuff(player, "4");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 15) {
				final String hasStuff5 = confsec.getString("5");
				if(hasStuff5 != null) {
					SaveStuff.GetStuff(player, "5");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			//********************************************************

			if(event.getSlot() == 29) {
				final String hasStuff1 = confsec.getString("1");
				if(hasStuff1 != null) {
					SaveStuff.DeleteStuff(player, "1");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 30) {
				final String hasStuff2 = confsec.getString("2");
				if(hasStuff2 != null) {
					SaveStuff.DeleteStuff(player, "2");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 31) {
				final String hasStuff3 = confsec.getString("3");
				if(hasStuff3 != null) {
					SaveStuff.DeleteStuff(player, "3");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 32) {
				final String hasStuff4 = confsec.getString("4");
				if(hasStuff4 != null) {
					SaveStuff.DeleteStuff(player, "4");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 33) {
				final String hasStuff5 = confsec.getString("5");
				if(hasStuff5 != null) {
					SaveStuff.DeleteStuff(player, "5");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}

			//********************************************************
			if(event.getSlot() == 20) {
				final String hasStuff1 = confsec.getString("1");
				if(hasStuff1 != null) {
					SaveStuff.SeeStuff(player, "1");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 21) {
				final String hasStuff2 = confsec.getString("2");
				if(hasStuff2 != null) {
					SaveStuff.SeeStuff(player, "2");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 22) {
				final String hasStuff3 = confsec.getString("3");
				if(hasStuff3 != null) {
					SaveStuff.SeeStuff(player, "3");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 23) {
				final String hasStuff4 = confsec.getString("4");
				if(hasStuff4 != null) {
					SaveStuff.SeeStuff(player, "4");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
			if(event.getSlot() == 24) {
				final String hasStuff5 = confsec.getString("5");
				if(hasStuff5 != null) {
					SaveStuff.SeeStuff(player, "5");
					return;
				}else {
					player.sendMessage(SaveStuff.prefix + "§cUne erreur est survenue ! §4CODE 4");
				}
			}
		}
	}
}
