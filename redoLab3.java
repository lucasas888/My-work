// redo lab 3
// GUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class frame extends JFrame
{
	// declare variables
	private final JLabel name;
	private final JLabel DOB;
	private final JLabel email;
	private final JTextField jtfName;
	private final JTextField jtfDOB;
	private final JTextField jtfEmail;
	
	private final JLabel comments;
	private final JTextField comment1;
	private final JTextField comment2;
	
	private final ImageIcon ic;
	private final JLabel picture;
	
	// default constructor
	public frame ()
	{
		// title of GUI
		super ("Welcome to my GUI");
		
		// give layout
		setLayout (new FlowLayout());
		
		name = new JLabel ("Name");
		DOB = new JLabel ("DOB");
		email = new JLabel ("Email");
		picture = new JLabel ();
		
		jtfName = new JTextField ("Lucas Chew", 30);
		jtfName.setEditable (false); // lock editing
		
		jtfDOB = new JTextField ("30 May 2000", 30);
		jtfDOB.setEditable (false); // lock editing
		
		jtfEmail = new JTextField ("Lucas888@live.com.sg", 30);
		jtfEmail.setEditable (false); // lock editing
		
		ic = new ImageIcon ("1.jpg");
		picture.setIcon (ic); // set picture to label
		picture.setToolTipText ("Championssssss"); // hover over text
		
		comments = new JLabel ("Comments here");
		comment1 = new JTextField ("Change me");
		comment2 = new JTextField ("no, change me");
		
		// add all to JFrame
		add (name);
		add (jtfName);
		add (DOB);
		add (jtfDOB);
		add (email);
		add (jtfEmail);
		add (picture);
		add (comments);
		add (comment1);
		add (comment2);
		
		// register events
		myAction action = new myAction ();
		comment1.addActionListener (action);
		comment2.addActionListener (action);
	}
	
	// inner class IMPLEMENTS actionlistener
	private class myAction implements ActionListener
	{
		@Override 
		public void actionPerformed (ActionEvent e)
		{
			String a = "";
			String b = "";
			
			if (e.getSource() == comment1 || e.getSource() == comment2)
			{
				a = comment1.getText ();
				b = comment2.getText ();
				
				String message = "Summary of your changes \n 1. " + a + "\n2. " + b;
				
				JOptionPane.showMessageDialog (null, message, "Changes made", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}

class redoLab3
{
	public static void main (String [] args)
	{
		// create frame object
		frame myFrame = new frame ();
		
		// set size
		myFrame.setSize (400, 300);
		
		// set visible
		myFrame.setVisible (true);
		
		// close program
		myFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}


