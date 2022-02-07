<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="<c:url value="/template/css/login.css" />">

<link rel="stylesheet"
	href="<c:url value="/template/css/bootstrap.min.css" />">


</head>
<body>
	<div class="form-bg">
		<div class="container">
			<div class="row">
				<div class=" ">
					<div class="form-container">
						<div class="left-content">
							<h3 class="title">Site Name</h3>
							<h4 class="sub-title">Lorem ipsum dolor sit amet.</h4>
						</div>
						<div class="right-content">
							<h3 class="form-title">Login</h3>

							<form class="form-horizontal" action="/WebBanHangQuanAo/login"
								method="post">
								<div class="form-group">
									<label>Username / Email</label> <input type="text"
										class="form-control" name="name">
								</div>
								<div class="form-group">
									<label>Password</label> <input type="password"
										class="form-control" name="pass">
								</div>
								<button class="btn signin" type="submit">Login</button>
								<div class="remember-me">
									<input type="checkbox" class="checkbox"> <span
										class="check-label">Remember Me</span>
								</div>
								<a href="" class="forgot">Forgot Password</a> <span
									class="separator">OR</span>
								<ul class="social-links">
									<li><a href=""><i class="fab fa-google"></i> Login
											with Google</a></li>
									<fb:login-button scope="public_profile,email"
										onlogin="checkLoginState();">
									</fb:login-button>
								</ul>
								<span class="signup-link">Don't have an account? Sign up
									<a href="">here</a>
								</span>
								<div id="status"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		function statusChangeCallback(response) {
			console.log('statusChangeCallback');
			console.log(response);
			if (response.status === 'connected') {
				testAPI();
			} else {
				document.getElementById('status').innerHTML = 'Please log '
						+ 'into this app.';
			}
		}

		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
			FB.api('/me', {
				fields : ' name, email, id'
			}, function(response) {
				console.log(response);
					    	 /*  window.location.href = '/WebBanHangQuanAo/login?name='+response.name+'&id='+response.id; */
					    	   window.location.href = '/WebBanHangQuanAo/login?name='+response.name+'&id='+response.id+'&email='+response.email;
// 					    	  USER-ID?fields=id,name,email,picture&access_token=ACCESS-TOKEN
// 				window.location.href = '/WebBanHangQuanAo/login?name='+response.name;
// 				window.location.href = '/WebBanHangQuanAo/login';
			});
		}

		window.fbAsyncInit = function() {
			FB.init({
				appId : '395679735650428',
				cookie : true,
				xfbml : true,
				version : 'v12.0'
			});

			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});

		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		function testAPI() {
			console.log('Welcome!  Fetching your information.... ');
			FB
					.api(
							'/me',
							function(response) {
								console.log('Successful login for: '
										+ response.name);
								document.getElementById('status').innerHTML = 'Thanks for logging in, '
										+ response.name + '!';
							});
		}
	</script>


</body>
</html>