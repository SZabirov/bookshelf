/**
 * Created by aygulmardanova on 01.06.16.
 */

correctLogin = function () {
    var login = $("#login").val();
    if (login != '') {
        var pattern = /^[a-zA-Z][a-zA-Z0-9-_\.]{3,20}$/i;
        $.ajax({
            type: 'POST',
            url: "/ajax/checkLogin",
            data: {"nickname": login},
            dataType: "text",
            async: false,
            success: function (response_data) {
                if (response_data == 'true') {
                    $("#login").css({'border': '1px solid black'});
                    $("#login_valid").html("Логин занят");
                } else {
                    if (pattern.test(login)) {
                        $('#login').css({'border': '1px solid #569b44'});
                        $('#login_valid').text('');
                    } else if (login.length < 4) {
                        $('#login').css({'border': '1px solid black'});
                        $('#login_valid').text('Длина логина должна быть > 3');
                    } else if (login.length > 20) {
                        $('#login').css({'border': '1px solid black'});
                        $('#login_valid').text('Длина логина должна быть < 20');
                    } else {
                        $('#login').css({'border': '1px solid black'});
                        $('#login_valid').text('Неверный формат');
                    }
                }
            }
        });
    } else {
        $('#login').css({'border': '1px solid black'});
        $('#login_valid').text('Это поле обязательно для заполнения');
    }
}

correctPass = function () {
    var pass = $("#pass").val();
    var pattern = /^[a-zA-Z0-9]{5,20}$/i;
    if (pass != '') {
        if (pattern.test(pass)) {
            $('#pass').css({'border': '1px solid #569b44'});
            $('#correct').text('');
        } else if (pass.length < 5) {
            $('#pass').css({'border': '1px solid black'});
            $('#correct').text('Длина пароля должна быть > 4');
        } else if (pass.length > 20) {
            $('#pass').css({'border': '1px solid black'});
            $('#correct').text('Длина пароля должна быть < 20');
        } else {
            $('#pass').css({'border': '1px solid black'});
            $('#correct').text('Неверный формат');
        }
    } else {
        $('#pass').css({'border': '1px solid black'});
        $('#correct').text('Это поле обязательно для заполнения');
    }
}

correctRepeat = function () {
    var pass1 = $("#pass").val();
    var pass2 = $("#pass_repeat").val();
    if (pass2 != '') {
        if (pass1 != pass2) {
            $('#pass_repeat').css({'border': '1px solid black'});
            $('#info').text('Пароль повторен неверно');
        } else {
            $('#pass_repeat').css({'border': '1px solid #569b44'});
            $('#info').text('');
        }
    } else {
        $('#pass_repeat').css({'border': '1px solid black'});
        $('#info').text('Повторите пароль');
    }
}

correctEmail = function () {

    var email = $("#email").val();
    if (email != '') {
        var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
        $.ajax({
            type: 'POST',
            url: "/ajax/checkEmail",
            data: {"email": email},
            dataType: "text",
            async: false,
            success: function (response_data) {
                if (response_data == 'true') {
                    $("#email").css({'border': '1px solid black'});
                    $("#valid").html("Email занят");
                } else {
                    if (pattern.test(email)) {
                        $('#email').css({'border': '1px solid #569b44'});
                        $('#valid').text('');
                    } else {
                        $('#email').css({'border': '1px solid black'});
                        $('#valid').text('Неверный email');
                    }
                }
            }
        });
    } else {
        $('#email').css({'border': '1px solid black'});
        $('#valid').text('Это поле обязательно для заполнения');
    }
}

correctPhone = function () {
    var phone = $("#phone").val();
    if (phone != '') {
        var pattern = /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/i;
        if (pattern.test(phone)) {
            $('#phone').css({'border': '1px solid #569b44'});
            $('#phone_valid').text('');
        } else {
            $('#phone').css({'border': '1px solid black'});
            $('#phone_valid').text('Incorrect phone number');
        }
    } else {
        $('#phone').css({'border': '1px solid black'});
        $('#phone_valid').text('Phone number should not be empty');
    }
}