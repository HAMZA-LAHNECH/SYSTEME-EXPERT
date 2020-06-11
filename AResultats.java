import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 

class AResultats extends JFrame
{
	AResultats(int[][] Matrice, LRegles LR, LFaits LF)
	{ 
		setTitle(".: Les résultats");
		setBounds(45,115, 400, 621); 
		pan = new pan_AResultats(Matrice, LR, LF); 
		defil = new JScrollPane(pan);
		getContentPane().add(defil);
	}
	
	private pan_AResultats pan;
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
	void setNbSaves(int I)
	{
		pan.setNbSaves(I);	
	}	
}


class pan_AResultats extends JPanel
{ 
	int[][] Mat;
	int nbSaves;
	LFaits LF;
	LRegles LR; 
	public pan_AResultats(int[][] Matrice, LRegles L1, LFaits L2)
	{
		Mat	= Matrice;
		LR = L1;
		LF = L2;
	} 
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g); 
		Ecrire(Mat, nbSaves, LR, LF, g);
	} 
	void setMat(int[][] M)
	{
		Mat = M;
	} 
	void setNbSaves(int I)
	{
		nbSaves = I;	
	}
	
	 
	void setLF(LFaits L)
	{
		LF = L;	
	} 
	void Ecrire(int[][] Mat, int nbSaves, LRegles LR, LFaits LF, Graphics g)
	{ 
		Regles R;
		LFaits LFts;
		Faits F;
		int xligne=30;
		int yligne=20;		
		int i, tmp=1, nbRech=1;
		FontMetrics fm;
		
		g.setColor (Color.black);
		g.drawString (".: Les résultats :", xligne, yligne);
		xligne = xligne + 20;
		yligne = yligne + 20;
		
		for (i=0; i<nbSaves; i++)
		{ 
			if (tmp != Mat[1][i])
			{ 
				if ((Mat[1][i] == 0) || (Mat[1][i] == 1))
				{
					tmp = Mat[1][i];
					g.setColor (Color.white);
					xligne = 50;
					
					g.drawString ("------------------------------------------------------------", xligne, yligne);
					yligne = yligne + 20;
					
					g.setColor (Color.black);
					g.drawString ("Recherche n°", xligne, yligne);
					xligne = xligne + 80;
					
					g.setColor (Color.blue);
					g.drawString ("" + nbRech, xligne, yligne);
					
					g.setColor (Color.white);
					if (Mat[1][i] == 0)
					{
						xligne = 200;
						g.drawString ("Chainage avant.", xligne, yligne);
					}
					else
					{
						if (Mat[1][i] == 1)
						{
							xligne = 200;
							g.drawString ("Chainage arrière.", xligne, yligne);
						}						
					}
					
					yligne = yligne + 25;
					xligne = 50;				
					g.setColor (Color.gray);
					g.drawString ("Liste de faits initiaux :", xligne, yligne);
					yligne = yligne + 20;
					nbRech++;
				}
				else   
				{
					tmp = Mat[1][i];
					g.setColor (Color.gray);
					yligne = yligne + 10;
					xligne = 50;
					g.drawString ("Liste de faits résultats :", xligne, yligne);
					yligne = yligne + 20;	
				}		
			} 
			if ((Mat[1][i] == 0) || (Mat[1][i] == 1))
			{
				xligne = 70;
				
				g.setColor (Color.black);
				g.drawString ("Fait n°", xligne, yligne);
				xligne = xligne + 37;
				
				g.setColor (Color.blue);
				g.drawString ("" + Mat[0][i], xligne, yligne); 
	 
				fm = g.getFontMetrics();
				xligne += fm.stringWidth ("" + Mat[0][i]);
				
				g.setColor (Color.black);
				g.drawString (" : ", xligne, yligne);
				xligne = xligne + 10; 
				
				if (LF.EstFait(Mat[0][i]))    
				{
					g.setColor (Color.gray);
					g.drawString ("" + LF.getFait(Mat[0][i]).getDesc(), xligne, yligne);
				}
				else   
				{
					g.setColor (Color.red);
					g.drawString ("Vide" , xligne, yligne);
				}
				
				yligne = yligne + 15;
			} 
			if ((Mat[1][i] == 2) || (Mat[1][i] == 3))
			{
				xligne = 70;
				g.setColor (Color.black);
				g.drawString ("Règle n°", xligne, yligne);
				xligne = xligne + 50;
				
				g.setColor (Color.blue);
				g.drawString ("" + Mat[0][i], xligne, yligne);  
				fm = g.getFontMetrics();
				xligne += fm.stringWidth ("" + Mat[0][i]);	
				
				g.setColor (Color.black);
				g.drawString (" : ", xligne, yligne);
				xligne = xligne + 10; 
				if (Mat[1][i] == 2)
				{
					R = LR.getRegle(Mat[0][i]);   
					LFts = R.getLFait();   
	 				F = LFts.getPremier();   
	 				
	 				while (F.getSuivant()!=null)
	 				{
						g.setColor (Color.green);
						g.drawString ("" + F.getNum(), xligne, yligne);
					
						fm = g.getFontMetrics();
						xligne += fm.stringWidth ("" + F.getNum());				
						
						g.setColor (Color.gray);
						g.drawString (" et ", xligne, yligne);
					 	xligne = xligne + 16;
					 						
	 					F = F.getSuivant();
	 				}
	 				
	 				g.setColor (Color.green);
	 				g.drawString ("" + F.getNum(), xligne, yligne);
					
					fm = g.getFontMetrics();
					xligne += fm.stringWidth ("" + F.getNum()); 								

	 				g.setColor (Color.gray);
	 				g.drawString (" = ", xligne, yligne);
					xligne = xligne + 12; 
					LFts = R.getLCons();  
	 				F = LFts.getPremier();   				
	 				
	  				while (F.getSuivant()!=null)
	 				{
						g.setColor (Color.red);
						g.drawString ("" + F.getNum(), xligne, yligne);
					
						fm = g.getFontMetrics();
						xligne += fm.stringWidth ("" + F.getNum());				
	
						g.setColor (Color.gray);
						g.drawString (" ou ", xligne, yligne);
					 	xligne = xligne + 19;
					 											
	 					F = F.getSuivant();	
	 				}
	 
	 				g.setColor (Color.red);
	 				g.drawString ("" + F.getNum(), xligne, yligne); 

					fm = g.getFontMetrics();
					xligne += fm.stringWidth ("" + F.getNum());	
								 				
		 			g.setColor (Color.gray);
		 			g.drawString (".", xligne, yligne);
	 				
	 				yligne = yligne + 20;	
	 				 
		 				xligne = 70;
		 				g.setColor (Color.gray);
		 				g.drawString ("Avec :", xligne, yligne);
		 				
		 				F = LFts.getPremier();    				
		  				while (F!=null)
		 				{
							xligne = 110;
							
							g.setColor (Color.gray);
							g.drawString ("Fait n°", xligne, yligne);
							xligne = xligne + 37;

							g.setColor (Color.white);
							g.drawString ("" + F.getNum(), xligne, yligne);
							
							fm = g.getFontMetrics();
							xligne += fm.stringWidth ("" + F.getNum());							
							
							g.setColor (Color.gray);
							g.drawString (" : ", xligne, yligne);
							xligne = xligne + 10; 
							
							if (LF.EstFait(Mat[0][i]))   
							{
								g.setColor (Color.white);
								g.drawString ("" + F.getDesc() + ".", xligne, yligne);
							}
							else  
							{
								g.setColor (Color.red);
								g.drawString ("Vide." , xligne, yligne);
							}
							
							yligne = yligne + 15;
						 											
		 					F = F.getSuivant();	
		 				}	 					
		 				
		 				xligne = 70;
		 				g.setColor (Color.gray);
		 				g.drawString ("-------------------------------------------", xligne, yligne);
		 				yligne = yligne + 20;				
				}
				else
				{		
					if (Mat[1][i] == 3)  
					{  
					
						R = LR.getRegle(Mat[0][i]);   
						LFts = R.getLCons();   
		 				F = LFts.getPremier();   
		 				
		 				while (F.getSuivant()!=null)
		 				{
							g.setColor (Color.red);
							g.drawString ("" + F.getNum(), xligne, yligne);
						
							fm = g.getFontMetrics();
							xligne += fm.stringWidth ("" + F.getNum());				
							
							g.setColor (Color.gray);
							g.drawString (" ou ", xligne, yligne);
						 	xligne = xligne + 19;
						 						
		 					F = F.getSuivant();
		 				}
		 				
		 				g.setColor (Color.red);
		 				g.drawString ("" + F.getNum(), xligne, yligne);
						
						fm = g.getFontMetrics();
						xligne += fm.stringWidth ("" + F.getNum()); 
						
						g.setColor (Color.gray);
						g.drawString (" = ", xligne, yligne);
						xligne = xligne + 12; 
						LFts = R.getLFait();   
		 				F = LFts.getPremier();    				
		 				
		  				while (F.getSuivant()!=null)
		 				{
							g.setColor (Color.green);
							g.drawString ("" + F.getNum(), xligne, yligne);
						
							fm = g.getFontMetrics();
							xligne += fm.stringWidth ("" + F.getNum());				
		
							g.setColor (Color.gray);
							g.drawString (" et ", xligne, yligne);
						 	xligne = xligne + 16;
						 											
		 					F = F.getSuivant();	
		 				}
		 
		 				g.setColor (Color.green);
		 				g.drawString ("" + F.getNum(), xligne, yligne); 
		 				
						fm = g.getFontMetrics();
						xligne += fm.stringWidth ("" + F.getNum());	
								 				
		 				g.setColor (Color.gray);
		 				g.drawString (".", xligne, yligne);
		 				
	 				yligne = yligne + 20;	
	 				   
		 				xligne = 70;
		 				g.setColor (Color.gray);
		 				g.drawString ("Avec :", xligne, yligne);
		 				
		 				F = LFts.getPremier();   			
		  				while (F!=null)
		 				{
							xligne = 110;
							
							g.setColor (Color.gray);
							g.drawString ("Fait n°", xligne, yligne);
							xligne = xligne + 37;

							g.setColor (Color.white);
							g.drawString ("" + F.getNum(), xligne, yligne);
							
							fm = g.getFontMetrics();
							xligne += fm.stringWidth ("" + F.getNum());							
							
							g.setColor (Color.gray);
							g.drawString (" : ", xligne, yligne);
							xligne = xligne + 10; 
							
							if (LF.EstFait(Mat[0][i]))  
							{
								g.setColor (Color.white);
								g.drawString ("" + F.getDesc() + ".", xligne, yligne);
							}
							else 
							{
								g.setColor (Color.red);
								g.drawString ("Vide." , xligne, yligne);
							}
							
							yligne = yligne + 15;
						 											
		 					F = F.getSuivant();	
		 				}	 					
		 				
		 				xligne = 70;
		 				g.setColor (Color.gray);
		 				g.drawString ("-------------------------------------------", xligne, yligne);
		 				yligne = yligne + 20;				
											
					}					
				}										
			}
			
			if (Mat[1][i] == -1)   
			{
		 		xligne = 70;

		 		g.setColor (Color.red);
		 		g.drawString ("Aucun résultat !", xligne, yligne);
		 		yligne = yligne + 20;								
			}								
		} 
		if (nbSaves != 0)
		{
			xligne = 50;
			yligne = yligne + 5;
			g.setColor (Color.white);
			g.drawString ("------------------------------------------------------------", xligne, yligne);
			yligne = yligne + 20; 	
			setPreferredSize(new Dimension(250, yligne));
			revalidate();			
		}
		else   
		{
			g.setColor (Color.red);
			g.drawString ("Liste de résultat vide ...", xligne, yligne);;
		}	
	}	
}