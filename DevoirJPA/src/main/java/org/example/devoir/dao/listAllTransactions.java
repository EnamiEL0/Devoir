package org.example.devoir.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.devoir.Transaction;
import org.example.devoir.dao.implementation.TransactionDaoImplementation;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ListTransactionsServlet", urlPatterns = "/listAllTransactions")
public class listAllTransactions extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransactionDao dao = new TransactionDaoImplementation();
        List<Transaction> transactionsList = dao.listAll();

        request.setAttribute("transactionsList", transactionsList);
        getServletContext().getRequestDispatcher("/transactionslistAll.jsp").forward(request, response);
    }
}
