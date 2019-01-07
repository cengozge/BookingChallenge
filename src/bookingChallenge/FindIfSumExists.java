package bookingChallenge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;


public class FindIfSumExists {

	public static void main(String[] args) {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the integer array: ");
			String array = bf.readLine();
			System.out.println("Enter the length of the array: ");
			String size = bf.readLine();
			System.out.println("Enter the integer that you want to find if sum of any two integers equals it: ");
			String number = bf.readLine();
			
			String[] inputArray = array.split(" ");
			int sizeOfInputArray = Integer.parseInt(size);
			int numberToBeFindOfSum = Integer.parseInt(number);
			List<String> list = Arrays.asList(inputArray);
			List<Integer> intList = new ArrayList<Integer>();
			int exists = 0;
			
			for (String s : list) {
				int arrayElement = Integer.valueOf(s);
				intList.add(arrayElement);
				
				Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
				hashTable.put(arrayElement, arrayElement);
				
			}
			
			Collections.sort(intList);
			intList.removeIf(e-> e > numberToBeFindOfSum);
			
			for (int i = 0; i < intList.size(); i++) {
				if(intList.contains(numberToBeFindOfSum-intList.get(i)))
				{
					exists = 1;
					break;
				}
			}
			
			System.out.println(exists);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
