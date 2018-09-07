package ch1;

public class Sum extends Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend ) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String to){
        double amount = augend.reduce(bank, to).amount
                + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression times(double multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
