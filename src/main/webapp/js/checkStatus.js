(function ($) {
    $(document).ready(function(word){
        if(word === "ON"){
            $('.status').css('color', 'darkgreen');
        }else{
            $('.status').css('color', 'red');
        }
    });
})(window.jQuery);