package com.atgugui.optional;

import java.util.Optional;

public class NewMan {

	private Optional<Godness> god=Optional.empty();

	public Optional<Godness> getGod() {
		return god;
	}

	public void setGod(Optional<Godness> god) {
		this.god = god;
	}

	@Override
	public String toString() {
		return "NewMan [god=" + god + "]";
	}

	public NewMan(Optional<Godness> god) {
		super();
		this.god = god;
	}

	public NewMan() {
		super();
	}
	
}
