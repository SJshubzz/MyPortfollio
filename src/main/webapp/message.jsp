
<%
String message = (String) session.getAttribute("msg");
if (message != null) {
	if (message.equals("Message sent sucssesfully...")) {
%>
<div class="alert alert-success	 alert-dismissible fade show"
	role="alert" style="text-align: center;">
	<strong><%=message%></strong>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<%
} else {
%>
<div class="alert alert-danger alert-dismissible fade show"
	role="alert" style="text-align: center;">
	<strong><%=message%></strong>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<%
}
}
session.removeAttribute("msg");
%>