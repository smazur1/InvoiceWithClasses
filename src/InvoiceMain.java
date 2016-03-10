
import java.util.Scanner;

public class InvoiceMain {



	public static void main(String[] args) {
		// TODO Auto-generated method stub


		double taxRatePercent = 0.0;
		double taxRate = 0.0;
		double price =0.0;
		double tax = 0.0;
		double printPrice = 0.0;
		double subTotal = 0.0;
		double grandTotal = 0.0;
		String taxable = "";
		boolean isTaxable = false;


		LineItem[] items = new LineItem[100];

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter Tax Rate : (%)");
		taxRatePercent = keyboard.nextDouble();
		taxRate = taxRatePercent / 100;

		System.out.println("Is Item 1 taxable? (y) or (n) ");
		taxable = keyboard.next();
		if (taxable.equalsIgnoreCase("y")) {
			isTaxable = true;
		}

		System.out.println("Price Item # 1 : ");
		price = keyboard.nextDouble();

		int i = 0;

		while (price != 0.0)  {


			try {

				LineItem item = new LineItem(taxRate);
				item.setItem(taxRate, price, isTaxable);
				items[i] = item;


				i ++;


				System.out.println("Is Item " + (i + 1) + " taxable? (y) or (n) ");
				taxable = keyboard.next();
				if (taxable.equalsIgnoreCase("y")) {
					isTaxable = true;
				} else {
					isTaxable = false;
				}

				System.out.println("Price # " + (i + 1) + " : ");
				price = keyboard.nextDouble();


			} catch (Exception e) {

				System.out.println("Exception occurred " + e);

			}

		} // End While

		keyboard.close();



		System.out.println();
		System.out.println("------------------------------------------\n");
		System.out.println("Receipt");


		if (items[0].getPrice()  != 0.0 ) {

			for (int j = 0; j < i; j++) {

				printPrice = items[j].getPrice();
				subTotal = subTotal + items[j].getPrice();
				tax = tax + items[j].getTax();

				System.out.printf("$%.2f%n" , printPrice);


			}  // End For
		}  // End If

		System.out.printf("$%.2f  SubTotal\n" , subTotal);
		System.out.printf("$%.2f  Tax\n" , tax );
		grandTotal = subTotal + tax;
		System.out.printf("$%.2f  Grand Total", grandTotal );


	}  // End main
}

