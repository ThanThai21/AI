package com.company;

import java.net.URI;
import java.util.ArrayList;

public class NeuralNetwork {

    private ArrayList<Neuron> neurons = new ArrayList<>(); //26 neuron
    private ArrayList<TrainingSet> trainingSets;

    public NeuralNetwork() {
        for (int i = 0; i < 26; i++) {
            neurons.add(new Neuron());
        }
        trainingSets = Utils.getTrainingSets();
    }

    public void setInputs(ArrayList<Integer> inputs) {
        for (Neuron neuron : neurons) {
            neuron.setInputs(inputs);
        }
    }

    public ArrayList<Double> getOutputs() {
        ArrayList<Double> outputs = new ArrayList<>();
        for (Neuron neuron : neurons) {
            outputs.add(neuron.calculateOutput());
        }
        return outputs;
    }


    /**
     * @param times the times machine will learn
     */
    public void learn(long times) {
        for (int i = 0; i < times; i++) {
            int index = ((int) Math.random()) * trainingSets.size(); //pick any training set to learn
            TrainingSet trainingSet = trainingSets.get(index);
            setInputs(trainingSet.getInputs());
            adjustWeights(trainingSet.getNormalOutputs());
        }
    }

    /**
     * machine learn all of training data. It maybe take a lot of time.
     */
    public void learn() {
        for (TrainingSet trainingSet : trainingSets) {
            setInputs(trainingSet.getInputs());
            adjustWeights(trainingSet.getNormalOutputs());
        }
    }

    /**
     *
     */
    private void adjustWeights(ArrayList<Double> normalOuputs) {
        for (int i = 0; i < normalOuputs.size(); i++) {
            neurons.get(i).adjustWeights(normalOuputs.get(i));
        }
    }


}
