<header class="header">
        <div class="menu-icon" onclick="openSidebar()">
          <span class="material-icons-outlined">menu</span>
        </div>
        <div class="header-left">
          <span class="material-icons-outlined">search</span>
        </div>
        <div class="header-right">
          <span class="material-icons-outlined">notifications</span>
          <span class="material-icons-outlined">email</span>
          <span class="material-icons-outlined">account_circle</span>
        </div>
</header>

<aside id="sidebar">
        <div class="sidebar-title">
          <div class="sidebar-brand">
            <span class="material-icons-outlined">inventory</span>ONLINE FOOD DELIVERY
          </div>
          <span class="material-icons-outlined" onclick="closeSidebar()">close</span>
        </div>

        <ul class="sidebar-list">
          <li class="sidebar-list-item">
            <a href="http://localhost:8080/admin/dashboard">
              <span class="material-icons-outlined">dashboard</span> Dashboard
            </a>
          </li>
          <li class="sidebar-list-item">
            <a href="http://localhost:8080/admin/category">
              <span class="material-icons-outlined">inventory_2</span> Category
            </a>
          </li>
          <li class="sidebar-list-item">
            <a href="http://localhost:8080/admin/item">
              <span class="material-icons-outlined">fact_check</span> Item
            </a>
          </li>
          <li class="sidebar-list-item">
            <a href="#">
              <span class="material-icons-outlined">add_shopping_cart</span> Purchase Orders
            </a>
          </li>
          <li class="sidebar-list-item">
            <a href="#">
              <span class="material-icons-outlined">shopping_cart</span> Sales Orders
            </a>
          </li>
          <li class="sidebar-list-item">
            <a href="#">
              <span class="material-icons-outlined">poll</span> Reports
            </a>
          </li>
          <li class="sidebar-list-item">
            <a href="#">
              <span class="material-icons-outlined">settings</span> Settings
            </a>
          </li>
        </ul>
      </aside>