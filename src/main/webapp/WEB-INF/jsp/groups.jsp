<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery_tablesorter_min.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
                $("#groups").tablesorter();
        });
    </script>
</head>


<body>

<form method="post" action="createGroup.htm">

    <table id="groups" class="tablesorter">
      <thead>
        <tr>
          <th>Name</th>
          <th>Founder</th>
          <th>Creation Date</th>
          <th>Members</th>
          <th>Forum entries</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="myGroup" items="${allGroups}">
            <tr>
                <td><c:out value="${myGroup.name}"/></td>
                <td><c:out value="${myGroup.founder}"/></td>
                <td><c:out value="${myGroup.creationDate}"/></td>
                <td>60</td>
                <td>70</td>
            </tr>
        </c:forEach>
      </tbody>
    </table>

    <table>
    <tr>
        <td><label>Name:</label></td>
        <td><input name="name" id="name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Create Group"/>
        </td>
    </tr>
</table>

    

</form>

    <a href="http://www.travel-together.org/pres/index.php" target="blank">Open Map</a>

</body>