package ch1;

public abstract class Expression {

    abstract public Money reduce(Bank bank, String to);
    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }
    abstract public Expression times(double multiplier);
}
