import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 

class ARegles extends JFrame
{
	ARegles(LRegles L)
	{ 
		setTitle(".: Liste de règles");
		setBounds(45,285, 370, 438); 
		pan = new pan_ARegles(L); 
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


class pan_ARegles extends JPanel
{ 
	LRegles LR; 
	pan_ARegles(LRegles L)
	{
		LR = L;
	} 
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g); 
		Ecrire(LR, g);
	} 
	void Ecrire(LRegles LR, Graphics g)
	{ 
		int xligne=30;
		int yligne=20;	
		Regles rude;
		Faits rude2;
		FontMetrics fm;
		
		g.setColor (Color.black);
		g.drawString (".: Liste de règles :", xligne, yligne);
		xligne = xligne + 20;
		yligne = yligne + 20;

		rude = LR.getPremier();	
		if (rude==null)
		{
			g.setColor (Color.red);
			g.drawString ("La liste de règles est actuellement vide.", xligne, yligne);
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
			g.drawString ("" + LR.getNbRegles(), xligne, yligne);
			 
			fm = g.getFontMetrics();
			xligne += fm.stringWidth (" " + LR.getNbRegles());
			
			g.setColor (Color.white);
			g.drawString ("règle(s).", xligne, yligne);
			yligne = yligne + 20;
			xligne = 50;
			
			g.setColor (Color.gray);			
			g.drawString ("---------------------------------------------", xligne, yligne);
			yligne = yligne + 20; 
			while (rude != null)  
			{
				xligne = 50;
				g.setColor (Color.black);
				g.drawString ("Règle n° : ", xligne, yligne);
				xligne = xligne + 60;
				
				g.setColor (Color.blue);
				g.drawString ("" + rude.getNum(), xligne, yligne);
				yligne = yligne + 15;
				
				xligne = 50;
				g.setColor (Color.gray);				
				g.drawString ("Faits hypothèses : ", xligne, yligne);
				xligne = xligne + 120; 
				rude2 = rude.getLFait().getPremier();
				
				if (rude2 != null)   
				{
					while (rude2 != null) 
					{
						g.setColor (Color.gray);
						g.drawString ("Fait n°", xligne, yligne);
						xligne = xligne + 40;
						
						g.setColor (Color.black);
						g.drawString ("" + rude2.getNum(), xligne, yligne);
						 
						fm = g.getFontMetrics();
						xligne += fm.stringWidth ("" + rude2.getNum());
						
						g.setColor (Color.gray);
						g.drawString (" : ", xligne, yligne);
						xligne = xligne + 10; 
						
						g.setColor (Color.black);
						g.drawString ("" + rude2.getDesc(), xligne, yligne);			
						
						yligne = yligne + 15;
						xligne = 170;
						rude2=rude2.getSuivant();					
					}
				}
				else   
				{
					g.setColor (Color.red);
					g.drawString ("Vide", xligne, yligne);
					yligne = yligne + 15;					
				}

				xligne = 50;
				yligne = yligne + 10;
				g.setColor (Color.gray);
				g.drawString ("Faits Résultats : ", xligne, yligne);
				xligne = xligne + 120; 
				rude2 = rude.getLCons().getPremier();
				
				if (rude2 != null)  
				{				
					while (rude2 != null) 
					{
						g.setColor (Color.gray);
						g.drawString ("Fait n°", xligne, yligne);
						xligne = xligne + 40;
						
						g.setColor (Color.black);
						g.drawString ("" + rude2.getNum(), xligne, yligne); 
						fm = g.getFontMetrics();
						xligne += fm.stringWidth ("" + rude2.getNum());
						
						g.setColor (Color.gray);
						g.drawString (" : ", xligne, yligne);
						xligne = xligne + 10; 
						
						g.setColor (Color.black);
						g.drawString ("" + rude2.getDesc(), xligne, yligne);			
						
						yligne = yligne + 15;
						xligne = 170;
						rude2=rude2.getSuivant();					
					}
				}
				else   
				{
						g.setColor (Color.red);
						g.drawString ("Vide", xligne, yligne);
						yligne = yligne + 15;					
				}					
				
				g.setColor (Color.gray);
				xligne = 50;	
				g.drawString ("-----------------------------------------------------------", xligne, yligne);				
				yligne = yligne + 20;
				rude=rude.getSuivant(); 
				setPreferredSize(new Dimension(250, yligne));
				revalidate();
			}					
		}
	}
}