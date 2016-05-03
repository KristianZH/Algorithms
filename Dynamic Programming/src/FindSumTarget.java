import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindSumTarget {

	public static void main(String[] args) {
		int[] nums=new int[]{3,3,1,3,5,0,2,4};
		int targetSum=7;
		System.out.println((CalcPossibleSums(nums,targetSum)));

	}
	
	private static ArrayList<Integer>
	CalcPossibleSums(int[] nums, int targetSum){
		//sum -> what we added to obtain the sum 
		HashMap<Integer,Integer> possibleSums=new HashMap<Integer,Integer>();
		possibleSums.put(0, 0);
		for (int i = 0; i < nums.length; i++) {
			int currentNum=nums[i];
			HashMap<Integer,Integer> newSums= new HashMap<Integer,Integer>();
			for (HashMap.Entry<Integer,Integer> possibleSum : possibleSums.entrySet()) {
				int newSum=possibleSum.getKey()+currentNum;
				newSums.put(newSum, currentNum);
				
			}
			
			for(HashMap.Entry<Integer,Integer> newSum : newSums.entrySet()){
				if(!possibleSums.containsKey(newSum.getKey())){
					possibleSums.put(newSum.getKey(), newSum.getValue());
					
				}
			}
		}
		
		// subset the numbers from hashmap
		
		ArrayList<Integer> subset = new ArrayList<>();
		while(targetSum>0){
			for (int i = 0; i < nums.length; i++) {
				int newSum=targetSum-nums[i];
				if(newSum>=0 && possibleSums.containsValue(newSum)){
					targetSum=newSum;
					subset.add(nums[i]);
				}
			}
		}
		return subset;
		
	}

}
