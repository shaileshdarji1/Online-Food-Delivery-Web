var categoryData;
$(document).ready(function () {
    console.log("ready!");
    getCart();
});


function getCart() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/orders/', true);

    xhr.send()

    xhr.onload = () => {
        if (xhr.status === 200) {
            let data = xhr.responseText;
            orderData = JSON.parse(data);
            displayDataHead(orderData)
        }
    }
    let displayDataHead = (data) => {
        var table = document.getElementById('table-body');
        let htmlTemplate = '';
        for (let item of data) {
            htmlTemplate += '<tr><td>' + item.orderId + '<td>'+item.orderName+'</td></td><td>' + item.user.userId + '</td>' +
            '<td>'+item.user.username+'</td>'+

            '<td>'+item.item.category.name+'</td>'+
            '<td>'+item.totalAmount+'</td>'+
            '<td>'+item.quantity+'</td>'+
            '</tr>';
        }
        table.innerHTML = htmlTemplate;
    }
}