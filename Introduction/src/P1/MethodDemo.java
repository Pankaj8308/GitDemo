package P1;

public class MethodDemo {

	public static void main(String[] args) {
		//Method should not be created in Main block
		//Syntax classname object = new classname();
MethodDemo d = new MethodDemo();
MethodDemo2 d1 = new MethodDemo2();
//Syntax to call method object.method();
d1.getUserData();
String str1 = d1.getUserData();
String str =d.getData();
System.out.println(str1);
System.out.println(str);
getData2();
String str2 = getData2();
System.out.println(str2);
	}
//Methods will be created here
	public String getData()
	{
		System.out.println("Hello");
		return "Pankaj Tiwari";
	}
	public static String getData2()
	{
		System.out.println("Hello");
		return "Pankaj Bhai";
	}
}
