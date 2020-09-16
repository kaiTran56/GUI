package prac.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestConvertHashMapToList {
	public static void main(String[] args) {
		TestConvertHashMapToList list = new TestConvertHashMapToList();
		Map<Integer, String> hashName = new HashMap<Integer, String>();
		String[] name = { "Q", " K ", " H ", " K ", " T " };
		for (int i = 0; i < 5; i++) {
			hashName.put(i, name[i]);
		}
		System.out.println("Show the HashMap: ");
		list.printf(hashName);
		System.out.println("------------------------");
		Set<Integer> setNumber = hashName.keySet();
		List<Integer> listNumber = new ArrayList<Integer>(setNumber);
		System.out.println("Show the ListNumber: ");
		list.printf(listNumber);
		System.out.println("--------------------------");
		Collection<String> collectName = hashName.values();
		List<String> listName = new ArrayList<String>(collectName);
		System.out.println("Show the list Name: ");
		list.printf(listName);
		System.out.println("---------------------------");
		Set<Entry<Integer, String>> setHashName = hashName.entrySet();
		List<Entry<Integer, String>> listHashMap = new ArrayList<Entry<Integer, String>>(setHashName);
		System.out.println("Show the number and Name by List: ");
		list.printf(listHashMap);
	}

	public <T> void printf(T t) {
		System.out.println(t.toString());
	}

}
