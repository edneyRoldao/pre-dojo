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
					<h2>PRE-DOJO</h2>
				</div>
			</div>
		</header>
		<div class="container">
			<div class="bodyIndex">
				<h3 style="margin-bottom: 25px;">Regras gerais para gerar uma partida</h3>
				<ul>
					<li>Definir o caminho onde o arquivo de log será salvo na classe AppConfig</li>
					<li>Definir o nome do arquivo na classe AppConfig</li>
					<li>Definir um intervalo de tempo (em segundos) para as ações (assassinatos) na classe AppConfig</li>
					<li>Devemos definir também o tamanho (em linhas) de uma partida na classe AppConfig</li>
					<li>Na consulta do log da partida, o formato do jogador WORLD foi modificado para #WORLD#</li>
					<li>Podemos remover e/ou adicionar jogadores a partir das classes: KillersConfig e WeaponsConfig</li>
					<li>Estou disponibilizando também os resultados da partida em formato Json em /pre-dojo/match/ranking.json</li>
				</ul>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
		<%@ include file="scripts.jsp" %>
	</body>
</html>