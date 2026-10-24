package com.calculator.service;

import java.util.List;

public interface HistoryService {

    void addEntry(String expression, double result);

    List<String> getHistory();

    void clearHistory();
    //δήλωση M+, M-,MR,MC

        //M+
    void addM(double value);

    //M-
    void subM(double value);

    //MC
    void clearM();

    //MR
    double returnM();
}