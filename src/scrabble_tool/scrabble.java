package Lab4;

import java.util.*;
public class scrabble
{
    public static String [] words; 
    public static void main(String[] args)
    {
        FileIO reader = new FileIO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your letters: "); // prompt input from user
        String s1 = sc.nextLine(), s2="", s3="", s4="";
        int count = 0, w = 0;

        words = reader.load("/home/ian/dictionary.txt"); // Reading the File as a String array
        String [] found= new String[words.length];

        mergeSort(words); // Sort the array from biggest to smallest
        //System.out.println(words.length); // output length of the array
        sc.close();

        for(int i=0; i<words.length; i++)
        {
            s2=words[i];
            s3=s2;
            s4=s1;

            if(s2.length()-1>s1.length())
            {
                i++;
            }
                else
                {
                    for(int j=0; j<s2.length(); j++)
                    {
                        for(int k=0; k<s1.length(); k++)
                        {
                            if(s4.charAt(k)==s2.charAt(j))
                            {
                                char [] s2words = s2.toCharArray();
                                s2words[j]='*';
                                s2=String.valueOf(s2words);

                                char [] s4words = s4.toCharArray();
                                s4words[k]='-';
                                s4=String.valueOf(s4words);
                                count=0;

                                for(int n=0; n<s2.length(); n++)
                                {
                                    if(s2.charAt(n)=='*')
                                    {
                                        count++;

                                        if(count==s2.length()-1)
                                        {
                                            found[w]=s3;
                                            w++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        
        System.out.println("Here are the top 10 suggestions: ");
        
        for(int i=0;i<10;i++)
        {
            if(found[i]!=null)
            {
                System.out.println(found[i]);
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