// redo of A1

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// enum class
enum NumberType
{
	ONE (1, "un", "satu", "uno"),
	TWO (2, "deux", "dua", "dos"),
	THREE (3, "trois", "tiga","tres"),
	FOUR (4, "quatre", "empat", "cuatro"),
	FIVE (5, "cinq", "lima", "cinxo"),
	SIX (6, "six", "enam", "seis"),
	SEVEN (7, "sept", "tujuh", "siete"),
	EIGHT (8, "huit", "delapan", "ocho"),
	NINE (9, "neuf", "sembilan", "nueve"),
	TEN (10, "dix", "sepuluh", "diez");
	
	// declare final variables
	private final int digit;
	private final String french;
	private final String bahasa;
	private final String spanish;
	
	// consructor
	NumberType (int digit, String french, String bahasa, String spanish)
	{
		this.digit = digit;
		this.french = french;
		this.bahasa = bahasa;
		this.spanish = spanish;
	}
	
	// getter 
	public int getDigit ()
	{
		return digit;
	}
	
	public String getFrench ()
	{
		return french;
	}
	
	public String getBahasa ()
	{
		return bahasa;
	}
	
	public String getSpanish ()
	{
		return spanish;
	}
	
}

class Set
{
	// declare private variable 
	private ArrayList <NumberType> s;
	
	// default constructor
	public Set ()
	{
		
	}
	
	// other constructor
	public Set (ArrayList <NumberType> s)
	{
		this.s = new ArrayList <NumberType> ();
		
		for (NumberType a : s)
		{
			this.s.add (a);
		}
	}
	
	// copy constructor
	public Set (Set otherSet)
	{
		this.s = new ArrayList <NumberType> ();
		
		// deep copy
		for (NumberType a : otherSet.getS())
		{
			this.s.add (a);
		}
	}
	
	// getter
	public ArrayList <NumberType> getS ()
	{
		return s;
	}
	
	// setter 
	public void setS (ArrayList <NumberType> s)
	{
		this.s = new ArrayList <NumberType> ();
		
		// deep copy
		for (NumberType a : s)
		{
			this.s.add (a);
		}
	}
	
	// method to check if set is empty
	public boolean isEmpty ()
	{
		return s.size () == 0;
	}
	
	// cardinal number
	public int cardinality ()
	{
		return s.size ();
	}
	
	// check if number belongs to set
	public boolean belongTo (NumberType element)
	{
		return this.s.contains (element);
	}
	
	// add element 
	public void addElement (NumberType element)
	{
		if (!this.s.contains (element))
			this.s.add (element);
	}
	
	// checks if its a subset of the other set
	public boolean subset (Set otherSet)
	{
		if (this.s.isEmpty ())
			return true;
		
		for (NumberType a : s)
		{
			if (!otherSet.getS().contains (a))
				return false;
		}
		
		return true;
	}
	
	// Union method
	public void union (Set otherSet)
	{
		for (NumberType a : otherSet.getS())
		{
			if (!this.s.contains (a))
				this.s.add (a);
		}
	}
	
	// intersect method 
	public void intersection (Set otherSet)
	{
		// make a temp arraylist
		ArrayList <NumberType> temp = new ArrayList <> ();
		
		for (NumberType a : otherSet.getS())
		{
			if (this.s.contains (a))
				temp.add (a);
		}
		
		setS (temp);
	}
	
	// difference method
	public void difference (Set otherSet)
	{
		// make a temp arraylist
		ArrayList <NumberType> temp = new ArrayList <> ();
		
		for (NumberType a : otherSet.getS())
		{
			if (!this.s.contains (a))
				temp.add (a);
		}
		
		setS (temp);
	}
	
	// complement method 
	public void complement ()
	{
		// make a temp arraylist
		ArrayList <NumberType> temp = new ArrayList <> ();
		
		for (NumberType a : NumberType.values())
		{
			if (!this.s.contains (a))
				temp.add (a);
		}
		
		setS (temp);
	}
	
	// equality method 
	public boolean equality (Set otherSet)
	{
		if (this.subset (otherSet) || otherSet.subset (this))
		{
			return true;
		}
		return false;
	}
	
	// toString method
	public String toString ()
	{
		String list = "{";
		
		for (int i = 0; i < s.size (); i++)
		{
			list += s.get (i);
			
			if (i < s.size () - 1)
			{
				list += ", ";
			}
		}
		
		list += "}";
		
		return String.format ("%s", list);
	}
	
	// change languages
	public String getNumberInfoFormat ()
	{
		String list = "{";
		
		Random rand = new Random ();
		int random = rand.nextInt (4);
		
		// determine language selected
		if (random == 0)
		{
			for (int i = 0; i < s.size (); i++)
			{
				list += s.get(i).getFrench();
					
				if (i < s.size () - 1)
				{
					list += ", ";
				}
			}
		}
		
		if (random == 1)
		{
			for (int i = 0; i < s.size (); i++)
			{
				list += s.get(i).getBahasa();
					
				if (i < s.size () - 1)
				{
					list += ", ";
				}
			}
		}
		
		if (random == 2)
		{
			for (int i = 0; i < s.size (); i++)
			{
				list += s.get(i).getDigit();
					
				if (i < s.size () - 1)
				{
					list += ", ";
				}
			}
		}
		
		if (random == 3)
		{
			for (int i = 0; i < s.size (); i++)
			{
				list += s.get(i).getSpanish();
					
				if (i < s.size () - 1)
				{
					list += ", ";
				}
			}
		}
		
		list += "}";
		
		return String.format ("%s", list);
	}
}


