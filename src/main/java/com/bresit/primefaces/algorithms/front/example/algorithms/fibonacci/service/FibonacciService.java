package com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.service;

import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.dto.FibonacciCalculationMethod;
import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.dto.FibonacciResult;

public interface FibonacciService {

    FibonacciResult calculate(Integer number, FibonacciCalculationMethod method) throws Exception;
}
