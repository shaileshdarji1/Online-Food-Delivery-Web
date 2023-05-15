<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Category</title>

    <!-- Montserrat Font -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/css/admin.css">
     <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  </head>
  <body>
    <div class="grid-container">
       <%@ include file = "admin-sidebar.jsp" %>
      <!-- Main -->
     <div class="container main-container">
       <div class="row">
       <div class="col-md-4 offset-md-4">
       <form action="/admin/add_category" method="POST" enctype="multipart/form-data">
         <div class="form-group">
           <label for="menuName">Menu Name</label>
           <input type="text" class="form-control" name="name" id="menu-name" placeholder="Enter Menu name">
         </div>
          <div class="form-group">
             <label for="exampleFormControlFile1">Menu Image</label>
             <input type="file" class="form-control-file" id="exampleFormControlFile1" name="image">
           </div>
         <div class="form-check">
           <input type="checkbox" class="form-check-input" id="exampleCheck1" name="active" value="true">
           <label class="form-check-label" for="exampleCheck1">isActive</label>
         </div>
         <button type="submit" class="btn btn-primary">Submit</button>
       </form>
       <div><h4 style="color:green">${success}</h4></div>
       <div><h4 style="color:red">${error}</h4></div>
       </div>
       </div>
       <div class="row m-2">
        <table class="styled-table" id="table">
         <thead>
          <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Image</th>
           <th>isActive</th>
           <th>Action</th>
           </tr>
          </thead>
         <tbody id="table-body">

         </tbody>
        </table>
       </div>
       <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
           <div class="modal-content">
             <div class="modal-header">
               <h5 class="modal-title" id="modal_title">Modal title</h5>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                 <span aria-hidden="true">&times;</span>
               </button>
             </div>
             <div class="modal-body" id="modal_body">

             </div>
             <div class="modal-footer" id="modal-footer">


             </div>
           </div>
         </div>
       </div>
     </div>
    </div>

    <!-- Scripts -->
    <!-- Custom JS -->
    <script src="/js/admin.js"></script>
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <script src="/js/admincategory.js"></script>
  </body>
</html>