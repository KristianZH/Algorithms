import java.util.Stack;

public class HanoiTower {

	public static void main(String[] args) {
		Stack<Integer> source= new Stack<>();
		source.push(3);
		source.push(2);
		source.push(1);
		Stack<Integer> spare= new Stack<>();
		Stack<Integer> destination= new Stack<>();
		Move(3,source,destination,spare);
		System.out.println(destination);
	}
	
	
	private static void  Move(int disk,Stack<Integer> source, 
			Stack<Integer> destination, Stack<Integer> spare){		 
		if(disk<1){
			return;
		}
		//Move all up disks to spare
		Move(disk-1,source,spare,destination);
		//Move current disk to destination
		destination.push(disk);
		source.pop();
		//Move all disks from spare to destination
		Move(disk-1,spare,destination,source);
	}

}
