package fr.univlille.iutinfo.r3_04.modelQ1;

import fr.univlille.iutinfo.r3_04.utils.Subject;

public class Thermogeekostat extends Subject implements ITemperature {

	public double d = 20;
	
	@Override
	public void setTemperature(double d) {
		this.d=d;
		
	}

	@Override
	public Double getTemperature() {
		// TODO Auto-generated method stub
		return d;
	}

	@Override
	public void incrementTemperature() {
		this.d++;
		this.notifyObservers(d);
		
	}

	@Override
	public void decrementTemperature() {
		this.d--;
		this.notifyObservers(d);
		
	}

}
