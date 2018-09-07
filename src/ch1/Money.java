package ch1;

public class Money extends Expression{
    public double amount = 0;
    public String currency;

    public Money(double amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(double amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(double amount){
        return new Money(amount, "CHF");
    }

    public Expression times(double multiplier) {
        return new Money(multiplier * amount, currency);
    }

    @Override
    public Money reduce(Bank bank, String to){
        double rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }

    @Override
    public boolean equals(Object object){
        Money money = ((Money) object);
        return money.amount == amount
                && money.currency.equals(currency);
    }
}
