import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 
class JDFaits extends JFrame implements ActionListener
{ 
    JDialog boite;
	JComboBox choix;
	JTextField txt1, txt2;
	JButton ok, ok2;
	JPanel pan;
	 
	LRegles LR;	
	LFaits LF;
 
	LFaits ListeF, ListeC;
	Regles R;
	Faits F;
	int numTmp;
	String descTmp;
	 
	JDFaits (int x, int y, int lg, int ht, JFrame fen, String tab[], LRegles ListeRegles, LFaits ListeFaits)
	{ 
		boite = new JDialog (fen, ".: Gestion de la base de faits", false);
		boite.setBounds (x, y, lg, ht);
		 
		pan = new pan_faits();
		pan.setBackground (Color.gray);
		pan.setBounds (0, 0, lg, ht);
		pan.setLayout (null);
		boite.getContentPane().add (pan); 
		choix = new JComboBox(tab);
		choix.setSelectedIndex(0);
		choix.setBounds (20, 45, 300, 20);
		choix.addActionListener (this);
		pan.add(choix); 
		txt1 = new JTextField ("Numéro", 20);
		txt1.setEditable (true);
		txt1.setBounds (220, 147, 90, 20);
		pan.add (txt1);
		
		txt2 = new JTextField ("Description", 20);
		txt2.setEditable (true);
		txt2.setBounds	(220, 177, 90, 20);
		pan.add (txt2); 
		ok = new JButton ("GO !");
		ok.setBounds (240, 80, 70, 25);
		pan.add (ok);
		ok.setEnabled (true);
		ok.addActionListener(this);		
		
		ok2 = new JButton ("GO !");
		ok2.setBounds (232, 210, 70, 25);
		pan.add (ok2);
		ok2.setEnabled (false);
		ok2.addActionListener(this); 
		LR=ListeRegles;
		LF=ListeFaits;

		pan.updateUI();						
	}
	
	
	public void actionPerformed (ActionEvent e)
	{
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
			
			direction = choix.getSelectedIndex();					
			switch (direction)
			{
				case 0:
				{							
					txt1.setEditable (true);
					txt2.setEditable (true);
					break;		
				}
							
				case 1:
				{
					txt1.setEditable (true);
					txt2.setEditable (false);
					break;							
				}
						
				case 2:
				{							
					txt1.setEditable (true);
					txt2.setEditable (true);
					break;		
				}									
			}
		}
						
		if (source == ok2)   
		{
			direction = choix.getSelectedIndex();					
			switch (direction)
			{
				case 0:   
				{													
					try   
					{ 
						numTmp = Integer.parseInt(txt1.getText());
						descTmp = txt2.getText();								
								
						if (LF.EstFait(numTmp))  
						{
							JOptionPane.showMessageDialog(this, "Le fait n°" + numTmp + " existe déjà ! " + "\nVeuillez ressaisir ...");	
						}
						else
						{ 
							F = new Faits(); 
							F.setNum(numTmp);
							F.setDesc(descTmp); 
							LF.AjouterFait(F);
						}						
					}
					catch (Exception erreur)   
					{
						JOptionPane.showMessageDialog(this, "Erreur de saisie !");	
					}					
					break;
				}
							
				case 1:   
				{
					try  
					{
						 
						numTmp = Integer.parseInt(txt1.getText());
						 
						LF.SupprFait(numTmp);
					}
					catch (Exception erreur)   
					{
						JOptionPane.showMessageDialog(this, "Erreur de saisie !");	
					}					
					break;							
				}
						
				case 2:   
				{
					try   
					{ 
						numTmp = Integer.parseInt(txt1.getText());
						descTmp = txt2.getText(); 
						if (LF.EstFait(numTmp))
						{ 
							LF.getFait(numTmp).setDesc(descTmp);								
						}
						else
						{
							System.out.println("  --> Le fait recherche n'est pas dans la liste");	
						}
					}
					catch (Exception erreur)   
					{
						JOptionPane.showMessageDialog(this, "Erreur de saisie !");	
					}					
					break;							
				}							
			}
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
	void InsertListe(LFaits L, String S)
	{
		int numTmp=0, numTmp2;
		char charTmp;
		String strTmp="";

		while(numTmp<=S.length()-1)
		{ 
			charTmp=S.charAt(numTmp);

			if ((charTmp!=';') && (charTmp!=' '))
			{ 
				strTmp=strTmp+charTmp;									
			}
			else
			{ 
				numTmp2=Integer.parseInt(strTmp);	 
				F = new Faits(); 
				F.setNum(numTmp2);
				F.setDesc(LF.getFait(numTmp2).getDesc()); 
				L.AjouterFait(F); 
				strTmp="";									
			}
			numTmp++;
		}	
	} 
	void DeleteListe(LFaits L, String S)
	{
		int numTmp=0, numTmp2;
		char charTmp;
		String strTmp="";

		while(numTmp<=S.length()-1)
		{ 
			charTmp=S.charAt(numTmp);

			if ((charTmp!=';') && (charTmp!=' '))
			{ 
				strTmp=strTmp+charTmp;									
			}
			else
			{ 
				numTmp2=Integer.parseInt(strTmp);	 
				L.SupprFait(numTmp2); 
				strTmp="";									
			}
			numTmp++;
		}	
	}
}


class pan_faits extends JPanel
{
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor (Color.lightGray);
		g.drawRoundRect(10, 10, 320, 110, 50, 50); 
		g.drawRoundRect(10, 130, 320, 120, 50, 50);
			
		g.setColor (Color.white);				
		g.drawString ("Que voulez-vous faire ?", 25, 30);
				
		g.drawString ("Valider l'opération afin de pouvoir", 25, 90);
		g.drawString ("Continuer la saisie.", 25, 105);	
				
		g.drawString (".: Numéro du fait :", 25, 162);
		g.drawString (".: Description du fait :", 25, 192);
				
		g.drawString (".: Afin de valider l'opération :", 25, 227);								
	}
}