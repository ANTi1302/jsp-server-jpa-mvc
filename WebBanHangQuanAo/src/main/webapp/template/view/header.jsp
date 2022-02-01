<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iuh.fit.controller.SearchController"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<c:url value="/template/css/position.css" />">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<!-- Search Wrapper Area Start -->
<div class="search-wrapper section-padding-100">
	<div class="search-close">
		<i class="fa fa-close" aria-hidden="true"></i>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="search-content">
					<div class="dropdown">
						<form action="search" method="get">
							<!-- 							<input type="text" name="txt" class="search-txt" -->
							<%-- 								value="${tenS}"  --%>
							<!-- 								placeholder="Tìm sản phẩm, thương hiệu, và tên shop ..."> -->
							<!-- 							<button type="submit"> -->
							<%-- 								<img src="<c:url value="/template/img/core-img/search.png" />" --%>
							<!-- 									alt="?txt="> -->
							<!-- 							</button> -->
							<!-- 														<div class="dropdown-list"> -->
							<!-- 															<div class="dropdown-item"> -->
							<!-- 																<a href="">Figma</a> -->
							<!-- 															</div> -->
							<!-- 															<div class="dropdown-item"> -->
							<!-- 																<a href="">Figma</a> -->
							<!-- 															</div> -->
							<!-- 															<div class="dropdown-item"> -->
							<!-- 																<a href="">Figma</a> -->
							<!-- 															</div> -->
							<!-- 														</div> -->

							<div class="search-input">
								<a href="" target="_blank" hidden></a> <input type="text"
									name="txt" class="search-txt" value="${tenS}"
									placeholder="Type to search..">
								<div class="autocom-box">
									<li>Chanel</li>
									<li>Chanel</li>
									<li>Chanel</li>
									<li>Chanel</li>
								</div>
								<div class="icon">
									<i class="fas fa-search"></i>
								</div>
								<div class="dropdown-list">
									<c:forEach items="history">
										<!-- 								<div class="dropdown-item">					 -->
										<%-- 									<a href="">${theItem}</a> --%>
										<!-- 								</div> -->

										<%
										List<String> items = (List<String>) request.getSession().getAttribute("history");
										if (items == null) {
											items = new ArrayList<String>();
											request.getSession().setAttribute("history", items);
										}
										// getParameter tra ve String (todo-demo.jsp?theItem=? thi add ?)
										String theItem = request.getParameter("txt");
										if (theItem != null) {
											items.add(theItem);
										}
										for (String temp : items)
											out.println("<div class='dropdown-item'><a href='search?txt="+temp+"'>	" + temp + "</a></div>");
										%>
									</c:forEach>

								</div>
							</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- Search Wrapper Area End -->

<!-- ##### Main Content Wrapper Start ##### -->
<div class="main-content-wrapper d-flex clearfix">

	<!-- Mobile Nav (max width 767px)-->
	<div class="mobile-nav">
		<!-- Navbar Brand -->
		<div class="amado-navbar-brand">
			<a href="<c:url value="/template/view/cart.jsp" />"><img
				src="<c:url value="/template/img/core-img/logo.png" />" alt=""></a>
		</div>
		<!-- Navbar Toggler -->
		<div class="amado-navbar-toggler">
			<span></span><span></span><span></span>
		</div>
	</div>

	<!-- Header Area Start -->
	<header class="header-area clearfix">
		<!-- Close Icon -->
		<div class="nav-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<!-- Logo -->
		<div class="logo">
			<a href="<c:url value="/home" />"><img
				src="<c:url value="/template/img/core-img/logo.png" />" alt=""></a>
		</div>
		<!-- Amado Nav -->
		<nav class="amado-nav">
			<ul>
				<c:if test="${sessionScope.acc != null}">
					<li><a href="<c:url value="#" />">${sessionScope.acc.username}</a></li>
				</c:if>
				<li class="active"><a href="<c:url value="/home" />">Home</a></li>
				<li><a href="<c:url value="/shop" />">Shop</a></li>
				<c:if test="${sessionScope.acc == null}">
					<li><a href="<c:url value="/template/view/login.jsp" />">Login</a></li>
				</c:if>
				<c:if test="${sessionScope.acc != null}">
					<li><a href="<c:url value="/logout" />">Logout</a></li>
				</c:if>
				<li><a href="<c:url value="/print" />">Cart</a></li>
				<li><a href="<c:url value="/template/view/checkout.jsp" />">Checkout</a></li>
			</ul>
		</nav>
		<!-- Button Group -->
		<div class="amado-btn-group mt-30 mb-100">
			<a href="#" class="btn amado-btn mb-15">%Discount%</a> <a href="#"
				class="btn amado-btn active">New this week</a>
		</div>
		<!-- Cart Menu -->
		<div class="cart-fav-search mb-100">
			<a href="<c:url value="/print" />" class="cart-nav"><img
				src="<c:url value="/template/img/core-img/cart.png" />" alt="">
				Cart <span>(0)</span></a> <a href="#" class="fav-nav"><img
				src="<c:url value="/template/img/core-img/favorites.png" />" alt="">
				Favourite</a> <a href="#" class="search-nav"><img
				src="<c:url value="/template/img/core-img/search.png" />" alt="">
				Search</a>
		</div>
		<!-- Social Button -->
		<div class="social-info d-flex justify-content-between">
			<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
		</div>

	</header>
	<!-- Header Area End -->