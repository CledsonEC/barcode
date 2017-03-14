import java.util.Map;

public class Principal {

	private static char groupSeparator = (char)29;
	
	public static void main(String[] args) 
	{
		String barcode = "013789133832037310414616"+groupSeparator+"1717123193003223"+groupSeparator+"";
		//String barcode = "013789133832037310414616"+groupSeparator+"1717123193003223"+groupSeparator+"";

		Map<AII, String> decoded = GS1.parse(barcode);
		
		for (String code : decoded.values()) {
			System.out.println(code);
		}
	}

}
