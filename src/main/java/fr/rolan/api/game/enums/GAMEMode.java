package fr.rolan.api.game.enums;

import fr.rolan.api.UHCAPI;

public enum GAMEMode {
	UHC("UHC", "§6UHC"),
	OTHER("", "");
	
	private String name, displayName;
	
	private GAMEMode(String name, String displayName) {
		this.name = name;
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		UHCAPI.get().getSettings().MODE_NAME = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		UHCAPI.get().getSettings().MODE_DISPLAYNAME = displayName;
	}
}
