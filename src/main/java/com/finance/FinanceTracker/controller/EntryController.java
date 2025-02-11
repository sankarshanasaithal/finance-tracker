package com.finance.FinanceTracker.controller;

import com.finance.FinanceTracker.model.Entry;
import com.finance.FinanceTracker.service.EntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
public class EntryController {
    private final EntryService service;

    public EntryController(EntryService service) {
        this.service = service;
    }

    // Create Entry
    @PostMapping
    public Entry createEntry(@RequestBody Entry entry) {
        return service.createEntry(entry);
    }

    // Read All Entries
    @GetMapping
    public List<Entry> getAllEntries() {
        return service.getAllEntries();
    }

    // Read Entry by ID
    @GetMapping("/{id}")
    public Entry getEntryById(@PathVariable Long id) {
        return service.getEntryById(id).orElse(null);
    }

    // Update Entry
    @PutMapping("/{id}")
    public Entry updateEntry(@PathVariable Long id, @RequestBody Entry entry) {
        return service.updateEntry(id, entry);
    }

    // Delete Entry
    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
    }
}
