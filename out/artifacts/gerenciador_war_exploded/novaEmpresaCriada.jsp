<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empresa Criada</title>
</head>
    <body>
        <c:if test="${not empty empresa}">
            <p>A empresa ${empresa} foi cadastrada com sucesso!!!</p>
        </c:if>

        <c:if test="${empty empresa}">
            <p>Não tem empresa para ser cadastrada.</p>
        </c:if>
    </body>
</html>