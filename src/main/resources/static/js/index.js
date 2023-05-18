 const incrementBtns = document.querySelectorAll('.increment');
    const decrementBtns = document.querySelectorAll('.decrement');
    const quantityInputs = document.querySelectorAll('input[type="number"]');

    incrementBtns.forEach((incrementBtn, index) => {
      incrementBtn.addEventListener('click', () => {
        quantityInputs[index].stepUp();
      });
    });

    decrementBtns.forEach((decrementBtn, index) => {
      decrementBtn.addEventListener('click', () => {
        quantityInputs[index].stepDown();
      });
    });

$( document ).ready(function() {
    $('.add-cart-button').click(function() {
           var index = $('.add-cart-button').index($(this));
           var itemName = $('.card-title').eq(index).text();
           var itemId = this.id;
           var quantity = parseInt($('.card-quantity input').eq(index).val());
           const data = {
              "itemId":itemId,
              "quantity":quantity
           }
           let xhr = new XMLHttpRequest();
                   xhr.open('POST','http://localhost:8080/cart/add_cart/'+this.id+'/'+quantity,true);
                   xhr.send()
           alert('Added ' + quantity + ' ' + itemName + '(s) to the cart.');
           location.reload();
          })


});
