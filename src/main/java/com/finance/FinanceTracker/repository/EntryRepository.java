package com.finance.FinanceTracker.repository;

import com.finance.FinanceTracker.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByCategory(String category);
    List<Entry> findByType(String type);
    List<Entry> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(e.amount) FROM Entry e WHERE e.type = 'income'")
    Double getTotalIncome();

    @Query("SELECT SUM(e.amount) FROM Entry e WHERE e.type = 'expense'")
    Double getTotalExpense();
}
