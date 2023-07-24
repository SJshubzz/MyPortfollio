<%
String message = (String) session.getAttribute("msg");
if (message != null) {
	if(message.equals("Message sent sucssesfully...")){
		
%>
<h1 style="text-align: center;color: green;"><%=message%></h1>
<%
}
	else{
		%>
<h1 style="text-align: center; color: red;"><%=message %></h1>
<% 
	}
}
session.removeAttribute("msg");
%>