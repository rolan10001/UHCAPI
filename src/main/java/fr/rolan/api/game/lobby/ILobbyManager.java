package fr.rolan.api.game.lobby;

import java.util.Map;

import org.bukkit.entity.Player;

import fr.rolan.api.game.lobby.arena.IArenaManager;

public interface ILobbyManager {
	public IArenaManager getArenaManager();
	
	public void setPlayerLobby(Player player);
	
	public void unregisterListeners();
	
	public Map<Integer, String> setLobbyScoreboard();
}
