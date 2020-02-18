import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordFreqCount {

	public static void main(String[] args) {

		Map<String,Integer> map=new HashMap<>();
		File file=new File("Book.txt"); 
		try {
			Scanner sc=new Scanner(file);
			while(sc.hasNext()) {
				String data=sc.next();
		        data= data.replaceAll("[^a-zA-Z]+", "");
				if(map.containsKey(data)) {
					map.replace(data, map.get(data)+1);
				}else {
					map.put(data,1);
				}
			}


		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		List<Map.Entry<String,Integer>> list=sortByValue(map);

		System.out.println("Top 20 Least Appeared Words:");
		for (int i = 1; i <=  20; i++) {
			System.out.println(String.format("(%d): ",i)+list.get(i).getValue()+" --> "+list.get(i).getKey());
		}



		System.out.println("\n\n");
		System.out.println("Top 20 Most Appeared Words:");
		for (int i = 1,j=list.size(); i <=20; i++) {
			System.out.println(String.format("(%d): ",i)+list.get(j-i).getValue()+" --> "+list.get(j-i).getKey());
		}
	}	

	public static List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map){
		List<Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue().compareTo( o2.getValue()));
			}
		});
		return list;
	}

}










