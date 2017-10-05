package com.company;

import java.util.ArrayList;

public class TrainingSet {

    private ArrayList<Integer> inputs;
    private ArrayList<Double> normalOutputs;

    public TrainingSet(ArrayList<Integer> inputs, ArrayList<Double> normalOutputs) {
        this.inputs = inputs;
        this.normalOutputs = normalOutputs;
    }

    public ArrayList<Integer> getInputs() {
        return inputs;
    }

    public ArrayList<Double> getNormalOutputs() {
        return normalOutputs;
    }
}
