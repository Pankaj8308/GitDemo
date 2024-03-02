package P1;

public class CorJavaBasic3 {

	public static void main(String[] args) {
		//String is an object
		//String Literal
		//String s = "Rahul Shetty Academy";
		String s1 = "Rahul Shetty Academy";
		//String with new keyword
		//String s2 = new String("Welcome");
		//String s3 = new String("Welcome");
		
	String s = "Rahul Shetty Academy";
		String[] ss = s.split("Shetty");
		
		//for (int i=0; i<ss.length; i++)
		{
		//	System.out.println(ss[i].trim());
		}
		
		//for (int i=0; i<s1.length(); i++)
		{
		//	System.out.println(s1.charAt(i));
		}
		//Printing string in Reverse
		for (int i= s1.length()-1; i>=0; i--)
		{
			System.out.print(s1.charAt(i));
		}
		

	}

}
