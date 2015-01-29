package ba.bitcamp.ba.edibimamovic;

import java.util.Scanner;
import java.util.Currency;

public class CurrencyAa {

	private String currency;

	public static void main(String[] args) {

		System.out.println("Unesite valutu");
		Scanner sc = new Scanner(System.in);

		String currencyCode = sc.nextLine();
		Currency c = Currency.getInstance(currencyCode);

		System.out.printf("Name: %s\n", c.getDisplayName());
		System.out.printf("Name: %s\n" , c.getSymbol());

	}

}
