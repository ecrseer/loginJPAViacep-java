<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@include file="../components/bootstrap.jsp" %>
    <title>ACME Cadastrese</title>
</head>

<body>
<%@include file="../components/menu.jsp" %>
<h1>ACME </h1>
<h2>Meu perfil</h2>
<h4>Usuario: ${loggedUser.getName()}</h4>
<hr/>
<form action="editarUsuario" method="post" id="editaForm" enctype="multipart/form-data">


    <div class="mb-3 col-6">
        <h5>Mudar nome</h5>
        <label for="name" class="form-label">Novo Nome</label>
        <input type="text" name="name" id="name" class="form-control" value="${loggedUser.getName()}">
    </div>

    <div class="col-12">
        <button class="btn btn-primary" type="submit">Salvar</button>
    </div>

</form>
<c:if test="${editado!=null}">

    <h2>Usuario ${editado.email} editado com sucesso</h2>
</c:if>
</body>

</html>