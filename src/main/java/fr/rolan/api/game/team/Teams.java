package fr.rolan.api.game.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.rolan.api.UHCAPI;
import fr.rolan.api.player.IUser;
import fr.rolan.api.scoreboard.IScoreboardTeam;

public enum Teams {
	BLUE("BLUE", "§9§lBLEU", "§9", "", true, 9, (byte) 4, Arrays.asList()),
	RED("RED", "§c§lROUGE", "§c", "", true, 12, (byte) 1, Arrays.asList()),
	YELLOW("YELLOW", "§e§lJAUNE", "§e", "", true, 14, (byte) 11, Arrays.asList()),
	GREEN("GREEN", "§a§lVert", "§a", "", true, 10, (byte) 10, Arrays.asList()),
	PURPLE("PURPLE", "§5§lVIOLET", "§5", "", true, 5, (byte) 5, Arrays.asList()),
	ORANGE("ORANGE", "§6§lORANGE", "§6", "", true, 6, (byte) 14, Arrays.asList()),
	CYAN("CYAN", "§b§lCYAN", "§b", "", true, 11, (byte) 12, Arrays.asList()),
	PINK("PINK", "§d§lROSE", "§d", "", true, 13, (byte) 9, Arrays.asList()),
	DARK_AQUA("DARK_AQUA", "§3§lAQUA FONCÉ", "§3", "", true, 3, (byte) 6, Arrays.asList()),
	DARK_GREEN("DARK_GREEN", "§2§lVERT FONCÉ", "§2", "", true, 2, (byte) 2, Arrays.asList()),
	WHITE("WHITE", "§f§lBLANC", "§f", "", true, 15, (byte) 15, Arrays.asList()),
	GRAY("GRAY", "§7§lGRIS", "§7", "", true, 7, (byte) 7, Arrays.asList()),
	DARK_GRAY("DARK_GRAY", "§8§lGRIS FONCÉ", "§8", "", true, 8, (byte) 8, Arrays.asList()),
	DARK_RED("DARK_RED", "§4§lROUGE FONCÉ", "§4", "", true, 4, (byte) 1, Arrays.asList()),
	DARK_BLUE("DARK_BLUE", "§1§lBLUE FONCÉ", "§1", "", true, 1, (byte) 4, Arrays.asList()),
	DEFAULT("DEFAULT", "§7Default", "§7", "", true, 7, (byte) 7, Arrays.asList());
	
	private String name, displayname, prefix, suffix;
	private boolean friendlyfire;
	private int color;
	private byte bannercolor;
	private List<UUID> players;
	
	private Teams(String name, String displayname, String prefix, String suffix, boolean friendlyfire, int color, byte bannercolor, List<UUID> players) {
		this.setName(name);
		this.setPrefix(prefix);
		this.setSuffix(suffix);
		this.setFriendlyfire(friendlyfire);
		this.setColor(color);
		this.setBannercolor(bannercolor);
		this.setPlayers(players);
		this.setDisplayName(displayname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayName() {
		return displayname;
	}
	
	public void setDisplayName(String displayname) {
		this.displayname = displayname;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public boolean isFriendlyfire() {
		return friendlyfire;
	}

	public void setFriendlyfire(boolean friendlyfire) {
		this.friendlyfire = friendlyfire;
		try{UHCAPI.get().getTeam().getScoreboardTeam(getName()).setFriendlyFire(friendlyfire);}catch(NullPointerException e) {}
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public byte getBannercolor() {
		return bannercolor;
	}

	public void setBannercolor(byte bannercolor) {
		this.bannercolor = bannercolor;
	}

	public List<UUID> getPlayers() {
		return players;
	}

	public void setPlayers(List<UUID> players) {
		this.players = players;
	}
	
	public void addPlayer(UUID uuid) {
		IUser user = UHCAPI.get().getUser(uuid);
		try {user.getTeam().removePlayer(uuid);}catch(Exception e) {}
		List<UUID> list = new ArrayList<UUID>(players);
		list.add(uuid);
		setPlayers(list);
		IScoreboardTeam team = UHCAPI.get().getTeam().getScoreboardTeam(getName());
		for(Player players : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(team.updateTeam());
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(team.addOrRemovePlayer(3, Bukkit.getOfflinePlayer(uuid).getName()));
		}
		user.setTeam(this);
	}

	public void removePlayer(UUID uuid) {
		List<UUID> list = new ArrayList<UUID>(players);
		list.remove(uuid);
		setPlayers(list);
		IScoreboardTeam team = UHCAPI.get().getTeam().getScoreboardTeam(getName());
		for(Player players : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(team.updateTeam());
			((CraftPlayer) players).getHandle().playerConnection.sendPacket(team.addOrRemovePlayer(4, Bukkit.getOfflinePlayer(uuid).getName()));
		}
		IUser user = UHCAPI.get().getUser(uuid);
		user.setTeam(DEFAULT);
	}
}
