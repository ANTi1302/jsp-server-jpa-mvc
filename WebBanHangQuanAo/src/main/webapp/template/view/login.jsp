<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="<c:url value="/template/css/login.css" />">

<link rel="stylesheet" href="<c:url value="/template/css/bootstrap.min.css" />">
<!-- Latest compiled and minified CSS -->


<!-- Optional theme -->


<!-- Latest compiled and minified JavaScript -->

</head>
<body>
	<div class="form-bg">
		<div class="container">
			<div class="row">
				<div class=" ">
					<div class="form-container">
						<div class="left-content">
							<h3 class="title">Ellent handmade</h3>
							<h4 class="sub-title">Lorem ipsum dolor sit amet.</h4>
						</div>
						<div class="right-content">
							<h3 class="form-title">Login</h3>
							<form class="form-horizontal" action="login" method="post">
								<div class="form-group">
									<label>Username / Email</label> <input name="user" type="text" 
										class="form-control" >
								</div>
								<div class="form-group">
									<label>Password</label> <input name="password" type="password"
										class="form-control" >
								</div>
								<button class="btn signin" type="submit">Login</button>
								<div class="remember-me">
									<input type="checkbox" class="checkbox"> <span
										class="check-label">Remember Me</span>
								</div>
								<a href="" class="forgot">Forgot Password</a>
							</form>
							<span class="separator">OR</span>
							<ul class="social-links">
								<li><a href=""><i class="fab fa-google"></i> Login with
										Google</a></li>
								<li><a href=""><i class="fab fa-facebook-f"></i> Login
										with Facebook</a></li>
							</ul>
							<span class="signup-link">Don't have an account? Sign up <a
								href="">here</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>