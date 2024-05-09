package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class NumbersProcessorTest {
    @Test
    public void min() {
        assertEquals(1, NumbersProcessor.min("test1.txt"));
        assertEquals(0, NumbersProcessor.min("test2.txt"));
        assertEquals(-5, NumbersProcessor.min("test3.txt"));
    }

    @Test
    public void max() {
        assertEquals(3, NumbersProcessor.max("test1.txt"));
        assertEquals(0, NumbersProcessor.max("test2.txt"));
        assertEquals(2, NumbersProcessor.max("test3.txt"));
    }

    @Test
    public void sum() {
        assertEquals(7, NumbersProcessor.sum("test1.txt"));
        assertEquals(0, NumbersProcessor.sum("test2.txt"));
        assertEquals(-6, NumbersProcessor.sum("test3.txt"));
        assertEquals(-6, NumbersProcessor.sum("test4.txt"));
    }


    @Test
    public void mult() {
        assertEquals(6, NumbersProcessor.mult("test1.txt"));
        assertEquals(0, NumbersProcessor.mult("test2.txt"));
        assertEquals(30, NumbersProcessor.mult("test3.txt"));
        assertEquals(-6, NumbersProcessor.mult("test4.txt"));
    }
    @Test
    public void sum_script(){
        double res1 = (NumbersProcessor.min("test1.txt") + NumbersProcessor.max("test1.txt"));
        double res2 = (NumbersProcessor.min("test2.txt") + NumbersProcessor.max("test2.txt"));
        double res3 = (NumbersProcessor.min("test3.txt") + NumbersProcessor.max("test3.txt"));
        assertEquals(4, res1, 1e-8);
        assertEquals(0, res2, 1e-8);
        assertEquals(-3.0, res3, 1e-8);
    }
}