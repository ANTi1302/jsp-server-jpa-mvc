<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>


<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Cart</title>
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

        <div class="cart-table-area section-padding-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="cart-title mt-50">
                            <h2>Shopping Cart</h2>
                        </div>

                        <div class="cart-table clearfix">
                            <table class="table table-responsive">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="o">
                                
                                <tr>
                                        <td class="cart_product_img">
                                            <a href="#"><img src="<c:url value="${o.imageLink}" />" alt="Product"></a>
                                        </td>
                                        <td class="cart_product_desc">
                                            <h5>${o.productName}</h5>
                                        </td>
                                        <td class="price">
                                            <span>$${o.price}</span>
                                        </td>
                                        <td class="qty">
                                            <div class="qty-btn d-flex">
                                                <p>Qty</p>
                                                <div class="quantity">
                                                    <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 0 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                                    <input type="number" class="qty-text" id="qty" step="1" min="0" max="300" name="quantity" value="1">
                                                    <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-12 col-lg-4">
                        <div class="cart-summary">
                            <h5>Cart Total</h5>
                            <ul class="summary-table">
                                <li><span>subtotal:</span> <span>${total}</span></li>
                                <li><span>delivery:</span> <span>Free</span></li>
                                <li><span>total:</span> <span>${sum}</span></li>
                            </ul>
                            <div class="cart-btn mt-100">
                                <a href="<c:url value="/template/view/cart.jsp" />" class="btn amado-btn w-100">Checkout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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