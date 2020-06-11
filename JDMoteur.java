import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 

class JDMoteur extends JFrame implements ActionListener
{ 
    private JDialog boite;
	private AResultats boite2;
	private JTextField txt1;
	private JButton ok, ok2;
	private JComboBox choix;	
	private pan_moteur pan;
	 
	private LRegles LR;	
	private LFaits LF;
	private LFaits ListeFTmp;
	 
	private int[][] Mat = new int[2][10000];
	private int nbSaves=0; 
		 
	JDMoteur(int x, int y, int lg, int ht, JFrame fen, LRegles ListeRegles, LFaits ListeFaits)
	{
		 
		boite = new JDialog (fen, ".: Moteur d'inférence", false);
		boite.setBounds (x, y, lg, ht);
		 
		pan = new pan_moteur();
		pan.setBackground (Color.gray);
		pan.setBounds (0, 0, lg, ht);
		pan.setLayout (null);
		boite.getContentPane().add (pan);		
		 
		String tab[] = {"Recherche en chainage avant", "Recherche en chainage arrière"};
		choix = new JComboBox (tab);
		choix.setSelectedIndex(0);		
		choix.setBounds (20, 45, 300, 20);
		choix.addActionListener (this);
		pan.add(choix);
		 
		ok = new JButton ("GO !");
		ok.setBounds (240, 80, 70, 25);
		pan.add (ok);
		ok.setEnabled (true);
		ok.addActionListener(this);					
		 
		txt1 = new JTextField ("F1;F2;...;Fn;", 20);
		txt1.setEditable (true);
		txt1.setBounds (180, 147, 130, 20);
		pan.add (txt1);
		 
		ok2 = new JButton ("Résultat");
		ok2.setBounds (220, 182, 90, 24);
		pan.add (ok2);
		ok2.setEnabled (true);
		ok2.addActionListener(this);	
		 
		ListeFTmp = new LFaits();
		
		pan.updateUI();	 
		boite2 = new AResultats(Mat, ListeRegles, ListeFaits);
		boite2.setBounds(x, y+ht+4, 350, 399);			
		 
		LR=ListeRegles;
		LF=ListeFaits;
	}
		
