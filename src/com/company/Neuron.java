package com.company;

import java.util.ArrayList;

public class Neuron {

    private static final int BIAS = 1;
    private static final float LEARNING_RATE = 0.1f;

    private ArrayList<Integer> inputs = new ArrayList();
    private ArrayList<Double> weights = new ArrayList();

    private double biasWeight;
    private double output;


    public Neuron() {
        biasWeight = Math.random();
    }

    public void setInputs(ArrayList<Integer> inputs) {
        this.inputs = inputs;
    }

    private void firstGenWeights() {
        for (int i = 0; i < inputs.size(); i++) {
            weights.add(Math.random());
        }
    }

    public double calculateOutput() {
        double sum = 0;
        for (int i = 0; i < inputs.size(); i++) {
            sum += inputs.get(i) * weights.get(i);
        }
        sum += BIAS * biasWeight;
        output = Utils.calculateSigmoidValue(sum);
        return output;
    }

    public void adjustWeights(double normalOutput) {
        for (int i = 0; i < inputs.size(); i++) {
            double newValue = weights.get(i).doubleValue() + LEARNING_RATE*(normalOutput - output)*inputs.get(i);
            weights.set(i, newValue);
        }

        biasWeight += LEARNING_RATE * (normalOutput - output)*BIAS;
    }

}
