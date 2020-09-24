$(function(){
    $.getJSON("http://localhost:9090/api/products", function (data) {
        // console.log(data);
        // กำหนดตัวแปรไว้เก็บโครงสร้างตาราง
        var trString = "";
        $.each(data,function(key,val){
        trString += `<tr>
                        <td>${val.id}</td>
                        <td><img src="${val.productImage}" height="45"></td>
                        <td>${val.productName}</td>
                        <td>${val.productPrice}</td>
                        <td>${val.productQty}</td>
                        <td>${val.productStatus}</td>
                        <td style="width: 160px;">
                            <a href="#" data-toggle="modal" data-target="#modalEdit" class="btn btn-warning">Edit</a>
                            <a href="#" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>`
        }); 
        $('table#tbproduct tbody').append(trString);     
    });
});