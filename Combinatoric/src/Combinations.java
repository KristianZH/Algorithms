import java.util.Arrays;

public class Combinations {

	public static void main(String[] args) {
		int k=3;
		int n=5;
		int[] arr=new int[k];
		Comb(0,0,k,n,arr);

	}
	
	private static void Comb(int index,int start, int k, int n, int[]arr){
		if(index>=k){
			System.out.println(Arrays.toString(arr));
		}
		else{
			for (int i = start; i < n; i++) {
				arr[index]=i;
				Comb(index+1,i+1,k,n,arr);
			}
		}
	}

}