	public void actionPerformed (ActionEvent e)
	{ 
		String S, strTmp = "";
		char charTmp;
		int numTmp = 0;
		Faits rude;
		LFaits Resultat;
		int direction;
		 
		Object source =	e.getSource();

		if (source == choix)   
		{
			ok.setEnabled (true);
			ok2.setEnabled (false);
		}
		
		if (source == ok)  
		{
			ok.setEnabled (false);
			ok2.setEnabled (true);
		} 
		if (source == ok2)
		{
			try   
			{
				direction = choix.getSelectedIndex();			
				 
				S = txt1.getText();
				while(numTmp<S.length())
				{ 
					charTmp = S.charAt(numTmp);
	
					if ((charTmp!=';') && (charTmp!=' '))
					{ 
						strTmp=strTmp+charTmp;									
					}
					else
					{ 
						Mat[0][nbSaves] = Integer.parseInt(strTmp);
						 
						Mat[1][nbSaves] = direction;
					
						strTmp = "";
						nbSaves++;	
					}
					numTmp++;
				}
			 
				if (direction == 0)
				{
					Moteur_1();
				}
				else
				{
					if (direction == 1)
					{
						Moteur_2();	
					}
				} 
				boite2.setNbSaves(nbSaves);
			}
			catch (Exception erreur)  
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie !");	
			}			
		}
	}
	 
	void setNbSaves(int I)
	{
		nbSaves = I;
		boite2.setNbSaves(I);
	}
 
	void Moteur_1()
	{ 
		Faits F;
		ListeFTmp.setPremier(null);
		Regles rude;
		Faits rude2;		
		boolean flag = false; 
		ListeFTmp.InsertListe(LF, txt1.getText());

		while (!flag)
		{
			flag = true; 
			rude = LR.getPremier();			
			while ((rude != null) && (flag))
			{	
				if (!(rude.getTeste()) && EstContenu(rude.getLFait(), ListeFTmp))
				{ 
					rude2 = rude.getLCons().getPremier();
					while (rude2 != null)
					{ 
						F = new Faits(); 
						F.setNum(rude2.getNum());
						F.setDesc(rude2.getDesc());					 
						ListeFTmp.AjouterFait(F);
						
						rude2 = rude2.getSuivant();
					}
					 
					Mat[0][nbSaves] = rude.getNum(); 
					Mat[1][nbSaves] = 2;					
					nbSaves++;
									
					rude.setTeste(true);
					flag = false;
				}
				else
				{ 
					rude = rude.getSuivant();	
				}
			}
			
			if (Mat[1][nbSaves-1] == 0)   
			{ 
					Mat[1][nbSaves] = -1;
					nbSaves++;				
			}
			 
		}
 
		LR.InitTeste(); 
	} 
	void Moteur_2()
	{ 
		Faits F;
		ListeFTmp.setPremier(null);
		Regles rude;
		Faits rude2;		
		boolean flag = false;		 
		ListeFTmp.InsertListe(LF, txt1.getText());

		while (!flag)
		{
			flag = true; 
			rude = LR.getPremier();			
			while ((rude != null) && (flag))
			{	
				if (!(rude.getTeste()) && Contien1Element(rude.getLCons(), ListeFTmp))
				{ 
					rude2 = rude.getLFait().getPremier();
					while (rude2 != null)
					{ 
						F = new Faits();
						 
						F.setNum(rude2.getNum());
						F.setDesc(rude2.getDesc());						
					 
						ListeFTmp.AjouterFait(F);
						
						rude2 = rude2.getSuivant();
					} 
					Mat[0][nbSaves] = rude.getNum();
					 
					Mat[1][nbSaves] = 3;					
					nbSaves++;
									
					rude.setTeste(true);
					flag = false;
				}
				else
				{ 
					rude = rude.getSuivant();	
				}
			}
			
			if (Mat[1][nbSaves-1] == 1)   
			{ 
					Mat[1][nbSaves] = -1;
					nbSaves++;				
			}
			 
		}
 
		LR.InitTeste(); 
	} 
	boolean EstContenu(LFaits Liste1, LFaits Liste2)
	{ 
		Faits rude, rude2;
		boolean flag=true;
		 
		rude = Liste1.getPremier();
		while ((rude != null) && (flag))	
		{
			flag = false;
			rude2 = Liste2.getPremier(); 
			while ((rude2 != null) && (!flag))
			{
				if (rude.getNum() == rude2.getNum())
				{
					flag = true;	
				}
				rude2 = rude2.getSuivant();
			} 
			rude = rude.getSuivant();
		}
		 
		return flag;
	} 
	 
	boolean Contien1Element(LFaits Liste1, LFaits Liste2)
	{ 
		Faits rude, rude2;
		boolean flag=false;
		 
		rude = Liste1.getPremier();
		while ((rude != null) && (!flag))	
		{
			rude2 = Liste2.getPremier();
			 
			while ((rude2 != null) && (!flag))
			{
				if (rude.getNum() == rude2.getNum())
				{
					flag = true;	
				}
				rude2 = rude2.getSuivant();
			}
		 
			rude = rude.getSuivant();
		} 
		
		return flag;
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
	void setVoirRes(boolean B)
	{
		if (B)
		{
			boite2.setVoir (true);
		}
		else
		{
			boite2.setVoir (false);
		}	
	}	
}


class pan_moteur extends JPanel
{ 
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor (Color.lightGray);
		g.drawRoundRect(10, 10, 320, 110, 50, 50); 
		g.drawRoundRect(10, 130, 320, 92, 50, 50);
			
		g.setColor (Color.white);				
		g.drawString ("Nature de la recherche ?", 25, 30);
				
		g.drawString ("Valider l'opération afin de pouvoir", 25, 90);
		g.drawString ("Continuer la saisie.", 25, 105);	
				
		g.drawString (".: Liste de fait(s) :", 25, 162);
				
		g.drawString (".: Afin de valider l'opération :", 25, 198);					
	}
}