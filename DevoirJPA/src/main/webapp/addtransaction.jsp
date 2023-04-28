<!DOCTYPE html>
<html>
<head>
	<title>Add Transaction</title>
</head>
<body>
	<h1>Add Transaction</h1>
	<form method="post" action="addTransaction">
		<label for="ref">Reference:</label>
		<input type="text" id="ref" name="ref"><br><br>
		
		<label for="cptDeb">Debit Account:</label>
		<input type="text" id="cptDeb" name="cptDeb"><br><br>
		
		<label for="cptCred">Credit Account:</label>
		<input type="text" id="cptCred" name="cptCred"><br><br>
		
		<label for="montant">Amount:</label>
		<input type="text" id="montant" name="montant"><br><br>
		
		<input type="submit" value="Add Transaction">
	</form>
</body>
</html>
