package com.zzvc.model;

public class World {
	private String value;
	
	private String rare;
	
	private String version;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRare() {
		return rare;
	}

	public void setRare(String rare) {
		this.rare = rare;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "World [value=" + value + ", rare=" + rare + ", version=" + version + "]";
	}

	
}
