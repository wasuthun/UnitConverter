/*
 * enum Length is Collected all unit and value for convert calculation
 * 
 * @author Wasuthun Wanaphongthipakorn.
 * */
public enum Length implements Unit
{
	Foot(0.3048), Inch(0.0254), Meter(1.0), Kilometer(1000.0), Micrometer(0.000001), Wa(2.0);
	private double value;

	// constructor
	Length(double value)
	{
		this.value = value;
	}

	@Override
	// get value of unit.
	public double getValue()
	{
		return this.value;
	}

}
