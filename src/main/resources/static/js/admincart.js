var categoryData;
$(document).ready(function () {
    console.log("ready!");
    getCart();
});


function getCart() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/cart/', true);

    xhr.send()

    xhr.onload = () => {
        if (xhr.status === 200) {
            let data = xhr.responseText;
            cartData = JSON.parse(data);
            displayDataHead(cartData)
        }
    }
    let displayDataHead = (data) => {
        var table = document.getElementById('table-body');
        let htmlTemplate = '';
        for (let item of data) {
            htmlTemplate += '<tr><td>' + item.cartId + '</td><td>' + item.user.userId + '</td>' +
            '<td>'+item.user.username+'</td>'+
            '<td>'+item.item.name+'</td>'+
            '<td>'+item.item.category.name+'</td>'+
            '<td>'+item.item.price+'</td>'+
            '<td>'+item.quantity+'</td>'+
            '</tr>';
        }
        table.innerHTML = htmlTemplate;
    }
}
