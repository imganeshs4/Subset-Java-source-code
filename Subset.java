import java.util.*;
import java.io.*;
import java.lang.*;

public class Subset
{
  static int set[];
  static int selected[];
  static int sum;
  static int count;
 
  public static void subset(int WtSoFar,int k,int RemainingWt )
  {
    selected[k]=1;
    
    if(WtSoFar+set[k]==sum)
     {
       System.out.printf("\nSubset Solution%d : ",++count);
       for(int i=0;i<=k;i++)
       {
          if(selected[i]==1)
            System.out.print("\t"+set[i]);
       }
       System.out.println();
       return;
     }

    if(WtSoFar+set[k]+set[k+1]<=sum)
     {
        subset(WtSoFar+set[k],k+1,RemainingWt-set[k]);
     }

    if((WtSoFar+set[k+1]<=sum) && (WtSoFar+RemainingWt-set[k]>=sum))
     {
        selected[k]=0;
        subset(WtSoFar,k+1,RemainingWt-set[k]);
     }
  } 

  
  public static void main(String args[])
  {

   Scanner in=new Scanner(System.in);
   System.out.println("Enter the number of elements in a Subset : ");
   int n=in.nextInt();
   
   set=new int[n+1];
   selected=new int[n+1];

   System.out.println("Enter the Subset elements : ");
   for(int i=0;i<n;i++)
    set[i]=in.nextInt();

   int total=0;
   count=0;

   for(int i=0;i<n;i++)
     total=total+set[i];
   
   System.out.println("Enter the Sum wanted from the Subset : ");
   sum=in.nextInt();

   if(sum>total)
    System.out.println("No solution exists");

   subset(0,0,total);

   if(count==0)
    System.out.println("No solution exists");    
    
  }

}
