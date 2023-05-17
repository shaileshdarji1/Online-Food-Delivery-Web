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
                '<img class="card-img-top" src="/image/item/'+item.imageUrl+'" alt="Card image cap">'+
                '<div class="card-body">'+
                    '<h5 class="card-title">'+item.name+'</h5>'+
                    '<p class="card-text">'+item.description+'</p>'+
                    '<a href="#" class="btn btn-primary">Add Cart</a>'+
                '</div>'+
            '</div>';
        food.appendChild(newDiv);
        }

        }

}

