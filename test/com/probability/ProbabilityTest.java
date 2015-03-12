package com.probability;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ProbabilityTest {
    @Test
    public void createGivesNullForWrongInput() {
        Probability p = Probability.create(3,5);
        assertNull(p);
    }

    @Test
    public void createShouldCreatesValidProbabilityWithValidInput() {
        Probability p = Probability.create(5,3);
        assertNotNull(p);
    }

    @Test
    public void createShouldCreatesValidProbability1WithValidInput1And1() {
        Probability p = Probability.create(1,1);
        assertEquals(p.getValue(), 1, 0.0);
    }

    @Test
    public void createShouldCreatesValidProbabilityPoint5WithValidInput2And1() {
        Probability p = Probability.create(2,1);
        assertEquals(p.getValue(), 0.5, 0.0);
    }

    @Test
    public void andWIllgiveANDOfTwoProbalities() {
        Probability p1 = Probability.create(2,1);
        Probability p2 = Probability.create(2,1);
        Probability expected = p1.and(p2);
        assertEquals(expected.getValue(),0.25,0.01);
    }

    @Test
    public void andWIllgiveANDOfTwoProbalitiesFor2_1And4_1() {
        Probability p1 = Probability.create(2,1);
        Probability p2 = Probability.create(4,1);
        Probability expected = p1.and(p2);
        assertEquals(expected.getValue(), 0.125, 0.01);
    }

    @Test
    public void complimentOfProbability_1_ShouldGiveZero() {
        Probability p = Probability.create(1,1);
        assertEquals((p.compliment()).getValue(), 0.0, 0.01);
    }

    @Test
    public void complimentOfProbability_0_ShouldGive_1() {
        Probability p = Probability.create(1,0);
        assertEquals((p.compliment()).getValue(), 1.0, 0.01);
    }

    @Test
    public void complimentShouldNegateProbability() {
        Probability p = Probability.create(2,1);
        assertEquals((p.compliment()).getValue(), 0.5, 0.01);
    }

    @Test
    public void ORWIllgiveCombineProbabilityOfTwoProbalities() {
        Probability p1 = Probability.create(2,1);
        Probability p2 = Probability.create(2,1);
        Probability expected = p1.or(p2);
        assertEquals(expected.getValue(), 0.75, 0.01);
    }

    @Test
    public void ORWIllgiveCombinedProbabilityOfTwoProbalities2_1_and_4_1() {
        Probability p1 = Probability.create(2,1);
        Probability p2 = Probability.create(4,1);
        Probability expected = p1.or(p2);
        assertEquals(expected.getValue(), 0.62, 0.01);
    }

}
