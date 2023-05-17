// A $( document ).ready() block.
var itempath="target/classes/static/image/item/";
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
    htmlTemplate +='<div id="'+item.name+'"><p id="category-name">'+item.name+'</p></div>';
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
        var itemCard= document.createElement('div');
                         itemCard.setAttribute('id','item-card')

                         var cardTop= document.createElement('div');
                         cardTop.setAttribute('id','card-top');

                         var img= document.createElement('img');
                         img.src="/image/item/"+item.imageUrl;

                         var itemName= document.createElement('p');
                         itemName.setAttribute('id','item-name');
                         itemName.innerText= item.name;

                         var itemPrice= document.createElement('p');
                         itemPrice.setAttribute('id','item-price');
                         itemPrice.innerText= 'Price :' + item.price;

                         itemCard.appendChild(cardTop);
                         itemCard.appendChild(img);
                         itemCard.appendChild(itemName);
                         itemCard.appendChild(itemPrice);

                         food.appendChild(itemCard);
        }

        }

}

