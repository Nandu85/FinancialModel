<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Financial Model</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.0-beta1/js/bootstrap.min.js"
	integrity="sha512-Hqe3s+yLpqaBbXM6VA0cnj/T56ii5YjNrMT9v+us11Q81L0wzUG0jEMNECtugqNu2Uq5MSttCg0p4KK0kCPVaQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.0-beta1/css/bootstrap.min.css"
	integrity="sha512-o/MhoRPVLExxZjCFVBsm17Pkztkzmh7Dp8k7/3JrtNCHh0AQ489kwpfA3dPSHzKDe8YCuEhxXq3Y71eb/o6amg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
table {
	border-style: solid 2px;
	border-color: black;
}
</style>
</head>



<body>


	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Financial Model</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample04" aria-controls="navbarsExample04"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExample04">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>

				</ul>

			</div>
		</div>

	</nav>


	<div class="container">
		<form class="form-inline"
			action="<%=request.getContextPath()%>/information/" method="post">
			<div class="form-group">
				<input type="text" class="form-control" name="fixedAmount"
					placeholder="Fixed Amount(in lacs)" value="${info.fixedAmount}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="income"
					placeholder="Income(in lacs)" value="${info.income}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="expense"
					placeholder="Expense(in lacs)" value="${info.expense}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="eGrowthRate"
					placeholder="Expense GrowthRate(%)" value="${info.eGrowthRate}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="iGrowthRate"
					placeholder="IncomeGrowthRate(%)" value="${info.iGrowthRate}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="noOfYears"
					placeholder="No Of Years" value="${info.noOfYears}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="currentYear"
					placeholder="Starting Year" value="${info.currentYear}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="retireMentYear"
					placeholder="Retirement Year" value="${info.retireMentYear}">
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
		</form>

	</div>


	<hr>
	<hr>


	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Year</th>
				<th scope="col">Income</th>
				<th scope="col">Expense</th>
				<th scope="col">Balance</th>
				<th scope="col">Investment at 5%</th>
				<th scope="col">Investment at 8%</th>
				<th scope="col">Investment at 15%</th>
				<th scope="col">Return Of Investment</th>
				<th scope="col">Total Balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="result">
				<tr>
					<td>${result.getCurrentYear()}</td>
					<td>${result.getIncome()}</td>
					<td>${result.getExpense()}</td>
					<td>${result.getBalance()}</td>
					<td>${result.getInvestment5()}</td>

					<td>${result.getInvestment8()}</td>
					<td>${result.getInvestment15()}</td>
					<td>${result.getRoi()}</td>
					<td>${result.getTotalBalance()}</td>

				</tr>
			</c:forEach>
			<tr></tr>
			<tr>

				<td><strong>Mediclaim</strong></td>
				<td><strong>${values.getMediclame()}</strong></td>
				<td></td>
				<td><strong>Emergency<br>Fund</strong>
				</td>
				<td><strong>${values.getEmergencyFund()}</strong></td>

				<td></td>
				<td><strong>Saving Amount</strong></td>
				<td><strong>${values.getSavingAmount()}</strong></td>
				<td></td>
			</tr>
		</tbody>
	</table>



</body>
</html>