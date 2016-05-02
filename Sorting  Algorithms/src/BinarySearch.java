
public class BinarySearch {

	public static void main(String[] args) {
		int[] array= new int[]{2,4,5,7,8,12,23,41,53,72,85,97,103,123,223,723,912};
		System.out.println(binarySearch(array,41,0,array.length));

	}
	
	
	public static int binarySearch(int arr[], int key, int start,int end){
		if(end<start){
			return -1;
		}
		else{
			int mid= (start+end)/2;
			if(arr[mid]>key){
				return binarySearch(arr,key,start,mid-1);
			}
			else if(arr[mid]<key){
				return binarySearch(arr,key,mid+1,end);
			}
			else{
				return mid;
			}
				
				
		}
			
	}

}


