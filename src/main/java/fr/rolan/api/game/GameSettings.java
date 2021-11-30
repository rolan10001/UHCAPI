package fr.rolan.api.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;

import fr.rolan.tools.scoreboard.ScoreboardHealth;

public class GameSettings {
	public static int EPISODE = 1;
	public static int SECOND = 0;
	public static int MINUTE = 0;
	public static int HEURE = 0;
	public static int MINUTES = 0;
	public static int PLAYERS = 0;
	public static WorldBorder BORDER = Bukkit.getWorld("Host").getWorldBorder();
	public static List<UUID> PLAYERS_LIST = new ArrayList<UUID>();
	public static ScoreboardHealth HEALTH_SCOREBOARD;
}
