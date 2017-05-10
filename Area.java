/*
 * enum Area is Collected all unit and value for convert calculation
 * 
 * @author Wasuthun Wanaphongthipakorn.
 * */
public enum Area implements Unit
{
	Squarekilometer(1000000), Squaremeter(1.0), Squaredecimeter(100), Hectare(10000), Are(100), Squarewa(4.0);
	private final double value;

	// constructor
	Area(double value)
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
