package com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.controller;

import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.dto.FibonacciCalculationMethod;
import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.dto.FibonacciResult;
import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.service.FibonacciService;
import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.service.FibonacciServiceImpl;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
@Data
public class FibonacciController implements Serializable {

    private Integer number;
    private FibonacciResult result;
    private FibonacciService fibonacciService;

    @PostConstruct
    public void init() {
        fibonacciService = new FibonacciServiceImpl();
    }

    public void calculate(FibonacciCalculationMethod method) throws Exception {
        result = fibonacciService.calculate(number, method);
    }
}
