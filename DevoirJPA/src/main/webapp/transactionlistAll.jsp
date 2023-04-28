<%@ page import="org.example.devoir.Transaction" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Transactions List</title>
  </head>
  <body>
    <h1>Transactions List</h1>
<%@ page import="java.util.List" %>
<%@ page import="org.example.devoir.dao.TransactionDao" %>
<%@ page import="org.example.devoir.dao.implementation.TransactionDaoImplementation" %>
<%@ page import="org.example.devoir.Transaction" %>

<%
    TransactionDao dao = new TransactionDaoImplementation();
    List<Transaction> transactionsList = dao.listAll();
%>

<table>
    <thead>
        <tr>
            <th>Ref</th>
            <th>CptCred</th>
            <th>CptDeb</th>
            <th>Montant</th>
            <th>Date</th>
            <th>Type</th>
        </tr>
    </thead>
    <tbody>
        <% for (Transaction transaction : transactionsList) { %>
            <tr>
                <td><%= transaction.getRef() %></td>
                <td><%= transaction.getCptCred() %></td>
                <td><%= transaction.getCptDeb() %></td>
                <td><%= transaction.getMontant() %></td>
                <td><%= transaction.getDate() %></td>
                <td><%= transaction.getType() %></td>
            </tr>
        <% } %>
    </tbody>
</table>
    <br>
    <form method="get" action="addTransaction.jsp">
      <button type="submit">Add Transaction</button>
    </form>
  </body>
</html>
