package com.calculator.controller;

import com.calculator.model.CalculatorModel;
import com.calculator.view.CalculatorView;
import com.calculator.service.HistoryService;

public class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;
    private final HistoryService historyService;

    public CalculatorController(CalculatorModel model, CalculatorView view, HistoryService historyService) {
        this.model = model;
        this.view = view;
        this.historyService = historyService;
    }