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
<h2>Cadastre-se</h2>
<form action="cadastrar" method="post">
    <div class="mb-3 col-6">
        <label for="name" class="form-label">Nome</label>
        <input type="text" name="name" id="name" class="form-control">
    </div>
    <div class="mb-3 col-6">
        <label for="email" class="form-label">Email</label>
        <input type="text" name="email" id="email" class="form-control">
    </div>
    <div class="mb-3 col-6">
        <label for="password" class="form-label">Senha</label>
        <input type="password" name="password" id="password" class="form-control" id="password">
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Cadastrar</button>
    </div>
</form>
</body>

</html>