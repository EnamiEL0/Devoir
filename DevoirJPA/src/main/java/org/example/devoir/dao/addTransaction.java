package org.example.devoir.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.devoir.Transaction;
import org.example.devoir.dao.implementation.TransactionDaoImplementation;

import java.io.IOException;

@WebServlet(name = "addTransaction", urlPatterns ="/addTransaction")
public class addTransaction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransactionDao dao = new TransactionDaoImplementation();

        String ref = request.getParameter("ref");
        String cptDeb = request.getParameter("cptDeb");
        String cptCred = request.getParameter("cptCred");
        double montant = Double.parseDouble(request.getParameter("montant"));


        Transaction transaction = new Transaction(ref, cptDeb, cptCred, montant);
        dao.addTransaction(transaction);

        response.sendRedirect("transactionAdded.jsp");
    }
}
