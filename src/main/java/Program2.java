import java.util.function.Consumer;

public class Program2 {

	public static void main(String[] args) {

		Consumer s = a -> System.out.println(a);
		Integer[] intArray = { 10, 20, 30, 40, 50 };
		Double[] doubleArray = { 11.11, 21.2, 32.3, 43.4 };
		Character[] charArray = { 'T', 'E', 'S', 'T'};	
		
		print(intArray);
		print(doubleArray);
		print(charArray);
	}

	public static <T> void print(T[] tArray){

		System.out.println("Print Started...");
		for(T t : tArray){
			System.out.println(t);
		}
		System.out.println("Print Ended...");
		System.out.println("");
		
	}
}
