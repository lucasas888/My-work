// Practice GUI and actionlisteners

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.ArrayList;

class frame extends JFrame
{
	// declare variables
	private final JLabel name;
	private final JLabel ID;
	private final JLabel pic;
	private final JTextField jtfName;
	private final JTextField jtfID;
	private final JTextField comment;
	private final JLabel desc;
	private ImageIcon picture;
	
	private final String [] text = {"im tired", "i want to go home", "i hate 121"};
	
	// default constructor
	public frame ()
	{
		super ("Welcome to my frame");
		setLayout (new FlowLayout());
		
		name = new JLabel ("Name");
		ID = new JLabel ("ID");
		jtfName = new JTextField ("Lucas");
		jtfID = new JTextField ("1111111");
		comment = new JTextField ("change me");
		pic = new JLabel ();
		desc = new JLabel ("Please make some changes here:");
		
		jtfName.setEditable (false);
		jtfID.setEditable (false);
		
		picture = new ImageIcon ("1.jpg");
		pic.setIcon (picture);
		pic.setToolTipText ("Hello");
		
		add (name);
		add (jtfName);
		add (ID);
		add (jtfID);
		add (pic);
		add (desc);
		add (comment);
		
		// register events
		// create myAction object
		myAction act = new myAction ();
		comment.addActionListener (act);
	}
	
	// inner class actionlistener
	private class myAction implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent e)
		{
			String a = "";
			if (e.getSource() == comment)
			{
				a = comment.getText();
				String message = "Changes made: \n" + a;
				
				ImageIcon trophy = new ImageIcon ("trophy.jpg");
				
				JOptionPane.showMessageDialog (null, message, "This is my title", JOptionPane.INFORMATION_MESSAGE, trophy);
			}
		}
			
	}
	
}

class GUIPractice
{	
	public static void main (String []args)
	{
		frame myFrame = new frame ();
		myFrame.setVisible (true);
		myFrame.setSize (300, 200);
		myFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
	}

}