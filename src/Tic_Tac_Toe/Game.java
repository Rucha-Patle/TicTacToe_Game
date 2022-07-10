package Tic_Tac_Toe;

import java.awt.Color;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game implements ActionListener{
	JFrame jf;
	JButton b[];
	int count=0;
	String txt="";
	Color cl1,cl2;    //cl1 and cl2 are object
	Font font;        //font is object
	boolean win=false;
	
	public Game()
	{
		jf=new JFrame("Rucha's TIC TAC TOE Game");
		
		b=new JButton[9];
		
		for(int i=0;i<9;i++)
		{
			b[i]=new JButton();
			b[i].addActionListener(this);   //The object can be registered using the addActionListener() method.
			jf.add(b[i]);
			b[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,7));
		}
		
		jf.setSize(800,800);       //method makes the rectangular area(create frame)
		jf.setResizable(false);      // JFrame should not be resized by user in any condition
		jf.setLocationRelativeTo(null);     //used to center the GUI on the screen 
		//jf.getContentPane().setBackground(Color.pink);
		jf.setLayout(new GridLayout(3,3,10,10));  //The Java GridLayout class is used to arrange the components in a rectangular grid.
		jf.setVisible(true);              //makes the frame appear on the screen         
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)  
	{
		count+=1;
		 font = new Font("Bold",1,50);
		if(count%2==0)
		{ 
		   txt="X";
		  cl1=Color.WHITE;   
		  cl2=Color.BLACK;
		}
		else
		{
			txt="O";
			cl1=Color.BLACK;
			cl2=Color.WHITE;
		}
		for(int i=0;i<9;i++)
		{
		// The getSource method is used in the actionPerformed method to determine which button was clicked.
			if(e.getSource()==b[i])  
			{
			b[i].setText(txt);
			b[i].setForeground(cl2); //used to set the foreground colour i.e the colour in which text is shown.
			b[i].setBackground(cl1); //Sets the background color of this window.
			b[i].setFont(font);      
			b[i].setEnabled(false);  //setEnabled(false) disables the button
			break;
			}
		}
		winpossibilities();
	}
	void winpossibilities()
	{
		//Vertical possibilities
		if(b[0].getText()==b[3].getText() && b[3].getText()==b[6].getText() &&b[0].getText()!="")
		{
			win=true;
		}
		else if(b[1].getText()==b[4].getText() && b[4].getText()==b[7].getText() && b[1].getText()!="")
		{
			win=true;
		}
		else if(b[2].getText()==b[5].getText() && b[5].getText()==b[8].getText() && b[2].getText()!="")
		{
			win=true;
		}
		
		//Horizontal Possibilities
		else if(b[0].getText()==b[1].getText() && b[1].getText()==b[2].getText() && b[0].getText()!="")
		{
			win=true;
		}
		else if(b[3].getText()==b[4].getText() && b[4].getText()==b[5].getText() && b[3].getText()!="")
		{
			win=true;
		}
		else if(b[6].getText()==b[7].getText() && b[7].getText()==b[8].getText() && b[6].getText()!="")
		{
			win=true;
		}
		
		//Diagonally Possibilities
		else if(b[0].getText()==b[4].getText() && b[4].getText()==b[8].getText() && b[0].getText()!="")
		{
			win=true;
		}
		else if(b[2].getText()==b[4].getText() && b[4].getText()==b[6].getText() && b[2].getText()!="")
		{
			win=true;
		}
		else {
			win=false;
		}
		
		whowins();
	}
	void whowins()
	{
		if(win==true)
		{
		//JOptionPane makes it easy to pop up a standard dialog box that prompts 
		//users for a value or informs them of something.
			JOptionPane.showMessageDialog(jf, txt+" Wins");
			restartgame();
		}
		else if(win==false && count==0)
		{
			JOptionPane.showMessageDialog(jf, " Draw");
			restartgame();
		}
	}
	void restartgame()
	{
		int i=JOptionPane.showConfirmDialog(jf, "Do You Want To Restart The Game");
	
		if (i==0)
		{
			for(int j=0;j<9;j++)
			{
				b[j].setText("");
				b[j].setBackground(null);
				b[j].setForeground(null);
				b[j].setEnabled(true);
				count=0;
				txt="";
			}
		}
		else 
		{
			jf.setVisible(false);
		}
	}
}
