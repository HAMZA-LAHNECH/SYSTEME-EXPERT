import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class AFaits extends JFrame
{
	AFaits(LFaits L)
	{
		
		setTitle(".: Liste de faits");
		setBounds(10,235, 300, 450);
		
		pan = new pan_AFaits(L);
		
		defil = new JScrollPane(pan);
		getContentPane().add(defil);
	}
	
	private JPanel pan;
	private JScrollPane defil;
	Dimension d;
	
	
	void setVoir(boolean B)
	{
		if (B)
		{
			setVisible (true);	
		}
		else
		{
			setVisible (false);	
		}	
	}		
}


class pan_AFaits extends JPanel
{
	
	LFaits LF;
	
	pan_AFaits(LFaits L)
	{
		LF = L;		
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		Ecrire(LF, g);
	}
	
	void Ecrire(LFaits LF, Graphics g)
	{
		int xligne=30;
		int yligne=20;	
		Faits rude;
		FontMetrics fm;
		
		g.setColor (Color.black);
		g.drawString (".: Liste de faits :", xligne, yligne);
		xligne = xligne + 20;
		yligne = yligne + 20;
			
		rude = LF.getPremier();
		if (rude==null)
		{
			g.setColor (Color.red);
			g.drawString ("La liste de faits est actuellement vide.", xligne, yligne);
		}
		else
		{
			g.setColor (Color.gray);
			g.drawString ("----------------------------------------------", xligne, yligne);
			yligne = yligne + 20;
			
			g.setColor (Color.white);
			g.drawString ("Vous avez actuellement", xligne, yligne);
			fm = g.getFontMetrics();
			xligne += fm.stringWidth ("Vous avez actuellement ");
			
			g.setColor (Color.blue);
			g.drawString ("" + LF.getNbFaits(), xligne, yligne);
			
			// Calcul de xligne par rapport au numero.
			fm = g.getFontMetrics();
			xligne += fm.stringWidth (" " + LF.getNbFaits()+1);
			
			g.setColor (Color.white);
			g.drawString ("fait(s).", xligne, yligne);
			yligne = yligne + 20;
			xligne = 50;
			
			g.setColor (Color.gray);			
			g.drawString ("---------------------------------------------", xligne, yligne);
			yligne = yligne + 20;			

			while (rude != null)
			{
				g.setColor (Color.gray);
				g.drawString ("Fait n°", xligne, yligne);
				xligne = xligne + 40;
				
				g.setColor (Color.black);
				g.drawString ("" + rude.getNum(), xligne, yligne);
				 
				fm = g.getFontMetrics();
				xligne += fm.stringWidth ("" + rude.getNum());
				
				g.setColor (Color.gray);
				g.drawString (" : ", xligne, yligne);
				xligne = xligne + 10; 
				
				g.setColor (Color.black);
				g.drawString ("" + rude.getDesc(), xligne, yligne);			
				
				yligne = yligne + 15;
				xligne = 50;
				rude=rude.getSuivant();
			}
			
			g.setColor (Color.gray);
			g.drawString ("----------------------------------------------", xligne, yligne);
			yligne = yligne + 20;
			 
			setPreferredSize(new Dimension(250, yligne));
			revalidate();
		}	
	}	
}	
