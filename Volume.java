/*
 * enum Volume is Collected all unit and value for convert calculation
 * 
 * @author Wasuthun Wanaphongthipakorn.
 * */
public enum Volume implements Unit
{
	Quart(0.000946353), Gallon(0.00378541), Cubicmeter(1.0), Cubickilometer(1000000000.0), Cubicmicrometer(
			1e-18), Kwian(2);

	private final double value;

	// constructor
	Volume(double value)
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
