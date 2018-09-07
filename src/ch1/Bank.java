package ch1;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public void addRate(String from, String to, double rate) {
        rates.put(new Pair(from, to), rate);
    }

    public Money reduce (Expression source, String to){
        return source.reduce(this, to);
    }

    public double rate(String from, String to) {
        if (from.equals(to)) return 1;
        Double rate = (Double) rates.get(new Pair(from, to));
        return rate;
    }

    private class Pair {
        private String from;
        private String to;

        Pair(String from, String to ){
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
