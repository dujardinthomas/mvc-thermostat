package fr.univlille.iutinfo.r3_04.modelQ1;

import fr.univlille.iutinfo.r3_04.utils.Subject;

public class Thermogeekostat extends Subject implements ITemperature {

	public double tempMin = -10;
	public double tempMax = 30;
	public double tempValue = 20;

	public double d = tempValue;

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
	public void changeValues(double v) {
		this.d=v;
		this.notifyObservers(d);
	}

	@Override
	public void incrementTemperature() {
		if(d<tempMax && d>=tempMin) {
			this.d++;
			this.notifyObservers(d);
			System.out.println("new + : " +d);
		}

	}

	@Override
	public void decrementTemperature() {
		if(d<=tempMax && d>tempMin) {
			this.d--;
			this.notifyObservers(d);
			System.out.println("new - : " +d);
		}

	}

}
