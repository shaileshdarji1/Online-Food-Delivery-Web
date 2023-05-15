<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,viewport-fit=cover">
    <title>Food Website</title>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
    <%@ include file = "header.jsp" %>
    <div class="container" id="container">
        <%@ include file = "sidebar.jsp" %>
        <table class="styled-table" id="table">
                  <thead>
                   <tr>
                    <th>Id</th>
                    <th>Quantity</th>
                    <th>Item Id</th>
                    <th>User Id</th>
                    <th>Action</th>
                    </tr>
                   </thead>
                  <tbody id="table-body">

                  </tbody>
                 </table>
    </div>
    <script src="/js/cart.js" type="module"></script>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</body>
</html>
