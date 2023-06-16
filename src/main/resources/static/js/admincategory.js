var categoryData;
$(document).ready(function () {
    console.log("ready!");
    getCategory();
});

$(document).on('click', '.btnedit', function () {
    var data = null;
    for (var i = 0, len = categoryData.length; i < len; ++i) {
        var obj = categoryData[i]
        if (obj.categoryId == this.id) {
            data = obj;
            break;
        }
    }
    document.getElementById('modal_title').innerHTML = "Update Category";
    var modal = document.getElementById("modal_body");
    let htmlTemplate = '';
    htmlTemplate += '<form action="/admin/add_category" method="POST" enctype="multipart/form-data"><div class="form-group">' +
        '<span>Menu Name</span>' +
        '<input type="text" class="form-control" name="name" id="menu-name" placeholder="Enter Menu name" value="' + data.name + '">' +
        '</div>' +
        '<div class="form-group">' +
             '<span>Menu Image</span>' +
             '<input type="file" id="editimage" class="form-control-file" name="image">' +
        '<div class="form-group">'+
            '<input type="hidden"name="categoryId" value="'+data.categoryId+'">'+
        '</div>'+
        '<button type="submit" class="btn btn-primary">Update</button></form>'+
        '</div>';

    modal.innerHTML = htmlTemplate;

});
$(document).on('click', '.btndelete', function () {
    console.log(this.id);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/category/delete/' + this.id, true);
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
            displayDataHead(categoryData)
        }
    }
    let displayDataHead = (data) => {
        var table = document.getElementById('table-body');
        let htmlTemplate = '';
        for (let item of data) {
            htmlTemplate += '<tr><td>' + item.categoryId + '</td><td>' + item.name + '</td><td>' +
                item.imageUrl + '</td><td><button id="' +
                item.categoryId + '" type="button" class="btnedit btn btn-success" data-toggle="modal" data-target="#exampleModal">Edit</button>&nbsp;<button type="button" id="' +
                item.categoryId + '" class="btndelete btn btn-danger">Delete</button></td></tr>';
        }
        table.innerHTML = htmlTemplate;
    }
}
