class LFaits
{
	
	Faits premier;
	int nbfaits;
	LFaits()
	{
		premier=null;
		nbfaits=0;
	}
	
		Faits getPremier()
		{
			return premier;	
		}
		
		int getNbFaits()
		{
			return nbfaits;	
		}
		
		Faits getFait(int numFait)
		{	
			Faits rude=premier;
			Faits resultat;
			
			while ((rude!=null) && (rude.getNum()!=numFait))
			{
				 rude=rude.getSuivant();
			}
			if (rude==null)
			{
				 System.out.println("  --> Le fait recherche n'est pas dans la liste");
				 resultat=null;		
			}
			else
			{
				 resultat=rude;				 	
			}
			
			return resultat;
		}
		void setPremier(Faits element)
		{
			premier=element;	
		}
		void setNbFaits(int I)
		{
			nbfaits = I;	
		}
		void InitListe()
		{
			premier=null;
			nbfaits=0;			
		}
		void Afficher_liste_fait()
		{
			Faits rude;
			
			if (premier == null)
			{
				System.out.println("           Vide ...");		
			}
			else
			{
				rude = premier;
				while (rude != null)
				{
					System.out.print("           Num(" + rude.getNum() + ") : ");
					System.out.println(rude.getDesc() + ".");
					rude = rude.getSuivant();
				}			
			}
			System.out.println();
		}
		
		boolean EstFait(int num_fait)
		{	
			Faits rude=premier;
			boolean resultat;
			while ((rude!=null) && (rude.getNum()!=num_fait))
			{
				 rude=rude.getSuivant();
			}
			if (rude==null)
			{
				 System.out.println("  --> Le fait recherche n'est pas dans la liste");
				 resultat=false;		
			}
			else
			{
				 resultat=true;				 	
			}
			
			return resultat;
		}
	
		void AjouterFait(Faits element)
		{	
			Faits rude;
			if (premier==null)
			{
				premier=element;
			}
			else
			{
				 rude=premier;
				 while ((rude.getSuivant()!=null) && (rude.getSuivant().getNum() < element.getNum()))
				 {
				 	rude=rude.getSuivant();
				 }
				 
				 element.setSuivant(rude.getSuivant());
				 rude.setSuivant(element);
			}
			
			nbfaits++;	
		}
		void SupprFait(int num_fait)
		{	
			Faits rude;
			
			if (!EstFait(num_fait))
			{
				System.out.println(" --> Suppression impossible");
			}
			else
			{
				 rude=premier;
				 
				 if (rude.getNum()==num_fait)
				 {
				 	premier=rude.getSuivant();
				 	rude=null;
				 }
				 else
				 {
				 	while (rude.getSuivant().getNum()!=num_fait)
				 	{
				 		rude=rude.getSuivant();
				 	}
				 	rude.setSuivant(rude.getSuivant().getSuivant());
				 	rude = null;			 	
				}
			}
			nbfaits--;
		}
		void InsertListe(LFaits LF, String S)
		{
			Faits F;
			int numTmp=0, numTmp2;
			char charTmp;
			String strTmp="";
			
			while(numTmp<S.length())
			{
				charTmp = S.charAt(numTmp);
	
				if ((charTmp!=';') && (charTmp!=' '))
				{
					strTmp=strTmp+charTmp;									
				}
				else
				{
					numTmp2=Integer.parseInt(strTmp);	
	
					if (LF.EstFait(numTmp2))
					{
						F = new Faits();
		
						F.setNum(numTmp2);
						F.setDesc(LF.getFait(numTmp2).getDesc());
						AjouterFait(F);
					}
					strTmp = "";									
				}
				numTmp++;
			}	
		}
		void DeleteListe(String S)
		{
			int numTmp=0, numTmp2;
			char charTmp;
			String strTmp="";
	
			while(numTmp<S.length())
			{
				charTmp=S.charAt(numTmp);
	
				if ((charTmp!=';') && (charTmp!=' '))
				{
					strTmp=strTmp+charTmp;									
				}
				else
				{
					numTmp2=Integer.parseInt(strTmp);	
					SupprFait(numTmp2);
					strTmp="";									
				}
				numTmp++;
			}	
		}		
}