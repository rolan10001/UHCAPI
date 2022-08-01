package fr.rolan.api.permissions;

import java.util.UUID;

import org.bukkit.entity.Player;

public interface IPermissions {
	public void updatePermissionsForPlayer(Player player);
	
	public boolean isAdmin(UUID uuid);
	
	public boolean isStaff(UUID uuid);
	
	public boolean isHost(UUID uuid);
}
