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
    <%@ include file = "header.jsp" %>
    <div class="container" id="container">
        <%@ include file = "sidebar.jsp" %>
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
      </div>
    <script src="/js/index.js" type="module"></script>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</body>
</html>
