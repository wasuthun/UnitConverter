/*
 * enum Weight is Collected all unit and value for convert calculation
 * 
 * @author Wasuthun Wanaphongthipakorn.
 * */
public enum Weight implements Unit
{
	Pound(453.592), Ton(1000000), Gram(1.0), Kilogram(1000.0), Microgram(0.000001), Tamlueng(60.0);

	private final double value;

	// constructor
	Weight(double value)
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
