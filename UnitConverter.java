/*
 * UnitConverter class have methods for calculation and get array of unit
 * 
 * @author Wasuthun Wanaphongthipakorn.
 * */
public class UnitConverter
{
	// covert calculation.
	public double convert(double amount, Unit fromUnit, Unit toUnit)
	{
		return amount * fromUnit.getValue() / toUnit.getValue();
	}

	// get array of unit.
	public Unit[] getUnits(UnitTypes unitType)
	{
		return unitType.getUnit();
	}
}
