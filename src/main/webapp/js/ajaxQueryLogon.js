(function($) {
    function validateFormAut() {
        var valid = true;
        if ($('#n').val() === "" && $('#n').val().length < 3) {
            $('#nickName').html("to be > 2 char and no empty");
            valid = false;
        }

        if ($('#p').val() === "" && $('#p').val().length < 5) {
            $('#password').html("to be > 4 char and no empty");
            valid = false;
        }

        return valid;
    }
    $(document).ready(function() {
        $('.btn.btn-outline-danger.btn-lg').click(function() {
            var data = {};

            if (!validateFormAut()) { return; }

            $($('.form').find('input')).each(function (index, input) {
                data[$(input).attr('name')] = $(input).val();
            });
            $.ajax({
                type: 'POST',
                data: data,
                url: 'logon',
                success: function(result) {
                    clearSpan();

                    var isJSON;
                    try {
                        isJSON = true;
                        result = $.parseJSON(result);
                    } catch(e) {
                        isJSON = false;
                    }
                    if(isJSON){
                        $('#nickName').html(result.nickName);
                        $('#password').html(result.password);
                        $('.form-control').val('');
                    }else if (result !== "redirect") {
                        $('#open').html(result);
                        $('#m').modal('show');
                        setTimeout(function () {
                            $('#m').modal('hide');
                        }, 3000);
                        $('#n').val('');
                        $('#p').val('');
                    }else {
                        window.location.replace(window.location.href = '//' + window.location.host + '/WebSiteGame/home');
                    }
                }
            });
        });
    });
})(window.jQuery);

function clearSpan() {
    $('#nickName').html("");
    $('#password').html("");
}