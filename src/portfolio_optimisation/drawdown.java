package Lab8;

import java.io.*;
import java.util.*;

public class drawdown
{
	public static void main(String[] args) 
	{
		FileIO io = new FileIO();
		String[] original = io.load("/home/ian/stockData.txt");
		
		int numrows=original.length;
		int numcols=original[0].split("\t").length;
		double[][] array = new double[numrows][numcols];

		for(int i=1;i<numrows;i++){
			for(int j=1;j<numcols;j++)
			{
				array[i][j]=Double.parseDouble(original[i].split("\t")[j]);
			}
		}
	}
}