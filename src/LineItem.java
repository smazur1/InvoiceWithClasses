

public class LineItem {

	private double price;
	private boolean isTaxable;
	private double tax;


	// Constructor	

	public LineItem(double _taxRate) {
		price = 0.0;
		isTaxable = false;
		tax = 0.0;
	}


	//  Setters

	public void setItem(double _taxRate, double _price, boolean _isTaxable) {

		price = _price;
		isTaxable = _isTaxable;
		if (isTaxable == true){
			tax = price * _taxRate;
		} else {
			tax = 0.0;
		}

	}

	// Getters

	public double getPrice() {

		return price;
	}


	public double getTax() {

		return tax;
	}

}
