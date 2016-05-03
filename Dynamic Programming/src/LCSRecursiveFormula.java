import java.util.ArrayList;

public class LCSRecursiveFormula {
	static String firstStr="xabcxxxx";
	static String secondStr="abcxxyxabcx";
	static int[][] lcs= new int[firstStr.length()][secondStr.length()];

	public static void main(String[] args) {
		InitializeLCS();
		CalcLCS(firstStr.length()-1,secondStr.length()-1);
		int[][] memo= new int[firstStr.length()+1][secondStr.length()+1];
		for (int first = 1; first < memo.length; first++) {
			for (int second = 1; second < memo[1].length; second++) {
				if(firstStr.charAt(first-1)==secondStr.charAt(second-1)){
					memo[first][second]=memo[first-1][second-1]+1;
				}
				else{
					memo[first][second]=Math.max(memo[first-1][second], memo[first][second-1]);
				}
			}
		}
		PrintLCS(firstStr.length()-1,secondStr.length()-1);

	}
	
	private static String PrintLCS(int x, int y){
		ArrayList<Character> lcsLetters=new ArrayList<>();
		while(x>=0&&y>=0){
			if((firstStr.charAt(x)==secondStr.charAt(y))
					&&CalcLCS(x-1,y-1)+1==lcs[x][y]){
						lcsLetters.add(firstStr.charAt(x));
						x--;
						y--;
					}
			else if(CalcLCS(x-1,y)==lcs[x][y]){
				x--;
			}
			else{
				y--;
			}
		}
		return lcsLetters.toString();	
		}

	private static int CalcLCS(int x, int y) {
		if(x<0 || y<0){
			return 0;
		}
		if(lcs[x][y]==-1){
			int lcsFirstMinusOne = CalcLCS(x-1,y);
			int lcsSecondMinusOne=CalcLCS(x,y-1);
			lcs[x][y]=Math.max(lcsFirstMinusOne, lcsSecondMinusOne);
			if(firstStr.charAt(x)==secondStr.charAt(y)){
				int lcsBothMinusOne=1+CalcLCS(x-1,y-1);
				lcs[x][y]=Math.max(lcs[x][y], lcsBothMinusOne);
			}
		}
		return lcs[x][y];
	}
	
	private static void InitializeLCS(){
		for (int x = 0; x < firstStr.length(); x++) {
			for (int y = 0; y < secondStr.length(); y++) {
				lcs[x][y]=-1;
			}
			
		}
	}

}
