import java.util.Arrays;
import java.util.Random;

public class Shuffling {

	public static void main(String[] args) {
		Integer[] array=new Integer[]{1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(Shuffle(array)));

	}
	
	
	public static <T extends Number> T[] Shuffle (T[] source){
		Random rnd= new Random();
		int n= source.length;
		for (int i = 0; i < n; i++) {
			int r=i+rnd.nextInt(n-i);
			T temp= source[i];
			source[i]=source[r];
			source[r]=temp;
		}
		return source;
		
	}

}
