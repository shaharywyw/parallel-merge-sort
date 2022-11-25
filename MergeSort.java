import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class MergeSort 
{

	private ArrayList<ArrayList<Integer>> arr;
	private int m;
	private int threads;
	private Merge [] merge;
	public MergeSort(ArrayList<ArrayList<Integer>> arr,int m)
	{
		this.arr=arr;
		this.m=m;
		threads=0;
		
		merge=new Merge[m];
		
		for(int i=0;i<m;i++)
			merge[i]=new Merge(this);
		
		for(int i=0;i<m;i++)
			merge[i].start();
		
		for(int i=0;i<m;i++)
			try {
				merge[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	public synchronized ArrayList<ArrayList<Integer>> getArray()
	{
		while(arr.size()==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(arr.size()>1)
		{
			threads++;
			
			ArrayList<Integer> subArr1=new ArrayList<Integer>(arr.get(0));
			arr.remove(0);
			ArrayList<Integer> subArr2=new ArrayList<Integer>(arr.get(0));
			arr.remove(0);
			
			ArrayList<ArrayList<Integer>> subArr=new ArrayList<ArrayList<Integer>>();
			subArr.add(subArr1);
			subArr.add(subArr2);
			
			return subArr;
		}
		
		if(threads==0) //work is done
			return null;
		
		return null; //for compilation only
	}
	
	public synchronized void putArray(ArrayList<Integer> subArr)
	{
		arr.add(subArr);
		threads--;
		notifyAll();
	}
	
	public synchronized ArrayList<Integer> get()
	{
		return arr.get(0);
	}
}
