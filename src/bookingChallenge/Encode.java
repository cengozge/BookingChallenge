package bookingChallenge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Encode {

	// input : 25626 25757 24367 24267 16 100 2 7277
	/**
	 * first one is written as it is. after, each subsequence number difference from the element before it.
	 * if difference -127 <= diff <= 127 not passed, put -128 before writing the difference, 
	 * write -128 and after write difference*/
	// output: [25626, -128, 131, -128, -1390, -100, -128, -24251, 84, -98, -128, 7275]
	public static void main(String[] args) {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the integer array: ");
			String array = bf.readLine();
			
			String[] inputArray = array.split(" ");
			List<String> list = Arrays.asList(inputArray);
			List<Integer> intList = new ArrayList<Integer>();
			List<Integer> newIntList = new ArrayList<Integer>();
			
			for (String s : list) {
				intList.add(Integer.valueOf(s));
			}
			
			for (int i = 0; i < intList.size(); i++) {
				int add = intList.get(i);
				
				if(i == 0){
					newIntList.add(intList.get(0));
				}
				else{
					int addAfter = intList.get(i-1);
					int diff = add - addAfter;
					if(diff < -128 || diff > 127 ){
						newIntList.add(-128);
						newIntList.add(diff);
					}
					else{
						newIntList.add(diff);
					}
				}
			}
			
			System.out.println(newIntList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
