package twenty;

public class EvenGenerator extends IntGenerator {

	private  int value = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EvenChecker.test(new EvenGenerator(), 10);
	}

	@Override
	public int next() {
		// TODO Auto-generated method stub
		value++;
		Thread.yield();
		value++;
		return value;
	}

}
