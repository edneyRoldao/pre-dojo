<%@ include file="taglib.jsp" %>
<html>
	<head>
		<title>Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="styles.jsp" %>
	</head>
	<%@ include file="menu.jsp" %>
	<body>
		<header>
			<div class="jumbotron containerApp">
				<div class="container">
					<h2>Lista de Jogadores e Armas</h2>
				</div>
			</div>
		</header>
		<div class="container" style="width: 1180px; clear: left; clear: right;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center;">JOGADORES</h3>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${killers}" var="k">
							<li> <strong>${k}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="width: 1180px; clear: left; clear: right;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center;">ARMAS</h3>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${weapons}" var="w">
							<li> <strong>${w.name}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
		<%@ include file="scripts.jsp" %>
	</body>
</html>
