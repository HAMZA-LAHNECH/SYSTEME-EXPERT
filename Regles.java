class Regles
{

	int numRegle;
	Regles suivantRegle;
	LFaits C;
	LFaits F;
	boolean EstTeste;
	
	Regles()
	{
	 	numRegle = 0;
	 	suivantRegle = null;
	 	C = null;
	 	F = null;
	 	EstTeste = false;	
	}

		int getNum()
		{
			return numRegle;		
		}
	
		Regles getSuivant()
		{
			return suivantRegle;	
		}
		
		LFaits getLCons()
		{
			return C;	
		}

		LFaits getLFait()
		{
			return F;	
		}
		
		boolean getTeste()
		{
			return EstTeste;		
		}

		void setNum(int I)
		{
			numRegle = I;		
		}	
		
		void setSuivant(Regles R)
		{
			suivantRegle=R;	
		}
		
		void setLFait(LFaits L)
		{
			F=L;	
		}
		
		void setLCons(LFaits L)
		{
			C=L;	
		}
		
		void setTeste(boolean B)
		{
			EstTeste = B;		
		}
}