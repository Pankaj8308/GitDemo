package P1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsFilter {

	public static void main(String[] args) {
		// Count the number of names starting with A with usual method
		List<String> names = new ArrayList<String>();
		names.add("Abj");
		names.add("Pankaj");
		names.add("Amit");
		names.add("Jini");
		names.add("Amar");
		names.add("Kanu");
		names.add("Abj");
		names.add("Pankaj");
		names.add("Amit");
		names.add("Jini");
		names.add("Amar");
		names.add("Awanu");

		int j = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).startsWith("A")) {
				j++;
			}
		}
		System.out.println(j);

		// Using streams for counting
		List<String> name = new ArrayList<String>();
		name.add("Absd");
		name.add("Pankaj");
		name.add("Amidt");
		name.add("Aini");
		name.add("Amaar");
		name.add("Aaednu");
		name.add("Abj");
		name.add("Pankaj");
		name.add("Amt");
		name.add("Jini");
		name.add("Amar");
		// Stream, -> Lamda Expression
		Long c = name.stream().filter(s -> s.startsWith("A")).count();
		// Note data type of count is always long
		System.out.println(c);
		// Creating stream of Names Note: Its an alternate way to practice streams
		System.out.println(Stream.of("Abhai", "Ajay", "Abhi", "Ram", "Rakesh").filter(n -> n.startsWith("A")).count());
		// Print all the name present in List with length more than 4 without using Loop
		name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		// Print all the names
		name.stream().forEach(s->System.out.print(s+" "));
		// .limit used to limit the result out put eg limit result of Names with lenghth less than 4 and we need only 3 results
		name.stream().filter(s->s.length()>2).limit(2).forEach(s->System.out.println(s));
	}
		
		

	

}
