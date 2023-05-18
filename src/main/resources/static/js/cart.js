$(document).ready(function() {
    let xhr = new XMLHttpRequest();
        xhr.open('GET','http://localhost:8080/cart/',true);

        xhr.send()

        xhr.onload=()=>{
         if(xhr.status===200){
         let data =xhr.responseText;
         var cartItems = JSON.parse(data);
         updateCart(cartItems);
         }
        }


      });

      function updateCart(cartItems) {
        $('#cart-items').empty();
               var totalPrice = 0;

               for (var i = 0; i < cartItems.length; i++) {
                 var data = cartItems[i];
                 var itemTotal = data.quantity * data.item.price;

                 var itemHTML = '<div class="cart-item">';
                 itemHTML += '<img src="/image/item/' + data.item.imageUrl + '" alt="Product Image">';
                 itemHTML += '<div class="cart-item-details">';
                 itemHTML += '<span class="cart-item-name">' + data.item.name + '</span>';
                 itemHTML += '<span class="cart-item-quantity">Quantity: ' + data.quantity + '</span>';
                 itemHTML += '<span class="cart-item-price">$' + itemTotal + '</span>';
                 itemHTML += '</div>';
                 itemHTML += '</div>';

                 $('#cart-items').append(itemHTML);
                 totalPrice += itemTotal;
               }

               $('#total-price').text('Total Price: $' + totalPrice);
        }



