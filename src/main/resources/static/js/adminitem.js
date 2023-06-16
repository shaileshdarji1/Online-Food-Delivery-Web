var categoryData;
var itemData;
$(document).ready(function () {
    console.log("ready!");
    getCategory();
    getItem();
});

$(document).on('click', '.btnedit', function () {
    var data = null;
        for (var i = 0, len = itemData.length; i < len; ++i) {
            var obj = itemData[i]
            if (obj.itemId == this.id) {
                data = obj;
                break;
            }
        }
    document.getElementById('modal_title').innerHTML = "Update Item";
    var modal = document.getElementById("modal_body");
    let selectoption = '';
    for (let item of categoryData) {
          selectoption += '<option value="' + item.categoryId + '">' + item.name + '</option>';
    }
    let htmlTemplate = '';
    htmlTemplate += '<form action="/admin/update_item" method="POST" enctype="multipart/form-data">'+
                                   '<div class="form-group">'+
                                     '<label for="itemName">Item Name</label>'+
                                     '<input type="text" class="form-control" name="name" id="menu-name" placeholder="Enter Item name" value="' + data.name + '">'+
                                   '</div>'+
                                   '<div class="form-group">'+
                                     '<label for="select">Choose Category:</label> <select class="form-control" id="select" name="categoryId">'+selectoption+
                                     '</select>'+
                                   '</div>'+
                                   '<div class="form-group">'+
                                     '<label for="exampleFormControlFile1">Item Image</label>'+
                                     '<input type="file" class="form-control-file" id="exampleFormControlFile1" name="imageUrl">'+
                                   '</div>'+
                                   '<div class="form-group">'+
                                     '<label for="price">Price</label>'+
                                     '<input class="form-control" type="text" id="price" placeholder="Enter Price" name="price" value="' + data.price + '">'+
                                   '</div>'+
                                   '<div class="form-group">'+
                                     '<label for="description">Description</label>'+
                                     '<input class="form-control" type="textarea" id="description" placeholder="Enter Description" name="description" value="' + data.description + '">'+
                                   '</div>'+
                                   '<div class="form-group">'+
                                      '<input type="hidden" name="itemId" value="'+data.itemId+'">'+
                                   '</div>'+
                                   '<button type="submit" class="btn btn-primary">Update</button>'+
                                 '</form>'

    modal.innerHTML = htmlTemplate;

});
$(document).on('click', '.btndelete', function () {
    console.log(this.id);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/item/delete/' + this.id, true);
    xhr.send()
    location.reload(true);
});
function getCategory() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/category/', true);

    xhr.send()

    xhr.onload = () => {
        if (xhr.status === 200) {
            let data = xhr.responseText;
            categoryData = JSON.parse(data);
            displayData(categoryData)
        }
    }
    let displayData = (data) => {
        var select = document.getElementById('select');
        let htmlTemplate = '<label for="category">Choose a category:</label>' +
            '<select id="category" name="category">';
        for (let item of data) {
            htmlTemplate += '<option value="' + item.categoryId + '">' + item.name + '</option>';
        }
        htmlTemplate += '</select>';
        select.innerHTML = htmlTemplate;
    }


}

function getItem() {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/item/items', true);

    xhr.send()

    xhr.onload = () => {
        if (xhr.status === 200) {
            let data = xhr.responseText;
            itemData = JSON.parse(data);
            displayDataHead(itemData)
        }
    }
    let displayDataHead = (data) => {
        var table = document.getElementById('table-body');
        let htmlTemplate = '';
        for (let item of data) {
            htmlTemplate += '<tr><td>' + item.itemId + '</td><td>' + item.category.categoryId + '</td><td>' +
                item.name + '</td><td>' + item.imageUrl + '</td><td>' + item.price + '</td>' +
                '<td>' + item.description + '</td>' +
                '<td><button id="' +
                item.itemId + '" type="button" class="btnedit btn btn-success" data-toggle="modal" data-target="#exampleModal">Edit</button>&nbsp;<button type="button" id="' +
                item.itemId + '" class="btndelete btn btn-danger">Delete</button></td></tr>';
        }
        table.innerHTML = htmlTemplate;
    }


}