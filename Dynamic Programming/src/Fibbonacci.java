
public class Fibbonacci {

	public static void main(String[] args) {
		int number=7;
		System.out.println(Fibonacci(number));

	}
	
	private static long Fibonacci(int n){
		long[] fib = new long[n+1];
		fib[0]=0;
		fib[1]=1;
		for (int i = 2; i <=n; i++) {
			fib[i]=fib[i-1] + fib[i-2];
		}
		return fib[n];
	}

}
