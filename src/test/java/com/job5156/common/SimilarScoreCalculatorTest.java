package com.job5156.common;

import junit.framework.TestCase;

public class SimilarScoreCalculatorTest extends TestCase {
    SimilarScoreCalculator similarScoreCalculator = new SimilarScoreCalculator();

    public void testCalculateScore() throws Exception {
        assertCaculate(1, 2000, 0);
        assertCaculate(8, 2000, 0);
        assertCaculate(10, 2000, 1);
        assertCaculate(20, 2000, 1);
        assertCaculate(50, 2000, 3);
        assertCaculate(77, 2000, 4);
        assertCaculate(100, 2000, 5);
        assertCaculate(177, 2000, 9);
        assertCaculate(200, 2000, 10);
        assertCaculate(400, 2000, 20);
        assertCaculate(1000, 2000, 50);
        assertCaculate(1999, 2000, 100);

        assertCaculate(1, 1, 10);
        assertCaculate(5, 5, 28);
        assertCaculate(10, 10, 50);
        assertCaculate(30, 30, 60);
        assertCaculate(50, 50, 70);
        assertCaculate(75, 75, 78);
        assertCaculate(100, 100, 85);
        assertCaculate(150, 150, 90);
        assertCaculate(200, 200, 95);
        assertCaculate(600, 600, 98);
        assertCaculate(1000, 1000, 100);
        assertCaculate(2000, 2000, 100);

        assertCaculate(10, 10, 50);
        assertCaculate(10, 30, 20);
        assertCaculate(10, 50, 14);
        assertCaculate(10, 75, 10);
        assertCaculate(10, 100, 9);
        assertCaculate(10, 150, 6);
        assertCaculate(10, 200, 5);
        assertCaculate(10, 600, 2);
        assertCaculate(10, 1000, 1);
        assertCaculate(10, 2000, 1);
    }

    private void assertCaculate(int hitCount, int appearCount, int expectScore) {
        System.out.println(String.format("hitCount:%s,appearCount:%s,score:%s", hitCount, appearCount, similarScoreCalculator.similarScore(hitCount, appearCount)));
        assertEquals(expectScore, similarScoreCalculator.similarScore(hitCount, appearCount));
    }
}