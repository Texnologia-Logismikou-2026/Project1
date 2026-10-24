package com.calculator.service;

import java.util.List;

public interface HistoryService {
    void addEntry(String expression, double result);
    List<String> getHistory();
    void clearHistory();
}