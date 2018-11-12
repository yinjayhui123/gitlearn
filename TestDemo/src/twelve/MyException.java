package twelve;

public class MyException extends Exception{

	String name ;
	public MyException(){
		
	}
	
	public MyException(String name){
		super(name);
		this.name = name;
	}
	
	public void show(){
		System.err.println("name="+ name);
	}
}
