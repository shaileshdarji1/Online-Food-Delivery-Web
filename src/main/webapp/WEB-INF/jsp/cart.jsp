<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,viewport-fit=cover">
  <title>Cart</title>
  <link rel="stylesheet" href="/css/index.css">
  <link rel="stylesheet" href="/css/cart.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
  <%@ include file="header.jsp" %>
    <div class="container1" id="container1">
      <%@ include file="sidebar.jsp" %>
        <div id="food-container">
          <div class="d-food-items">
            <div class="container">
              <section class="h-100 h-custom" style="background-color: #fff;">
                <div class="container py-5 h-100">
                  <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                      <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                        <div class="card-body p-0">
                          <div class="row g-0">
                            <div class="col-lg-8">
                              <div class="p-5" id="user-cart">
                                <div class="d-flex justify-content-between align-items-center mb-5">
                                  <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                </div>
                                <hr class="my-4">
                              </div>
                            </div>
                            <div class="col-lg-4 bg-grey">
                              <div class="p-5">
                                <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                <hr class="my-4">
                                <div id="summary">
                                </div>
                                <div class="d-flex justify-content-between mb-5">
                                  <h5 class="text-uppercase">Total price</h5>
                                  <h5 id="total-price-cart">0</h5>
                                </div>
                                <button type="button" class="btn btn-block btn-lg" data-mdb-ripple-color="dark"
                                  style="background:#32be8f;color:white;" onclick="placedOrder()">Place Order</button>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </section>
            </div>
          </div>
        </div>

        <div id="cart">
          <div id="category-list">
            <p class="item-menu">Go For Hunt</p>
            <div class="border"></div>
          </div>
        </div>
    </div>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"></script>
    <script src="/js/cart.js" defer></script>

</body>

</html>