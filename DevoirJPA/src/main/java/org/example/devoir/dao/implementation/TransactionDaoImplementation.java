package org.example.devoir.dao.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.devoir.Transaction;
import org.example.devoir.dao.TransactionDao;

import java.util.List;

public class TransactionDaoImplementation implements TransactionDao {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public TransactionDaoImplementation() {
        entityManagerFactory = Persistence.createEntityManagerFactory("transaction_pu");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public List<Transaction> listAll() {
        String query = "SELECT * FROM transactions";
        entityManager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Transaction> transactionsList = entityManager.createQuery(query).getResultList();
        entityManager.getTransaction().commit();
        return transactionsList;
    }

    public void addTransaction(Transaction transaction) {
        entityTransaction.begin();
        entityManager.persist(transaction);
        entityTransaction.commit();
        entityManager.close();
    }

    public void deleteTransaction(Transaction transaction) {
        entityTransaction.begin();
        entityManager.remove(transaction);
        entityTransaction.commit();
        entityManager.close();
    }

    public Transaction find(String id) {
        Transaction transaction = entityManager.find(Transaction.class,id);
        return transaction;
    }

   /* public void update(Transaction transaction) {
        entityTransaction.begin();
        entityManager.merge(transaction);
        entityTransaction.commit();
        entityManager.close();
    }*/
}
