<%@ include file="header.jsp" %>

    <ul class="nav navbar-nav navbar-right">
    <!--  drop down menu -->
     <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#">My Account</a></li>
        <li><a href="#">My Orders</a></li>
        <li><a href="#">Settings</a></li>
        <li><a href="home">Sign Out</a></li>        
       </ul>
       </li>
       <li><a href="#"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a></li>
      </ul>       
    </div>
    </div>
   <BR>
<div>
    <ul class="nav navbar-nav navbar-left">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#">Indoor Lightings</a></li>
        <li><a href="#">flat panel</a></li>
        <li><a href="#">surface panel</a></li>             
        <li><a href="#">external lunar</a></li>
        <li><a href="#">led strip</a></li>
        <li><a href="#">color changing led panel light</a></li>
        <li><a href="#">Outdoor Lightings</a></li>
        <li><a href="#">pathway</a></li>
        <li><a href="#">street & roadway</a></li>
        <li><a href="#">decorative street & roadway</a></li>
        <li><a href="#">parking structure</a></li>
        <li><a href="#">high mast</a></li>        
       </ul>
       </li>
  </ul>
  <ul>
   <li>
   <form class = "bs-example bs-example-form" role = "form">
      <div class = "row">
 <div class = "col-lg-6">
            <div class = "input-group">
               <input type = "text" class = "form-control">
               
               <span class = "input-group-btn">
                  <button class = "btn btn-default" type = "button">
                     Go!
                  </button>
               </span>
               
            </div><!-- /input-group -->
         </div><!-- /.col-lg-6 -->
              </div><!-- /.row -->
   </form>
   

</li>
  </ul>  
</div>
</nav>

<div align="center">
        <h2>Welcome ${sessionScope.welcomeMsg}!</h2>
    </div>

<div id="myCarousel" class="carousel slide">
<ol class="carousel-indicators">
 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
 <li data-target="#myCarousel" data-slide-to="1"></li>
 <li data-target="#myCarousel" data-slide-to="2"></li>
</ol>

<div class="carousel-inner">
 <div class ="item">
 <img src="4.jpg" alt="4"  class="img-responsive">
 <div class="carousel-caption"><h3>Offers</h3></div>
  </div>
  
 <div class ="item active">
 <img src="5.jpg" alt="5"  class="img-responsive">
 <div class="carousel-caption"><h3>Offers</h3></div>
  </div>
 
 <div class ="item">
 <img src="6.jpg" alt="6"  class="img-responsive">
 <div class="carousel-caption"><h3>Offers</h3></div>
  </div>   
</div>

<a class="carousel-control left" href="#myCarousel" data-slide="prev">
<span class="icon-prev"></span>
</a>

<a class="carousel-control right" href="#myCarousel" data-slide="next">
<span class="icon-next"></span>
</a>

</div>
<br><br>



<center>
<div class="container">
   <a href="#"><img src="1.jpg" class="img-circle" width="230" height="230"></a>
  <a href="#"><img src="2.jpg" class="img-circle" width="230" height="230"></a>
  <a href="#"><img src="3.jpg" class="img-circle" width="230" height="230"></a>
</div>
</center>


<!-- 
<div id="wrapper">
 sidebar
   <div id="sidebar-wrapper">
     <ul class="sidebar-nav">
       <li a href="#">Account</a></li>
       <li a href="#">Settings</a></li>
       <li a href="#">LogOut</a></li>  
      </ul>   
   </div>


  page content 
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <div class="row">
          <div class="column-lg-12">
          <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
       <a href="#" class="btn btn-success" id="menu-toggle">Categories</a> 
        <h1>Sidebar menu</h1>
        <p>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
         </div>
        </div>         
      </div>  
    </div>
 </div>   

 jQuery 
    <script src="js/jquery.js"></script>

     Bootstrap Core JavaScript
    <script src="js/bootstrap.min.js"></script>

<script>
  $("#menu-toggle").click(function (e){
	  e.preventDefault();
	  $("#wrapper").toggleClass("toggled");
  })
</script> -->



<%@ include file="footer.jsp" %>