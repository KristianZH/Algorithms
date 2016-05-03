import java.util.ArrayList;

public class KnapsackProblem {

	public static void main(String[] args) {
		Item[] items=new Item[]{
		new Item(5, 30),
		new Item(8, 120),
		new Item(7, 10),
		new Item(0, 20),
		new Item(4, 50),
		new Item(5, 80),
		new Item(2, 10)
		};
		int knapsackCapacity=100;
		System.out.println(FillKnapsack(items,knapsackCapacity));

	}
	
	public static String FillKnapsack(Item[] items, int capacity){
		int[][] maxPrices=new int[items.length][capacity+1];
		boolean[][] isTaken= new boolean[items.length][capacity+1];
		for (int c = 0; c <= capacity; c++) {
			if(items[0].Weight<=c){
				maxPrices[0][c]=items[0].Price;
				isTaken[0][c]=true;
			}
		}
		for (int i = 1; i < maxPrices.length; i++) {
			for (int c = 0; c <= maxPrices.length; c++) {
				//dont take the Item
				maxPrices[i][c]=maxPrices[i-1][c];
				int remainingCapacity = c-items[i].Weight;
				if(remainingCapacity>=0
						&& items[i].Price+ maxPrices[i-1][remainingCapacity]>maxPrices[i-1][c]){
					maxPrices[i][c]=items[i].Price+maxPrices[i-1][remainingCapacity];
					isTaken[i][c]=true;
			
				}
			}
			
		}
		int index=items.length-1;
		ArrayList<String> itemsTaken= new ArrayList<>();
		while(index>=0){
			if(isTaken[index][capacity]){
				itemsTaken.add(items[index].Weight+","+ items[index].Price);
				capacity-=items[index].Weight;
			}
			index--;
		}
		return itemsTaken.toString();
	}

}