class redoA1
{
	// construct new Scanner class object
	private static Scanner input = new Scanner (System.in);
	
	// construct random class object
	private static Random rand = new Random ();
	
	// display universal set info
	private static void displayNumberTypeInfo ()
	{
		System.out.println ("Universal set info");
		
		System.out.printf ("%-15s %-15s %-10s %-10s %-10s\n", "Number Type", "Number", "French", "Bahasa", "Spanish");
		
		for (NumberType a : NumberType.values())
		{
			System.out.printf ("%-15s %-15s %-10s %-10s %-10s\n", a, a.getDigit(), a.getFrench(), a.getBahasa(), a.getSpanish());
		}
	}
	
	// get a random element
	private static NumberType getAnElement ()
	{
		// Create a temp NumberType Array
		NumberType [] temp = NumberType.values();
		
		// Pick a random index from the temp array
		int randomIndex = rand.nextInt (temp.length);
		
		// return the random (random index) object in the temp array
		return temp [randomIndex];
	}
	
	// Method to make a set 
	private static Set getASet ()
	{
		// Create a filler NumberType ArrayList 
		ArrayList <NumberType> filler = new ArrayList <> ();
		
		// Get a random number of elements to fill the arraylist
		int randomQty = rand.nextInt (10);
		
		// fill the arraylist random no. of times
		for (int i = 0; i <= randomQty; i++)
		{
			NumberType a = getAnElement();
			if (!filler.contains (a))
				filler.add (a);
		}
		
		// Create a set object with the filled arraylist
		Set aSet = new Set (filler);
		
		return aSet;
	}
	
	// menu display 
	private static void displayMenu ()
	{
		System.out.println ("\nWelcome to SIM Set Theory Lesson\n");
		System.out.println ("0: Properties of set");
		System.out.println ("1. Union Example");
		System.out.println ("2. Intersection Example");
		System.out.println ("3. Subset Example");
		System.out.println ("4. Difference Example");
		System.out.println ("5. Complement Example");
		System.out.println ("6. Sets Equality Example");
		System.out.println ("7. Distributive Law 1");
		System.out.println ("8. Distributive Law 2");
		System.out.println ("9. Quit\n");
		
		System.out.print ("Your option: ");
	}
	
	// Method to display submenu
	public static void displaySubMenu ()
	{
		System.out.println ("Some basic operations set");
		System.out.println ("\t1. Add an Element");
		System.out.println ("\t2. Check an Element");
		System.out.println ("\t3. Cardinality");
		System.out.println ("\t4. Number Info Format");
		System.out.println ("\t9. Quit");
		
		System.out.print ("\nYour option: ");
	}
	
	// Union example
	private static void unionExample ()
	{
		System.out.println ("\nGiven sets");
		
		// create 2 sets
		Set A = getASet ();
		Set B = getASet ();
		
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		
		A.union (B);
		System.out.printf ("\tUnion of A and B = %s", A.toString());
	}
	
	// Intersection example 
	private static void intersectionExample ()
	{
		System.out.println ("\nGiven sets");
		
		// create 2 sets
		Set A = getASet ();
		Set B = getASet ();
		
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		
		A.intersection (B);
		System.out.printf ("\tIntersection of A and B = %s\n", A.toString());
	}
	
	// subset example
	private static void subsetExample ()
	{
		System.out.println ("\nGiven sets");
		
		// create 2 sets
		Set A = getASet ();
		Set B = getASet ();
		
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		
		System.out.println ("Conclusion");
		System.out.println ("A subset of B: " + A.subset (B));
		
		System.out.println ("B subset of A:  " + B.subset (A));
	}
	
	// Difference example 
	private static void differenceExample ()
	{
		System.out.println ("\nGiven sets");
		
		// create 2 sets
		Set A = getASet ();
		Set B = getASet ();
		
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		
		A.difference (B);
		System.out.printf ("\tA - B = %s\n", A.toString());
	}
	
	// Complement example 
	private static void complementExample ()
	{
		System.out.println ("\nGiven sets");
		
		// create 2 sets
		Set A = getASet ();
		
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		
		A.complement ();
		System.out.printf ("\tA' = %s\n", A.toString());
	}
	
	
	// equality example
	private static void equalityExample ()
	{
		System.out.println ("\nGiven sets");
		
		// create 2 sets
		Set A = getASet ();
		Set B = getASet ();
		
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		
		System.out.println ("Conclusion");
		System.out.println ("A subset of B: " + A.subset (B));
		
		System.out.println ("B subset of A: " + B.subset (A));
		
		System.out.println ("Analysis");
		System.out.println ("A equals B: " + A.equality (B));
	}
	
