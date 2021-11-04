<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<form:form action="save" modelAttribute="newContact">

    <form:hidden path="id"/>
    <br><br>

    Name <form:input path="name"/>
    <br>
    <form:errors path="name"/>
    <br><br>

    Surname <form:input path="surname"/>
    <br>
    <form:errors path="surname"/>
    <br><br>

    Address <form:input path="adress"/>
    <br><br>

    Phone <form:input path="phone"/>
    <br>
    <form:errors path="phone"/>
    <br><br>

    <input type="submit" value="OK">

</form:form>
</body>

</html>