<!DOCTYPE html>
<%@page import="com.pojo.MessagePojo"%>
<%@page import="com.dao.MessaegeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.util.ArrayList"%>

<html lang="en">
<head>
<meta charset="utf-8">


<title>contacts card - Bootdey.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	margin-top: 20px;
	background: #eee;
}

.profile .panel-profile {
	border: none;
	margin-bottom: 0;
	box-shadow: none;
}

.profile .panel-heading {
	color: #585f69;
	background: #fff;
	padding: 7px 15px;
	border-bottom: solid 3px #f7f7f7;
}

.overflow-h {
	overflow: hidden;
}

.panel-heading {
	color: #fff;
	padding: 5px 15px;
}

.profile .panel-title {
	font-size: 16px;
}

.profile .profile-blog {
	padding: 20px;
	background: #fff;
}

.profile .blog-border {
	border: 1px solid #f0f0f0;
}

.profile .profile-blog img {
	float: left;
	width: 50px;
	height: 50px;
	margin-right: 20px;
}

.rounded-x {
	border-radius: 50% !important;
}

.profile .name-location {
	overflow: hidden;
}

.profile .name-location strong {
	color: #555;
	display: block;
	font-size: 16px;
}

.profile .name-location span a {
	color: #555;
}

.margin-bottom-20 {
	margin-bottom: 20px;
}

.share-list {
	margin-bottom: 0;
}

.list-inline {
	padding-left: 0;
	margin-left: -5px;
	list-style: none;
}

.list-inline li {
	display: inline-block;
	padding-right: 5px;
	padding-left: 5px;
	font-size: 11px;
}

.share-list li i {
	color: #72c02c;
	margin-right: 5px;
}
</style>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<%
String email = (String) session.getAttribute("check");
if (!email.equals(null)) {
%>
<body>
	<div class="container profile">
		<div class="col-md-12">
			<div class="panel panel-profile">
				<div class="panel-heading overflow-h">
					<h1 class="panel-title heading-sm pull-left"
						style="color: red; font-weight: bold; font-size: 30px">
						<i></i>Contact
						</h2>
				</div>
				<div class="panel-body">
					<div class="row">


						<%
						ArrayList<Object> al = new MessaegeDao().read();
						int i = 1;
						for (Object obj : al) {
							MessagePojo m = (MessagePojo) obj;
						%>
						<!-- LOOP -->


						<div class="col-sm-12">
							<div class="profile-blog blog-border">

								<div class="name-location">
									<h3><%=i%></h3>
									<strong><%=m.getName()%></strong> <span><i></i><a
										href="#"><%=m.getDatetime()%>,</a> <a href="#"><%=m.getEmail()%></a></span>
								</div>
								<div class="clearfix margin-bottom-20"></div>
								<p><%=m.getMessage()%></p>
								<hr>
								<script type="text/javascript">
									function ensure() {
										if (confirm("ARE YOU SURE!!!")) {
											return true;
										} else {
											return false;
										}
									}
								</script>
								<form action="DeleteMessage" method="post" >
									<input type="hidden" name="sn" value="<%=m.getSn()%>">
									<button>Delete</button>
								</form>
							</div>
							<i class="fa-sharp fa-regular fa-calendar-days"></i>
						</div>

						<!-- LOOP -->
						<%
						i++;
						}
						%>
						<%
						} else {
						response.sendRedirect("login.jsp");
						}
						%>


					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>