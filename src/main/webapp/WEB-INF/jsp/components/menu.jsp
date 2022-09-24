<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <c:if test="${loggedUser !=null}">
            <a class="navbar-brand" href="#">Bem vindo, ${loggedUser.getEmail()}</a>
        </c:if>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <c:if test="${loggedUser ==null}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/usuario/registrar">Cadastrar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/usuario/logar">Login</a>
                    </li>
                </c:if>
                <c:if test="${loggedUser !=null}">
                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/usuario/perfil">Meu perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/usuario/deslogar">Deslogar</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
</body>

</html>