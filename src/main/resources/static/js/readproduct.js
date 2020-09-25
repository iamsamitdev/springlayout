function readProduct(){
    $.getJSON("http://localhost:9090/api/products", function (data) {
    // console.log(data);
    // กำหนดตัวแปรไว้เก็บโครงสร้างตาราง
    var trString = "";
    // var row = $('table tbody tr').length;
    var row = 1;
    $.each(data,function(key,val){
        trString += `<tr>
                    <td>${row}</td>
                    <td><img src="${val.productImage}" height="45"></td>
                    <td>${val.productName}</td>
                    <td>${val.productPrice}</td>
                    <td>${val.productQty}</td>
                    <td>${val.productStatus}</td>
                    <td style="width: 160px;">
                        <a href="#" data-toggle="modal" data-target="#modalEdit" class="btn btn-warning">Edit</a>
                        <a href="#delete" class="btn btn-danger" data-id="${val.id}" id="btnDelete">Delete</a>
                    </td>
                </tr>`
        row = row + 1;
        }); 
        $('table#tbproduct tbody').html(trString);     
    });
}

$(function(){
    readProduct();

    // Delete Product
    $('body').on('click','a#btnDelete',function(){
        var pid = $(this).attr('data-id');
        // alert(pid);
        $.ajax({
            method:"DELETE",
            url: "http://localhost:9090/api/product/"+pid,
            success: function (response) {
                //alert(response);
                // อ่านข้อมูลใหม่ที่เหลือ
                readProduct();
            }
        });
    });

});