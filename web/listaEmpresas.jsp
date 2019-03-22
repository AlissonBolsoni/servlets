<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/mostraEmpresa" var="editaEmpresa"/>
<c:url value="/removeEmpresa" var="removeEmpresa"/>
<html>
<head>
    <title>Lista Empresas</title>
</head>
<body>

    <c:if test="${not empty empresa}">
        <p>A empresa ${empresa} foi cadastrada com sucesso!!!</p>
    </c:if>

    <h2>Lista Empresas: </h2>
    <ul>
        <c:forEach items="${empresas}" var="empresa">
            <li>${empresa.nome} -
                <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                <a href="${editaEmpresa}?id=${empresa.id}">edita</a>
                <a href="${removeEmpresa}?id=${empresa.id}">Remover</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
