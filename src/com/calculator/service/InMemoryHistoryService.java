package com.calculator.service;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryService implements HistoryService {

    private ArrayList<String> History = new ArrayList<>();
    private double memory=0;

    @Override
    public void addEntry(String expression, double result) {

        History.add(expression + "=" + result);


    }
    @Override
    public List<String> getHistory(){

        return new ArrayList<>( History);



    }

    @Override
    public  void clearHistory(){

        History.clear();

    }


    @Override
    public void addM(double value){
        memory+=value;

    }

    @Override
    public void subM(double value){
        memory-=value;
    }
    @Override
    public  double returnM(){
        return memory;
    }
    @Override
    public void clearM(){
        memory=0;
    }

}