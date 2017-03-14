import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;


public class GS1 {
	
	private static Map<String, AII> aiiMap = new HashMap<String, AII>();
	private static String[] aiis;
    private static int minLengthOfAI = 1;
    private static int maxLengthOfAI = 4;
    private static char groupSeparator = (char)29;
    private static String ean128StartCode = "]C1";
    private static boolean hasCheckSum = false;
	
    public static char getGroupSeparator() {
		return groupSeparator;
	}
	public static void setGroupSeparator(char groupSeparator) {
		GS1.groupSeparator = groupSeparator;
	}
	public static String getEan128StartCode() {
		return ean128StartCode;
	}
	public static void setEan128StartCode(String ean128StartCode) {
		GS1.ean128StartCode = ean128StartCode;
	}
	public static boolean isHasCheckSum() {
		return hasCheckSum;
	}
	public static void setHasCheckSum(boolean hasCheckSum) {
		GS1.hasCheckSum = hasCheckSum;
	}
	
	
	 private static void GS1(){
		add("00","SerialShippingContainerCode", 2, DataType.Numeric, 18, false);
		add("01", "EAN-NumberOfTradingUnit", 2, DataType.Numeric, 14, false);
        add("02", "EAN-NumberOfTheWaresInTheShippingUnit", 2, DataType.Numeric, 14, false);
        add("10", "Charge_Number", 2, DataType.Alphanumeric, 20, true);
        add("11", "ProducerDate_JJMMDD", 2, DataType.Numeric, 6, false);
        add("12", "DueDate_JJMMDD", 2, DataType.Numeric, 6, false);
        add("13", "PackingDate_JJMMDD", 2, DataType.Numeric, 6, false);
        add("15", "MinimumDurabilityDate_JJMMDD", 2, DataType.Numeric, 6, false);
        add("17", "ExpiryDate_JJMMDD", 2, DataType.Numeric, 6, false);
        add("20", "ProductModel", 2, DataType.Numeric, 2, false);
        add("21", "SerialNumber", 2, DataType.Alphanumeric, 20, true);
        add("22", "HIBCCNumber", 2, DataType.Alphanumeric, 29, false);
        add("240", "PruductIdentificationOfProducer", 3, DataType.Alphanumeric, 30, true);
        add("241", "CustomerPartsNumber", 3, DataType.Alphanumeric, 30, true);
		add("250", "SerialNumberOfAIntegratedModule", 3, DataType.Alphanumeric, 30, true);
        add("251", "ReferenceToTheBasisUnit", 3, DataType.Alphanumeric, 30, true);
        add("252", "GlobalIdentifierSerialisedForTrade", 3, DataType.Numeric, 2, false);
        add("30", "AmountInParts", 2, DataType.Numeric, 8, true);
        add("310d", "NetWeight_Kilogram", 4, DataType.Numeric, 6, false);
        add("311d", "Length_Meter", 4, DataType.Numeric, 6, false);
        add("312d", "Width_Meter", 4, DataType.Numeric, 6, false);
        add("313d", "Heigth_Meter", 4, DataType.Numeric, 6, false);
        add("314d", "Surface_SquareMeter", 4, DataType.Numeric, 6, false);
        add("315d", "NetVolume_Liters", 4, DataType.Numeric, 6, false);
        add("316d", "NetVolume_CubicMeters", 4, DataType.Numeric, 6, false);
        add("320d", "NetWeight_Pounds", 4, DataType.Numeric, 6, false);
        add("321d", "Length_Inches", 4, DataType.Numeric, 6, false);
        add("322d", "Length_Feet", 4, DataType.Numeric, 6, false);
        add("323d", "Length_Yards", 4, DataType.Numeric, 6, false);
        add("324d", "Width_Inches", 4, DataType.Numeric, 6, false);
        add("325d", "Width_Feed", 4, DataType.Numeric, 6, false);
        add("326d", "Width_Yards", 4, DataType.Numeric, 6, false);
        add("327d", "Heigth_Inches", 4, DataType.Numeric, 6, false);
        add("328d", "Heigth_Feed", 4, DataType.Numeric, 6, false);
        add("329d", "Heigth_Yards", 4, DataType.Numeric, 6, false);
        add("330d", "GrossWeight_Kilogram", 4, DataType.Numeric, 6, false);
        add("331d", "Length_Meter", 4, DataType.Numeric, 6, false);
        add("332d", "Width_Meter", 4, DataType.Numeric, 6, false);
        add("333d", "Heigth_Meter", 4, DataType.Numeric, 6, false);
        add("334d", "Surface_SquareMeter", 4, DataType.Numeric, 6, false);
        add("335d", "GrossVolume_Liters", 4, DataType.Numeric, 6, false);
        add("336d", "GrossVolume_CubicMeters", 4, DataType.Numeric, 6, false);
        add("337d", "KilogramPerSquareMeter", 4, DataType.Numeric, 6, false);
        add("340d", "GrossWeight_Pounds", 4, DataType.Numeric, 6, false);
        add("341d", "Length_Inches", 4, DataType.Numeric, 6, false);
        add("342d", "Length_Feet", 4, DataType.Numeric, 6, false);
        add("343d", "Length_Yards", 4, DataType.Numeric, 6, false);
        add("344d", "Width_Inches", 4, DataType.Numeric, 6, false);
        add("345d", "Width_Feed", 4, DataType.Numeric, 6, false);
        add("346d", "Width_Yards", 4, DataType.Numeric, 6, false);
        add("347d", "Heigth_Inches", 4, DataType.Numeric, 6, false);
        add("348d", "Heigth_Feed", 4, DataType.Numeric, 6, false);
        add("349d", "Heigth_Yards", 4, DataType.Numeric, 6, false);
        add("350d", "Surface_SquareInches", 4, DataType.Numeric, 6, false);
        add("351d", "Surface_SquareFeet", 4, DataType.Numeric, 6, false);
        add("352d", "Surface_SquareYards", 4, DataType.Numeric, 6, false);
        add("353d", "Surface_SquareInches", 4, DataType.Numeric, 6, false);
        add("354d", "Surface_SquareFeed", 4, DataType.Numeric, 6, false);
        add("355d", "Surface_SquareYards", 4, DataType.Numeric, 6, false);
        add("356d", "NetWeight_TroyOunces", 4, DataType.Numeric, 6, false);
        add("357d", "NetVolume_Ounces", 4, DataType.Numeric, 6, false);
        add("360d", "NetVolume_Quarts", 4, DataType.Numeric, 6, false);
        add("361d", "NetVolume_Gallonen", 4, DataType.Numeric, 6, false);
        add("362d", "GrossVolume_Quarts", 4, DataType.Numeric, 6, false);
        add("363d", "GrossVolume_Gallonen", 4, DataType.Numeric, 6, false);
        add("364d", "NetVolume_CubicInches", 4, DataType.Numeric, 6, false);
        add("365d", "NetVolume_CubicFeet", 4, DataType.Numeric, 6, false);
        add("366d", "NetVolume_CubicYards", 4, DataType.Numeric, 6, false);
        add("367d", "GrossVolume_CubicInches", 4, DataType.Numeric, 6, false);
        add("368d", "GrossVolume_CubicFeet", 4, DataType.Numeric, 6, false);
        add("369d", "GrossVolume_CubicYards", 4, DataType.Numeric, 6, false);
        add("37", "QuantityInParts", 2, DataType.Numeric, 8, true);
        add("390d", "AmountDue_DefinedValutaBand", 4, DataType.Numeric, 15, true);
        add("391d", "AmountDue_WithISOValutaCode", 4, DataType.Numeric, 18, true);
        add("392d", "BePayingAmount_DefinedValutaBand", 4, DataType.Numeric, 15, true);
        add("393d", "BePayingAmount_WithISOValutaCode", 4, DataType.Numeric, 18, true);
        add("400", "JobNumberOfGoodsRecipient", 3, DataType.Alphanumeric, 30, true);
        add("401", "ShippingNumber", 3, DataType.Alphanumeric, 30, true);
        add("402", "DeliveryNumber", 3, DataType.Numeric, 17, false);
        add("403", "RoutingCode", 3, DataType.Alphanumeric, 30, true);
        add("410", "EAN_UCC_GlobalLocationNumber(GLN)_GoodsRecipient", 3, DataType.Numeric, 13, false);
        add("411", "EAN_UCC_GlobalLocationNumber(GLN)_InvoiceRecipient", 3, DataType.Numeric, 13, false);
        add("412", "EAN_UCC_GlobalLocationNumber(GLN)_Distributor", 3, DataType.Numeric, 13, false);
        add("413", "EAN_UCC_GlobalLocationNumber(GLN)_FinalRecipient", 3, DataType.Numeric, 13, false);
        add("414", "EAN_UCC_GlobalLocationNumber(GLN)_PhysicalLocation", 3, DataType.Numeric, 13, false);
        add("415", "EAN_UCC_GlobalLocationNumber(GLN)_ToBilligParticipant", 3, DataType.Numeric, 13, false);
        add("420", "ZipCodeOfRecipient_withoutCountryCode", 3, DataType.Alphanumeric, 20, true);
        add("421", "ZipCodeOfRecipient_withCountryCode", 3, DataType.Alphanumeric, 12, true);
        add("422", "BasisCountryOfTheWares_ISO3166Format", 3, DataType.Numeric, 3, false);
        add("7001", "Nato Stock Number", 4, DataType.Numeric, 13, false);
        add("8001", "RolesProducts", 4, DataType.Numeric, 14, false);
        add("8002", "SerialNumberForMobilePhones", 4, DataType.Alphanumeric, 20, true);
        add("8003", "GlobalReturnableAssetIdentifier", 4, DataType.Alphanumeric, 34, true);
        add("8004", "GlobalIndividualAssetIdentifier", 4, DataType.Numeric, 30, true);
        add("8005", "SalesPricePerUnit", 4, DataType.Numeric, 6, false);
        add("8006", "IdentifikationOfAProductComponent", 4, DataType.Numeric, 18, false);
        add("8007", "IBAN", 4, DataType.Alphanumeric, 30, true);
        add("8008", "DataAndTimeOfManufacturing", 4, DataType.Numeric, 12, true);
        add("8018", "GlobalServiceRelationNumber", 4, DataType.Numeric, 18, false);
        add("8020", "NumberBillCoverNumber", 4, DataType.Alphanumeric, 25, false);
        add("8100", "CouponExtendedCode_NSC_offerCcode", 4, DataType.Numeric, 10, false);
        add("8101", "CouponExtendedCode_NSC_offerCcode_EndOfOfferCode", 4, DataType.Numeric, 14, false);
        add("8102", "CouponExtendedCode_NSC", 4, DataType.Numeric, 6, false);
        add("90", "InformationForBilateralCoordinatedApplications", 2, DataType.Alphanumeric, 30, true);
        add("91", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("92", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("93", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("94", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("95", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("96", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("97", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("98", "Company specific", 2, DataType.Alphanumeric, 30, true);
        add("99", "Company specific", 2, DataType.Alphanumeric, 30, true);
        
        aiis = aiiMap.keySet().toArray(new String[aiiMap.size()]);        
       
        //Verificar essa parte, não sei se o campareTo implementado no AII vai funcionar
        minLengthOfAI = Collections.min(aiiMap.values()).getLengthOfAI();        
        maxLengthOfAI = Collections.max(aiiMap.values()).getLengthOfAI();
        
	}
	
	
	/**
	 * 
	 * @param aI - Number of the AI
	 * @param description - Description
	 * @param lengthOfAI - LengthOfAI
	 * @param dataDescription - The type of the content
	 * @param lengthOfData - The max lenght of the content
	 * @param FNC1 - Support a group seperator
	 */
	public static void add(String aI, String description, int lengthOfAI, DataType dataDescription, int lengthOfData, boolean FNC1){
		
		aiiMap.put(aI, new AII(aI,description,lengthOfAI,dataDescription,lengthOfData, FNC1));
	}
	
	/**
	 * Parse the EAN128 code
	 * @param data - The raw scanner data 
	 * @return
	 */
	public static Map<AII, String> parse(String data){

		GS1();
		// cut off the EAN128 start code 
		if(data.startsWith(getEan128StartCode()))
			data = data.substring(getEan128StartCode().length());
		
		// cut off the check sum
		if(isHasCheckSum())
			data = data.substring(0, data.length() - 2);
		
		Map<AII, String> result = new HashMap<AII, String>();
		
		AtomicInteger index = new AtomicInteger(0);
		
		while (index.intValue() < data.length()){			
			AII ai = getAI(data, index);
			
			if(ai == null)
				return result;
			
			String code = getCode(data, ai, index);
			
			result.put(ai, code);
		}
		
		return result;
		
	}
	
	/**
	 * Try to get the AI at the current position
	 * @param data - The row data from the scanner
	 * @param index - The reference of the current position
	 * @return
	 */
	private static AII getAI(String data, AtomicInteger index){
		AII result = null;
		
		// Step through the different lenghts of the AIs
		for (int i = minLengthOfAI; i <= maxLengthOfAI; i++) {
			// get the AI sub string
            String ai = data.substring(index.intValue(), index.intValue()+i);
            
            
            // try to get the ai from the dictionary
            if(aiiMap.containsKey(ai)){
            	result = aiiMap.get(ai);
            	// Shift the index to the next
            	int novoIndex = index.intValue() + i;
            	index.set(novoIndex);
            	
            	return result;
            }            
		}
		
		return result;
	}
	
	/**
	 * 	Get the current code to the AI
	 * @param data - The row data from the scanner
	 * @param ai - The current AI
	 * @param index - The reference of the current position
	 * @return the data to the current AI
	 */
	private static String getCode(String data, AII ai, AtomicInteger index){

		// get the max lenght to read.
        int lenghtToRead = Math.min(ai.getLengthOfData(), data.length() - index.intValue());
        // get the data of the current AI
        String result = data.substring(index.intValue(), index.intValue()+lenghtToRead);
        
        if(ai.isFNC1())
        {
        	// try to find the index of the group seperator
            int indexOfGroupTermination = result.indexOf(getGroupSeparator());
            
            if (indexOfGroupTermination >= 0)
                lenghtToRead = indexOfGroupTermination + 1;
            // get the data of the current AI till the gorup seperator
            result = data.substring(index.intValue(), index.intValue() + lenghtToRead);
        }
        
        // Shift the index to the next
        int nextIndex = index.intValue() + lenghtToRead;
        index.set(nextIndex);
        
        return result;
	}
	
	
}
