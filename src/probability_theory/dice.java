package Lab9;
import java.util.*;
public class dice 
{
	static int counter=0;
	static int total=0;
	static int count=0;
	public static void main(String[] args) 
	{
		while(counter!=100)
		{	
		boolean snapchat=false;
		boolean sneeze=false;
		count=0;
		int result=0;
		
		Random rand = new Random();
		
			while(sneeze==false || snapchat==false || result!=6)
			{	
				snapchat=false;
				sneeze=false;
				result = 0;
				
				result = rand.nextInt(6)+1;
			
				if(rand.nextInt(100)%5==0)
				{
					snapchat=true;
				}
				if(rand.nextInt(100)%12==0)
				{
					sneeze=true;
				}
				count++;
				
			}
			System.out.println("The number of rolls it took for all 3 to happen is: "+count);
			counter++;
		}
		total+=count;
		System.out.println((double)total/counter);
	}
}