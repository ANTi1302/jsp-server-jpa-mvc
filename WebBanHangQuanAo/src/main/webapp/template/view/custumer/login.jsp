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
								</form>
								<a href="" class="forgot">Forgot Password</a> <span
									class="separator">OR</span>
								<ul class="social-links">
									<li><a href="" id="mySignin" onclick="login()"><i class="fab fa-google"></i> Login
											with Google</a></li>
									<fb:login-button scope="public_profile,email"
										onlogin="checkLoginState();">
									</fb:login-button>
								</ul>
								<span class="signup-link">Don't have an account? Sign up
									<a href="">here</a>
								</span>
								<div id="status"></div>
							
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
	
	 <script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      }
    </script>
 <script type="text/javascript">
        function login() 
        {
          var myParams = {
            'clientid' : '1058431666102-onqbil7jmmg6nu5kn9j3rcl6kru538da.apps.googleusercontent.com',
            'cookiepolicy' : 'single_host_origin',
            'callback' : 'loginCallback',
            'approvalprompt':'force',
            'scope' : 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read'
          };
          gapi.auth.signIn(myParams);
        }

        function loginCallback(result)
        {
            if(result['status']['signed_in'])
            {
                var request = gapi.client.plus.people.get(
                {
                    'userId': 'me'
                });
                request.execute(function (resp)
                {
                     console.log(resp.emails[0].value); 
                   console.log( resp.displayName); 
                     console.log(resp.name.givenName); 
                     console.log(resp.image.url); 
                     console.log(resp.ageRange.max); 
                    console.log(resp.id);
                    console.log(resp.etag);
                    console.log(resp);
                    if(resp!=null){
                    window.location.href = 'Login?action=Google&name='+resp.name.givenName+'&email='+resp.emails[0].value+'&id='+resp.id+'&fullName='+ resp.displayName+'&image='+resp.image.url+'&age='+resp.ageRange.max+'&etag='+resp.etag;
                    }
                    var email = '';
                    if(resp['emails'])
                    {
                        for(i = 0; i < resp['emails'].length; i++)
                        {
                            if(resp['emails'][i]['type'] == 'account')
                            {
                                email = resp['emails'][i]['value'];//here is required email id
                            }
                        }
                    }
                   var usersname = resp['displayName'];//required name
                });
            }
        }
        function onLoadCallback()
        {
            gapi.client.setApiKey('AIzaSyAugrM0yLLyoXkNTJJ-WpZe5NtrWvMCqTA');
            gapi.client.load('plus', 'v1',function(){});
        }

            </script>

        <script type="text/javascript">
              (function() {
               var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
               po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
               var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
             })();
        </script>

</body>
</html>