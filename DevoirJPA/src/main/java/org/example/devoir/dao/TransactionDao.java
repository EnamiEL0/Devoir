package org.example.devoir.dao;

import org.example.devoir.Transaction;

import java.util.List;

public interface TransactionDao {
    public List<Transaction> listAll();
    public void addTransaction(Transaction transaction);
    public void deleteTransaction(Transaction transaction);
    public Transaction find(String id);
    //public void update(Transaction transaction);

}
