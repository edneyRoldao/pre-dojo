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
					<h2>Resultado do Arquivo de Log da Partida (Original)</h2>
					<h6> Por quest�es de seguran�a da p�gina, a exibi��o do jogador WORLD est� assim: #WORLD# </h6>
				</div>
			</div>
		</header>
		<div class="container">
			<div class="bodyIndex">
				<c:forEach items="${logList}" var="line">
					<h6 >${line}</h6>
				</c:forEach>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
		<%@ include file="scripts.jsp" %>
	</body>
</html>