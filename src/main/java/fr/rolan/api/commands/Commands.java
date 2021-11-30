package fr.rolan.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface Commands {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);
}