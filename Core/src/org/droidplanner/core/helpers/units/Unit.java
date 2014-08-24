package org.droidplanner.core.helpers.units;

public class Unit implements Comparable{
	private double conversionFactor;
	private String unitName;
	private String suffix;
	public Unit(String unitName, String suffix, double conversionFactor){
		this.unitName = unitName;
		this.suffix = suffix;
		this.conversionFactor = conversionFactor;
	}

	public String getUnitName(){
		return unitName;
	}

	public double getValue(double value){
		return value * conversionFactor;
	}

	public String toString(double value){
		return value*conversionFactor + " " + suffix;
	}

	/**
	 *
	 * @param value value in standard unit
	 * @param precision number of digits behind the decimal place
	 * @return rounded value with suffix
	 */
	public String toString(double value, int precision){
		return roundToPrecision(value,precision) + " " + suffix;
	}

	public String toSpokenString(double value, int precision){
		return roundToPrecision(value, precision) + " " + unitName;
	}

	private double roundToPrecision(double value, int precision){
		precision = (int)Math.pow(10,precision);
		return Math.round(value*conversionFactor*precision)/(double)precision;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Unit) {
			Unit unit = (Unit)o;
			if(unit.getValue(1.0) - conversionFactor > 0 ){
				return 1;
			}else if(unit.getValue(1.0) - conversionFactor < 0 ){
				return -1;
			}
		}
		return 0;
	}
}
