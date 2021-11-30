package fr.rolan.api.scoreboard;

import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;

public interface IScoreboardTeam {
	public PacketPlayOutScoreboardTeam createTeam();
	
	public PacketPlayOutScoreboardTeam updateTeam();
	
	public PacketPlayOutScoreboardTeam removeTeam();
	
	public PacketPlayOutScoreboardTeam setFriendlyFire(boolean v);
	
	public PacketPlayOutScoreboardTeam addOrRemovePlayer(int mode, String playerName);
	
	public String getName();
	
	public String getPrefix();
	
	public String getSuffix();
	
	public void setName(String name);
	
	public void setPrefix(String prefix);
	
	public void setSuffix(String suffix);
	
	public void setColor(int color);
	
	public int getColor();
}
