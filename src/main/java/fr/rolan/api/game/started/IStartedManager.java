package fr.rolan.api.game.started;

public interface IStartedManager {
	public void unregisterListeners();

	void setClassManager(Class<?> object);

	Class<?> getClassManager();
	
	Object getInstanceObjectManager();
}
