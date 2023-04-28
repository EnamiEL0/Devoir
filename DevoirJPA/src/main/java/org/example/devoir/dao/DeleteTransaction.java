package org.example.devoir.dao;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.example.devoir.Transaction;
import org.example.devoir.dao.implementation.TransactionDaoImplementation;



@WebServlet(name = "DeleteTransactionServlet", urlPatterns = { "/deleteTransaction" })
public class DeleteTransaction extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ref = request.getParameter("ref");
    TransactionDao dao = new TransactionDaoImplementation();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("transaction_pu");
    EntityManager em = emf.createEntityManager();

    Transaction transaction = em.find(Transaction.class, ref);

    em.getTransaction().begin();
    em.remove(transaction);
    em.getTransaction().commit();

    em.close();
    emf.close();

    response.sendRedirect(request.getContextPath() + "/listTransactions");
    // Check if a transaction was deleted
    if (request.getParameter("deletedRef") != null) {
      String deletedRef = request.getParameter("deletedRef");
      request.setAttribute("message", "Transaction " + deletedRef + " was successfully deleted.");
    }

	// Set the list of transactions as a request attribute
    request.setAttribute("transactionsList", dao.listAll());

    // Forward the request to the transactionsList.jsp page
    getServletContext().getRequestDispatcher("/transactionsList.jsp").forward(request, response);

  }
}
