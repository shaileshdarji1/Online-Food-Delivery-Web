$( document ).ready(function() {
    console.log( "ready!" );
    getCartProduct();
});

function getCartProduct(){
let xhr = new XMLHttpRequest();
    xhr.open('GET','http://localhost:8080/cart/',true);

    xhr.send()

    xhr.onload=()=>{
     if(xhr.status===200){
     let data =xhr.responseText;
     cartData = JSON.parse(data);
     displayDataHead(cartData);
     }
    }
    let displayDataHead =(data)=>{
     var table = document.getElementById('table-body');
    let htmlTemplate ='';
    for(let item of data){
    htmlTemplate +='<tr><td>'+item.cartId+'</td><td>'+item.quantity+'</td><td>'+
                    item.item.itemId+'</td><td>'+item.user.userId+'</td><td><button id="'+
                    item.cartId+'" type="button" class="btnedit btn btn-success" data-toggle="modal" data-target="#exampleModal">Edit</button>&nbsp;<button type="button" id="'+
                    item.cartId+'" class="btndelete btn btn-danger">Delete</button></td></tr>';
    }
    table.innerHTML=htmlTemplate;
}

}