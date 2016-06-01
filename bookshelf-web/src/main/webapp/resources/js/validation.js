$("#registr_form").validate({

    rules: {

        user: {
            required: true,
            minlength: 4,
            maxlength: 16,
            regx: /^[A-Za-z0-9_-]{4,16}$/
        },

        email: {
            required: true,
            email: true
        },

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
        },

        password1: {
            required: true,
            minlength: 3,
            maxlength: 16,
            regx: /^[A-Za-z0-9_-]{3,16}$/
        },

        password2: {
            required: true,
            equalTo: "#pswrd"
        }

    },

    messages: {

        user: {
            required: "Это поле обязательно для заполнения",
            minlength: "Логин должен содержать минимум 4 символа",
            maxlength: "Логин должен содержать максимум 16 символов",
            regx: "Логин может содержать только буквы латинского алфавита, цифры, дефис и нижнее подчеркивание"
        },

        email: {
            required: "Это поле обязательно для заполнения",
            email: "E-mail введен в неверном формате"
        },

        name: {
            required: "Это поле обязательно для заполнения",
            email: "Неверный формат"
        },

        surname: {
            required: "Это поле обязательно для заполнения",
            email: "Неверный формат"
        },

        city: {
            required: "Это поле обязательно для заполнения",
            email: "Неверный формат"
        },

        password1: {
            required: "Это поле обязательно для заполнения",
            minlength: "Пароль должен содержать минимум 3 символа",
            maxlength: "Пароль должен содержать максимум 16 символов",
            regx: "Пароль может содержать только буквы латинского алфавита, цифры, дефис и нижнее подчеркивание"
        },

        password2: {
            required: "Это поле обязательно для заполнения",
            equalTo: "Пароли не совпадают"
        }

    }

});


$.validator.addMethod("regx", function(value, element, regexpr) {
    return regexpr.test(value);
}, "Please enter a valid pasword.");