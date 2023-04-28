package org.example.devoir.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.devoir.Transaction;
import org.example.devoir.dao.implementation.TransactionDaoImplementation;

import java.io.IOException;




@WebServlet(name = "listTransactions", urlPatterns ="/listTransactions")
public class listTransactions extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransactionDao dao = new TransactionDaoImplementation();
        Transaction transaction = dao.find("1");

        String code = "";

            code += "<tr><td>" + transaction.getRef() + "</td>"
                    + "<td>" + transaction.getCptCred() + "</td>"
                    + "<td>" + transaction.getCptDeb() + "</td>"
                    + "<td>" + transaction.getMontant() + "</td>"
                    + "<td>" + transaction.getDate() + "</td>"
                    + "<td>" + transaction.getType() + "</td></tr>";


        request.setAttribute("listTransactions", code);
        getServletContext().getRequestDispatcher("/transactionsList.jsp").forward(request, response);


    }

}


