import java.util.*;

public class Compression {

	
	private static final int maxBits = 8;
	public static String test = "hellohellohellohellohe";
	private static List<String> mapOfCharacters = new ArrayList<String>((int) Math.pow(maxBits, 2));
	private static String finalInput = "";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		setInitialDictionary();
		for( int i = 0; i < test.length(); i++)
		{
			String temp = test.charAt(i) + "";
			while ( i < test.length() - 1 && mapOfCharacters.contains(temp + test.charAt(i + 1))  )
			{
				i++;
				temp += test.charAt(i);
			}
			String binString = Integer.toBinaryString(mapOfCharacters.indexOf(temp));
			while (binString.length() < maxBits)
			{
				binString = "0" + binString;
			}
			finalInput += binString + "";
			if ( mapOfCharacters.size() < 256 && i < test.length() - 1)
			{
				mapOfCharacters.add(temp + test.charAt(i + 1));
			}
		}
		System.out.println(finalInput);
		System.out.println(finalInput.length());
		System.out.println(test.length() * maxBits);
	}
	
	public static void setInitialDictionary()
	{
		for (int i = 0; i < 128; i++)
		{
			mapOfCharacters.add( ""+(char)i);
			//System.out.print(mapOfCharacters);
		}
	}

}
