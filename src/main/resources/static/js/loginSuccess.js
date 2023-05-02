// A $( document ).ready() block.
$( document ).ready(function() {
    console.log( "ready!" );
    getCategory();
});

function getCategory(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET','http://localhost:8081/category/',true);

    xhr.send()

    xhr.onload=()=>{
     if(xhr.status===200){
     let data =xhr.responseText;
     categoryData = JSON.parse(data);
     displayDataHead(categoryData)
     }
    }
    let displayDataHead =(data)=>{
    console.log(data);
     var food = document.getElementById('food-items');
    let htmlTemplate ='';
    for(let item of data){
    htmlTemplate +='<div id="'+item.name+'"><p id="category-name">'+item.name+'</p></div>';
    }
    food.innerHTML=htmlTemplate;
//          var head = document.createElement('div');
//          head.setAttribute('id',${data.name}');
//          var paragraph = document.createElement('p');
//          paragraph.setAttribute('id','category-name');
//           paragraph.innerText=${data.name};
//          head.appendChild(paragraph);
//          food.appendChild(head);

     }
}
