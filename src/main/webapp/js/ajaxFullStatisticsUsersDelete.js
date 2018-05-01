(function($) {
    $(document).ready(function() {
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
                        window.location.replace(window.location.href = '//' + window.location.host + '/WebSiteGame/fullreport/all');
                        break;
                    case 'send':
                        window.location.replace(window.location.href = '//' + window.location.host + '/WebSiteGame/info');
                        break;
                    case 'block':
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