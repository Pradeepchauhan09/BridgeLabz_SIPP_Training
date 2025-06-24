package packJava;

public class Track {
	String itemCode= "h0fh8";
	String itemName="pens";
	int price = 10;
	void display(int quant) {
		System.out.println(itemCode+" : "+itemName+" : "+ price*quant);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Track invent =  new Track();
		invent.display(5);
	}

}
