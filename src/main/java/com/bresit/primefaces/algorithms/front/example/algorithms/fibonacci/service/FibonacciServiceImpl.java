package com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.service;

import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.dto.FibonacciCalculationMethod;
import com.bresit.primefaces.algorithms.front.example.algorithms.fibonacci.dto.FibonacciResult;
import com.bresit.primefaces.algorithms.front.example.api_config.ApiRestConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public FibonacciResult calculate(Integer number, FibonacciCalculationMethod method) throws Exception {
        if (number == null)
            throw new Exception("Null number is not allowed");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ApiRestConfig.API_URL_BASE)
                .path("fibonacci")
                .queryParam("number", number)
                .queryParam("method", method);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FibonacciResult> resultEntity = restTemplate.getForEntity(builder.toUriString(), FibonacciResult.class);
        return resultEntity.getBody();
    }
}
