package P1;

public class CoreJavaBasic1 {

	public static void main(String[] args) {
		int myNum = 5;
		String website = "RahulShettyAcademy";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;
		
		//System.out.println(myNum + "is the value");
		//Arrays
		int[] arr = new int[5];//Size is decided
		arr[0] = 1;//Values assignment
		arr[1] = 2;
		arr[2] = 7;
		arr[3] = 8;
		arr[4] = 9;
		
		int[] arr2 = {1,2,3,4,5,4,5,3,2,4,5,3,3,4,5,4,3,3,4};//Size and value both are decided
		//System.out.println(arr2[3]);
		//For Loop
		
		for(int i=0; i<arr.length; i++)
		{
			//System.out.println(arr[i]);
		}
		for(int i=0; i<arr2.length; i++)
		{
			//System.out.println(arr2[i]);
		}
		String[] name = {"rahul","jaya","Pankaj"};
		for (int i=0; i<name.length; i++)
		{
			//System.out.println(name[i]);
		}
		for( String s: name)
		{
			System.out.println(s);
		}

	}

}
