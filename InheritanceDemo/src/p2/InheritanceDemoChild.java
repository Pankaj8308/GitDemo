package p2;

import org.testng.annotations.Test;

public class InheritanceDemoChild extends InheritanceDemoParent{
	@Test
	public void testRun()
	{
		int a=3;
		// We passed parameter while creating object hence we will need to create cosntructor
		InheritanceConstructorDemo inc = new InheritanceConstructorDemo(a);
		System.out.println(inc.increment());
		System.out.println(inc.decrement());
		// Constructordemo2 mul = new Constructordemo2(a);
		// we used object created for parent class InheritanceDemoParent to call method of Constructordemo2 which is inheritrd by InheritanceDemoParent
		System.out.println(inc.multiByTwo());
		System.out.println(inc.multiByThree());
		doThis();
		

	}

}
