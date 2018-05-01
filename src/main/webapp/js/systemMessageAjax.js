(function($) {
    function validateFormReg() {
        var valid = true;

        if ($('#n').val() === "" && $('#n').val().length < 3) {
            $('#nickName').html("to be > 2 char and no empty");
            valid = false;
        }

        if ($('#e').val() === "" && $('#e').val().length < 5) {
            $('#email').html("to be > 5 char and no empty");
            valid = false;
        }

        if ($('#f').val() === "" && $('#f').val().length < 5) {
            $('#fName').html("to be > 5 char and no empty");
            valid = false;
        }

        if ($('#l').val() === "" && $('#l').val().length < 5) {
            $('#lName').html("to be > 5 char and no empty");
            valid = false;
        }

        if ($('#p').val() === "" && $('#p').val().length < 6) {
            $('#password').html("to be > 6 char and no empty");
            valid = false;
        }

        if ($('#pt').val() === $('#p').val()) {
            $('#passwordTwo').html("to be equals");
            valid = false;
        }
        return valid;
    }

    $(document).ready(function() {
        $('.btn.btn-outline-danger.btn-lg').click(function() {

            if(!validateFormReg()){return;}
            var data = {};
            $($('.form').find('input')).each(function (index, input) {
                data[$(input).attr('name')] = $(input).val();
            });
            $.ajax({
                type: 'POST',
                data: data,
                url: 'login',
                success: function(result) {
                    clearSpan();
                    var isJSON;
                    try {
                        isJSON = true;
                        result = $.parseJSON(result);
                    } catch(e) {
                        console.log(e);
                        isJSON = false;
                    }
                    if(isJSON){
                        $('#nickName').html(result.nickName);
                        $('#email').html(result.email);
                        $('#fName').html(result.name);
                        $('#lName').html(result.name);
                        $('#password').html(result.password);
                        $('#passwordTwo').html(result.pas);
                        $('#txms').html(result.txms);
                        $('.form-control').val('');
                    }else if (result !== "redirect") {
                        $('#open').html(result);
                        $('#m').modal('show');
                        setTimeout(function () {
                            $('#m').modal('hide');
                        }, 3000);
                        $('#n').val('');
                        $('#e').val('');
                        $('#f').val('');
                        $('#l').val('');
                        $('#p').val('');
                        $('#pt').val('');
                    } else {
                        $('#open').html("Thank you for registration, pleas confirm you email address");
                        $('#m').modal('show');
                        setTimeout(function () {
                            $('#m').modal('hide');
                        }, 3000);
                        $('#n').val('');
                        $('#e').val('');
                        $('#f').val('');
                        $('#l').val('');
                        $('#p').val('');
                        $('#pt').val('');
                        window.location.href = '//' + window.location.host + '/WebSiteGame/logon';
                    }
                }
            });
        });
    });
})(window.jQuery);

function clearSpan() {
    $('#nickName').html("");
    $('#email').html("");
    $('#fName').html("");
    $('#lName').html("");
    $('#password').html("");
    $('#passwordTwo').html("");
    $('#txms').html("");
}