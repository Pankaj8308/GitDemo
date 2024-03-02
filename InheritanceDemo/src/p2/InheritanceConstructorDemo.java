package p2;

public class InheritanceConstructorDemo extends Constructordemo2 {
	int a;
public InheritanceConstructorDemo(int a) {
	// Super constructor
	super(a);
		this.a=a;
	}
public int increment()
{
	a=a+1;
	return a;
	}
public int decrement()
{
	a=a-1;
	return a;
	}

}
