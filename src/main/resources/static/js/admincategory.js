var categoryData;
$( document ).ready(function() {
    console.log( "ready!" );
    getCategory();
});

$(document).on('click', '.btnedit', function(){
    var data = categoryData[this.id-1];
    document.getElementById('modal_title').innerHTML="Update Category";
    var modal = document.getElementById("modal_body");

    let htmlTemplate ='';
        htmlTemplate +='<div class="form-group">'+
                                   '<span>Menu Name</span>'+
                                   '<input type="text" class="form-control" name="name" id="menu-name" placeholder="Enter Menu name" value="'+data.name+'">'+
                                 '</div>'+
                                  '<div class="form-group">'+
                                     '<span>Menu Image</span>'+
                                     '<input type="file" id="editimage" class="form-control-file" name="imageUrl">'+
                                   '</div>'+
                                 '<div class="form-check">'+
                                   '<input type="checkbox" id="checkbox1" class="form-check-input" name="active" value="true">'+
                                   '<span>isActive</span>'+
                                 '</div>';

        modal.innerHTML=htmlTemplate;
        if(data.active==true){
            $("#checkbox1").prop('checked', true);
            }
             var footer = document.getElementById("modal-footer");
                footer.innerHTML = '<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button><button type="button" class="btn btn-primary">Update</button>';
});
$(document).on('click', '.btndelete', function(){
console.log(this.id);
    let xhr = new XMLHttpRequest();
        xhr.open('POST','http://localhost:8080/category/delete/'+this.id,true);
        xhr.send()
        location.reload(true);
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
     var table = document.getElementById('table-body');
    let htmlTemplate ='';
    for(let item of data){
    htmlTemplate +='<tr><td>'+item.categoryId+'</td><td>'+item.name+'</td><td>'+
                    item.imageUrl+'</td><td>'+item.active+'</td><td><button id="'+
                    item.categoryId+'" type="button" class="btnedit btn btn-success" data-toggle="modal" data-target="#exampleModal">Edit</button>&nbsp;<button type="button" id="'+
                    item.categoryId+'" class="btndelete btn btn-danger">Delete</button></td></tr>';
    }
    table.innerHTML=htmlTemplate;
}


}
