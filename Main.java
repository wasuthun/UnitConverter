/*
 * Main contain main method for run program
 * 
 * @author Wasuthun Wanaphongthipakorn.
 * */
public class Main
{
	// main method
	public static void main(String[] args)
	{
		UnitConverter unitconverter = new UnitConverter();
		ConverterUI ui = new ConverterUI(unitconverter);
		ui.run();

	}
}
