package com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.service;

import com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.dto.SmallestLargestNumberResult;

import java.util.List;

public interface SmallestLargestNumberService {

    SmallestLargestNumberResult findSmallestLargestNumber(List<Integer> listNumbers);
}
