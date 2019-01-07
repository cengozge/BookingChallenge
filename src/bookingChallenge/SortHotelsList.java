package bookingChallenge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SortHotelsList {
	//sample inputs
	//breakfast beach citycenter location metro view staff price
	//5
	//1 
	//This hotel has a nice view of the citycenter. The location is perfect.
	//2
	//The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
	//1
	//Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
	//1
	//They said I couldn't take my dog and there wew other guests with dogs! That is not fair.
	//2
	//Very friendly staff and good cost-benefit ratio.Its location is a bit far from citycenter.

	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the words splitting with a blank: ");
			String words = bf.readLine();
			System.out.println("Enter the # of reviews: ");
			String numOfReviews = bf.readLine();
			System.out.println("Enter the hotel id first, and enter, then enter your sentence about hotel: ");

			Map<Integer,Integer> mapOfIdsAndCounts = new HashMap<Integer,Integer>();
			
			for (int i = 0; i < Integer.valueOf(numOfReviews); i++) {
				Integer number = 0;
				try{
					number = Integer.valueOf(bf.readLine());
				}
				catch(NumberFormatException e)
				{
					throw new NumberFormatException("Please enter a numeric value");
				}
				StringBuilder newSentence = new StringBuilder(bf.readLine());
				List<String> newSentenceAsList = Arrays.asList(newSentence.toString().replace(",", " ").replace(".", " ").split(" "));

				List<String> wordsArray = Arrays.asList(words.split(" "));
				for (String s : wordsArray) {
					int count = (int) newSentenceAsList.stream().filter(p->p.equalsIgnoreCase(s)).count();
					if(mapOfIdsAndCounts.get(number) != null){
						mapOfIdsAndCounts.put(number, mapOfIdsAndCounts.get(number) + count);
					}
					else{
						mapOfIdsAndCounts.put(number, count);
					}
				}
			}
			System.out.println("finished: " + mapOfIdsAndCounts);
			Map<Integer, Integer> sortedMap = 
					mapOfIdsAndCounts.entrySet().stream()
				    .sorted(Map.Entry.comparingByValue())
				    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				                              (e1,e2)->e1, LinkedHashMap::new));
			
			System.out.print(sortedMap.keySet());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
