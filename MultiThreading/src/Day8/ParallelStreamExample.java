package Day8;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {

	public static void main(String[] args) {

		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("Sequential stream");

		listOfNumbers.stream().map(n -> n * n).forEach(System.out::println);

		System.out.println("Parallel stream");

		listOfNumbers.parallelStream().map(n -> n * n).forEach(System.out::println);

		
	}

}
