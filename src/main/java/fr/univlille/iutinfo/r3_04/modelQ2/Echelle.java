package fr.univlille.iutinfo.r3_04.modelQ2;

import java.util.Map;
import java.util.function.Function;

public enum Echelle {
	CELSIUS("Celsius", "C"), 
	DELISLE("Delisle", "D"), 
	FAHRENHEIT("Fahrenheit", "F"), 
	KELVIN("Kelvin", "K"), 
	LEYDEN("Leyden", "L"), 
	NEWTON("Newton", "N"), 
	RANKINE("Rankine", "Ra"), 
	REAUMUR("Reaumur", "Re"), 
	ROMER("Romer", "Ro");
	
	
	private String name;
	private String abbrev;

	Echelle(String name, String abbrev) {
		this.abbrev = abbrev;
		this.name = name;
	}
	
	private static Map<Echelle,Function<Double,Double>> fromKelvin = Map.ofEntries(
			Map.entry(CELSIUS, (v) -> v - 273.15 ) ,
			Map.entry(FAHRENHEIT, (v) -> (v - 273.15) * 9.0 / 5.0 + 32.0 ) ,
			Map.entry(KELVIN, (v) -> v ) ,
			Map.entry(NEWTON, (v) -> (v  - 273.15) * 0.33 ) ,
			Map.entry(RANKINE, (v) -> v * 1.8 ) 
			);

	private static Map<Echelle,Function<Double,Double>> toKelvin = Map.ofEntries(
			Map.entry(CELSIUS, (v) -> v + 273.15 ) ,
			Map.entry(FAHRENHEIT, (v) -> (v - 32.0) * 5.0 / 9.0 + 273.15 ) ,
			Map.entry(KELVIN, (v) -> v ) ,
			Map.entry(NEWTON, (v) -> v  / 0.33 + 273.15 ) ,
			Map.entry(RANKINE, (v) -> v / 1.8 ) 
			);

	
	public double toKelvin(double value) {
		return toKelvin.get(this).apply(value);
		
	}
	
	public double fromKelvin(double value) {
		return fromKelvin.get(this).apply(value);
		
	}
	
	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}