package com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.controller;

import com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.dto.SmallestLargestNumberResult;
import com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.service.SmallestLargestNumberService;
import com.bresit.primefaces.algorithms.front.example.algorithms.smallest_largest_number.service.SmallestLargestNumberServiceImpl;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@Data
public class SmallestLargestNumberController implements Serializable {

    private Integer number;
    private List<Integer> listNumbers;
    private SmallestLargestNumberResult result;
    private SmallestLargestNumberService smallestLargestNumberService;

    @PostConstruct
    public void init() {
        smallestLargestNumberService = new SmallestLargestNumberServiceImpl();
    }

    public void addNumberToList() {
        if (listNumbers == null)
            listNumbers = new ArrayList<>();
        if (number != null) {
            listNumbers.add(number);
        }
        number = null;
    }

    public void clearList() {
        listNumbers = new ArrayList<>();
        result = null;
    }

    public void findSmallestLargestNumber() {
        if (listNumbers == null || listNumbers.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("listNumbers", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Enter almost one number"));
            return;
        }
        result = smallestLargestNumberService.findSmallestLargestNumber(listNumbers);
    }
}
