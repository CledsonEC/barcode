import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class EAN128Test {

	private static char groupSeparator;
 

	@Before
    public void setUp() throws Exception
    {      
        this.groupSeparator = (char)29;
    }

	@Test
	public void converterEAN128_test1(){
		String barcode = "013789133832037310414616"+groupSeparator+"1717123193003223"+groupSeparator+"";

		Map<AII, String> decoded = GS1.parse(barcode);
				
		assertEquals(4, decoded.keySet().size());
			
		List<String> resultados = new ArrayList<String>();
		resultados.add("37891338320373");
		resultados.add("003223");
		resultados.add("171231");
		resultados.add("414616");
		
		
		for (String codes : decoded.values()) {
			
			assertTrue(resultados.contains(codes));
		}	
		
	}
	
	@Test
	public void converterEAN128_test2(){
		
		String barcode = "01078983574100152112345678"+groupSeparator+"101201";

		Map<AII, String> decoded = GS1.parse(barcode);
				
		assertEquals(3, decoded.keySet().size());
			
		List<String> resultados = new ArrayList<String>();
		resultados.add("07898357410015");
		resultados.add("12345678");
		resultados.add("1201");
		
		for (String codes : decoded.values()) {
			
			assertTrue(resultados.contains(codes));
		}	
		
	}
	

}
