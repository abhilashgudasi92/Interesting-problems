
public class selectionSortArray {

	public static void main(String[] args){
		int arr[] = {1,5,2,4,6,7,6};
		selectionSortArray s = new selectionSortArray();
		System.out.println("Before sort:");
		s.printArray(arr);
		s.selection(arr);
		System.out.println("After sort:");
		s.printArray(arr);
	}
	
	void printArray(int[] arr){
		for(int i = 0;i < arr.length; i++){
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
	private void selection(int[] arr){
		int n = arr.length;
		int min;
		for(int i = 0; i < n; i++){
			min = i;
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[min])
					min = j;
			}
			swap(arr,i,min);
		}
	}
	
	void swap(int[] arr,int i,int min){
		int temp;
		temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
}
