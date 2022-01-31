<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Product Details</title>

  <!-- Favicon  -->
   <link rel="icon" href="<c:url value="/template/img/core-img/favicon.ico" />">

    <!-- Core Style CSS -->
 	<link rel="stylesheet" href="<c:url value="/template/css/font-awesome.min.css" />" >
    <link rel="stylesheet" href="<c:url value="/template/css/core-style.css" /> ">
<link rel="stylesheet"
	href="<c:url value="/template/css/position.css" />">

</head>

<body>
    <!-- Search Wrapper Area Start -->
       <%@ include file="header.jsp" %>
    <!-- Header Area End -->

        <!-- Product Details Area Start -->
        <div class="single-product-area section-padding-100 clearfix">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mt-50">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Furniture</a></li>
                                <li class="breadcrumb-item"><a href="caterogy?txtC=${dsProductChiTiet.categoryID.catogoryID}">${dsProductChiTiet.categoryID.catogoryName}</a></li>
                                <li class="breadcrumb-item active" aria-current="page">${dsProductChiTiet.productName}</li>
                            </ol>
                        </nav>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-lg-7">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(<c:url value="/template/img/product-img/pro-big-1.jpg" />);">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(<c:url value="/template/img/product-img/pro-big-2.jpg" />);">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(<c:url value="/template/img/product-img/pro-big-3.jpg" />);">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="3" style="background-image: url(<c:url value="/template/img/product-img/pro-big-4.jpg" />);">
                                    </li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="gallery_img" href="<c:url value="/template/img/product-img/pro-big-1.jpg" />">
                                            <img class="d-block w-100" src="<c:url value="/template/img/product-img/pro-big-1.jpg" />" alt="First slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="<c:url value="/template/img/product-img/pro-big-2.jpg" />">
                                            <img class="d-block w-100" src="<c:url value="/template/img/product-img/pro-big-2.jpg" />" alt="Second slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="<c:url value="/template/img/product-img/pro-big-3.jpg" />">
                                            <img class="d-block w-100" src="<c:url value="/template/img/product-img/pro-big-3.jpg" />" alt="Third slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="<c:url value="/template/img/product-img/pro-big-4.jpg" />">
                                            <img class="d-block w-100" src="<c:url value="/template/img/product-img/pro-big-4.jpg" />" alt="Fourth slide">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-5">
                        <div class="single_product_desc">
                            <!-- Product Meta Data -->
                            
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price">$${dsProductChiTiet.price}</p>
                                <a href="<c:url value="/template/view/product-details.jsp" />">
                                    <h6>${dsProductChiTiet.productName}</h6>
                                </a>
                                <!-- Ratings & Review -->
                                <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                    <div class="ratings">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="review">
                                        <a href="#">Write A Review</a>
                                    </div>
                                </div>
                                <!-- Avaiable -->
                                <p class="avaibility"><i class="fa fa-circle"></i> In Stock</p>
                            </div>

                            <div class="short_overview my-5">
                                <p>${dsProductChiTiet.description}</p>
                            </div>
				
                            <!-- Add to Cart Form -->
                            <form class="cart clearfix" method="post">
                                <div class="cart-btn d-flex mb-50">
                                    <p>Qty</p>
                                    <div class="quantity">
                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( ${dsProductChiTiet.amount} ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-caret-down" aria-hidden="true"></i></span>
                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="${dsProductChiTiet.amount}" name="quantity" value="1">
                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-caret-up" aria-hidden="true"></i></span>
                                    </div>
                                </div>
                                <button type="submit" name="addtocart" value="id" class="btn amado-btn">Add to cart</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Product Details Area End -->
    </div>
    <!-- ##### Main Content Wrapper End ##### -->
    <!-- ##### Newsletter Area Start ##### -->
       <%@ include file="footer.jsp" %>
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