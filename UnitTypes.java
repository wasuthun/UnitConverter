/*
 * enum UnitTypes is collected all of unit
 * 
 * @author Wasuthun Wanaphongthipakorn.*/
public enum UnitTypes
{

	LENGTH(Length.values()), AREA(Area.values()), WEIGHT(Weight.values()), VOLUME(Volume.values());
	private Unit[] units;

	// constructor of enum
	UnitTypes(Unit[] unit)
	{
		units = unit;
	}

	// get array of unit
	public Unit[] getUnit()
	{
		return units;
	}

}
