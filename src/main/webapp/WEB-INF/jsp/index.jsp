<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,viewport-fit=cover">
    <title>Food Website</title>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="/js/loginSuccess.js"></script>
</head>
<body>
    <div class="navbar">
        <div class="logo">
            <a href="#">Online Food Delivery</a>
        </div>
        <div class="nav_right">
            <ul>
                <li class="nr_li">
                    <i class="fa fa-shopping-cart"></i>
                </li>
                <li class="nr_li">
                    <i class="fa fa-shopping-bag"></i>
                </li>


                <li class="nr_li dd_main">
                    <img src="/image/user.png" alt="profile_img">

                    <div class="dd_menu">
                        <div class="dd_left">
                            <ul>
                                <li><i class="fas fa-map-marker-alt" ></i></li>
                                <li><i class="far fa-star"></i></li>
                                <li><i class="far fa-plus-square"></i></li>
                                <li><i class="fas fa-cog"></i></li>
                                <li><i class="fas fa-download"></i></li>
                                <li><i class="fas fa-sign-out-alt"></i></li>
                            </ul>
                        </div>
                        <div class="dd_right">
                            <ul>
                                <li>Location</li>
                                <li>Favorites</li>
                                <li>Addpeople</li>
                                <li>Settings</li>
                                <li>Downloads</li>
                                <li>Logout</li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="container" id="container">
        <div id="menu">
            <div class="menu-item">
                <a href="#">Homepage</a>
                <a href="#">Category</a>
                <a href="#">Your Orders</a>
                <a href="#">Wishlists</a>
                <a href="#">Cart</a>
                <a href="#">Contact</a>
                <a href="#">Checkout</a>
            </div>
        </div>

        <div id="food-container">

            <div id="food-items" class="d-food-items">
            </div>
        </div>

        <div id="cart">
            <div id="category-list">
                <p class="item-menu">Go For Hunt</p>
                <div class="border"></div>
            </div>
        </div>
    <script src="/js/index.js" type="module"></script>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</body>
</html>
