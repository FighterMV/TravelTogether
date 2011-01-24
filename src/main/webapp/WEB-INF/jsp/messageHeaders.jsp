<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>
    <br>
    <a href="messageHeaders.htm">Received messages</a> |
    <a href="writeMessageForm.htm">Compose new message</a>
    <br><br><br>
            <c:forEach var="myMessage" items="${allMessages}">
                <hr/>
                <c:out value="${myMessage.sender}"/> -
                <c:out value="${myMessage.creationDate}"/> -
                <c:out value="${myMessage.subject}"/> <br>
                <c:out value="${myMessage.content}"/>
             </c:forEach>
</center>