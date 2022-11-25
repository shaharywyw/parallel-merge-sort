import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		Scanner scan =new Scanner(System.in);
		int n,m;
		Random rnd = new Random();
		
		System.out.println("Enter the length of the array");
		n=scan.nextInt();
		System.out.println("Enter the number of threads");
		m=scan.nextInt();
		
		for(int i=0;i<n;i++) //generating the array
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.add(rnd.nextInt(100));
			arr.add(temp);
		}
		System.out.println("The array :\n"+arr+"\n");
		
		MergeSort mergeSort= new MergeSort(arr,m);
		
		System.out.println("The sorted array :\n"+mergeSort.get());
	}

}
