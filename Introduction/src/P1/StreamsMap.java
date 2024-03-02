package P1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamsMap {

	public static void main(String[] args) {
		// Print names which ends with h in upper case
		// For Manipulating we use Map which can map orignal stram in to expected manipulation
	Stream.of("Abhai", "Ajay", "Abhih", "Ram", "Rakesh", "Ashsks").filter(s->s.endsWith("h")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	// Printing Letters start with A in Upper case and sorted
	String[] names = {"Rahul", "Shyan", "Aanahay" ,"Ahagsjwy", "jsdisdmsk", "Adama"};
	List<String> name = Arrays.asList(names);
	name.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
	List<String> nam = Arrays.asList("Abhai", "Ajay", "Abhih", "Ram", "Rakesh", "Ashsks");
	// Merging two list and sorting(we will use .con cat
	Stream<String> newStream= Stream.concat(name.stream(), nam.stream());
	// After merging we will sort and print
	newStream.sorted().forEach(s->System.out.println(s));
	// To check whether list contains particular name or not
	Boolean flag =name.stream().anyMatch(s->s.equalsIgnoreCase("Rahul"));
	System.out.println(flag);
	Assert.assertTrue(flag);
	
	// Converting Stream to list
	
	List<String> newNam= Stream.of("Abhai", "Ajay", "Abhih", "Ram", "Rakesh", "Ashsks").filter(s->s.endsWith("h")).map(s->s.toUpperCase())
	.collect(Collectors.toList());
	System.out.println(newNam.get(1));
	
	List<Integer> numbers = Arrays.asList(3,2,4,5,43,543,22,3,4,22,43,22);
	// Print Unique numbers from this array
	numbers.stream().distinct().forEach(s->System.out.println(s));
	// Sort this array
	numbers.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(numbers.get(0));
	
		
		
		

	}

}
