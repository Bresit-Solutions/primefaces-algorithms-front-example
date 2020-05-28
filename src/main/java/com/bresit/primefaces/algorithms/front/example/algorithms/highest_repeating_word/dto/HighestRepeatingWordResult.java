package com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HighestRepeatingWordResult {

    private String word;
    private Integer timesRepeated;
}
