package com.finance.FinanceTracker.service;

import com.finance.FinanceTracker.model.Entry;
import com.finance.FinanceTracker.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    private final EntryRepository repository;

    public EntryService(EntryRepository repository) {
        this.repository = repository;
    }

    public Entry createEntry(Entry entry) {
        return repository.save(entry);
    }

    public List<Entry> getAllEntries() {
        return repository.findAll();
    }

    public Optional<Entry> getEntryById(Long id) {
        return repository.findById(id);
    }

    public Entry updateEntry(Long id, Entry updatedEntry) {
        return repository.findById(id).map(entry -> {
            entry.setAmount(updatedEntry.getAmount());
            entry.setCategory(updatedEntry.getCategory());
            entry.setType(updatedEntry.getType());
            entry.setDate(updatedEntry.getDate());
            entry.setDescription(updatedEntry.getDescription());
            return repository.save(entry);
        }).orElse(null);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

    public Double getTotalIncome() {
        return repository.getTotalIncome() != null ? repository.getTotalIncome() : 0.0;
    }

    public Double getTotalExpense() {
        return repository.getTotalExpense() != null ? repository.getTotalExpense() : 0.0;
    }
}
