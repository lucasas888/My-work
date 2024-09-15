// redo A2
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

enum ShapeColor {Blue, Yellow, Red, Green, White};

interface shape
{
	// abstract method for implementation of area
	public double area ();
	
	// constant for PI
	public double PI = 3.141569;
}

interface ForTwoD 
{
	public double perimeter ();
	public void recolor (ShapeColor sc);
}

interface ForThreeD
{
	public double volume ();
	public void resize (double percentage);
}

// abstract class that implements interfaces shape & ForTwoD
abstract class TwoD implements shape, ForTwoD
{
	// protected variables
	protected ShapeColor sc;
	protected int a;
	protected int b;
	protected int c;
	
	// default constructor
	public TwoD ()
	{
		
	}
	
	// other constructors
	public TwoD (ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	public TwoD (ShapeColor sc, int a, int b)
	{
		this (sc, a); // call above constructor
		this.b = b;
	}
	
	public TwoD (ShapeColor sc, int a, int b, int c)
	{
		this (sc, a, b);
		this.c = c;
	}
	
	// copy constructor 
	public TwoD (TwoD td)
	{
		this (td.sc, td.a, td.b, td.c);
	}
	
	// getters
	public int getA ()
	{
		return a;
	}
	
	public int getB ()
	{
		return b;
	}
	
	public int getC ()
	{
		return c;
	}
	
	public ShapeColor getShapeColor ()
	{
		return sc;
	}
	
	// setters
	public void set (ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	public void set (ShapeColor sc, int a, int b)
	{
		set (sc, a);
		this.b = b;
	}

	public void set (ShapeColor sc, int a, int b, int c)
	{
		set (sc, a, b);
		this.c = c;
	}
	
	public void recolor (ShapeColor sc)
	{
		this.sc = sc;
	}
	
	// toString methods depending on constructors
	public String toString ()
	{
		if (getC () > 0)
		{
			return String.format ("(2D (%s, %d, %d, %d))", getShapeColor(), getA(), getB(), getC());
		}
		else if (getB () > 0)
		{
			return String.format ("(2D (%s, %d, %d))", getShapeColor(), getA(), getB());
		}
		else 
			return String.format ("(2D (%s, %d))", getShapeColor(), getA());
	}
	
}

class Square extends TwoD
{
	// default constructor
	public Square ()
	{
		
	}
	
	// other constructor
	public Square (ShapeColor sc, int length)
	{
		super (sc, length);
	}
	
	// copy constructor
	public Square (Square sq)
	{
		super (sq);
	}
	
	// getters
	public int getLength ()
	{
		return super.getA ();
	}
	
	// setters
	@Override
	public void set (ShapeColor sc, int length)
	{
		super.set (sc, length);
	}
	
	// override area method
	@Override
	public double area ()
	{
		return getLength () * getLength ();
	}
	
	// override perimeter method
	@Override
	public double perimeter ()
	{
		return getLength () * 4;
	}
	
	// toString method
	@Override
	public String toString ()
	{
		return String.format ("%s %s", getClass().getName(), super.toString());
	}

}

class Rectangle extends Square
{
	// default constructor
	public Rectangle ()
	{
		
	}
	
	// other constructor (pure rectangle)
	public Rectangle (ShapeColor sc, int length)
	{
		super (sc, length);
	}
	
	// other constructor (square rectangle)
	public Rectangle (ShapeColor sc, int length, int width)
	{
		super (sc, length);
		this.b = width;
	}
	
	// copy constructor
	public Rectangle (Rectangle r)
	{
		super (r);
	}
	
	// getters
	@Override
	public int getLength ()
	{
		return super.getA();
	}
	
	public int getWidth ()
	{
		return super.getB();
	}
	
	// setter
	@Override
	public void set (ShapeColor sc, int length, int width)
	{
		super.set (sc, length, width);
	}
	
	// area
	@Override
	public double area ()
	{
		double a = 0;
		
		if (getWidth() > 0)
		{
			a = getLength () * getWidth ();
		}
		else
		{
			a = getLength () * getLength ();
		}
		
		return a;
	}
	
	// perimeter
	@Override
	public double perimeter ()
	{
		double p = 0;
		
		if (getWidth() > 0)
		{
			p = ((getLength() * 2) + (getWidth() * 2));
		}
		else 
		{
			p = getLength() * 4;
		}
		return p;
	}
	
	@Override
	public String toString ()
	{
		if (getWidth() > 0)
		{
			return String.format ("%s", super.toString());
		}
		else
		{
			return String.format ("Square (%s)", super.toString());
		}
	}
}

class Triangle extends TwoD
{
	// default constructor
	public Triangle ()
	{
		
	}
	
	// other constructor
	public Triangle (ShapeColor sc, int a, int b, int c)
	{
		super (sc, a, b, c);
	}
	
	// copy constructor 
	public Triangle (Triangle t)
	{
		super (t);
	}
	
	// getters
	@Override
	public int getA ()
	{
		return super.getA ();
	}
	
	@Override
	public int getB ()
	{
		return super.getB();
	}
	
	@Override
	public int getC ()
	{
		return super.getC();
	}
	
	// setter
	@Override
	public void set (ShapeColor sc, int a, int b, int c)
	{
		super.set (sc, a, b, c);
	}
	
	@Override
	public double perimeter ()
	{
		return getA() + getB() + getC();
	}
	
	@Override
	public double area ()
	{
		double s = (getA() + getB() + getC()) / 2.0;
		return Math.sqrt (s * (s - getA()) * (s - getB()) * (s - getC()));
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s %s", getClass().getName(), super.toString());
	}
	
}

// abstract class that implements interfaces shape & ForThreeD
abstract class ThreeD implements shape, ForThreeD
{
	// protected variables
	protected ShapeColor sc;
	protected double a;
	
	// default constructor
	public ThreeD ()
	{
		
	}
	
	// other constructor
	public ThreeD (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	// copy constructor
	public ThreeD (ThreeD td)
	{
		this (td.sc, td.a);
	}
	
	// getter
	public double getA ()
	{
		return a;
	}
	
	// setter
	public void set (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	// resize method
	public void resize (double percentage)
	{
		this.a = this.a * (1 - percentage / 100);
	}
	
	public String toString ()
	{
		return String.format ("(3D (%s, %.3f))", sc, getA ());
	}
	
}


class Cube extends ThreeD
{
	// default constructor
	public Cube ()
	{
		
	}
	
	// other constructor
	public Cube (ShapeColor sc, double a)
	{
		super (sc, a);
	}
	
	// copy constructor
	public Cube (Cube c)
	{
		super (c);
	}
	
	// getter
	@Override
	public double getA ()
	{
		return super.getA();
	}
	
	// setter
	@Override
	public void set (ShapeColor sc, double a)
	{
		super.set (sc, a);
	}
	
	@Override
	public double area ()
	{
		return 6 * getA() * getA();
	}
	
	@Override
	public double volume ()
	{
		return getA() * getA() * getA();
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s %s", getClass().getName(), super.toString());
	}
}

class Sphere extends ThreeD
{
	// default constructor
	public Sphere ()
	{
		
	}
	
	// other constructor
	public Sphere (ShapeColor sc, double a)
	{
		super (sc, a);
	}
	
	// copy constructor
	public Sphere (Sphere s)
	{
		super (s);
	}
	
	// getter
	@Override
	public double getA ()
	{
		return super.getA();
	}
	
	// setter
	@Override
	public void set (ShapeColor sc, double a)
	{
		super.set (sc, a);
	}
	
	@Override
	public double area ()
	{
		return 4 * PI * getA() * getA();
	}
	
	@Override
	public double volume ()
	{
		return 4/3 * PI * getA() * getA() * getA();
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s %s", getClass().getName(), super.toString());
	}
	
}

class redoA2
{
	// construct random object
	static Random rand = new Random ();
	
	// get random int
	private static int getInt ()
	{
		int random = rand.nextInt ((50 - 1) + 1) + 1;
		return random;
	}
	
	// get random double 
	private static double getDouble ()
	{
		double random = rand.nextDouble () * ((50 - 1) + 1) + 1;
		return random;
	}
	
	// get random color
	private static ShapeColor getColor ()
	{
		// Array of colors
		ShapeColor [] colors = ShapeColor.values();
		
		int random = rand.nextInt (colors.length);
		
		ShapeColor a = colors [random];
		
		return a;
	}
	
	// is a triangle
	private static boolean isTriangle (int a, int b, int c)
	{
		return (a + b > c && b + c > a && a + c > b) && (a > 0 && b > 0 && c > 0);
	}
	
	// method to create a 2d shape
	private static TwoD getTwoD ()
	{
		// declare a object variable
		TwoD shape = null;
		
		int random = rand.nextInt (4);
		
		switch (random)
		{
			case 0: 
			{
				shape = new Square (getColor(), getInt());
				break;
			}
			
			case 1:
			{
				shape = new Rectangle (getColor(), getInt());
				break;
			}
			
			case 2:
			{
				shape = new Rectangle (getColor(), getInt(), getInt());
				break;
			}
			
			case 3:
			{
				int limit = 100;
				
				int a = getInt();
				int b = getInt();
				int c = getInt();
				
				while (limit > 0)
				{
					if (isTriangle (a, b, c))
					{
						shape = new Triangle (getColor(), a, b, c);
					}
					break;
				}
				limit--;
			}
			
		}
		return shape;
	}
	
	// get 3d shape
	private static ThreeD getThreeD ()
	{
		ThreeD shape = null;
		
		int random = rand.nextInt (2);
		
		switch (random)
		{
			case 0:
			{
				shape = new Cube (getColor(), getDouble());
				break;
			}
			
			case 1:
			{
				shape = new Sphere (getColor(), getDouble());
				break;
			}
		}
		return shape;
	}
	
	// method to recolor 2d shape
	private static void process2DShape (shape ss)
	{
		// get a new color
		ShapeColor color = getColor();
		
		
		// check if Shape ss is instanceof TwoD before downcasting
		if (ss instanceof TwoD)
		{
			TwoD twoD = (TwoD)ss; // downcast to access child methods as shape is top of hierarchy
	
			// prevent duplicate colors from happening
			while (color == twoD.getShapeColor())
			{
				color = getColor();
			}
			twoD.recolor (color); // use parent class method to recolor the object
		}
	}
	
	// method to resize 3d object
	private static double process3DShape (shape ss)
	{
		// get a random percentage
		double percentage = rand.nextDouble () * ((99 - 1) + 1) + 1;
		
		// check if Shape ss is instanceof TwoD before downcasting
		if (ss instanceof ThreeD)
		{
			ThreeD threeD = (ThreeD)ss; // downcast to access child methods as shape is top of hierarchy
		
			threeD.resize (percentage);
		}
		
		return percentage;
	}
	
	// method to display list
	private static void displayList (ArrayList<shape>alist)
	{
		int count = 1;
		
		for (shape s : alist)
		{
			if (s instanceof TwoD)
			{
				// downcast to access child methods
				TwoD twoD = (TwoD)s;
				
				System.out.printf ("\nShape %d: %s\n", count, twoD.toString());
				
				System.out.printf ("\nUpdated color: %s", twoD.getShapeColor());
				System.out.printf ("\nArea: %.3f", twoD.area());
				System.out.printf ("\nPerimeter: %.3f", twoD.perimeter());
				process2DShape(twoD); // recolor 2d shape
				System.out.printf ("\nI am a %s shape with color changed to %s", twoD.getClass().getName(), twoD.getShapeColor());
				System.out.println ("\n---------------------------------------------------");
			}
			
			if (s instanceof ThreeD)
			{
				// downcast to access child methods
				ThreeD threeD = (ThreeD)s;
				
				System.out.printf ("\nShape %d: %s\n", count, threeD.toString());
				System.out.printf ("\nSurface area: %.3f", threeD.area());
				System.out.printf ("\nVolume: %.3f", threeD.volume());
				double percentage = process3DShape(threeD); // resizes the 3d shape
				System.out.printf ("\nSize reduced by %.1f%%: %s", percentage, threeD.toString());
				System.out.printf ("\nUpdated surface area: %.3f", threeD.area());
				System.out.printf ("\nUpdated volume: %.3f", threeD.volume());
				System.out.println ("\nI am a " + threeD.getClass().getName() + " shape");
				System.out.println ("\n---------------------------------------------------");
			}
			count++;
		}
		
	}
	
	public static void main (String []args)
	{
		boolean prompt = true;
		
		// Empty arraylist of shape objects
		ArrayList <shape> alist = new ArrayList <> ();
		
		do
		{
			int k = rand.nextInt (3);
			
			switch (k)
			{
				case 0:
				{
					prompt = false;
					break;
				}
				case 1:
				{
					alist.add (getTwoD());
					break;
				}
				case 2:
				{
					alist.add (getThreeD());
					break;
				}
			}
		}
		while (prompt);
		
		displayList (alist);
	}
	
}