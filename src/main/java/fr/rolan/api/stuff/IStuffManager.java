package fr.rolan.api.stuff;

import org.bukkit.inventory.ItemStack;

public interface IStuffManager {
	public ItemStack[] getStuffStart();
	
	public void setStuffStart(ItemStack[] items);
	
	public ItemStack[] getStuffArmorStart();
	
	public void setStuffArmorStart(ItemStack[] items);
	
	public ItemStack[] getStuffDeath();
	
	public void setStuffDeath(ItemStack[] items);
	
	public ItemStack[] getStuffArmorDeath();
	
	public void setStuffArmorDeath(ItemStack[] items);
}
