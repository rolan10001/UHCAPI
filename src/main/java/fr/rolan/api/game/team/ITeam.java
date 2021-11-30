package fr.rolan.api.game.team;

import java.util.List;

import org.bukkit.entity.Player;

import fr.rolan.api.scoreboard.IScoreboardTeam;

public interface ITeam {
	
	public List<IScoreboardTeam> getTeams();
	
	public Teams getTeam(String name);
	
	public IScoreboardTeam getScoreboardTeam(String name);
	
	public void updatePlayer(Player player);
	
	public void updateTeam();
}
