package fr.rolan.api;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import fr.rolan.api.database.IDataBaseManager;
import fr.rolan.api.game.IGameManager;
import fr.rolan.api.game.game.IActifGameManager;
import fr.rolan.api.game.lobby.ILobbyManager;
import fr.rolan.api.game.started.IStartedManager;
import fr.rolan.api.game.team.ITeam;
import fr.rolan.api.game.teleportation.ITeleportationManager;
import fr.rolan.api.jda.IJDA;
import fr.rolan.api.permissions.IPermissions;
import fr.rolan.api.player.IUser;
import fr.rolan.api.scoreboard.IScoreboardManager;

public abstract class UHCAPI {
	private static UHCAPI INSTANCE;
	private JavaPlugin plugin;
	
	public UHCAPI(JavaPlugin plugin) {
		INSTANCE = this;
		this.plugin = plugin;
	}
	
	public void log(Level level, String text) {
		this.plugin.getLogger().log(level, text);
	}
	
	public JavaPlugin getPlugin() {
		return this.plugin;
	}
	
	public static UHCAPI get() {
		return INSTANCE;
	}
	
	public abstract IJDA getJDA();
	
	public abstract IDataBaseManager getDataBase();
	
	public abstract IPermissions getPermissions();
	
	public abstract ITeam getTeam();
	
	public abstract IUser getUser(UUID uuid);
	
	public abstract IUser getUser(Player player);
	
	public abstract Collection<IUser> getUsers();
	
	public abstract IScoreboardManager getScoreboardManager();
	
	public abstract IGameManager getGameManager();
	
	public abstract ILobbyManager getLobbyManager();
	
	public abstract void NewLobbyManager();
	
	public abstract IStartedManager getStartedManager();
	
	public abstract void NewStartedManager();

	public abstract List<Listener> getScenarios();
	
	public abstract ITeleportationManager getTeleportationManager();
	
	public abstract void NewTeleportationManager();
	
	public abstract IActifGameManager getActifGameManager();
	
	public abstract void NewActifGameManager();
}
