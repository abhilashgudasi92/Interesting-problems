
public class mergeSort {
	public static void main(String[] args){
		mergeSort m = new mergeSort();
		selectionSortArray s = new selectionSortArray();
		int arr[] = { 8,4,5,7,3,9,2,1};
		s.printArray(arr);
		m.MS(arr, 0, arr.length-1);
		s.printArray(arr);
	}
	
	void MS(int[] arr, int start, int last){
		if(start < last){
			int middle = start +((last - start)/2);
			MS(arr,start,middle);
			MS(arr,middle+1,last);
			merge(arr,start,middle,last);
		}
	}
	
	void merge(int[] arr,int start,int middle,int last){
		int[] temp = new int[arr.length];
		for(int i = start;i <= last;i++){
			temp[i] = arr[i];
		}
		int a = start;
		int b = middle+1;
		int k = start;
		
		while(a<= middle && b<= last){
			if(temp[a] <= temp[b]){
				arr[k] = temp[a];
				a++;
			}
			else{
				arr[k] = temp[b];
				b++;
			}
			k++;
		}
		while(a <= middle){
			arr[k] = temp[a];
			a++;k++;
		}
	}
}
