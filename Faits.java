class Faits
{
 
	int numFait;
	String descFait;
	Faits suivantFait;
	  
	Faits ()
	{
		numFait=0;	
		descFait=null;
		suivantFait=null;
	} 
		int getNum()
		{
			return numFait;	
		}  
		String getDesc()
		{
			return descFait;	
		}	 
		Faits getSuivant()
		{
			return suivantFait;	
		}
	 
		void setNum(int I)
		{
			numFait=I;	
		} 
		void setDesc(String S)
		{
			descFait=S;	
		}  
		void setSuivant(Faits F)
		{
			suivantFait=F;	
		}	
}