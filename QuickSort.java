
public class QuickSort {
	static selectionSortArray s = new selectionSortArray();
	public static void main(String[] args){
		QuickSort q = new QuickSort();
		int arr[] = { 8,4,5,7,3,9,2,1};
		s. printArray(arr);
		q.QS(arr, 0, arr.length-1);
		s.printArray(arr);
	}
	
	void QS(int[] arr, int start, int last){
		if(start<last){
			int pivot;
			pivot = partition(arr,start,last);
			QS(arr,start,pivot-1);
			QS(arr,pivot+1,last);
		}
	}
	
	int partition(int[] arr, int start, int last){
		int pivot = arr[last];
		int i = start - 1;
		
		for(int j= start;j<=last-1;j++){
			if(arr[j] <= pivot){
				i++;
				s.swap(arr,i,j);
			}	
		}
		s.swap(arr,i+1,last);
		return i+1;
	}
}
