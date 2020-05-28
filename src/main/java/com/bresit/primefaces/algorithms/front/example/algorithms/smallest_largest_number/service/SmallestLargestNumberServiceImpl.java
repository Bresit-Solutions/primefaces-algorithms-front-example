package com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.service;

import com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.dto.SmallestLargestNumberResult;
import com.bresit.primefaces.algorithms.front.example.api_config.ApiRestConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class SmallestLargestNumberServiceImpl implements SmallestLargestNumberService {

    @Override
    public SmallestLargestNumberResult findSmallestLargestNumber(List<Integer> listNumbers) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ApiRestConfig.API_URL_BASE)
                .path("smallestLargestNumber");
        listNumbers.forEach(number -> builder.queryParam("numbers", number));
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SmallestLargestNumberResult> resultEntity = restTemplate.getForEntity(builder.toUriString(), SmallestLargestNumberResult.class);
        return resultEntity.getBody();
    }
}
