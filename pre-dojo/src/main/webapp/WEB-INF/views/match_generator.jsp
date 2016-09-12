<%@ include file="taglib.jsp" %>
<html>
	<head>
		<title>Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="styles.jsp" %>
		<style type="text/css">
			.glyphicon-refresh-animate {
			    -animation: spin .7s infinite linear;
			    -webkit-animation: spin2 .7s infinite linear;
			}

			@-webkit-keyframes spin2 {
			    from { -webkit-transform: rotate(0deg);}
			    to { -webkit-transform: rotate(360deg);}
			}

			@keyframes spin {
			    from { transform: scale(1) rotate(0deg);}
			    to { transform: scale(1) rotate(360deg);}
			}
		</style>
		<script type="text/javascript">
			function loadPage() {
				document.getElementById('logFile').style.display = 'none';
				document.getElementById('loading').style.display = 'block';
			}
		</script>
	</head>
	<%@ include file="menu.jsp" %>
	<body>
		<header>
			<div class="jumbotron containerApp">
				<div class="container">
					<h2>Simulador de Partida (Ver regras na página Home)</h2>
				</div>
			</div>
		</header>
		<div class="container">
			<div class="bodyIndex" style="margin-right: 300px">
				<button class="btn btn-primary btn-lg btn-block" id="loading" style="display: none">
					<span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
					Gerando arquivo de log da partida ...
				</button>
				<a href='<spring:url value="/pre-dojo/log/generator"/>' class="btn btn-primary btn-lg btn-block" 
				onclick="loadPage()" id="logFile">
					Gerar Nova Partida 
				</a>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
		<%@ include file="scripts.jsp" %>
	</body>
</html>
