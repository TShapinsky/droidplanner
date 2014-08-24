package org.droidplanner.core.helpers.units;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UnitSet {
	private ArrayList<Unit> units;
	public UnitSet(Unit... units){
		this.units = new ArrayList<Unit>();
		Collections.addAll(this.units,units);
	}
}
