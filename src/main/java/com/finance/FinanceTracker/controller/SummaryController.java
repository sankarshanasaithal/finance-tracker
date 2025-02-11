package com.finance.FinanceTracker.controller;

import com.finance.FinanceTracker.service.EntryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SummaryController {
    private final EntryService service;

    public SummaryController(EntryService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        Map<String, Double> summary = new HashMap<>();
        double income = service.getTotalIncome();
        double expense = service.getTotalExpense();
        summary.put("Total Income", income);
        summary.put("Total Expenses", expense);
        summary.put("Balance", income - expense);
        return summary;
    }
}
