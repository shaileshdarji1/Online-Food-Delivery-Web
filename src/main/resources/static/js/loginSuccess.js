// A $( document ).ready() block.
$( document ).ready(function() {
    console.log( "ready!" );
    getCategory();
    getItem();
});


function getCategory(){
let xhr = new XMLHttpRequest();
    xhr.open('GET','http://localhost:8080/category/',true);

    xhr.send()

    xhr.onload=()=>{
     if(xhr.status===200){
     let data =xhr.responseText;
     categoryData = JSON.parse(data);
     displayDataHead(categoryData)
     }
    }
    let displayDataHead =(data)=>{
     var food = document.getElementById('food-items');
    let htmlTemplate ='';
    for(let item of data){
    htmlTemplate +='<div><p id="category-name">'+item.name+'</p></div><div class="row" id="'+item.name+'"></div>';
    }
    food.innerHTML=htmlTemplate;
}
}

function getItem(){
let xhr = new XMLHttpRequest();
    xhr.open('GET','http://localhost:8080/item/items',true);

    xhr.send()

    xhr.onload=()=>{
     if(xhr.status===200){
     let data =xhr.responseText;
     itemData = JSON.parse(data);
     displayItem(itemData)
     }
    }
     let displayItem =(data)=>{

        for(let item of data){
        var food = document.getElementById(item.category.name);
        // Create a new div element to hold the code
        var newDiv = document.createElement('div');
        newDiv.className = 'col-md-3 mt-3';

        // Set the innerHTML of the new div with the provided code
        newDiv.innerHTML = '<div class="card" style="width: 15rem;">'+
                '<img class="card-img-top" src="/image/item/'+item.imageUrl+'" width="180px" height="200px" style="overflow: hidden;"alt="Card image cap">'+
                '<div class="card-body">'+
                    '<h4 class="card-title">'+item.name+'</h4>'+
                    '<p class="card-text">'+item.description+'</p>'+
                     '<div class="add-cart-price"><h6 class="card-subtitle mt-1 text-muted">&#8377; '+item.price+'</h6>'+
                     '<div class="card-quantity">'+
                              '<button class="decrement">-</button>'+
                              '<input id="num" type="number" value="1" min="1" >'+
                              '<button class="increment">+</button>'+
                            '</div></div>'+
                    '<a href="#" class="btn btn-primary btn-block add-cart-button" id="'+item.itemId+'">Add Cart</a>'+
                '</div>'+
            '</div>';
        food.appendChild(newDiv);
        }
          var script = document.createElement('script');
            script.type = "text/javascript";
            script.src="/js/index.js"
            document.getElementsByTagName('head')[0].appendChild(script);
        }

//var quantityInput = document.querySelector('input[type="number"]');
//
//        addToCartBtn.addEventListener('click', () => {
//          const itemName = document.querySelector('.card-title').textContent;
//          const quantity = parseInt(quantityInput.value);
//          alert(`Added ${quantity} ${itemName}(s) to the cart.`);
//        });

}
