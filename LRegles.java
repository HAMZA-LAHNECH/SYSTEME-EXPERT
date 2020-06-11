class LRegles
{
	

	Regles premier;
	int nbRegles;
	
	LRegles()
	{
		premier=null;
		nbRegles=0;			
	}	
	
		Regles getPremier()
		{
			return premier;	
		}
	
		int getNbRegles()
		{
			return nbRegles;	
		}
		
		Regles getRegle(int I)
		{
			
			Regles rude=premier;
			
			if (!EstRegle(I))  
			{
				System.out.println("  --> Suppression impossible !");
			}
			else
			{
				while (rude.getNum()!=I)
				{
					rude=rude.getSuivant();		
				}				
			}
			return rude;	
		}

		void setPremier(Regles R)
		{
			premier=R;	
		}
		void setNbRegles(int I)
		{
			nbRegles = I;	
		}	
	
		void InitListe()
		{
			premier = null;
			nbRegles = 0;			
		}

		boolean EstRegle(int numRegle)
		{	
			Regles rude=premier;
			boolean resultat;
			
			while ((rude!=null) && (rude.getNum()!=numRegle))
			{
				 rude=rude.getSuivant();
			}
		
			if (rude==null)
			{
				 System.out.println("");
				 System.out.println("  --> La Regles recherchee n'est pas dans la liste.");
				 System.out.println("");
				 resultat=false;		
			}
			else
			{
				 resultat=true;				 	
			}
			return resultat;
		}
		
		void Ajouter_Regle(Regles R)
		{	
			Regles rude;
			if (premier==null)
			{
				premier=R;
			}
			else
			{
				 rude=premier;
				 while ((rude.getSuivant()!=null) && (rude.getSuivant().getNum() < R.getNum()))
				 {
				 	rude=rude.getSuivant();
				 }
				 
				 R.setSuivant(rude.getSuivant());
				 rude.setSuivant(R);
			}
			nbRegles++;
		}
		
		void Suppr_Regle(int numRegle)
		{	
			Regles rude;
			if (!EstRegle(numRegle))  
			{
				System.out.println("  --> Suppression impossible !");
			}
			else
			{
				 rude=premier;
				 
				 if (rude.getNum()==numRegle)
				 {
				 	premier=rude.getSuivant();
				 	rude=null;
				 }
				 else
				 {
				 	while (rude.getSuivant().getNum()!=numRegle)
				 	{
				 		rude=rude.getSuivant();
				 	}
				 	
				 	rude.setSuivant(rude.getSuivant().getSuivant());
					rude = null;			 	
				}
			}
			nbRegles--;
		}
		
		void Afficher_Regles()
		{
			Regles rude;
			rude = premier;
			
			System.out.println("* Les regles :");
			System.out.println("");
			
			if (premier==null)
			{
			 	System.out.println("  --> La liste de regles est vide !");
			 	System.out.println("");	
			}
			else
			{
				System.out.println("   - Vous avez actuellement dans votre liste " + getNbRegles() + " regles.");
				System.out.println("");	
				System.out.println("   - Liste de regles :");
				System.out.println("");	
				
				while (rude != null)
				{
					System.out.println("     Regle numero " + rude.getNum() + ".");
					System.out.println("");
					System.out.println("        - Faits : ");
					rude.getLFait().Afficher_liste_fait();
					System.out.println("        - Consequences : ");
					rude.getLCons().Afficher_liste_fait();
					rude = rude.getSuivant();
				}					
			}
		}
		
		void InitTeste()
		{
			Regles R;
			
			R = premier;
			
			while (R != null)
			{
				R.setTeste(false);
				R = R.getSuivant();	
			}
		}			
}