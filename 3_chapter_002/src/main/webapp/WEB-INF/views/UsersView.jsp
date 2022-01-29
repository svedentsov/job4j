<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: ghostwhite;
        }
        h2 {
            color: #008080;
            text-align: left;
        }
        p {
            font-family: Verdana, serif;
            color: #008B8B;
            text-align: left;
            font-size: 15px;
        }

        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 13px;
            border-radius: 5px;
            border-spacing: 0;
            text-align: center;
            background-color: white;
        }
        th {
            background: #BCEBDD;
            color: #008B8B;
            font-size: 14px;
            padding: 10px 10px;
            text-align: center;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: gainsboro;
        }
        th:first-child {
            border-top-left-radius: 5px;
        }
        th:last-child {
            border-top-right-radius: 5px;
            border-right: none;
        }
        tr:last-child td:first-child {
            border-radius: 0 0 0 5px;
        }
        tr:last-child td:last-child {
            border-radius: 0 0 5px 0;
        }
        tr td:last-child {
            border-right: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Users list</h2>
    <p>Users personal data</p>

    <table class="table table-hover" id="table">
        <thead>
        <tr>
            <th>id</th>
            <th>photo</th>
            <th>name</th>
            <th>login</th>
            <th>email</th>
            <th>country</th>
            <th>city</th>
            <th>created date</th>
            <th>password</th>
            <th>role</th>
            <th colspan="2">action</th>
        </tr>
        </thead>
        <%--<tbody id="datatable" onload="getPersons()">--%>
        <tbody id="datatable">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty user.photoId}">
                            <img src="${pageContext.servletContext.contextPath}/download?name=${user.photoId}"
                                 width="100px" height="100px"/></br>
                            <br>
                            <a href="${pageContext.servletContext.contextPath}/download?name=${user.photoId}"
                               class="btn btn-info btn-xs">download</a>
                        </c:when>
                        <c:otherwise>no image</c:otherwise>
                    </c:choose>
                </td>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>${user.city}</td>
                <td>${user.createDate}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td>
                    <form action="${pageContext.servletContext.contextPath}/update" method="get">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <button type="submit" class="btn btn-info btn-sm">update</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.servletContext.contextPath}/delete" method="post">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <button type="submit" class="btn btn-info btn-sm">delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="form-group">
        <form action="${pageContext.servletContext.contextPath}/create" method="get">
            <%--<button type="submit" class="btn btn-primary" onclick="return validate()">Create new user</button>--%>
            <button type="submit" class="btn btn-info">Create new user</button>
        </form>
    </div>
    <div class="form-group">
        <form action="${pageContext.servletContext.contextPath}/signout" method="get">
            <%--<button type="submit" class="btn btn-primary" onclick="return validate()">Exit</button>--%>
            <button type="submit" class="btn btn-primary">Exit</button>
        </form>
    </div>
</div>

</body>
</html>
