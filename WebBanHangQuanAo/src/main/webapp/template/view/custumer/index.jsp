<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<script>
	"use strict";

	!function() {
		var t = window.driftt = window.drift = window.driftt || [];
		if (!t.init) {
			if (t.invoked)
				return void (window.console && console.error && console
						.error("Drift snippet included twice."));
			t.invoked = !0, t.methods = [ "identify", "config", "track",
					"reset", "debug", "show", "ping", "page", "hide", "off",
					"on" ], t.factory = function(e) {
				return function() {
					var n = Array.prototype.slice.call(arguments);
					return n.unshift(e), t.push(n), t;
				};
			}, t.methods.forEach(function(e) {
				t[e] = t.factory(e);
			}), t.load = function(t) {
				var e = 3e5, n = Math.ceil(new Date() / e) * e, o = document
						.createElement("script");
				o.type = "text/javascript", o.async = !0,
						o.crossorigin = "anonymous",
						o.src = "https://js.driftt.com/include/" + n + "/" + t
								+ ".js";
				var i = document.getElementsByTagName("script")[0];
				i.parentNode.insertBefore(o, i);
			};
		}
	}();
	drift.SNIPPET_VERSION = '0.3.1';
	drift.load('4uevyecddz8x');
</script>
<!-- End of Async Drift Code -->
<!-- Start of Async Drift Code -->
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Amado - Furniture Ecommerce Template | Home</title>

<!-- Favicon  -->
<link rel="icon"
	href="<c:url value="/template/img/core-img/favicon.ico" />">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<!-- Core Style CSS -->
<link rel="stylesheet"
	href="<c:url value="/template/css/font-awesome.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/template/css/core-style.css" /> ">
 <link rel="stylesheet" href="<c:url value="/template/css/font-awesome.css"/> ">
</head>

<body>
	<!-- Search Wrapper Area Start -->

	<%@ include file="header.jsp"%>

	<!-- Header Area End -->

	<!-- Product Catagories Area Start -->
	<div class="products-catagories-area clearfix">

		<div class="amado-pro-catagory clearfix">
			<c:forEach items="${listProduct}" var="c">
				<!-- Single Catagory -->
				<div class="single-products-catagory clearfix">
					<a
						href="<c:url value="/details/${c.productName}?idProduct=${c.productID}" />">
						<img src="<c:url value="${c.imageLink}" />" alt="${c.productName}">
						<!-- Hover Content -->
						<div class="hover-content">
							<div class="line"></div>
							<p>From $${c.price}</p>
							<h4>${c.productName}</h4>
						</div>
					</a>
				</div>

			</c:forEach>
		</div>

	</div>
	<!-- Product Catagories Area End -->
	</div>


	<!-- ##### Main Content Wrapper End ##### -->
	<!-- ##### Newsletter Area Start ##### -->

	<%@ include file="footer.jsp"%>

	<!-- ##### Footer Area End ##### -->

	<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
	<script src="<c:url value="/template/js/jquery/jquery-2.2.4.min.js" />"></script>
	<!-- Popper js -->
	<script src="<c:url value="/template/js/popper.min.js" />"></script>
	<!-- Bootstrap js -->
	<script src="<c:url value="/template/js/bootstrap.min.js" />"></script>
	<!-- Plugins js -->
	<script src="<c:url value="/template/js/plugins.js" />"></script>
	<!-- Active js -->
	<script src="<c:url value="/template/js/active.js" />"></script>
	<script src="<c:url value="/template/js/script.js" />"></script>
	<script src="<c:url value="/template/js/suggestions.js" />"></script>

</body>

</html>