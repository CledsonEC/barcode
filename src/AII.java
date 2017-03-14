
/**
 *Information Class for an Application Identifier (AI) 
 * @author cpacheco
 *
 */
public class AII implements Comparable<AII> {
	private String AI;
	private String Description;
	private int LengthOfAI;
	private DataType DataDescription;
	private int LengthOfData;
	private boolean FNC1;
	
	
	public int getLengthOfAI() {
		return LengthOfAI;
	}


	public boolean isFNC1() {
		return FNC1;
	}


	public void setFNC1(boolean fNC1) {
		FNC1 = fNC1;
	}


	public void setLengthOfAI(int lengthOfAI) {
		LengthOfAI = lengthOfAI;
	}


	public int getLengthOfData() {
		return LengthOfData;
	}


	public void setLengthOfData(int lengthOfData) {
		LengthOfData = lengthOfData;
	}


	public AII (String AI, String Description, int LengthOfAI, DataType DataDescription, int LengthOfData, boolean FNC1){
		this.AI = AI;
		this.Description = Description;
		this.LengthOfAI = LengthOfAI;
		this.DataDescription = DataDescription;
		this.LengthOfData = LengthOfData;
		this.FNC1 = FNC1;
	}
	
	
	@Override
	public String toString()
	{
		return AI + "-" + Description;
	}


	@Override
	public int compareTo(AII aii) {
		
		if(LengthOfAI > aii.LengthOfAI)
			return 1;
		else
			return 0; 
	}
	
}
