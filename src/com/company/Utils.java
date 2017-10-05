package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utils {

    public static double calculateSigmoidValue(double sum) {
        return 1 / (1 + Math.exp(-sum));
    }

    public static ArrayList<TrainingSet> getTrainingSets() {
        ArrayList<TrainingSet> trainingSets = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char letterValue = (char) (i + 65);
            String letter = String.valueOf(letterValue);
            for (ArrayList<Integer> list : readFromFile("/letters" + letter + ".txt")) {
                trainingSets.add(new TrainingSet(list, getNormalOutputs(i)));
            }
        }

        return trainingSets;
    }

    private static ArrayList<ArrayList<Integer>> readFromFile(String filename) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();

        try {
            InputStream in = Utils.class.getClass().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<Integer> input = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    int value = 0;
                    try {
                        value = Integer.parseInt(String.valueOf(line.charAt(i)));
                    } catch (Exception e) {
                    }
                    input.add(value);
                }
                inputs.add(input);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputs;
    }

    private static ArrayList<Double> getNormalOutputs(int index) {
        ArrayList<Double> normalOutputs = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (i == index) {
                normalOutputs.add(1.0d);
            } else {
                normalOutputs.add(0.0d);
            }
        }
        return normalOutputs;
    }


}