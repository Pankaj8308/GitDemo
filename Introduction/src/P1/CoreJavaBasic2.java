package P1;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBasic2 {

	public static void main(String[] args) {
		int[] arr2 = {1,2,3,4,5,4,5,8,2,4,5,3,3,4,16,4,3,88,4};
		
		//2
		//for (int i=0;i<arr2.length;i++)
		{
			//if (arr2[i]%2==0)
			{
			//	System.out.println(arr2[i]);
			//	break;
			}
			//else
			{
				//System.out.println(arr2[i] +"is not multiple by 2");
			}
			ArrayList<String> a = new ArrayList<String>();
			//create object of the class - object.method
			a.add("Rahul");
			a.add("Pankaj");
			a.add("Neha");
			a.add("Pooja");
			//a.remove(2);
			//System.out.println(a.get(1));
			
			for(int i=0; i<a.size(); i++)
			{
				System.out.println(a.get(i));
			}
			System.out.println("*********");
			for (String s :a)
			{
				System.out.println(s);
			}
			//To check Item present in ArrayList
			System.out.println(a.contains("Pankaj"));
			String[] name = {"rahul","jaya","Pankaj"};
		//Converting name array to array list
			List<String>nameList = Arrays.asList(name);
			System.out.println(nameList.contains("Pankaj"));
			
		}
		
		
		

	}

}
