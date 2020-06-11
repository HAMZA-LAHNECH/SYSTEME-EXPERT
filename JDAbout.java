import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 
class JDAbout implements ActionListener
{ 
    JDialog boite;
	JButton ok;
	JPanel pan;	 
	JDAbout (int x, int y, int lg, int ht, JFrame fen)
	{ 
		boite = new JDialog (fen, ".: A propos de S.E", false);
		boite.setBounds (x, y, lg, ht);
		boite.setVisible (true); 
		pan = new pan_about();
		pan.setBackground (Color.lightGray);
		pan.setBounds (0, 0, lg, ht);
		pan.setLayout (null);
		boite.getContentPane().add (pan); 
		ok = new JButton ("ok");
		ok.setBounds (lg/2-35, ht-65, 70, 25);
		pan.add (ok);
		ok.setEnabled (true);
		ok.addActionListener(this);						
	}
	
	public void actionPerformed (ActionEvent e)
	{ 
		Object source =	e.getSource();
		
		if (source == ok)
		{
			boite.setVisible(false);
		}		
	} 
	void setVoir(boolean B)
	{
		if (B)
		{
			boite.setVisible (true);
		}
		else
		{
			boite.setVisible (false);	
		}	
	}
}


class pan_about extends JPanel
{ 
	private ImageIcon Ifond;
	private ImageIcon Ilogo;
	
	pan_about()
	{ 
		Ifond = new ImageIcon ("img/about2.jpeg"); 
		Ilogo = new ImageIcon ("img/logo.gif");	
	}

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.drawImage (Ifond.getImage(), 0, 0, null);
		g.drawImage (Ilogo.getImage(), 205, 20, null); 
		g.setColor (Color.lightGray);
		g.drawRect(45, 60, 250, 20);   
		g.drawRoundRect(10, 10, 320, 155, 50, 50);   
		g.drawRoundRect(190, -20, 300, 70, 50, 50);  

		g.setColor (Color.white);	
		g.drawString ("S.E {Système Expert by Ouijdane Abchir}", 63, 75);

		g.setColor (Color.black);
		g.drawString ("Version 2.1", 30, 40);

		g.drawString ("Application réalisée dans le cadre du projet KM", 43, 100);
		g.drawString ("Génie informatique {2ème année} à l'EHTP.", 43, 115);
		
		g.drawString ("Pour plus de renseignements, contactez moi", 42, 140);
		g.drawString ("A l'adresse suivante : ouijdane@gmail.com ", 50, 155);							
	}	
}