import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class Menu extends JFrame implements ActionListener
{
	
		LRegles LR = new LRegles();
		LFaits LF = new LFaits();
	
		String repSE, repBF, repBR;
		String ficSE, ficBF, ficBR;
	
	private JMenuBar barreMenus;  
		private JMenu A, B, C, D;  
			private JMenuItem Aa, Ac, Ae, Ah;  
			private JMenu Ab, Ad, Af, Ag;  
				private JMenuItem Aba, Abb, Abc, Ada, Adb, Afa, Afb, Afc, Aga, Agb;
			private JRadioButton Ba, Bb;  
			private JCheckBox Ca, Cb, Cc; 
			private JMenuItem Da, Db;  
				

	private JToolBar barreOutils;
	
		
		private JButton B_a, B_b, B_c, B_d, B_e;	
								
		private Icon Isys_create = new ImageIcon ("img/1.gif");
		private Icon Isys_fleche = new ImageIcon ("img/2.gif");
		private Icon Isys_close = new ImageIcon ("img/3.gif");
		private Icon Isys_save = new ImageIcon ("img/4.gif");
		private Icon Isys_save_all = new ImageIcon ("img/5.gif");
		private Icon Isys_save_as = new ImageIcon ("img/6.gif");
		private Icon Isys_print = new ImageIcon ("img/7.gif");
		private Icon Isys_quit = new ImageIcon ("img/8.gif");
		private Icon Iaff_b = new ImageIcon ("img/9.gif");
		private Icon Ihelp_about = new ImageIcon ("img/10.gif");
		private Icon Ihelp_doc = new ImageIcon ("img/11.gif");
		
	private JDFaits boite1;
	private JDRegles boite2;
	private JDMoteur boite3;
	private JDAbout boite6;
	
	private AFaits boite4;
	private ARegles boite5;
	
	int larg = 1024;
	int haut = 768;
		
	Container contenu = getContentPane();
		
	public Menu()
	{

		setTitle("S.E - Système Expert [Nouveau]"); 	
		setBounds(0, 0, larg, haut);

		JPanel pan = new panneau();
		pan.setLayout (null);
		contenu.add(pan);

		barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);

		
		A = new JMenu ("Système");
		A.setMnemonic('S');
		barreMenus.add(A);

			Aa = new JMenuItem ("Nouveau", Isys_create);
			Aa.addActionListener (this);
			Aa.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			A.add(Aa);

			Ab = new JMenu ("      Ouvrir...");
			Ab.addActionListener (this);
			A.add(Ab);
			
				
				Aba = new JMenuItem ("Un projet ...", Isys_fleche);
				Aba.addActionListener (this);
				Aba.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
				Ab.add(Aba);
				
				Abb = new JMenuItem ("Une base de faits ...", Isys_fleche);
				Abb.addActionListener (this);
				Ab.add(Abb);
				
				Abc = new JMenuItem ("Une base de règles ...", Isys_fleche);
				Abc.addActionListener (this);
				Ab.add(Abc);
				
			
			Ac = new JMenuItem ("Fermer", Isys_close);
			Ac.addActionListener (this);
			A.add(Ac);

			A.addSeparator();

			
			Ad = new JMenu ("       Enregistrer");
			Ad.addActionListener (this);
			A.add(Ad);
			
				
				Ada = new JMenuItem ("La base de faits ...", Isys_save);
				Ada.addActionListener (this);
				Ad.add(Ada);
				
				Adb = new JMenuItem ("La base de règles ...", Isys_save);
				Adb.addActionListener (this);
				Ad.add(Adb);

			Ae = new JMenuItem ("Enregistrer tout", Isys_save_all);
			Ae.addActionListener (this);
			Ae.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			A.add(Ae);

			Af = new JMenu ("       Enregistrer sous ...");
			Af.addActionListener (this);
			A.add(Af);
			
				
				Afa = new JMenuItem ("Le projet ...", Isys_save_as);
				Afa.addActionListener (this);
				Af.add(Afa);
				
				Afb = new JMenuItem ("La base de faits ...", Isys_save_as);
				Afb.addActionListener (this);
				Af.add(Afb);
				
				Afc = new JMenuItem ("La base de règles ...", Isys_save_as);
				Afc.addActionListener (this);
				Af.add(Afc);

			A.addSeparator();

			
			Ag = new JMenu ("       Imprimer ...");
			Ag.addActionListener (this);
			A.add(Ag);
			
				
				Aga = new JMenuItem ("La base de faits ...", Isys_print);
				Aga.addActionListener (this);
				Ag.add(Aga);
				
				Agb = new JMenuItem ("La base de règles ...", Isys_print);
				Agb.addActionListener (this);
				Ag.add(Agb);

			A.addSeparator();		

			Ah = new JMenuItem (" Quitter", Isys_quit);
			Ah.addActionListener (this);
			A.add(Ah);

		B = new JMenu ("Utilisation");
		B.setMnemonic('U');
		barreMenus.add(B);

			ButtonGroup groupe = new ButtonGroup();			
			
			Ba = new JRadioButton ("Nouvelle recherche", false);
			Ba.addActionListener (this);				
			B.add(Ba);
			groupe.add(Ba);

			Bb = new JRadioButton ("Gestion du Système Expert.", true);
			Bb.addActionListener (this);				
			B.add(Bb);
			groupe.add(Bb);

		C = new JMenu ("Affichage");
		C.setMnemonic('A');
		barreMenus.add(C);

			Ca = new JCheckBox ("Base de faits", true);
			Ca.addActionListener (this);
			C.add(Ca);

			Cb = new JCheckBox ("Base de règles", true);
			Cb.addActionListener (this);
			C.add(Cb);

			Cc = new JCheckBox ("Base de résultats", false);
			Cc.addActionListener (this);
			C.add(Cc);

		D = new JMenu ("Help");
		D.setMnemonic('H');
		barreMenus.add(D);

			Da = new JMenuItem ("Documentation d'aide", Ihelp_doc);
			Da.addActionListener (this);
			D.add(Da);

			Db = new JMenuItem ("A propos de S.E...", Ihelp_about);
			Db.addActionListener (this);
			D.add(Db);

		barreOutils = new JToolBar();
		contenu.add(barreOutils, "North");
		barreOutils.setVisible(true);

			B_a = new JButton (Iaff_b);
			B_a.setToolTipText("Nouvelle recherche.");
			B_a.addActionListener (this);

			B_b = new JButton (Iaff_b);
			B_b.setToolTipText("Gestion du Système Expert.");
			B_b.addActionListener (this);

			B_c = new JButton (Iaff_b);
			B_c.setToolTipText("Afficher la base de faits");
			B_c.addActionListener (this);

			B_d = new JButton (Iaff_b);
			B_d.setToolTipText("Afficher la base de règles");
			B_d.addActionListener (this);

			B_e = new JButton (Iaff_b);
			B_e.setToolTipText("Afficher la base de résultats");
			B_e.addActionListener (this);

			barreOutils.add(B_a);
			barreOutils.add(B_b);
			barreOutils.add(B_c);
			barreOutils.add(B_d);
			barreOutils.add(B_e);
		

			boite4 = new AFaits(LF);
			
			boite5 = new ARegles(LR);

			String tab1[] = {"Ajouter un élément à la liste de faits", "Supprimer un élément de la liste de faits", "Renommer un fait de la liste de faits"};
			boite1 = new JDFaits(larg-358, 75, 350, 287, this, tab1, LR, LF);				
	
			String tab2[] = {"Ajouter une règle", "Supprimer une règle", "Supprimer toutes les règles",
					        "Ajouter une liste de fait(s) à une règle", "Ajouter une liste de conséquence(s) à une règle",
					        "Suppression de fait(s) d'une règle", "Suppression de conséquence(s) d'une règle",
					        "Supprimer la liste de fait(s) d'une règle", "Supprimer la liste de conséquence(s) d'une règle"};
			
			boite2 = new JDRegles(larg-358, 365, 350, 371, this, tab2, LR, LF, boite4, boite5);	
			
			boite3 = new JDMoteur(larg-358, 75, 350, 259, this, LR, LF);
			
	
		setVisible(true);
		
		boite1.setVoir(true);
		boite2.setVoir(true);
		boite3.setVoir(false);
		boite3.setVoirRes(false);
		boite4.setVoir(true);
		boite5.setVoir(true);	
		
	addWindowListener (new WindowAdapter()
				{	public void windowClosing (WindowEvent e)
					{ System.exit(0);
					}
				});			
	}


	public void actionPerformed (ActionEvent e)
	{
		int choix;

		Object source =	e.getSource();

		if (source == Aa)
		{
			LF.InitListe();
			LR.InitListe();
			
			boite3.setNbSaves(0);
			
			reinitChemin();
			
			boite1.setVoir(true);
			boite2.setVoir(true);
			boite3.setVoir(false);
			boite3.setVoirRes(false);
			boite4.setVoir(true);
			boite5.setVoir(true);

			JOptionPane.showMessageDialog(this, "Système Expert initialisé !", "Nouveau Système Expert", JOptionPane.INFORMATION_MESSAGE);
			setTitle("S.E - Système Expert [Nouveau]");
		}
		
			if (source == Aba) {JDChargerSE(this);}
			if (source == Abb) {JDChargerBF(this);}
			if (source == Abc) {JDChargerBR(this);}
			
		
		if (source == Ac)
		{
			choix = JOptionPane.showConfirmDialog(this, "Voulez vous sauver le Système avant de le fermer ?");
			
			if (choix == 0)  
			{
				JDSauverSE(this);
				
				
				LF.setPremier (null);
				LR.setPremier (null);
				
				boite3.setNbSaves(0);
				
				reinitChemin();
	
				boite1.setVoir(false);
				boite2.setVoir(false);
				boite3.setVoir(false);
				boite3.setVoirRes(false);
				boite4.setVoir(false);
				boite5.setVoir(false);
				
				setTitle("S.E - Système Expert [Nouveau]");					
			}
			else
			{
				if (choix == 1)  
				{
					
					LF.InitListe();
					LR.InitListe();

					boite3.setNbSaves(0);
					
					reinitChemin();
		
					boite1.setVoir(false);
					boite2.setVoir(false);
					boite3.setVoir(false);
					boite3.setVoirRes(false);
					boite4.setVoir(false);
					boite5.setVoir(false);
					
					setTitle("S.E - Système Expert [Nouveau]");					
				}
			}
		}
		
		
			if (source == Ada) {JDSauverBF(this);}
			if (source == Adb) {JDSauverBR(this);}
			if (source == Ae) {JDSauverSE(this);}
			if (source == Afa) {JDSauverSousSE(this);}
			if (source == Afb) {JDSauverSousBF(this);}
			if (source == Afc) {JDSauverSousBR(this);}
		
		if (source == Ah)
		{
			choix = JOptionPane.showConfirmDialog(this, "Voulez vous sauver le Système avant de quitter ?");
			
			if (choix == 0) 
			{
				JDSauverSE(this);
				System.exit(0);	
			}
			else
			{
				if (choix == 1) 
				{
					System.exit(0);
				}
			}
		}
		
			if ((source == Ba) || (source == B_a))
			{
				boite1.setVoir(false);
				boite2.setVoir(false);
				boite3.setVoir(true);
				boite3.setVoirRes(true);
				boite4.setVoir(true);
				boite5.setVoir(false);
				Ca.setSelected(true);
				Cb.setSelected(false);
				Cc.setSelected(true);				
			}
	
			if ((source == Bb) || (source == B_b))
			{
				boite1.setVoir(true);
				boite2.setVoir(true);
				boite3.setVoir(false);
				boite3.setVoirRes(false);
				boite4.setVoir(true);
				boite5.setVoir(true);				
				Ca.setSelected(true);
				Cb.setSelected(true);
				Cc.setSelected(false);	
			}

			if (source == Ca)
			{
				if (Ca.isSelected())
				{boite4.setVoir(true);}
				else
				{boite4.setVoir(false);}	
			}
			if (source == Cb)
			{
				if (Cb.isSelected())
				{boite5.setVoir(true);}
				else
				{boite5.setVoir(false);}	
			}					
			if (source == Cc)
			{
				if (Cc.isSelected())
				{boite3.setVoirRes(true);}
				else
				{boite3.setVoirRes(false);}	
			}

			if (source == Da){}
			if (source == Db)
			{			
				if (boite6 == null)
				{
					boite6 = new JDAbout(larg/2-200, 210, 350, 250, this);
				}
				else
				{
					boite6.setVoir(true);	
				}
			}
					
		if (source == B_c){boite4.setVoir(true);}
		if (source == B_d){boite5.setVoir(true);}
		if (source == B_e){boite3.setVoirRes(true);}	 
	}
	
	void JDChargerBF(JFrame fen)
	{
    	JDialog boite;
		String txt, repTmp, ficTmp;
		txt = JOptionPane.showInputDialog (fen, "Entrer l'adresse :", "Charger une base de faits ...", JOptionPane.QUESTION_MESSAGE);
		ficTmp = ExtraitNomfichier(txt);
		repTmp = ExtraitNomrepertoire(txt);
		if (txt != null)
		{
			LF.InitListe();
			OuvrirFileFAI(repTmp, ficTmp, fen);			
		}
	}

	void JDChargerBR(JFrame fen)
	{
    	JDialog boite;
		String txt, repTmp, ficTmp;
		txt = JOptionPane.showInputDialog (fen, "Entrer l'adresse :", "Charger une base de règles ...", JOptionPane.QUESTION_MESSAGE);
		ficTmp = ExtraitNomfichier(txt);
		repTmp = ExtraitNomrepertoire(txt);
		
		if (txt != null)
		{
			LR.InitListe();
			OuvrirFileRGL(repTmp, ficTmp, fen);			
		}
	}

	void JDChargerSE(JFrame fen)
	{
    	JDialog boite;
		String txt, repTmp, ficTmp;
		txt = JOptionPane.showInputDialog (fen, "Entrer l'adresse :", "Charger un Système Expert ...", JOptionPane.QUESTION_MESSAGE);
		ficTmp = ExtraitNomfichier(txt);
		repTmp = ExtraitNomrepertoire(txt);
		if (txt != null)
		{
			LF.InitListe();
			LR.InitListe();
			
			OuvrirFilePRJ(repTmp, ficTmp, fen);
			setTitle("S.E - Système Expert " + "[" + ficTmp + "]");
		}
	}
	
	void JDSauverBF(JFrame fen)
	{
		if (ficBF != null)
		{
			EnregistrerFileFAI(repBF, ficBF, fen);
		}
		else
		{
			JDSauverSousBF(fen);
		}								
	}
	
	void JDSauverBR(JFrame fen)
	{
		if (ficBR!= null)
		{
			EnregistrerFileRGL(repBR, ficBR, fen);
		}
		else
		{
			JDSauverSousBR(fen);
		}
	}
	
	void JDSauverSE(JFrame fen)
	{
		if (ficSE != null)
		{
			EnregistrerFilePRJ(repSE, ficSE, fen);
			setTitle("S.E - Système Expert " + "[" + ficSE + "]");
		}
		else
		{
			JDSauverSousSE(fen);
		}		
	}	
	
	void JDSauverSousSE(JFrame fen)
	{
		String txt;
		String ficTmp, repTmp;
		txt = JOptionPane.showInputDialog (fen, "Entrer l'adresse :", "Sauver le Système Expert sous...", JOptionPane.QUESTION_MESSAGE);
		if (txt != null)
		{
			ficTmp = ExtraitNomfichier(txt);
			repTmp = ExtraitNomrepertoire(txt);
						
			EnregistrerFileFAI(repTmp, ficTmp, fen);
			EnregistrerFileRGL(repTmp, ficTmp, fen);
			EnregistrerFilePRJ(repTmp, ficTmp, fen);
			JOptionPane.showMessageDialog(fen, "Projet sauvegardé à l'adresse : " + repTmp + ficTmp + ".PRJ" );
			
			setTitle("S.E - Système Expert " + "[" + ficTmp + "]");
		}		
	}

	void JDSauverSousBF(JFrame fen)
	{
		String txt;
		String ficTmp, repTmp;
		txt = JOptionPane.showInputDialog (fen, "Entrer l'adresse :", "Sauver la base de faits sous...", JOptionPane.QUESTION_MESSAGE);	
		if (txt != null)
		{
			ficTmp = ExtraitNomfichier(txt);
			repTmp = ExtraitNomrepertoire(txt);
			
			EnregistrerFileFAI(repTmp, ficTmp, fen);
			JOptionPane.showMessageDialog(fen, "Base de faits sauvegardée à l'adresse : " + repTmp + ficTmp + ".FAI" );
		}
	}
	
	void JDSauverSousBR(JFrame fen)
	{
		String txt;
		String ficTmp, repTmp;

		txt = JOptionPane.showInputDialog (fen, "Entrer l'adresse :", "Sauver la base de règles sous...", JOptionPane.QUESTION_MESSAGE);
		
		if (txt != null)
		{
			ficTmp = ExtraitNomfichier(txt);
			repTmp = ExtraitNomrepertoire(txt);
			
			EnregistrerFileRGL(repTmp, ficTmp, fen);
			JOptionPane.showMessageDialog(fen, "Base de règles sauvegardée à l'adresse : " + repTmp + ficTmp + ".RGL" );
		}
	}	
		

	void OuvrirFilePRJ(String Repertoire, String Fichier, JFrame fen)
	{
		String repTmp, ficTmp;
		String FileF, FileR, Chemin;
		
		try
		{
			if (!A1extension(Fichier))
				Fichier = Fichier + ".PRJ";
			  								
			Chemin = Repertoire + Fichier;
			
			BufferedReader FichierProj = new BufferedReader (new FileReader (Chemin));
			
			FileF = FichierProj.readLine();
			ficTmp = ExtraitNomfichier(FileF);
			repTmp = ExtraitNomrepertoire(FileF);
			
			
			OuvrirFileFAI(repTmp, ficTmp, fen);						
			System.out.println("Fait : " + FileF);
			
			FileR = FichierProj.readLine();
			ficTmp = ExtraitNomfichier(FileR);
			repTmp = ExtraitNomrepertoire(FileR);			
			
			
			OuvrirFileRGL(repTmp, ficTmp, fen);				
			System.out.println("Regles : " + FileR);			
			
			FichierProj.close();
			
			repSE = Repertoire;				
			ficSE = Fichier;
			
		}
		catch(IOException err)
		{
			JOptionPane.showMessageDialog(fen, "Le fichier PRJ n'est pas un fichier valide !", "Erreur !", JOptionPane.ERROR_MESSAGE);	
		}			
	}
	

	
	void OuvrirFileFAI(String Repertoire, String Fichier, JFrame fen)
	{
		Faits F;
		char charTmp;
		String strTmp, strTmp2, Chemin;
		int numTmp, numTmp2;
		 
		try
		{
			
			if (!A1extension(Fichier))
			  Fichier = Fichier + ".FAI";
				
			Chemin = Repertoire + Fichier;
						
			
			BufferedReader FichierFAI = new BufferedReader (new FileReader (Chemin));
			
			do 
			{
				strTmp = FichierFAI.readLine();	
				
				if (strTmp != null)
				{ 
					strTmp2 = "";
					numTmp = 0;
					charTmp = 'A';
					
					while (charTmp!=' ')
					{
						charTmp=strTmp.charAt(numTmp);
						
						if (charTmp!=' ')
						{
							strTmp2	= strTmp2 + charTmp;
						}
						numTmp++;	
					}
		
					numTmp2=Integer.parseInt(strTmp2);
					
					strTmp2 = "";
					charTmp = 'A';			
					
					while (charTmp!='.')
					{
						charTmp=strTmp.charAt(numTmp);
						
						if (charTmp!='.')
						{
							strTmp2	= strTmp2 + charTmp;
						}
						numTmp++;	
					}			
					
					F = new Faits();
					F.setNum(numTmp2);
					F.setDesc(strTmp2);
					LF.AjouterFait(F);
				}
			}
			while (strTmp != null);	
			FichierFAI.close();
			
			repBF = Repertoire;				
			ficBF = Fichier;
		}
		catch(IOException err)
		{
			JOptionPane.showMessageDialog(fen, "Le fichier FAI n'est pas un fichier valide !", "Erreur !", JOptionPane.ERROR_MESSAGE);	
		}			
	}

	void OuvrirFileRGL(String Repertoire, String Fichier, JFrame fen)
	{
		LFaits ListeF, ListeC;
		Regles R;
		char charTmp;
		String strTmp, strTmp2, strTmp3, Chemin;
		int numTmp, numTmp2;		
		 
		try
		{
			if (!A1extension(Fichier))
			  Fichier = Fichier + ".RGL";
				
			Chemin = Repertoire + Fichier;
		
			BufferedReader FichierRGL = new BufferedReader (new FileReader (Chemin));
			
			do 
			{
				strTmp = FichierRGL.readLine();	
				
				if (strTmp != null)
				{ 
					
					strTmp2 = "";
					numTmp = 0;
					charTmp = 'A';
					
					while (charTmp!=':')
					{
						charTmp=strTmp.charAt(numTmp);
						
						if (charTmp!=':')
						{
							strTmp2	= strTmp2 + charTmp;
						}
						numTmp++;	
					}

					numTmp2 = Integer.parseInt(strTmp2);

					strTmp2 = "";
					charTmp = 'A';
					
					while (charTmp!='=')
					{
						charTmp=strTmp.charAt(numTmp);
						
						if (charTmp!='=')
						{
							strTmp2	= strTmp2 + charTmp;
						}
						numTmp++;	
					}
		
					strTmp3 = strTmp2;
					
					strTmp2 = "";
					charTmp = 'A';			
					
					while (charTmp!='.')
					{
						charTmp=strTmp.charAt(numTmp);
						
						if (charTmp!='.')
						{
							strTmp2	= strTmp2 + charTmp;
						}
						numTmp++;	
					}			
					
					ListeF = new LFaits();
					ListeC = new LFaits();
		
					ListeF.InsertListe(LF, strTmp3);
					ListeC.InsertListe(LF, strTmp2);
						
					R = new Regles();
						
					R.setNum(numTmp2);
					R.setLFait(ListeF);
					R.setLCons(ListeC);
	
					LR.Ajouter_Regle(R);
				}
			}
			while (strTmp != null);	
			
			FichierRGL.close();
			
			repBR = Repertoire;				
			ficBR = Fichier;
		}
		catch(IOException err)
		{
			JOptionPane.showMessageDialog(fen, "Le fichier RGL n'est pas un fichier valide !", "Erreur !", JOptionPane.ERROR_MESSAGE);	
		}			
	}

	void EnregistrerFilePRJ(String Repertoire, String Fichier, JFrame fen)
	{
		String repTmp, ficTmp;
		String FileF, FileR, Chemin;
		
		try
		{
			if (!A1extension(Fichier))
				Fichier = Fichier + ".PRJ";
			  								
			Chemin = Repertoire + Fichier;
			
			BufferedWriter FichierPRJ = new BufferedWriter (new FileWriter (Chemin));
			
			FichierPRJ.write(repBF + ficBF);
			FichierPRJ.newLine();
			FichierPRJ.write(repBR + ficBR);
			FichierPRJ.newLine();
			JDSauverBF(fen);
			JDSauverBR(fen);		
			FichierPRJ.close();	
			
			repSE = Repertoire;				
			ficSE = Fichier;
		}
		catch(IOException err)
		{
			JOptionPane.showMessageDialog(fen, "Le fichier PRJ n'est pas un fichier valide !", "Erreur !", JOptionPane.ERROR_MESSAGE);	
		}			
	}

	void EnregistrerFileFAI(String Repertoire, String Fichier, JFrame fen)
	{
		
		Faits F;
		String Chemin;
		
		if (!A1extension(Fichier))
			  Fichier = Fichier + ".FAI";
				
		Chemin = Repertoire + Fichier;				
				 
		try
		{
			BufferedWriter FichierFAI = new BufferedWriter (new FileWriter (Chemin));
			
			F = LF.getPremier();
			
			while(F != null)
			{
				FichierFAI.write(F.getNum() + " " + F.getDesc() + ".");
				FichierFAI.newLine();
				F = F.getSuivant();
			}
			FichierFAI.close();
			
			repBF = Repertoire;				
			ficBF = Fichier;
		}
		catch(IOException err)
		{
			JOptionPane.showMessageDialog(fen, "Le fichier FAI n'est pas un fichier valide !", "Erreur !", JOptionPane.ERROR_MESSAGE);	
		}
		
	}
	void EnregistrerFileRGL(String Repertoire, String Fichier, JFrame fen)
	{
		
		Regles R;
		Faits F;
		String Chemin;		
				 
		try
		{
			if (!A1extension(Fichier))
			  Fichier = Fichier + ".RGL";
				
			Chemin = Repertoire + Fichier;
			
			BufferedWriter FichierRGL = new BufferedWriter (new FileWriter (Chemin));
			
			R = LR.getPremier();
			
			while(R != null)
			{
				FichierRGL.write(R.getNum() + ":");
				F = R.getLFait().getPremier();
				
				while(F != null)
				{
					FichierRGL.write(F.getNum() + ";");										
					F = F.getSuivant();
				}
				
				FichierRGL.write("=");
				F = R.getLCons().getPremier();
								
				while(F != null)
				{
					FichierRGL.write(F.getNum() + ";");															
					F = F.getSuivant();
				}
				FichierRGL.write(".");
				FichierRGL.newLine();				
				R = R.getSuivant();
				
			}										
			
			FichierRGL.close();
			
			repBR = Repertoire;				
			ficBR = Fichier;
		}
		catch(IOException err)
		{
			JOptionPane.showMessageDialog(fen, "Le fichier RGL n'est pas un fichier valide !", "Erreur !", JOptionPane.ERROR_MESSAGE);	
		}				
		
	}
	
	String ExtraitNomfichier(String S)
	{		
		int numTmp=0, numTmp2, fin=1;
		char charTmp;
		String strrep="", strfic="";
		int nbslash=0;		
			
		while(numTmp < S.length())
		{
			charTmp = S.charAt(numTmp);

			if (charTmp == '/')
			{
				
				nbslash++;				
				if (nbslash > 0)
				{
					
					strrep = strrep + strfic;
					strfic = "";
				}
				else
				{
					strfic = strfic + charTmp;
				}
			}
			else
			{
				strfic = strfic + charTmp;						
			}
			numTmp++;
		}
		return strfic;
	}
	
	String ExtraitNomrepertoire(String S)
	{		
		int numTmp=0, nbslash=0;
		char charTmp;
		String strrep="", strfic="";		
			
		while(numTmp < S.length())
		{
			charTmp = S.charAt(numTmp);						

			if (charTmp == '/')
			{
				nbslash++;
				if (nbslash > 0)
				{
					strrep = strrep + strfic + charTmp;					
					strfic = "";
				}
				else
				{
					strfic = strfic + charTmp;
				}
			}
			else
			{
				strfic = strfic + charTmp;						
			}
			numTmp++;
		}
		return strrep;
	}
	
	boolean A1extension(String S)
	{
		boolean reponse=false;
		int numTmp=0;
		char charTmp;		
			
		while((numTmp < S.length()) && (!reponse))
		{
			
			charTmp = S.charAt(numTmp);

			if (charTmp == '.')
			{
				reponse = true;
			}
			numTmp++;
		}
		return reponse;		
	}
	

	void reinitChemin()
	{
		repSE = null;
		ficSE = null;
		repBF = null;
		ficBF = null;
		repBR = null;
		ficBR = null;
	}
}


class panneau extends JPanel
{
	private ImageIcon Ifond;
				
	public panneau()
	{

		Ifond = new ImageIcon ("img/fond2.jpeg");				
	}
		
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.drawImage (Ifond.getImage(), 0, 0, null);
				
		g.setColor (Color.black);	
		g.drawString ("Bienvenue dans S.E - Système Expert.", 20, 20);			
	}	
}