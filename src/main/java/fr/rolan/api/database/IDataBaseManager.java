package fr.rolan.api.database;

import java.util.UUID;

import com.mysql.jdbc.Connection;

public interface IDataBaseManager {
	public Connection getConnection();
	
	public void createAccount(UUID uuid);
	
	public boolean hasAccount(UUID uuid);
	
	public void connexion();
	
	public void deconnexion();
	
	public boolean isOnline();
}
