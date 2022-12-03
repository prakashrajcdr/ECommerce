import java.util.*;


public class Program3 {

	public static void main(String[] args) {
		
		List list = Arrays.asList("Kolkatha", "Chennai", "Trichy", "Madurai", "Mumbai", "London");
		
		Collections.sort(list);
		
		System.out.println("Sorted cities are "+list);
		
		System.out.println("\nSorted using stream : \n");

		list.stream().sorted().forEach(System.out::println);
	}
		
}
