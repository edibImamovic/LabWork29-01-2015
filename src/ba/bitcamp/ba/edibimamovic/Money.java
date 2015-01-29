package ba.bitcamp.ba.edibimamovic;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Scanner;

public class Money {

	private BigDecimal value;
	private Currency currency;
	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public static Money parse (String moneyString){
		Scanner s = new Scanner(moneyString);
		String valueString =s.next();
		String currencyString = s.next();
		s.close();
		BigDecimal value = new BigDecimal(valueString);
		Currency currency = Currency.getInstance(currencyString);
		return new Money(value, currency);
	}
	/**
	 * @param value
	 * @param currency
	 */
	public Money(BigDecimal value, Currency currency) {
		super();
		this.value = value;
		this.currency = currency;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %s", value, currency);
	}
	
}
