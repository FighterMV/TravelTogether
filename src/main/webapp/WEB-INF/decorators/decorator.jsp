<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Travel Together</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />

        <decorator:head/>

    </head>
    <body class="bodyArea" onload="initialize()">

		<div id="mainArea">

				<div id="header">

				</div>

				<div id="navigation">
					<span class="mainLink"><a href="profile.htm">Home</a></span>
					<span class="mainLink"><a href="search.htm">Search</a></span>
					<span class="mainLink"><a href="groups.htm">Groups</a></span>
					<span class="mainLink"><a href="messages.htm">Messages</a></span>
					<span class="mainLink"><a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">Logout</a></span>
				</div>


				<div id="mainContent">

                                    <decorator:body/>

				</div>

		</div>

    </body>
</html>
