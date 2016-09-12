<!-- Menu Superior -->
<nav class="navbar navbar-inverse navbar-fixed-top menu" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li style="margin-left: 40px;">
                    <a href='<spring:url value="/pre-dojo/match/ranking"/>'>Ranking da Partida</a>
                </li>
                <li style="margin-left: 40px;">
                    <a href='<spring:url value="/pre-dojo/log"/>'>Consultar Log da Partida</a>
                </li>
                <li style="margin-left: 40px;">
                    <a href='<spring:url value="/pre-dojo/log/partida/simular"/>'>Gerar Nova Partida</a>
                </li>
                <li style="margin-left: 40px;">
                    <a href='<spring:url value="/pre-dojo/lista/participantes"/>'>Lista de Jogadores e Armas no Jogo</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
