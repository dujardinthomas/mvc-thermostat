package fr.univlille.iutinfo.r3_04.modelQ2;

import fr.univlille.iutinfo.r3_04.modelQ1.ITemperature;
import fr.univlille.iutinfo.r3_04.utils.ConnectableProperty;
import fr.univlille.iutinfo.r3_04.utils.Subject;

public class Temperature extends ConnectableProperty implements ITemperature {


	protected Echelle echelle;

	public Temperature(Echelle e) {
		super();
		this.setValue(0.0);
		echelle = e;
	}
	
	public Echelle getEchelle() {
		return echelle;

	}
	public Double getTemperature() {
		return (double)this.getValue();
	}

	public void setTemperature(double val) {
		this.setValue(val);
	}

	@Override
	public void incrementTemperature() {
		setValue( (double)value + 1);
		
	}
	@Override
	public void decrementTemperature() {
		setValue( (double)value - 1);
	}
	
	@Override
	public void update(Subject other, Object data) {
		Temperature tOther = (Temperature) other;
		double tK =  tOther.echelle.toKelvin((double) data);
		
		this.setValue(echelle.fromKelvin(tK));
	}

	
	

}