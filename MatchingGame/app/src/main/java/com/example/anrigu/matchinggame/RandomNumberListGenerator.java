package com.example.anrigu.matchinggame;


import java.util.ArrayList;
import java.util.List;

public class RandomNumberListGenerator {
    public int random(int low, int high) {
        return (int) (Math.random() * (((high - low) + 1)) + low);
    }

    public List<Integer> generateListImage(List<Integer> listImageIds){
        List<Integer> randomImageList = new ArrayList<>();
        List<Integer> fullLenImageList = new ArrayList<>();
        for(int i = 0; i < listImageIds.size(); i++){
            fullLenImageList.add(listImageIds.get(i));
            fullLenImageList.add(listImageIds.get(i));
        }
        while(fullLenImageList.size() > 0){
            int idRandom = random(0,fullLenImageList.size()-1);
            randomImageList.add(fullLenImageList.get(idRandom));
            fullLenImageList.remove(idRandom);
        }
        return randomImageList;
    }

    public static void main(String[] args) {
        RandomNumberListGenerator generator = new RandomNumberListGenerator();
        MatchingApp matchingApp = new MatchingApp();
        System.out.println(generator.generateListImage(matchingApp.imageIds()));
    }
}
