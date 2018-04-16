(function ($) {
    'use strict';

    var _Game = function () {
        this.container = $('<div>').addClass("con");
        this.wrapper = $('<div>').addClass("wrapper");
        this.buttons = [];
        this.initButtons();
        this.mark = '&';
    };

    $.extend(_Game.prototype, {
        createButton: function (id) {
            var self = this,
                b = $('<button>').attr('data-button-value', id);

                b.data('noEmpty', false);

            b.on('click', function (e) {
                self.setButtonValue(b.attr('data-button-value'), self.mark);
                $(self).trigger('button-event', { attr: b.attr('data-button-value'), button: b });
            });

            return b;
        },

        initButtons: function () {
            var self = this;

            $.each(["lt", "mt", "rt", "lm", "mm", "rm", "lb", "mb", "rb"], function (index, value) {
                var b = self.createButton(value);
                self.wrapper.append(b);
                self.buttons.push(b);
            });

            this.container.append(this.wrapper);
        },

        appendToContainer: function (gamePlace) {
            $(gamePlace).append(this.container);
        },

        setMark: function (mark) {
            this.mark = mark;
        },

        disableButton: function (button) {
            button.prop("disabled", true);
        },

        enableButton: function (button) {
            button.prop("disabled", false);
        },

        getButtonByType: function (type) {
            var i, result = null;

            for (i = 0; i < this.buttons.length;i++) {
                if (this.buttons[i].attr('data-button-value') === type) {
                    // console.log(type + " --- " + " ++++++++ " + this.buttons[i].attr('data-button-value') + this.mark + " -- " + this.buttons[i].button[0].innerHTML);
                    result = this.buttons[i];
                    break;
                }
            }

            return result;
        },

        setButtonValue: function (type, value) {
            var button = this.getButtonByType(type);
            console.log("COME IN setButtonValue " + button);
            if (button) {
                button.data('noEmpty', true);
                console.log("COME IN setButtonValue ----------------------- " + button.data('noEmpty') + value);
                // this.setColor(button);
                this.setDisableAll();
                button[0].innerHTML = value;
                this.setColors(button, value);
            }
        },

        setDisableAll: function() {
            for (var i = 0; i < this.buttons.length; i++) {
                this.disableButton(this.buttons[i]);
            }
        },

        setEnableAll: function() {
            for (var i = 0; i < this.buttons.length; i++) {
                if (!this.buttons[i].data('noEmpty')) {
                    this.enableButton(this.buttons[i]);
                }
            }
        },

        setColors: function(button, value){
                if(value === "x"){
                    button[0].style.background ="#CD5C5C";
                }else if(value === "o"){
                    button[0].style.background ="#1E90FF";
                }
        },

        getMark: function () {
            return this.mark;
        }

    });

    $(document).ready(function () {
        // $("#game").append(div);
        window.Game = new _Game();
        console.log(window.Game);
    });
})(window.jQuery);
