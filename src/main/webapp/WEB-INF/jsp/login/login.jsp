<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@include file="../components/bootstrap.jsp" %>
    <title>Login </title>
</head>

<body>
<%@include file="../components/menu.jsp" %>
<h1>Logue-se </h1>
<form action="logar" method="post">

    <div class="mb-3 col-6">
        <label for="email" class="form-label">Email</label>
        <input type="email" name="email" id="email" class="form-control">
    </div>
    <div class="mb-3 col-6">
        <label for="password" class="form-label">Senha</label>
        <input type="password" name="password" id="password" class="form-control" id="password">
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Realizar login</button>
    </div>
</form>
<c:if test="${loggedUser!=null && loggedUser.getEmail()!=null}">
    <h1>Usuario logado com sucesso</h1>
    <pre>${loggedUser}</pre>
</c:if>
<c:if test="${falha!=null && loggedUser ==null}">
    <h2>${falha}</h2>
</c:if>
</body>

</html>