package com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.service;

import com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.dto.HighestRepeatingWordResult;
import com.bresit.primefaces.algorithms.front.example.api_config.ApiRestConfig;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;

public class HighestRepeatingWordServiceImpl implements HighestRepeatingWordService {

    @Override
    public HighestRepeatingWordResult findHighestRepeatingWord(File fileObj) {
        //Header multipart for send file to the Restfull API
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        //Body of the request
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(fileObj));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ApiRestConfig.API_URL_BASE)
                .path("highestRepeatingWord");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HighestRepeatingWordResult> resultEntity = restTemplate.postForEntity(builder.toUriString(), requestEntity, HighestRepeatingWordResult.class);
        return resultEntity.getBody();
    }
}
