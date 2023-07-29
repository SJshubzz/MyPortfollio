<!DOCTYPE html>
<html>
<head>
<title>Login Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
}

h1 {
	text-align: center;
}

form {
	display: flex;
	flex-direction: column;
}

input, button {
	margin-bottom: 10px;
	padding: 10px;
}

button {
	background-color: #007bff;
	color: #fff;
	border: none;
	cursor: pointer;
}

a {
	text-align: center;
	display: block;
}

/* Media Queries */
@media screen and (min-width: 768px) {
	.container {
		max-width: 600px;
	}
}
</style>
</head>
<body>

	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=msg%>
	</div>
	<%
	}
	%>


	<div class="container">
		<h1>Welcome Back!</h1>
		<form action="Login" method="post">
			<input type="text" placeholder="Username/Email" name="email" required>
			<input type="password" placeholder="Password" name="password"
				required> <label> <input type="checkbox">
				Remember Me
			</label>
			<button type="submit">Login</button>
		</form>
		<a href="#">Forgot Password?</a>
	</div>
</body>

</html>
