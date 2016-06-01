$("#registr_form").validate({

    rules: {

        name: {
            required: true,
            regx: /^[A-Za-zА-яа-я- ]*$/
        },

        surname: {
            required: true,
            regx: /^[A-Za-zА-яа-я- ]*$/
        },

        city: {
            required: true,
            regx: /^[A-Za-zА-яа-я- ]*$/
        }

    },

    messages: {

        name: {
            required: "Это поле обязательно для заполнения",
            regx: "Неверный формат"
        },

        surname: {
            required: "Это поле обязательно для заполнения",
            regx: "Неверный формат"
        },

        city: {
            required: "Это поле обязательно для заполнения",
            regx: "Неверный формат"
        }

    }

});


$.validator.addMethod("regx", function(value, element, regexpr) {
    return regexpr.test(value);
});