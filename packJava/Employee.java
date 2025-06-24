package packJava;

public class Employee{
	String name="pradeep";
	int id=1;
	int salary = 100000000;
	void display() {
		System.out.println(name+" "+id+" "+salary);
	}
	public static void main(String[] data) {
		Employee ep= new Employee();
		ep.display();
	}

}
