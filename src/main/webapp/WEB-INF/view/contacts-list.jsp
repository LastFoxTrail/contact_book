<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h1>You contacts</h1>
<br>

<table>
    <tr>
        <th>Number</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Options</th>
    </tr>

    <c:forEach var="contact" items="${contactsList}">

        <c:url var="deleteButton" value="/contacts/delete">
            <c:param name="deleteContactId" value="${contact.id}"/>
        </c:url>

        <c:url var="updateButton" value="/contacts/update">
            <c:param name="updateContact" value="${contact.id}"/>
        </c:url>

        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.surname}</td>
            <td>${contact.adress}</td>
            <td>${contact.phone}</td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
            </td>
            <td>
                <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<input type="button" value="Add new contact" onclick="window.location.href = 'new'"/>

</body>
</html>