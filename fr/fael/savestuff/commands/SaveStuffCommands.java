package fr.fael.savestuff.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.fael.savestuff.main.SaveStuff;
import fr.fael.savestuff.menu.SaveStuffMenu;

public class SaveStuffCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg) {
		if(sender instanceof Player) {
			if(label.equalsIgnoreCase("savestuff") || label.equalsIgnoreCase("ss")) {
				if(arg.length == 0) {
					new SaveStuffMenu((Player) sender);
					return true;
				}
				if(arg[0].equalsIgnoreCase("save")) {
					if(arg.length >= 2) {
						int stuff = Integer.parseInt(arg[1]);
						if(stuff > 0 && stuff < 6) {
							sender.sendMessage(SaveStuff.prefix + "§7Sauvegarde en cours de l'inventaire §6" + arg[1] + "§7.");
							try {
								SaveStuff.Save((Player)sender, arg[1]);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else {
							sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff save §6<1-5>) §4CODE 0§c.");
						}
					}else {
						sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff save §6<1-5>) §4CODE 1§c.");
						}
					}

				if(arg[0].equalsIgnoreCase("load")) {
					if(arg.length >= 2) {
						int stuff = Integer.parseInt(arg[1]);
						if(stuff > 0 && stuff < 6) {
							sender.sendMessage(SaveStuff.prefix + "§7Chargement en cours de l'inventaire §6" + arg[1] + "§7.");
							try {
								SaveStuff.GetStuff((Player)sender, arg[1]);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else {
							sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff load §6<1-5>) §4CODE 0§c.");
						}
					}else {
						sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff load §6<1-5>) §4CODE 1§c.");
						}
					}
				if(arg[0].equalsIgnoreCase("delete")) {
					if(arg.length >= 2) {
						int stuff = Integer.parseInt(arg[1]);
						if(stuff > 0 && stuff < 6) {
							sender.sendMessage(SaveStuff.prefix + "§7Suppression en cours de l'inventaire §6" + arg[1] + "§7.");
							try {
								SaveStuff.DeleteStuff((Player)sender, arg[1]);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else {
							sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff delete §6<1-5>) §4CODE 0§c.");
						}
					}else {
						sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff delete §6<1-5>) §4CODE 1§c.");
						}
					}

				if(arg[0].equalsIgnoreCase("see") || arg[0].equalsIgnoreCase("watch")) {
					if(arg.length >= 2) {
						int stuff = Integer.parseInt(arg[1]);
						if(stuff > 0 && stuff < 6) {
							sender.sendMessage(SaveStuff.prefix + "§7Suppression en cours de l'inventaire §6" + arg[1] + "§7.");
							try {
								SaveStuff.SeeStuff((Player)sender, arg[1]);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else {
							sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff watch §6<1-5>) §4CODE 0§c.");
						}
					}else {
						sender.sendMessage(SaveStuff.prefix + "§cArgument invalide ! §e(/savestuff watch §6<1-5>) §4CODE 1§c.");
						}
					}
				}else {
					System.out.println("Vous n'etes pas un joueur !");
			}
		}
		return true;
	}
}
