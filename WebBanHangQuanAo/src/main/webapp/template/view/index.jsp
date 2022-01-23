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
    <title>Amado - Furniture Ecommerce Template | Home</title>

    <!-- Favicon  -->
   <link rel="icon" href="<c:url value="/template/img/core-img/favicon.ico" />">

    <!-- Core Style CSS -->
 	<link rel="stylesheet" href="<c:url value="/template/css/font-awesome.min.css" />" >
    <link rel="stylesheet" href="<c:url value="/template/css/core-style.css" /> ">

</head>

<body>
    <!-- Search Wrapper Area Start -->
    
    <%@ include file="header.jsp" %>
    
    <!-- Header Area End -->

        <!-- Product Catagories Area Start -->
        <div class="products-catagories-area clearfix">
        
            <div class="amado-pro-catagory clearfix">
  				<c:forEach items="${listProduct}" var="c"> 
                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="<c:url value="/template/view/shop.jsp" />">
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

</body>

</html>