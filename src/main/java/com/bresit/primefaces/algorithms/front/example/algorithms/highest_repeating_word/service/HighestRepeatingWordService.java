package com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.service;

import com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.dto.HighestRepeatingWordResult;

import java.io.File;

public interface HighestRepeatingWordService {

    HighestRepeatingWordResult findHighestRepeatingWord(File fileObj);
}
