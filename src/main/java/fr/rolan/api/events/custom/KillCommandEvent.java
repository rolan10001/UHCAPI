package fr.rolan.api.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotation.NotNull;

public class KillCommandEvent extends Event {
	
	private static final HandlerList HANDLERS_LIST = new HandlerList();
	private final CommandSender sender;
	private final Command cmd;
	private final String label;
	private final String[] args;
	
	public KillCommandEvent(CommandSender sender, Command cmd, String label, String[] args) {
		this.sender = sender;
		this.cmd = cmd;
		this.label = label;
		this.args = args;
	}
	
	@NotNull
	public HandlerList getHandlers() {
		return HANDLERS_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}

	public CommandSender getSender() {
		return sender;
	}

	public Command getCommand() {
		return cmd;
	}

	public String getLabel() {
		return label;
	}

	public String[] getArgs() {
		return args;
	}
}
