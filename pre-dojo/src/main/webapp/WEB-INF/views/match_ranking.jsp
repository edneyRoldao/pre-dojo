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
			<div class="jumbotron containerApp" style="height: 50px">
				<div class="container" style="margin-top: -50px">
					<h3>Raking da Partida com o ID: ${matchRankingResults.id}</h3>
					<h6>Você pode obter o resultado da partida no formato Json, basta adicionar .json no final de url</h6>
				</div>
			</div>
		</header>
		<div class="container" style="width: 580px; float: left; margin-left: 50px">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h2 class="panel-title" style="text-align: center;">ASSASSINATOS</h2>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${matchRankingResults.murdersRanking}" var="murders">
							<li> <strong>${murders}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="width: 580px; float: right; margin-right: 50px">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h2 class="panel-title" style="text-align: center;">MORTES</h2>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${matchRankingResults.deathsRanking}" var="deaths">
							<li> <strong>${deaths}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="width: 1180px; clear: left; clear: right;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center;">ARMA MAIS USADA NAS MORTES PELO CAMPEÃO</h3>
				</div>
				<div class="panel-body" style="margin-top: -15px">
					<h4> Campeão:  ${matchRankingResults.championKiller}</h4>
					<ul>
						<c:forEach items="${matchRankingResults.weaponsMoreUsed}" var="weapons">
							<li> <strong>${weapons}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="width: 1180px; clear: left; clear: right;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center;">MAIOR SEQUÊNCIA DE ASSASSINATOS SEM MORRER</h3>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${matchRankingResults.greaterSequenceMurders}" var="sequence">
							<li> <strong>${sequence}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="width: 1180px; clear: left; clear: right;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center;">JOGADORES QUE NÃO MORRERAM</h3>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${matchRankingResults.killersHasNotDie}" var="notDie">
							<li> <strong>${notDie}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="width: 1180px; clear: left; clear: right;">
			<div class="panel panel-default panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center;">JOGADORES COM 5 ASSASSINATOS EM UM MINUTO</h3>
				</div>
				<div class="panel-body">
					<ul>
						<c:forEach items="${matchRankingResults.awardsFiveMurdersMinute}" var="fiveMurders">
							<li> <strong>${fiveMurders}</strong> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
		<%@ include file="scripts.jsp" %>
	</body>
</html>
