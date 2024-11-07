package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleArray {
    static int[][] range;

    public static void main(String[] args) throws IOException {
    }

    public static List<String> readFile(String fileName) throws IOException {
        List<String> textFromFile = new ArrayList<>();
        textFromFile = Files.readAllLines(Paths.get(fileName));
        return textFromFile;
    }

    public static int calculateTime() {
        int count = 0;
        while (!isAllInfected()) {
            infectNearest();
            count++;
        }
        return count;
    }

    public static boolean isAllInfected() {
        for (int i = 0; i < range.length; i++) {
            for (int j = 0; j < range[i].length; j++) {
                if (range[i][j] == 0) {
                    return false;
                } else continue;
            }
        }
        return true;
    }


    public static void getRange(List<String> textFromFile) {
        String[] str = textFromFile.getFirst().split(" ");
        int countOfLines = Integer.parseInt(str[0]);
        int countOfColumns = Integer.parseInt(str[1]);
        range = new int[countOfLines][countOfColumns];
        for (int i = 0; i < countOfLines; i++) {
            for (int j = 0; j < countOfColumns; j++) {
                range[i][j] = 0;
            }
        }
    }

    public static void setFirstInfected(List<String> textFromFile) {
        String[] str = textFromFile.get(1).split(" ");
        List<Integer> list = new ArrayList<>();
        list = Stream.of(str)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        list.removeFirst();

        for (int i = 0; i < list.size(); i = i + 2) {
            int line = list.get(i) - 1;
            int column = list.get(i + 1) - 1;
            range[line][column] = 1;
        }
    }

    public static void infectNearest() {

        int[][] newRange = new int[range.length][range[0].length];
        for (int i = 0; i < range.length; i++) {
            for (int j = 0; j < range[i].length; j++) {
                newRange[i][j] = range[i][j];
            }
        }
        for (int i = 0; i < range.length; i++) {
            for (int j = 0; j < range[i].length; j++) {
                if (range[i][j] == 1) {
                    try {
                        newRange[i][j + 1] = 1;
                    } catch (Exception e) {
                        int x;
                    }
                    try {
                        newRange[i][j - 1] = 1;
                    } catch (Exception e) {
                        int x;
                    }
                    try {
                        newRange[i + 1][j] = 1;
                    } catch (Exception e) {
                        int x;
                    }
                    try {
                        newRange[i - 1][j] = 1;
                    } catch (Exception e) {
                        int x;
                    }
                }
            }
        }
        range = newRange;
    }


}
