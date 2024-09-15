// practice handling exceptions
// self intro
import java.util.Scanner;
import java.util.*;


class eHandlePrac
{
	static Scanner input = new Scanner (System.in);
	
	public static void main (String []args)
	{
		boolean loop = true;
		do
		{
			try
			{
				System.out.print ("Enter a numerator: ");
				int numerator = input.nextInt ();
				
				System.out.print ("Enter a denominator: ");
				int denominator = input.nextInt ();
				
				if (numerator < 0 && denominator < 0)
					throw new ArithmeticException ();
				
				System.out.printf ("The fraction is %d / %d%n", numerator, denominator);
				loop = false;
			}
			catch (InputMismatchException e)
			{
				System.out.printf ("===> put correct type bodoh. %s%n", e);
				System.out.println ();
				input.nextLine();
			}
			catch (ArithmeticException e)
			{
				System.out.printf ("===> exception message is: %s%n", e);
				System.out.println ();
				input.nextLine();
			}
			catch (Exception e)
			{
				System.out.println ("I am any other exception");
				System.out.println ();
				input.nextLine();
			}
		} 
		while (loop);
	}
}

