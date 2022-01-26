<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

  <!-- Search Wrapper Area Start -->
    <div class="search-wrapper section-padding-100">
        <div class="search-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-content">
                        <form action="search" method="get">
                            <input type="search" name="txt" id="search" placeholder="Type your keyword...">
                            <button type="submit"><img src="<c:url value="/template/img/core-img/search.png" />" alt="?txt="></button>
                        </form>
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
                <a href="<c:url value="/template/view/cart.jsp" />"><img src="<c:url value="/template/img/core-img/logo.png" />" alt=""></a>
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
                <a href="<c:url value="home" />"><img src="<c:url value="/template/img/core-img/logo.png" />" alt=""></a>
            </div>
            <!-- Amado Nav -->
            <nav class="amado-nav">
                <ul>
                    <li  class="active"><a href="<c:url value="home" />">Home</a></li>
                    <li><a href="<c:url value="shop" />">Shop</a></li>
                    <li><a href="<c:url value="/template/view/product-details.jsp" />">Product</a></li>
                    <li><a href="<c:url value="/template/view/cart.jsp" />">Cart</a></li>
                    <li><a href="<c:url value="/template/view/checkout.jsp" />">Checkout</a></li>
                </ul>
            </nav>
            <!-- Button Group -->
            <div class="amado-btn-group mt-30 mb-100">
                <a href="#" class="btn amado-btn mb-15">%Discount%</a>
                <a href="#" class="btn amado-btn active">New this week</a>
            </div>
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
                <a href="<c:url value="/template/view/cart.jsp" />" class="cart-nav"><img src="<c:url value="/template/img/core-img/cart.png" />" alt=""> Cart <span>(0)</span></a>
                <a href="#" class="fav-nav"><img src="<c:url value="/template/img/core-img/favorites.png" />" alt=""> Favourite</a>
                <a href="#" class="search-nav"><img src="<c:url value="/template/img/core-img/search.png" />" alt=""> Search</a>
            </div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
           
        </header>
          
        <!-- Header Area End -->
