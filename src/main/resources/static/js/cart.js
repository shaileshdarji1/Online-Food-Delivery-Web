$(document).ready(function () {
    console.log("Ready");
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/cart/usercart', true);

    xhr.send()

    xhr.onload = () => {
        if (xhr.status === 200) {
            let data = xhr.responseText;
            var cartItems = JSON.parse(data);
            console.log(cartItems);
            displayCart(cartItems);
            summary(cartItems);
        }
    }

});

    let displayCart = (data) => {
        var food = document.getElementById('user-cart');
        var newDiv = document.createElement('div');
        let htmlTemplate = '';
        for (let item of data) {
            htmlTemplate += '<div class="row mb-4 d-flex justify-content-between align-items-center"><div class="col-md-2 col-lg-2 col-xl-2">' +
                '<img src="/image/item/' + item.item.imageUrl + '" class="img-fluid rounded-3">' +
                '</div>' +
                '<div class="col-md-3 col-lg-3 col-xl-3">' +
                '<h6 class="text-muted">' + item.item.category.name + '</h6>' +
                '<h6 class="text-black mb-0">' + item.item.name + '</h6>' +
                '</div>' +
                '<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">' +
                '<h6 class="mb-0">&#8377;' + item.item.price + '</h6>' +
                '</div>' +
                 '<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">' +
                                '<h6 class="mb-0">Quantity:' + item.quantity + '</h6>' +
                                '</div>' +
                '<div class="col-md-1 col-lg-1 col-xl-1 text-end">' +
                '<a id="'+item.cartId+'" class="text-muted"><i class="fas fa-times"></i></a>' +
                '</div>' +
                '</div>' +
                '<hr class="my-4">';
        }
        newDiv.innerHTML = htmlTemplate;
        food.appendChild(newDiv);
    }

let summary = (data) => {
         var totalPrice=0;
        var food = document.getElementById('summary');
        var newDiv = document.createElement('div');
        let htmlTemplate = '';
        for (let item of data) {
            var priceitem =item.quantity*item.item.price;
            totalPrice = totalPrice+priceitem;
            htmlTemplate += '<div class="d-flex justify-content-between mb-4">'+
                                                               '<h5>'+item.item.name+'</h5>'+
                                                               '<h5>'+priceitem+'</h5>'+
                                                             '</div>';
        }
        newDiv.innerHTML = htmlTemplate;
        food.appendChild(newDiv);
        document.getElementById('total-price-cart').innerHTML=totalPrice;
    }

