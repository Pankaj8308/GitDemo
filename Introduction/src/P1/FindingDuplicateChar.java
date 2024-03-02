package P1;

import java.util.Arrays;
import java.util.List;

public class FindingDuplicateChar {

	public static void main(String[] args) {
		String mess = "Good Liife";
		int count =0;
		char[] m = mess.toCharArray();
		for(int i=0;i<mess.length();i++)
		{
			count=1;
			for(int j=i+1;j<mess.length();j++)
			{
				if(m[i]==m[j])
				{
					count++;
					m[j]=0;
					if(count>1)
					{
						System.out.println(m[i]);
					}
				}
			}
		}
		
	
			}

	}


