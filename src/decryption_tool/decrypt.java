package Lab5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class decrypt
{
	public static String [] mystery;
	public static char [] mysteryChars;
    public static void main(String [] args)
    {
        FileIO reader = new FileIO();
        mystery = reader.load("/home/ian/mystery.txt");
        int ascii [] = new int[256];
        //System.out.println(mystery.length);
        double count=0;
        //mergeSort(ascii);
        
        for(int i=0; i<mystery.length; i++)
        {
        	for(int j=0; j<mystery[i].length(); j++)
        	{
        		ascii[(int)mystery[i].charAt(j)]++;
        		count++;
        	}
        	
        }
        System.out.println(count);
        
       for(int i=0; i<ascii.length; i++)
       {
    	   if(ascii[i]>0)
    	   { 
	    		   System.out.println("'"+(char)i+"' appeared "+ascii[i]+((ascii[i]==1)? " time    " : " times ")+" frequency = "+(100/count*ascii[i]));
    	   }
       }
    }
    public static void mergeSort(String[] ar) 
	{
	    if (ar.length >= 2)
	    {
	        String[] left = new String[ar.length / 2];
	        String[] right = new String[ar.length-ar.length / 2];
	
	        for (int i = 0; i < left.length; i++)
	        {
	            left[i] = ar[i]; 
	        }
	        for (int i = 0; i < right.length; i++)
	        {
	            right[i] = ar[i + ar.length / 2];
	        }
	        mergeSort(left);
	        mergeSort(right);
	
	        merge(ar, left, right);
	    }
	}

	public static void merge(String[] workspace, String[] left, String[] right)
	{
	    int x = 0;
	    int y = 0;
	
	    for (int i = 0; i < workspace.length; i++)
	    {
	        if (y >= right.length || (x < left.length && left[x].length()>(right[y].length())))
	
	        {
	            workspace[i] = left[x];
	            x++;
	        } 
	        else 
	        {
	            workspace[i] = right[y];
	            y++;
	        }
	    }
	}
}