(function ($) {
    $(document).ready(function() {
        if ($('#r').html() === "ON") {
            $('.status').css('color', 'darkgreen');
        } else {
            $('.status').css('color', 'red');
        }
    });
})(window.jQuery);