package Lab6;

import java.util.*;
public class extract 
{
    public static long p = 24852977l;
    public static long g = 2744l;
    public static long answer = 8414508l;
    public static long x = 1l;
    public static long found = 0;
    public static long oneoverc1 = 0;
    
    public static void main(String[] args)
    {
        while(found!=answer)
        {
            found=modPow(g, x, p);
            if(found==answer)
            {
                System.out.println("Primary Key: "+x);
            }
            else
            {
                x++;
            }
        }
        
        long c1=15268076l;
        long c2=743675l;
        
        oneoverc1=modPow(c1, p-1-x, p);
        
        long message = modMult(oneoverc1, c2, p);
        
        System.out.println("Message: "+message);
        
    }
    
    public static long modPow(long number, long power, long modulus)
    {
    	if(power==0)
    		 return 1;
    	
    		 else if(power%2==0)
    		 {
    			 long halfpower=modPow(number, power/2, modulus);
    			 return modMult(halfpower,halfpower,modulus);
    		 }
    		 else
    		 {
    			 long halfpower=modPow(number, power/2, modulus);
    			 long firstbit = modMult(halfpower,halfpower,modulus);
    			 return modMult(firstbit,number,modulus);
    		 }
	 }
    
    public static long modMult(long first, long second, long modulus)
    {
    	
    	if(second==0)
    		 return 0;
    		 
    		else if(second%2==0)
    		{
    			long half=modMult(first, second/2, modulus);
    			return (half+half)%modulus;
    		}
    		else
    		{
    			long half=modMult(first, second/2, modulus);
    			return (half+half+first)%modulus;
    		}
	 }

}