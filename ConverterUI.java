import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Unit converterUI
 * 
 * @author Wasuthun Wanaphongthipakorn.
 *
 */
public class ConverterUI implements Runnable
{
	// attributes
	private JFrame fame;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem item;
	private UnitConverter converter;
	private JLabel label;
	private JTextField textField1, textField2;
	private JButton button, clear;
	private JComboBox<Unit> unit1, unit2;

	/**
	 * Initialize ConverterUI with UnitConverter object and call initComponants.
	 * 
	 * @param unitconverter
	 *            is the object of UnitConverter.
	 */
	public ConverterUI(UnitConverter unitconverter)
	{
		converter = unitconverter;
		fame = new JFrame();
		fame.setTitle("Unit Converter");
		fame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent();
	}

	/**
	 * crate components.
	 */
	public void initComponent()
	{ // Menu bar
		menuBar = new JMenuBar();
		menu = new JMenu("Unit type");
		// menuItems
		Selected selected = new Selected();
		item = new JMenuItem("Length");
		item.addActionListener(selected);
		menu.add(item);

		item = new JMenuItem("Area");
		item.addActionListener(selected);
		menu.add(item);

		item = new JMenuItem("Weight");
		item.addActionListener(selected);
		menu.add(item);

		item = new JMenuItem("Volume");
		item.addActionListener(selected);
		menu.add(item);
		menu.addSeparator();

		item = new JMenuItem("Exit");
		item.addActionListener(selected);
		menu.add(item);

		menuBar.add(menu);

		JPanel panel = new JPanel();
		textField1 = new JTextField(7);
		unit1 = new JComboBox<>();
		label = new JLabel("=");
		unit2 = new JComboBox<>();
		textField2 = new JTextField(7);
		button = new JButton("Convert");
		clear = new JButton("Clear!! ");
		// add action
		ConvertListener conlistener = new ConvertListener();
		button.addActionListener(conlistener);
		textField1.addKeyListener(conlistener);
		textField2.addKeyListener(conlistener);

		ClearButtonListener clearlistener = new ClearButtonListener();
		clear.addActionListener(clearlistener);

		panel.add(textField1);
		panel.add(unit1);
		panel.add(label);
		panel.add(textField2);
		panel.add(unit2);
		panel.add(button);
		panel.add(clear);

		fame.setJMenuBar(menuBar);
		fame.add(panel);
		fame.pack();

	}

	/**
	 * Action listener for munubar.
	 *
	 */
	class Selected implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JMenuItem exitPressed = (JMenuItem) (e.getSource());
			if (exitPressed.getText().equalsIgnoreCase("exit"))
			{
				fame.dispose();
			} else
			{
				textField1.setForeground(null);
				textField2.setForeground(null);
				textField2.setText("");
				textField1.setText("");
				unit1.removeAllItems();
				unit2.removeAllItems();
				UnitTypes clicked = UnitTypes.valueOf(e.getActionCommand().toUpperCase());
				Unit[] typePicker = clicked.getUnit();
				for (Unit unit : typePicker)
				{
					unit1.addItem(unit);
					unit2.addItem(unit);
				}
				fame.pack();

			}

		}

	}

	/**
	 * Action listener for convert values.
	 *
	 */
	class ConvertListener implements ActionListener, KeyListener
	{

		private double nLeft = 0, nRight = 0;
		private boolean hasLeft = false, hasRight = false;
		private Unit uLeft, uRight;
		private String numLeftKeep = "";
		private String numRightKeep = "";

		@Override
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				actionPerformed(null);
			}

		}

		@Override
		public void keyReleased(KeyEvent e)
		{

		}

		@Override
		public void keyTyped(KeyEvent e)
		{

		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				textField1.setForeground(null);
				textField2.setForeground(null);
				if (!textField1.getText().equals(""))
				{
					nLeft = Double.parseDouble(textField1.getText());
					hasLeft = true;
				} else if (textField1.getText().equals(""))
				{
					hasLeft = false;
				}
				if (!textField2.getText().equals(""))
				{
					nRight = Double.parseDouble(textField2.getText());
					hasRight = true;
				} else if (textField2.getText().equals(""))
				{
					hasRight = false;
				}
				uLeft = (Unit) unit1.getSelectedItem();
				uRight = (Unit) unit2.getSelectedItem();
				if (!hasLeft && !hasRight)
				{
					numLeftKeep = "";
					numRightKeep = "";
				}
				if ((hasLeft && !hasRight) || (hasLeft && hasRight && !textField1.getText().equals(numLeftKeep))
						|| (hasLeft && hasRight && textField2.getText().equals(numRightKeep)))
				{
					textField2.setText(String.format("%.5g", converter.convert(nLeft, uLeft, uRight)));
					numLeftKeep = textField1.getText();
					numRightKeep = textField2.getText();
				}
				if ((!hasLeft && hasRight) || (!textField2.getText().equals(numRightKeep)))
				{
					textField1.setText(String.format("%.5g", converter.convert(nRight, uRight, uLeft)));
					numLeftKeep = textField1.getText();
					numRightKeep = textField2.getText();
				}
			} catch (NumberFormatException x)
			{
				textField2.setForeground(Color.RED);
				textField1.setForeground(Color.RED);
			} catch (NullPointerException y)
			{
				JOptionPane.showMessageDialog(fame, "Please select unit type");
			}
		}

	}

	/**
	 * Action listener for clear all values in textField1 and textField2.
	 *
	 */
	class ClearButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			textField1.setText("");
			textField2.setText("");

		}

	}

	/**
	 * For display the graphics window.
	 */
	@Override
	public void run()
	{

		fame.setVisible(true);

	}
}
