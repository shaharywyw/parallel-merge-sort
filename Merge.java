import java.util.ArrayList;

public class Merge extends Thread 
{
	private MergeSort mergeSort;
	
	public Merge(MergeSort mergeSort) 
	{
		this.mergeSort=mergeSort;
	}
	
	public void run()
	{
		super.run();
		
		ArrayList<ArrayList<Integer>> twoArrays;
		while((twoArrays=mergeSort.getArray())!=null)
		{
			ArrayList<Integer> abMerged=new ArrayList<Integer>();
			ArrayList<Integer> b=new ArrayList<Integer>(twoArrays.get(0));
			ArrayList<Integer> a=new ArrayList<Integer>(twoArrays.get(1));
			int i=0,j=0;
			
			while(i<a.size() && j<b.size())
			{
				if(a.get(i)<=b.get(j))
				{
					abMerged.add(a.get(i));
					i++;
				}
				else
				{
					abMerged.add(b.get(j));
					j++;
				}
			}
			while (i < a.size()) 
			{
				abMerged.add(a.get(i));
	            i++;
	        }
	    	while (j < b.size()) 
		    {
			  abMerged.add(b.get(j));
		      j++;
		    }
	    	
			mergeSort.putArray(abMerged);
		}
	}
}
