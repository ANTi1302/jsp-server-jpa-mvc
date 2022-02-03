$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	// Animate select box length
	var searchInput = $(".search-box input");
	var inputGroup = $(".search-box .input-group");
	var boxWidth = inputGroup.width();
	searchInput.focus(function(){
		inputGroup.animate({
			width: "300"
		});
	}).blur(function(){
		inputGroup.animate({
			width: boxWidth
		});
	});
});
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("table td:last-child").html();
    // Append table with add row form on add new button click
    $(".add-new").click(function () {
        $(this).attr("disabled", "disabled");
        var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><input type="text" class="form-control" name="name" id="name" placeholder="Nhập Tên"></td>' +
            '<td><input type="text" class="form-control" name="gioitinh" id="gioitinh" placeholder="Nhập Giới Tính"></td>' +
            '<td><input type="text" class="form-control" name="namsinh" id="namsinh" value="" placeholder="Nhập Ngày Sinh"></td>' +
            '<td><input type="text" class="form-control" name="diachi" id="diachi" value="" placeholder="Nhập Địa Chỉ"></td>' +
            '<td><input type="phone" class="form-control" name="SoDienThoai" id="SoDienThoai" value="" placeholder="Nhập sđt"></td>' +
            '<td><input type="text" class="form-control" name="chucvu" id="chucvu" value="" placeholder="Nhập Chức Vụ"></td>' +
            '<td>' + actions + '</td>' +
            '</tr>';
        $("table").append(row);
        $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
    //Lọc Table
    function sortTable() {
        var table, rows, switching, i, x, y, shouldSwitch;
        table = document.getElementById("myTable");
        switching = true;
        while (switching) {
            switching = false;
            rows = table.rows;
            for (i = 1; i < (rows.length - 1); i++) {
                shouldSwitch = false;
                x = rows[i].getElementsByTagName("TD")[0];
                y = rows[i + 1].getElementsByTagName("TD")[0];
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
            if (shouldSwitch) {
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                swal("Thành Công!", "Bạn Đã Lọc Thành Công", "success");
            }
        }
    }
    //Add Hàng
    $(document).on("click", ".add", function () {
        var empty = false;
        var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function () {
            if (!$(this).val()) {
                $(this).addClass("error");
                swal("Thông Báo!", "Dữ Liệu Trống Vui Lòng Kiểm Tra", "error");
                empty = true;
            } else {
                $(this).removeClass("error");
                swal("Thông Báo!", "Bạn Chưa Nhập Dữ Liệu", "error");
            }
        });
        $(this).parents("tr").find(".error").first().focus();
        if (!empty) {
            input.each(function () {
                $(this).parent("td").html($(this).val());
                swal("Thành Công", "Bạn Đã Cập Nhật Thành Công", "success");
            });
            $(this).parents("tr").find(".add, .edit").toggle();
            $(".add-new").removeAttr("disabled");

        }
    });
    // Edit Hàng
    $(document).on("click", ".edit", function () {
        $(this).parents("tr").find("td:not(:last-child)").each(function () {
            $(this).html('<input type="text" class="form-control" value="' + $(this)
                .text() + '">');
        });
        $(this).parents("tr").find(".add, .edit").toggle();
        $(".add-new").attr("disabled", "disabled");
    });
    jQuery(function () {
        jQuery(".add").click(function () {
            swal("Thành Công!", "Bạn Đã Sửa Thành Công", "success");
        });
    });
    // Delete Hàng
    $(document).on("click", ".delete", function () {
        $(this).parents("tr").remove();
        swal("Thành Công!", "Bạn Đã Xóa Thành Công", "success");
        $(".add-new").removeAttr("disabled");
    });
});

jQuery(function () {
    jQuery(".cog").click(function () {
        swal("Sorry!", "Tính Năng Này Chưa Có", "error");
    });
});
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("table td:last-child").html();
    // Append table with add row form on add new button click
    $(".add-new").click(function () {
        $(this).attr("disabled", "disabled");
        var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><input type="text" class="form-control" name="name" id="name" placeholder="Nhập Tên"></td>' +
            '<td><input type="text" class="form-control" name="gioitinh" id="gioitinh" placeholder="Nhập Giới Tính"></td>' +
            '<td><input type="text" class="form-control" name="namsinh" id="namsinh" value="" placeholder="Nhập Ngày Sinh"></td>' +
            '<td><input type="text" class="form-control" name="diachi" id="diachi" value="" placeholder="Nhập Địa Chỉ"></td>' +
            '<td><input type="phone" class="form-control" name="SoDienThoai" id="SoDienThoai" value="" placeholder="Nhập sđt"></td>' +
            '<td><input type="text" class="form-control" name="chucvu" id="chucvu" value="" placeholder="Nhập Chức Vụ"></td>' +
            '<td>' + actions + '</td>' +
            '</tr>';
        $("table").append(row);
        $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
    //Add Hàng
    $(document).on("click", ".add", function () {
        var empty = false;
        var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function () {
            if (!$(this).val()) {
                $(this).addClass("error");
                swal("Thông Báo!", "Dữ Liệu Trống Vui Lòng Kiểm Tra", "error");
                empty = true;
            } else {
                $(this).removeClass("error");
                swal("Thông Báo!", "Bạn Chưa Nhập Dữ Liệu", "error");
            }
        });
        $(this).parents("tr").find(".error").first().focus();
        if (!empty) {
            input.each(function () {
                $(this).parent("td").html($(this).val());
                swal("Thành Công", "Bạn Đã Cập Nhật Thành Công", "success");
            });
            $(this).parents("tr").find(".add, .edit").toggle();
            $(".add-new").removeAttr("disabled");

        }
    });
    // Edit Hàng
    $(document).on("click", ".edit", function () {
        $(this).parents("tr").find("td:not(:last-child)").each(function () {
            $(this).html('<input type="text" class="form-control" value="' + $(this)
                .text() + '">');
        });
        $(this).parents("tr").find(".add, .edit").toggle();
        $(".add-new").attr("disabled", "disabled");
    });
    jQuery(function () {
        jQuery(".add").click(function () {
            swal("Thành Công!", "Bạn Đã Sửa Thành Công", "success");
        });
    });
    // Delete Hàng
    $(document).on("click", ".delete", function () {
        $(this).parents("tr").remove();
        swal("Thành Công!", "Bạn Đã Xóa Thành Công", "success");
        $(".add-new").removeAttr("disabled");
    });
});

jQuery(function () {
    jQuery(".cog").click(function () {
        swal("Sorry!", "Tính Năng Này Chưa Có", "error");
    });
});