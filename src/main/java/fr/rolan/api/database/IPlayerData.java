package fr.rolan.api.database;

public interface IPlayerData {
	
	public void addKill(int power);
	
	public int getKill();
	
	public void addDeath(int power);
	
	public int getDeath();
	
	public void addKillStreak(int power);
	
	public int getKillStreak();
}
