import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/*******************************************************************************
 * Name: Tom Niu Assignment: PP6.14 Description: pizza delivery
 ******************************************************************************/
public class Pizza extends JPanel {
	// pizza
	private JPanel PizzaPanel;
	private JLabel lPizzaCost;
	private double[] aPizza = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0 };
	private double[] aSide = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	private JRadioButton small, medium, large, xlarge;
	private JRadioButton sourdough, deep_dish, normal, chicago, ny;
	private JRadioButton marinara, alfredo, teriyaki, dijon, barbecue;
	private JCheckBox american, swiss, mozzerela, pepper_jack, feta;
	private JCheckBox onion, tomato, green_pepper, olive, mushroom, pineapple,
			garlic, artichoke, arugula, shallot;
	private JCheckBox peperoni, sausage, chicken, bacon, salmon;
	private JPanel pSize, pBread, pSauce, pVeggie, pMeat, pCheese;
	private JTextField quantity;
	private JLabel lQuantity;
	private JButton bPizzaClear, bPizzaAdd;
	private double PizzaTotal = 0;

	// sides
	private JPanel SidePanel;
	private JCheckBox buffalo_wing, bread_stick, cheesy_bread, cinnamon_stick,
			chocolate_dunker, pizza_roller, garlic_bread, browny, chip,
			ice_cream;
	private JTextField s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
	private JButton bSideClear, bSideAdd;
	private JLabel lSideCost;
	private double SideTotal = 0;
	private JPanel side;

	// drinks
	private double[] aDrink = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private double[] aCostDrink = { 1.5, 1, 1, 1.5, 1, 1, .75, .75, .75, .5 };
	private JPanel DrinkPanel;
	private JPanel drink;
	private JCheckBox mountain_dew, pepsi, coke, fanta, sprite, dr_pepper,
			grape_juice, water, orange_juice, apple_juice;
	private JTextField d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
	private JButton bDrinkClear, bDrinkAdd;
	private JLabel lDrinkCost;
	private double DrinkTotal = 0;

	// tab
	private JTabbedPane tp;
	private JLabel lTitle;
	private JButton bTotal, bClear;
	private JLabel lCost;
	private double total;

	private ActionListener CostHandler;
	private NumberFormat formatter;

	public Pizza() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		formatter = new DecimalFormat("#0.00");
		CostHandler = new CostHandler();
		// pizza
		PizzaPanel = new JPanel();
		PizzaPanel.setLayout(new BoxLayout(PizzaPanel, BoxLayout.Y_AXIS));
		// size
		small = new JRadioButton("Small");
		medium = new JRadioButton("Medium (x1.2 base)");
		large = new JRadioButton("Large (x1.3 base)");
		xlarge = new JRadioButton("xLarge (x1.5 base)");
		small.setName("e");
		medium.setName("e");
		large.setName("e");
		xlarge.setName("e");
		// bread
		sourdough = new JRadioButton("Sour dough");
		deep_dish = new JRadioButton("Deep Dish");
		normal = new JRadioButton("Normal");
		chicago = new JRadioButton("Chicago");
		ny = new JRadioButton("New York");
		// sauce
		marinara = new JRadioButton("Marinara");
		alfredo = new JRadioButton("Alfredo");
		teriyaki = new JRadioButton("teriyaki");
		dijon = new JRadioButton("Dijon Mustard");
		barbecue = new JRadioButton("Barbeque");
		// cheese
		american = new JCheckBox("American");
		swiss = new JCheckBox("Swiss");
		mozzerela = new JCheckBox("Mozzerela");
		pepper_jack = new JCheckBox("Pepper Jack");
		feta = new JCheckBox("Feta");
		// veggie
		onion = new JCheckBox("Onion");
		tomato = new JCheckBox("tomato");
		green_pepper = new JCheckBox("Green pepper");
		olive = new JCheckBox("Olive");
		mushroom = new JCheckBox("Mushroom");
		pineapple = new JCheckBox("Pineapple");
		garlic = new JCheckBox("Garlic");
		artichoke = new JCheckBox("Artichoke");
		arugula = new JCheckBox("Arugula");
		shallot = new JCheckBox("Shallot");
		// meat
		peperoni = new JCheckBox("Peperoni");
		sausage = new JCheckBox("Sausage");
		chicken = new JCheckBox("Chicken");
		bacon = new JCheckBox("Bacon");
		salmon = new JCheckBox("Salmon");

		ButtonGroup gSize = new ButtonGroup();
		gSize.add(small);
		gSize.add(medium);
		gSize.add(large);
		gSize.add(xlarge);

		ButtonGroup gBread = new ButtonGroup();
		gBread.add(sourdough);
		gBread.add(deep_dish);
		gBread.add(normal);
		gBread.add(chicago);
		gBread.add(ny);

		ButtonGroup gSauce = new ButtonGroup();
		gSauce.add(marinara);
		gSauce.add(alfredo);
		gSauce.add(teriyaki);
		gSauce.add(dijon);
		gSauce.add(barbecue);


		pSize = new JPanel();
		pSize.setBorder(BorderFactory.createTitledBorder("Size"));
		pSize.setLayout(new BoxLayout(pSize, BoxLayout.Y_AXIS));
		pSize.add(small);
		pSize.add(medium);
		pSize.add(large);
		pSize.add(xlarge);

		pBread = new JPanel();
		pBread.setBorder(BorderFactory.createTitledBorder("Bread"));
		pBread.setLayout(new BoxLayout(pBread, BoxLayout.Y_AXIS));
		pBread.add(sourdough);
		pBread.add(deep_dish);
		pBread.add(normal);
		pBread.add(chicago);
		pBread.add(ny);

		pSauce = new JPanel();
		pSauce.setBorder(BorderFactory.createTitledBorder("Sauce"));
		pSauce.setLayout(new BoxLayout(pSauce, BoxLayout.Y_AXIS));
		pSauce.add(marinara);
		pSauce.add(alfredo);
		pSauce.add(teriyaki);
		pSauce.add(dijon);
		pSauce.add(barbecue);

		pCheese = new JPanel();
		pCheese.setBorder(BorderFactory.createTitledBorder("Cheese ($1)"));
		pCheese.setLayout(new BoxLayout(pCheese, BoxLayout.Y_AXIS));
		pCheese.add(american);
		pCheese.add(swiss);
		pCheese.add(mozzerela);
		pCheese.add(pepper_jack);
		pCheese.add(feta);

		pVeggie = new JPanel();
		pVeggie.setBorder(BorderFactory.createTitledBorder("Veggie ($0.5)"));
		pVeggie.setLayout(new BoxLayout(pVeggie, BoxLayout.Y_AXIS));
		pVeggie.add(onion);
		pVeggie.add(tomato);
		pVeggie.add(green_pepper);
		pVeggie.add(olive);
		pVeggie.add(mushroom);
		pVeggie.add(pineapple);
		pVeggie.add(garlic);
		pVeggie.add(artichoke);
		pVeggie.add(arugula);
		pVeggie.add(shallot);

		pMeat = new JPanel();
		pMeat.setBorder(BorderFactory.createTitledBorder("Meat ($1.5)"));
		pMeat.setLayout(new BoxLayout(pMeat, BoxLayout.Y_AXIS));
		pMeat.add(peperoni);
		pMeat.add(sausage);
		pMeat.add(chicken);
		pMeat.add(bacon);
		pMeat.add(salmon);

		JPanel pOne = new JPanel();
		TitledBorder b = BorderFactory.createTitledBorder("Select One Each");
		b.setTitleJustification(TitledBorder.CENTER);
		pOne.setBorder(b);
		pOne.add(pSize);
		pOne.add(pBread);
		pOne.add(pSauce);

		JPanel pMany = new JPanel();
		TitledBorder b1 = BorderFactory.createTitledBorder("Toppings");
		b1.setTitleJustification(TitledBorder.CENTER);
		pMany.setBorder(b1);
		pMany.add(pCheese);
		pMany.add(pVeggie);
		pMany.add(pMeat);

		lQuantity = new JLabel("Qty: ");

		quantity = new JTextField(5);
		quantity.setSize(1, 10);

		bPizzaAdd = new JButton("Add Current Item");
		bPizzaClear = new JButton("CLEAR COST");
		bPizzaAdd.addActionListener(CostHandler);
		bPizzaClear.addActionListener(CostHandler);

		lPizzaCost = new JLabel("$0.00");
		lPizzaCost.setPreferredSize(new Dimension(10, 20));
		JPanel bPizzaAC = new JPanel();
		bPizzaAC.setLayout(new BoxLayout(bPizzaAC, BoxLayout.X_AXIS));
		bPizzaAC.add(bPizzaAdd);
		bPizzaAC.add(Box.createHorizontalStrut(10));
		bPizzaAC.add(lPizzaCost);
		bPizzaAC.add(Box.createHorizontalStrut(10));
		bPizzaAC.add(bPizzaClear);

		PizzaPanel.add(pOne);
		PizzaPanel.add(pMany);

		PizzaPanel.add(lQuantity);
		PizzaPanel.add(quantity);
		PizzaPanel.add(bPizzaAC);
		// sides
		SidePanel = new JPanel();
		side = new JPanel();
		TitledBorder SideBorder = BorderFactory.createTitledBorder("Sides");
		SideBorder.setTitleJustification(TitledBorder.CENTER);
		side.setLayout(new GridLayout(10, 2));
		side.setBorder(SideBorder);
		buffalo_wing = new JCheckBox("Buffalo Wings");
		bread_stick = new JCheckBox("Bread Sticks");
		cheesy_bread = new JCheckBox("Cheesy Bread");
		cinnamon_stick = new JCheckBox("Cinnamon Stick");
		chocolate_dunker = new JCheckBox("Chocolate Dunker");
		pizza_roller = new JCheckBox("Pizza Roller");
		garlic_bread = new JCheckBox("Garlic Bread");
		browny = new JCheckBox("Brownies");
		chip = new JCheckBox("Chips");
		ice_cream = new JCheckBox("Ice Cream");

		buffalo_wing.setName("buffalo_wing");
		bread_stick.setName("bread_stick");
		cheesy_bread.setName("cheesy_bread");
		cinnamon_stick.setName("cinnamon_stick");
		chocolate_dunker.setName("chocolate_dunker");
		pizza_roller.setName("pizza_roller");
		garlic_bread.setName("garlic_bread");
		browny.setName("browny");
		chip.setName("chip");
		ice_cream.setName("ice_cream");

		s1 = new JTextField();
		s2 = new JTextField();
		s3 = new JTextField();
		s4 = new JTextField();
		s5 = new JTextField();
		s6 = new JTextField();
		s7 = new JTextField();
		s8 = new JTextField();
		s9 = new JTextField();
		s10 = new JTextField();

		side.add(buffalo_wing);
		side.add(s1);
		side.add(bread_stick);
		side.add(s2);
		side.add(cheesy_bread);
		side.add(s3);
		side.add(cinnamon_stick);
		side.add(s4);
		side.add(chocolate_dunker);
		side.add(s5);
		side.add(pizza_roller);
		side.add(s6);
		side.add(garlic_bread);
		side.add(s7);
		side.add(browny);
		side.add(s8);
		side.add(chip);
		side.add(s9);
		side.add(ice_cream);
		side.add(s10);

		lSideCost = new JLabel("$0.00");
		bSideAdd = new JButton("Add Current Item");
		bSideClear = new JButton("Clear Cost");
		bSideAdd.addActionListener(CostHandler);
		bSideClear.addActionListener(CostHandler);

		JPanel bSideAC = new JPanel();
		bSideAC.setLayout(new BoxLayout(bSideAC, BoxLayout.X_AXIS));
		bSideAC.add(bSideAdd);
		bSideAC.add(Box.createHorizontalStrut(10));
		bSideAC.add(lSideCost);
		bSideAC.add(Box.createHorizontalStrut(10));
		bSideAC.add(bSideClear);

		SidePanel.add(side);
		SidePanel.add(bSideAC);

		// Drinks
		DrinkPanel = new JPanel();
		drink = new JPanel();
		drink.setLayout(new GridLayout(10, 2));
		TitledBorder DrinkBorder = BorderFactory.createTitledBorder("Drinks");
		DrinkBorder.setTitleJustification(TitledBorder.CENTER);
		drink.setBorder(DrinkBorder);
		mountain_dew = new JCheckBox("Mountain Dew");
		pepsi = new JCheckBox("Pepsi");
		coke = new JCheckBox("Coke");
		fanta = new JCheckBox("Fanta");
		sprite = new JCheckBox("Sprite");
		dr_pepper = new JCheckBox("Dr Pepper");
		grape_juice = new JCheckBox("Grape Juice");
		orange_juice = new JCheckBox("Orange Juice");
		apple_juice = new JCheckBox("Apple Juice");
		water = new JCheckBox("Water");

		d1 = new JTextField();
		d2 = new JTextField();
		d3 = new JTextField();
		d4 = new JTextField();
		d5 = new JTextField();
		d6 = new JTextField();
		d7 = new JTextField();
		d8 = new JTextField();
		d9 = new JTextField();
		d10 = new JTextField();

		drink.add(mountain_dew);
		drink.add(d1);
		drink.add(pepsi);
		drink.add(d2);
		drink.add(coke);
		drink.add(d3);
		drink.add(fanta);
		drink.add(d4);
		drink.add(sprite);
		drink.add(d5);
		drink.add(dr_pepper);
		drink.add(d6);
		drink.add(grape_juice);
		drink.add(d7);
		drink.add(orange_juice);
		drink.add(d8);
		drink.add(apple_juice);
		drink.add(d9);
		drink.add(water);
		drink.add(d10);

		bDrinkClear = new JButton("Clear cost");
		bDrinkAdd = new JButton("Add Current Item");
		bDrinkClear.addActionListener(CostHandler);
		bDrinkAdd.addActionListener(CostHandler);
		lDrinkCost = new JLabel("$0.00");

		JPanel bDrinkAC = new JPanel();
		bDrinkAC.setLayout(new BoxLayout(bDrinkAC, BoxLayout.X_AXIS));
		bDrinkAC.add(bDrinkAdd);
		bDrinkAC.add(Box.createHorizontalStrut(10));
		bDrinkAC.add(lDrinkCost);
		bDrinkAC.add(Box.createHorizontalStrut(10));
		bDrinkAC.add(bDrinkClear);

		DrinkPanel.add(drink);
		DrinkPanel.add(bDrinkAC);

		// tab

		lTitle = new JLabel("Pizza Delivery");
		lTitle.setFont(new Font("title", 1, 20));
		lTitle.setAlignmentX(CENTER_ALIGNMENT);

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		bTotal = new JButton("Total Cost");
		bClear = new JButton("Clear Total");
		bTotal.addActionListener(new CostHandler());
		bClear.addActionListener(new CostHandler());
		lCost = new JLabel("$0.00");
		p.add(bTotal);
		p.add(Box.createHorizontalGlue());
		p.add(lCost);
		p.add(Box.createHorizontalGlue());
		p.add(bClear);
		tp = new JTabbedPane();
		tp.addTab("Pizza", PizzaPanel);
		tp.addTab("Sides", SidePanel);
		tp.addTab("Drinks", DrinkPanel);
		add(lTitle);
		add(tp);
		add(p);

	}

	public double getCost(String name) {
		double value;
		if (name == "buffalo_wing")
			value = 5;
		else if (name == "bread_stick")
			value = 3;
		else if (name == "cheesy_bread")
			value = 3.5;
		else if (name == "cinnamon_stick")
			value = 2;
		else if (name == "chocolate_dunker")
			value = 4;
		else if (name == "pizza_roller")
			value = 3;
		else if (name == "garlic_bread")
			value = 2;
		else if (name == "browny")
			value = 1.5;
		else if (name == "chip")
			value = 1;
		else
			value = 1;
		return value;
	}

	public class CostHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == bPizzaAdd) {

				double sum = 0,factor = 1;
				for (int i = 0; i < 24; i++)
					aPizza[i] = 0;
				Component[] cSize = pSize.getComponents();
				Component[] cCheese = pCheese.getComponents();
				Component[] cVeggie = pVeggie.getComponents();
				Component[] cMeat = pMeat.getComponents();

				for (int i = 0; i <= 3; i++) {
					JRadioButton JB = (JRadioButton) cSize[i];
					if (JB.isSelected()){
						aPizza[i] = (int) (JB.getName().charAt(0) - 96);
					if(i == 0)factor = 1;	
					else if(i==1)factor = 1.2;
					else if(i==2)factor = 1.3;
					else factor= 1.5;
					}
				}
				for (int i = 0; i <= 4; i++) {
					JCheckBox JB = (JCheckBox) cCheese[i];
					if (JB.isSelected())
						aPizza[i + 4] = 1;
				}
				for (int i = 0; i <= 9; i++) {
					JCheckBox JB = (JCheckBox) cVeggie[i];
					if (JB.isSelected())
						aPizza[i + 9] = .5;
				}
				for (int i = 0; i <= 4; i++) {
					JCheckBox JB = (JCheckBox) cMeat[i];
					if (JB.isSelected())
						aPizza[i + 19] = 1.5;
				}
				for (int i = 0; i < 24; i++)
					sum = sum + aPizza[i];

				int q = 1;
				try {
					q = Integer.parseInt(quantity.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PizzaTotal = PizzaTotal + factor*sum * q;

				lPizzaCost.setText("$ " + formatter.format(PizzaTotal));

			} else if (e.getSource() == bPizzaClear) {
				PizzaTotal = 0;

				lPizzaCost.setText("$ " + formatter.format(PizzaTotal));
			}

			else if (e.getSource() == bSideAdd) {

				for (int i = 0; i < 10; i++)
					aSide[i] = 0;
				Component[] cSide = side.getComponents();

				for (int i = 0; i <= 18; i = i + 2) {
					JCheckBox JB = (JCheckBox) cSide[i];
					if (JB.isSelected())
						aSide[i / 2] = getCost(JB.getName());
				}

				int[] q = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
				try {
					q[0] = Integer.parseInt(s1.getText().toString());
					q[1] = Integer.parseInt(s2.getText().toString());
					q[2] = Integer.parseInt(s3.getText().toString());
					q[3] = Integer.parseInt(s4.getText().toString());
					q[4] = Integer.parseInt(s5.getText().toString());
					q[5] = Integer.parseInt(s6.getText().toString());
					q[6] = Integer.parseInt(s7.getText().toString());
					q[7] = Integer.parseInt(s8.getText().toString());
					q[8] = Integer.parseInt(s9.getText().toString());
					q[9] = Integer.parseInt(s10.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					SideTotal = SideTotal + aSide[i] * q[i];
				}

				lSideCost.setText("$ " + formatter.format(SideTotal));
			} else if (e.getSource() == bSideClear) {
				SideTotal = 0;
				lSideCost.setText("$ " + formatter.format(SideTotal));
				
			} else if (e.getSource() == bDrinkAdd) {
				for (int i = 0; i < 10; i++)
					aDrink[i] = 0;
				Component[] cDrink = drink.getComponents();

				for (int i = 0; i <= 18; i = i + 2) {
					JCheckBox JB = (JCheckBox) cDrink[i];
					if (JB.isSelected())
						aDrink[i / 2] = aCostDrink[i / 2];
				}

				int[] q = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
				try {
					q[0] = Integer.parseInt(s1.getText().toString());
					q[1] = Integer.parseInt(s2.getText().toString());
					q[2] = Integer.parseInt(s3.getText().toString());
					q[3] = Integer.parseInt(s4.getText().toString());
					q[4] = Integer.parseInt(s5.getText().toString());
					q[5] = Integer.parseInt(s6.getText().toString());
					q[6] = Integer.parseInt(s7.getText().toString());
					q[7] = Integer.parseInt(s8.getText().toString());
					q[8] = Integer.parseInt(s9.getText().toString());
					q[9] = Integer.parseInt(s10.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					DrinkTotal = DrinkTotal + aDrink[i] * q[i];
				}

				lDrinkCost.setText("$ " + formatter.format(DrinkTotal));
			} else if (e.getSource() == bDrinkClear) {
				DrinkTotal = 0;
				lDrinkCost.setText("$ " + formatter.format(DrinkTotal));
			}
			
			 else if (e.getSource() == bTotal) {
					total = PizzaTotal + SideTotal+DrinkTotal;
					lCost.setText("$ " + formatter.format(total));
				} else if (e.getSource() == bClear) {
					total = 0;
					lCost.setText("$ " + formatter.format(total));
				}
		}
	}

	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.getContentPane().add(new Pizza());
		j.pack();
		j.setVisible(true);
	}
}