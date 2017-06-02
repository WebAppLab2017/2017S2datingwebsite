

<%@page import="java.util.List"%>
<%@page import="core.Product"%>
<%@page import="core.Initializer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>E-Shop</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-5">
<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>
	<div id="header">																																																																																																																																																																																																				<div class="inner_copy"><a href="http://ecommercebuilders.blogspot.com/">best ecommerce platforms & website builders</a></div>
		<a href="#" class="float"><img src="images/logo.jpg" alt="" width="171" height="73" /></a>																																																		
	  <div class="topblock1">
			Currency:<br /><select><option>US Dollar</option></select>
		</div>
	    <div class="topblock2">
			Lanquage:<br />
		    <a href="#"><img src="images/flag1.gif" alt="" width="19" height="11" /></a>																																		
		    <a href="#"><img src="images/flag2.gif" alt="" width="19" height="11" /></a>
		    <a href="#"><img src="images/flag3.gif" alt="" width="19" height="11" /></a>
		    <a href="#"><img src="images/flag4.gif" alt="" width="19" height="11" /></a>
		    <a href="#"><img src="images/flag5.gif" alt="" width="19" height="11" /></a>
		    <a href="#"><img src="images/flag6.gif" alt="" width="19" height="11" /></a>
		</div>
		<div class="topblock2">
			<img src="images/shopping.gif" alt="" width="24" height="24" class="shopping" />																																																																									
		 	<p>Shopping cart</p> <p><strong>0</strong> <span>items</span></p>
		</div>
		<ul id="menu">
			<li><img src="images/li.gif" alt="" width="19" height="29" /></li>
			<li><a href="#"><img src="images/but1_a.gif" alt="" width="90" height="29" /></a></li>
			<li><a href="#l"><img src="images/but2.gif" alt="" width="129" height="29" /></a></li>
			<li><a href="#"><img src="images/but3.gif" alt="" width="127" height="29" /></a></li>
			<li><a href="i#"><img src="images/but4.gif" alt="" width="113" height="29" /></a></li>
			<li><a href="#l"><img src="images/but5.gif" alt="" width="132" height="29" /></a></li>
			<li><a href="#"><img src="images/but6.gif" alt="" width="105" height="29" /></a></li>
			<li><a href="#"><img src="images/but7.gif" alt="" width="82" height="29" /></a></li>
			<li><a href="#"><img src="images/but8.gif" alt="" width="112" height="29" /></a></li>
			<li><a href="#"><img src="images/but9.gif" alt="" width="71" height="29" /></a></li>
		</ul>
	</div>
	
	<div id="container">																																																																																																																																																																																																																<div class="inner_copy"><a href="http://www.bestfreetemplates.info/builders.php">Top 10 Free Website Builders</a></div>																																																																																																																																																																										
	  <div id="center" class="column">
	  	
	  	<div id="content">

			<div class="stuff">
                            <%
                                List<Product> products = Initializer.getTablets();
                                
                                for (Product product : products) {
                            %>
				<div class="item">
					<img src="<%=product.getInfo()%>" alt="" width="124" height="90" />
					<a href="#" class="name"><%=product.getProductName()%></a>
                                        <span><%=product.getProductPrice()%></span>
					<a href="#"><img src="images/zoom.gif" alt="" width="53" height="19" /></a><a href="#"><img src="images/cart.gif" alt="" width="71" height="19" /></a>
				</div>
				<%}%>
			</div>
		</div>
	  </div>
	  <div id="left" class="column">
	  	<div class="block">
		<img src="images/title1.gif" alt="" width="168" height="42" /><br />
			<ul id="navigation">
				<li class="color"><a href="index.jsp">Mobile</a></li>
				<li><a href="laptop.jsp">Laptop</a></li>
				<li class="color"><a href="tablet.jsp">Tablet</a></li>
                                <li><a href="television.jsp">Television</a></li>
				<li class="color"><a href="#">Dolor sit amet</a></li>
				<li><a href="#">Lorem ipsum dolor</a></li>
				<li class="color"><a href="#">Dolor sit amet</a></li>
				<li><a href="#">Seddiam</a></li>
				<li class="color"><a href="#">Nonumy eirmod</a></li>
				<li><a href="#">Consetetur sadipscing</a></li>
				<li class="color"><a href="#">Lorem ipsum dolor</a></li>
				<li><a href="#">Nonumy eirmod</a></li>
				<li class="color"><a href="#">Dolor sit amet</a></li>
				<li><a href="#">Seddiam</a></li>
				<li class="color"><a href="#">Lorem ipsum dolor</a></li>
				<li><a href="#">Nonumy eirmod</a></li>
				<li class="color"><a href="#">Seddiam</a></li>
				<li><a href="#">Consetetur sadipscing</a></li>
				<li class="color"><a href="#">Nonumy eirmod</a></li>
				<li><a href="#">Dolor sit amet</a></li>
				<li class="color"><a href="#">Seddiam</a></li>
				<li><a href="#">Nonumy eirmod</a></li>
				<li class="color"><a href="#">Lorem ipsum dolor</a></li>
				<li><a href="#">Dolor sit amet</a></li>
				<li class="color"><a href="#">Seddiam</a></li>
			</ul>
		</div>
		<a href="#"><img src="images/banner1.jpg" alt="" width="172" height="200" /></a>
	  </div>
	  <div id="right" class="column">
	  	<a href="#"><img src="images/banner2.jpg" alt="" width="237" height="216" /></a><br />
		<div class="rightblock">
			<img src="images/title4.gif" alt="" width="223" height="29" /><br />
			<div class="blocks">
				<img src="images/top_bg.gif" alt="" width="218" height="12" />
				<form action="#">
					<p class="line"><span>Login:</span> <input type="text" /></p>
					<p class="line"><span>Password:</span> <input type="text" /></p>
					<p class="line center"><a href="#" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p>
					<p class="line center pad20"><a href="#"><img src="images/enter.gif" alt="" width="69" height="25" /></a></p>
				</form>
				<img src="images/bot_bg.gif" alt="" width="218" height="10" /><br />
			</div>
			<div class="blocks">
				<img src="images/top_bg.gif" alt="" width="218" height="12" />
				<div id="news">
					<img src="images/title5.gif" alt="" width="201" height="28" />
					<span class="date">23 november</span>
					<p>Dolor sit amet, consetetur sadipscing elitr, seddiam nonumy eirmod tempor. invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</p>
					<a href="#" class="more">read more</a>
				</div>
				<img src="images/bot_bg.gif" alt="" width="218" height="10" /><br />
			</div>
		</div>
	  </div>
	</div>
	

</body>
</html>