	private static void distributiveLaw1 ()
	{
		System.out.println ("\nWe wish to prove: A U (B I C) = (A U B) I (A U C)");
		
		// create 3 sets
		Set A = getASet ();
		Set B = getASet ();
		Set C = getASet ();
		
		System.out.println ("Given sets");
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		System.out.printf ("\t%s = %s\n", "C", C.toString());
		
		System.out.println ("LHS Analysis");
		
		// create 3 copies of sets
		Set A2 = new Set (A);
		Set B2 = new Set (B);
		Set C2 = new Set (C);
		
		B2.intersection (C2);
		A2.union (B2);
		
		System.out.printf ("\tLHS = %s\n", A2.toString());
		
		// create 3 copies of sets
		Set A3 = new Set (A);
		Set B3 = new Set (B);
		Set C3 = new Set (C);
		
		A.union (B);
		A3.union (C3);
		A.intersection (A3);
		
		System.out.println ("RHS Analysis");
		System.out.printf ("\tRHS = %s\n", A.toString());
		
		System.out.println ("Conclusion");
		System.out.println ("\tLHS = RHS: " + A2.equality (A));
	}
	
	private static void distributiveLaw2 ()
	{
		System.out.println ("\nWe wish to prove: A I (B U C) = (A I B) U (A I C)");
		
		// create 3 sets
		Set A = getASet ();
		Set B = getASet ();
		Set C = getASet ();
		
		System.out.println ("Given sets");
		System.out.printf ("\t%s = %s\n", "A", A.toString());
		System.out.printf ("\t%s = %s\n", "B", B.toString());
		System.out.printf ("\t%s = %s\n", "C", C.toString());
		
		System.out.println ("LHS Analysis");
		
		// create 3 copies of sets
		Set A2 = new Set (A);
		Set B2 = new Set (B);
		Set C2 = new Set (C);
		
		B2.union (C2);
		A2.intersection (B2);
		
		System.out.printf ("\tLHS = %s\n", A2.toString());
		
		// create 3 copies of sets
		Set A3 = new Set (A);
		Set B3 = new Set (B);
		Set C3 = new Set (C);
		
		A.intersection (B);
		A3.intersection (C3);
		A.union (A3);
		
		System.out.println ("RHS Analysis");
		System.out.printf ("\tRHS = %s\n", A.toString());
		
		System.out.println ("Conclusion");
		System.out.print ("\n\tLHS = RHS is " + A2.equality (A));
	}
	
	// display example
	public static void anExample ()
	{
		boolean prompt = false;
		Set A = getASet ();
		
		System.out.println ("Here is an  example of a set");
		System.out.printf ("\tA = %s\n", A.toString());
		System.out.println ("All elements in set are distinct and random\n");
		
		do
		{
			displaySubMenu();
			
			System.out.print ("\nEnter your option: ");
			int promptSubMenu = input.nextInt ();
			
			switch (promptSubMenu)
			{
				case 1: 
				{
					System.out.print ("\nEnter an element: ");
					NumberType user = NumberType.valueOf (input.next ());
						
					if (!A.getS().contains (user))
					{
						A.getS().add (user);
					}
					System.out.println ("==> A = " + A.toString() + "\n");
					
					break;
				}
				
				case 2:
				{
					System.out.print ("\nEnter an element: ");
					NumberType user = NumberType.valueOf (input.next ());
					
					if (!A.belongTo (user))
					{
						System.out.printf ("\n==> Element %s is NOT in set", user);
					}
					else  
						System.out.printf ("\n==> Element %s is in set", user);
					
					break;
				}
				
				case 3:
				{
					int cardinal = A.cardinality();
					
					System.out.printf ("\n==> No of elements in set is %s", cardinal);
					
					break;
				}
				
				case 4:     
				{
					System.out.print ("\nNotation in enum format");
					System.out.printf ("\n\tA = %s", A.getNumberInfoFormat());
					
					break;
				}
				
				case 9 :
				{
					prompt = true;
					break;
				}
				
				default: System.out.print ("\nEnter valid  option");
			}
		}
		while (prompt == false);
	}
	
	public static void main (String []args)
	{
		boolean prompt = false;
		
		displayNumberTypeInfo();
		
		do
		{
			displayMenu ();
			int promptMenu = input.nextInt();
			
			switch (promptMenu)
			{
				case 0:
				{
					anExample();
					break;
				}
				
				case 1:
				{
					unionExample();
					break;
				}
				
				case 2:
				{
					intersectionExample();
					break;
				}
				
				case 3:
				{
					subsetExample();
					break;
				}
				
				case  4:
				{
					differenceExample();
					break;
				}
				
				case 5:
				{
					complementExample();
					break;
				}
				
				case 6:
				{
					equalityExample();
					break;
				}
				
				case 7:
				{
					distributiveLaw1();
					break;
				}
				
				case 8:
				{
					distributiveLaw2();
					break;
				}
				
				case 9:
				{
					prompt = true;
					break;
				}
				
				default: System.out.println ("Enter a valid option");
			}
		}
		while (prompt == false);
		
	}
	
}