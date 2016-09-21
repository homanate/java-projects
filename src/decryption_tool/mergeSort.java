package Lab5;

public class mergeSort{

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