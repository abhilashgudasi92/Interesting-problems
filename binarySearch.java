public class binarySearch{ 
	public static void main(String[] args){
		binarySearch b = new binarySearch();
		selectionSortArray s = new selectionSortArray();
		int value = 1;
		int arr[] = {2,4,5,6,8,9,10,50};
		System.out.print("Array:");
		s.printArray(arr);
		System.out.println("Element: "+value+" present at: " + (b.BS(arr,0,arr.length-1,value)+1));
	}
	
	int BS(int[] arr,int start, int last,int value){
		if(last >= start){
			int mid = start + (last - start)/2;
			if(arr[mid] == value)
				return mid;
			else if(arr[mid] > value){
				return BS(arr,start,mid-1,value);
			}
			else
				return BS(arr,mid+1,last,value);
		}
		return -2;
	}
}
