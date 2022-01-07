<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TicketCancelling">
   <input type="hidden" name="cancelpnr" id="" value="<%= request.getParameter("pnrnumber")%>">
   <h1>to confirm cancellation press ok</h1>
   <button type="submit">ok</button>
   
   </form>
   
</body>
</html>