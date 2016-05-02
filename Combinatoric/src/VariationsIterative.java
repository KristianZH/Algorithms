import java.util.Arrays;

public class VariationsIterative {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int[] arr = new int[k];
		// 0 0 0
		while (true) {
			System.out.println(Arrays.toString(arr));
			int index = k - 1;
			while (index >= 0 && arr[index] == n - 1) {
				index--;
			}
			// check when to stop
			if (index < 0) {
				break;
			}
			arr[index]++;
			// restart the 4 to 0
			for (int i = index + 1; i < k; i++) {
				arr[i] = 0;
			}
		}

	}

}
