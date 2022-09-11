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
<form action="cadastrar" method="post" id="cadastraForm">
    <div class="mb-3 col-6">
        <label for="name" class="form-label">Nome</label>
        <input type="text" name="name" id="name" class="form-control" value="${registeringUser.getName()}">
    </div>
    <div class=" mb-3 col-6">
        <label for="email" class="form-label">Email</label>
        <input type="email" name="email" id="email" class="form-control" value="${registeringUser.getEmail()}">
    </div>
    <div class=" mb-3 col-6">
        <label for="password" class="form-label">Senha</label>
        <input type="password" name="password" id="password" class="form-control"
               value="${registeringUser.getPassword()}">
    </div>

    <div class=" mb-3 col-6">
        <label for="cep" class="form-label">CEP</label>
        <input type="text" name="cep" id="cep" class="form-control" value="${registeringUser.getCep()}"
               onblur="switchForm()">
    </div>
    <c:if test="${registeringUser!=null}">

        <div class="mb-3 col-6">
            <label for="logradouro" class="form-label">Endereco</label>
            <input type="text" name="logradouro" id="logradouro" class="form-control"
                   value="${registeringUser.getLogradouro()}">
        </div>
        <div class="mb-3 col-6">
            <label for="bairro" class="form-label">Bairro</label>
            <input type="text" name="bairro" id="bairro" class="form-control" value="${registeringUser.getBairro()}">
        </div>
        <div class="mb-3 col-6">
            <label for="localidade" class="form-label">Localidade</label>
            <input type="text" name="localidade" id="localidade" class="form-control"
                   value="${registeringUser.getLocalidade()}">
        </div>
        <div class="mb-3 col-6">
            <label for="uf" class="form-label">UF</label>
            <input type="text" name="uf" id="uf" class="form-control" value="${registeringUser.getUf()}">
        </div>

        <div class="mb-3 col-6">
            <label for="numeroEndereco" class="form-label">Numero</label>
            <input type="text" name="numeroEndereco" id="numeroEndereco" class="form-control">
        </div>

        <div class="col-12">
            <button class="btn btn-primary" type="submit">Cadastrar</button>
        </div>
    </c:if>
</form>
<c:if test="${cadastrado!=null}">
    <h2>Usuario ${cadastrado.email} cadastrado com sucesso</h2>
</c:if>
<script>
    function switchForm() {
        const form = cadastraForm;
        form.action = 'cadastroPesquisaCep'
        form.submit()
    }
</script>
</body>

</html>