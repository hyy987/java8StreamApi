package com.atgugui.optional;

public class Man {

	private Godness godness;

	public Godness getGodness() {
		return godness;
	}

	public void setGodness(Godness godness) {
		this.godness = godness;
	}

	@Override
	public String toString() {
		return "Man [godness=" + godness + "]";
	}

	public Man(Godness godness) {
		super();
		this.godness = godness;
	}

	public Man() {
		super();
	}
	
	
}
