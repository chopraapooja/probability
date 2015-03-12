package com.probability;

public class Probability {
    private final int total;
    private final int favourable;
    private double value;

    private Probability(int totalOutcomes,int favourableOutcomes) {
        this.total = totalOutcomes;
        this.favourable = favourableOutcomes;
        this.value = ((double)favourableOutcomes)/totalOutcomes;
    }

    public static Probability create(int totalOutcomes, int favourableOutcomes) {
        if(totalOutcomes<0 || favourableOutcomes<0 || totalOutcomes<favourableOutcomes)
            return null;
        return new Probability(totalOutcomes, favourableOutcomes);
    }

    public double getValue() {
        return value;
    }

    public Probability and(Probability p) {
        return new Probability(this.total*p.total,this.favourable*p.favourable);
    }

    public Probability compliment() {
        return new Probability(this.total, this.total-this.favourable);
    }

    public Probability or(Probability p) {
        return ((this.compliment()).and(p.compliment())).compliment();
    }

}
