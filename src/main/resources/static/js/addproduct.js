$(function(){
    // เขียนเหตุการณ์กดปุ่ม submit
    $('button#submit').click(function(){
        // รับค่าจากฟอร์ม
        var product_name = $('input#product_name').val();
        var product_price = $('input#product_price').val();
        var product_qty = $('input#product_qty').val();
        var product_image = $('input#product_image').val();
        var product_status = $('input#product_status').val();

        // alert(product_name+'\n'+
        // product_price+'\n'+
        // product_qty+'\n'+
        // product_image+'\n'+
        // product_status);

        // ส่งข้อมูลไปที่ API ผ่าน AJAX
        $.ajax({
            type: "POST",
            url: "http://localhost:9090/api/products",
            data: JSON.stringify({
                "productName":product_name,
                "productPrice":product_price,
                "productQty":product_qty,
                "productImage":product_image,
                "productStatus":product_status
            }),
            dataType: "json",
            headers: {
                "Content-Type": "application/json"
            },
            success: function (response) {
                // alert(JSON.stringify(response));
                // ปิด popup
                $('#modalAdd').modal('hide');
                // โหลดข้อมูลในตาราง
                readProduct();
            }
        });
    });
});