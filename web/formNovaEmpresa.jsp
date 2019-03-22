<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/novaEmpresa" var="novaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
    <form action="${novaEmpresa}" method="post">
        <input type="hidden" name="id" value="${empresa.id}">
        nome: <input type="text" name="nome"  value="${empresa.nome}">
        data: <input type="text" name="dataAbertura"  value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">

        <input type="submit" value="Enviar">
    </form>
</body>
</html>