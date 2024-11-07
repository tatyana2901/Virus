package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoubleArrayTest {

    @Test
    void readFile() throws IOException {
        String s = "main/resources/INPUT.TXT";
        List<String> expected = new ArrayList<>();
        expected.add("4 5");
        expected.add("2 2 1 4 5");
        List<String> actual = DoubleArray.readFile(s);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void calculateTime() {
        DoubleArray.range = new int[][]{{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int actual = DoubleArray.calculateTime();
        Assertions.assertEquals(3,actual);
    }

    @Test
    void isAllInfectedTest1() {
        DoubleArray.range = new int[][]{{1, 1, 1}, {0, 0, 0}, {1, 1, 1}};
        Assertions.assertFalse(DoubleArray.isAllInfected());
    }

    @Test
    void isAllInfectedTest2() {
        DoubleArray.range = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        Assertions.assertTrue(DoubleArray.isAllInfected());
    }

    @Test
    void getRange() {
        int [][] expected = new int[][]{{0, 0}, {0, 0}, {0, 0}};
        List<String> dataFromFile = new ArrayList<>();
        dataFromFile.add("3 2");
        dataFromFile.add("2 2 3 3 4");
        DoubleArray.getRange(dataFromFile);
        Assertions.assertArrayEquals(expected,DoubleArray.range);
    }

    @Test
    void setFirstInfected() {
        DoubleArray.range = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        List<String> dataFromFile = new ArrayList<>();
        dataFromFile.add("3 4");
        dataFromFile.add("2 2 3 3 4");
        DoubleArray.setFirstInfected(dataFromFile);
        int[][] expected = new int[][]{{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        Assertions.assertArrayEquals(expected, DoubleArray.range);
    }

    @Test
    void infectNearest() {
        DoubleArray.range = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        DoubleArray.infectNearest();
        int[][] expected = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        Assertions.assertArrayEquals(expected, DoubleArray.range);
    }
}