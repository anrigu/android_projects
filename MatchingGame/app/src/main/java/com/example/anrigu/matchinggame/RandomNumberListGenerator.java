package com.example.anrigu.matchinggame;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberListGenerator {
    public int random(int low, int high) {
        return (int) (Math.random() * (((high - low) + 1)) + low);
    }

    public List<Integer> generateNumberList(int numberOfCards) {
        List<Integer> listNumbers = new ArrayList<>();
        for (int i = 1; i <= numberOfCards; i++) {
            int nextNum = i;
            listNumbers.add(nextNum);
            listNumbers.add(nextNum);
        }
        return listNumbers;
    }

    public List<Integer> scrambleNumberList(int listLength) {
        List<Integer> listNums = new ArrayList<>(generateNumberList(listLength / 2));
        List<Integer> scrambledList = new ArrayList<>();
        while (listNums.size() > 0){
            int randomIndex = random(0, listNums.size() - 1);
            scrambledList.add(listNums.get(randomIndex));
            listNums.remove(randomIndex);
        }
        return scrambledList;
    }

    public static void main(String[] args) {
        RandomNumberListGenerator generator = new RandomNumberListGenerator();
        System.out.println(generator.scrambleNumberList(6));
        System.out.println(generator.scrambleNumberList(6));
        System.out.println(generator.scrambleNumberList(6));
    }
}
