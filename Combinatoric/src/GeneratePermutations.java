import java.util.Arrays;

public class GeneratePermutations {

	public static void main(String[] args) {
		arr = new String[] { "apple", "banana", "orange" };
		permutation = new String[arr.length];
		GeneratePermutationsBoolean(0);

	}

	static boolean[] used = new boolean[3];
	static String[] arr;
	static String[] permutation;

	private static void GeneratePermutationsBoolean(int index) {
		if (index == arr.length) {
			System.out.println(Arrays.toString(permutation));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!used[i]) {
					used[i] = true;
					permutation[index] = arr[i];
					GeneratePermutationsBoolean(index + 1);
					used[i] = false;
				}
			}
		}
	}

}
