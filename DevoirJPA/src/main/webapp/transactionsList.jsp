<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List des Transaction</h1>
	<table>
		<tr>
			<td> Reference</td>
			<td> Compte Credit </td>
			<td> Copmte Debit </td>
			<td> Montant </td>
			<td> Date</td>
			<td> Type</td>
		</tr>
		<tr>
		<%
		String code = (String) request.getAttribute("listTransactions");
		out.println(code);
		%>
		</tr>

	</table>


</body>
</html>