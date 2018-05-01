(function($) {
    function validateFormHelp(form) {
        var valid = true;
        if ($('#nam').val() === "" && $('#nam').val().length < 3) {
            $('#nickName').html("to be > 2 char and no empty");
            valid = false;
        }

        if ($('#ema').val() === "" && $('#ema').val().length < 5) {
            $('#email').html("to be > 4 char and no empty");
            valid = false;
        }

        if ($('#comment').val() === "" && $('#comment').val().length < 15) {
            $('#txms').html("to be > 14 char and no empty");
            valid = false;
        }
        return valid;
    }
    $(document).ready(function() {
        $('.btn.btn-outline-danger.btn-lg').click(function() {
            var data = {};
            $($('form').find('input')).each(function (index, input) {
                data[$(input).attr('name')] = $(input).val();
            });

            if (!validateFormHelp('.form')) { return; }

            data[$('#comment').attr('name')] = $('textarea.form-control').val();
            $.ajax({
                type: 'POST',
                data: data,
                url: 'help',
                success: function(result) {
                    clearSpan();
                    var isJSON;
                    try {
                        isJSON = true;
                        result = $.parseJSON(result);

                    } catch(e) {
                        isJSON = false;
                    }
                    console.log(result);
                    if (isJSON) {
                        $('#nickName').html(result.nickName);
                        $('#email').html(result.email);
                        $('#txms').html(result.txms);
                        $('.form-control').val('');
                    } else {
                        $('#open').html(result);
                        $('#m').modal('show');
                        setTimeout(function () {
                            $('#m').modal('hide');
                        }, 3000);
                        $('.form-control').val('');
                    }
                }
            });
        });
    });
})(window.jQuery);

function clearSpan() {
    $('#nickName').html("");
    $('#email').html("");
    $('#txms').html("");
}