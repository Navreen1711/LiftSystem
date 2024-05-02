package LiftManagement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LiftSystem {
	
	static Scanner s= new Scanner(System.in);
	
	public static void main(String[] args) {	
		System.out.println("No Of Lift => 5\nL1 & L2 => will stop at floor (0 to 5)"
				+ "\nL3 & L4 => will stop at floor (0,6,7,8,9,10)\nL5 => will stop at all floors (0 to 10)");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		while (true) {
			System.out.println("Enter 1 -> Continue and 2 -> Exit ");
			System.out.println("Enter Choice:");
			int choice = s.nextInt();
			
			switch (choice) {
				case 1:
					System.out.println("Enter no of people:");
					int npeople=s.nextInt();
					
					if(npeople<=10) {
						liftPosition();
					}
					else {
						System.out.println("Number of people capable to travel only 10 ");
					}
					break;
				case 0:
					System.out.println("Thank you for using");
					return;
				default:
					System.out.println("Enter correct  choice");
			}
		}

	}
	public static void liftPosition() {
		
		System.out.println("Current Floor:");
		int curr=s.nextInt();
		System.out.println("Destination Floor:");
		int des=s.nextInt();
		
		int sum=0;
		
		String L[]= {"L1","L2","L3","L4","L5"};
		int liftposition[]= {0,0,0,0,0};
		
		System.out.println("Lift: "+Arrays.toString(L));
		System.out.println("Floor: "+Arrays.toString(liftposition));
		
		System.out.println("\nOutput: "+AssignLift(curr,des, liftposition)+" is assigned");
		System.out.println("Lift: "+Arrays.toString(L));
		System.out.println("Floor: "+Arrays.toString(liftposition));
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
	}
	
	public static String AssignLift(int curr,int des, int[] liftposition) {
		
		int arr[][]={{0,1,2,3,4,5},
				{0,1,2,3,4,5},
				{0,6,7,8,9,10},
				{0,6,7,8,9,10},
				{0,1,2,3,4,5,6,7,8,9,10}};
		
		String LT[]= {"L1","L2","L3","L4","L5"};
		int k=0;
		
		boolean re=false;
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=0;j<arr[i].length;j++) {
				
				if(curr==liftposition[i] || (Math.abs(curr-liftposition[i]))<=3) {
					if(des==arr[i][j]) {
						k=i;
						re=true;
						break;
					}
				}
			}
			if(re) {
				break;
			}
		}
		liftposition[k]=des;
		return LT[k];
	}

}
