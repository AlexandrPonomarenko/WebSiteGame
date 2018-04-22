(function($) {
    $(document).ready(function() {
        // $('.btn_del').click(function() {
        //     var data = {
        //         "id": $($(this).parent()).attr('data-user-id'),
        //         "bname": "delete"
        //     };
        // });

        function send(data, callback) {
            $.ajax({
                type: 'POST',
                data: data,
                url: 'fullreport',
                success: function(result) {
                    callback(result);
                }
            });
        }

        $('.action').click(function() {
            var parent = $($(this).parent());
            var action = $(this).attr('data-action');
            var data = {
                "id": parent.attr('data-user-id'),
                "bname": action
            };
            // var data = {};
            // $($('.form').find('input')).each(function (index, input) {
            //     data[$(input).attr('name')] = $(input).val();
            // });

            // data[$('.btn_del').attr('name')] = $('button.btn_del').val();
            // data[$('#del').attr('name')] = $('input#del').val();

            // console.log(data);
            // $.ajax({
            //     type: 'POST',
            //     data: data,
            //     url: 'fullreport',
            //     success: function(result) {
            //         console.log(result + "------------------------------------------");
            //         $('#open').html(result);
            //         $('#m').modal('show');
            //         setTimeout(function () {
            //             $('#m').modal('hide');
            //         }, 3000);
            //
            //         parent.remove();
            //     }
            // });

            send(data, function(result) {
                switch(action) {
                    case 'delete':
                        parent.fadeOut(1000, function () {
                            parent.remove();
                            $('#open').html(result);
                            $('#m').modal('show');
                            setTimeout(function () {
                                $('#m').modal('hide');
                            }, 3000);
                        });
                        break;
                    case 'more':
                        console.log('more');
                        window.location.replace("http://localhost:8080/WebSiteGame/fullreport/all");
                        break;
                    case 'send':
                        console.log('send');
                        window.location.replace("http://localhost:8080/WebSiteGame/info");
                        break;
                    case 'block':
                        console.log('block');
                        $('#open').html(result);
                        $('#m').modal('show');
                        setTimeout(function () {
                            $('#m').modal('hide');
                        }, 3000);
                        break;
                }
            });
        });
    });
})(window.jQuery);