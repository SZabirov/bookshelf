<!DOCTYPE HTML>

<html>
<head>
    <title>Bookshelf</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <script src="/resources/css/ie/html5shiv.js"></script>
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/jquery.dropotron.min.js"></script>
    <script src="/resources/js/skel.min.js"></script>
    <script src="/resources/js/skel-layers.min.js"></script>
    <script src="/resources/js/init.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-1.5.2.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/resources/js/myscripts.js"></script>
    <noscript>
        <link rel="stylesheet" href="/resources/css/skel.css"/>
        <link rel="stylesheet" href="/resources/css/style.css"/>
    </noscript>
    <link rel="stylesheet" href="/resources/css/ie/v8.css"/>

    <script type="text/javascript" src="/resources/js/ajax_val.js"></script>
</head>
<body class="no-sidebar">

<!-- Header -->
<div id="header">
    <div class="container">

        <!-- Logo -->
        <h1><a href="#" id="logo">Bookshelf</a></h1>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li><a href="/">Главная</a></li>
                <li><a href="/login">Вход</a></li>
                <li><a href="/registration">Регистрация</a></li>
                <li><a href="/search">Поиск</a></li>
            </ul>
        </nav>

    </div>
</div>

<!-- Main -->
<div id="main" class="wrapper style1">
    <form id="registr_form" action='/registration' method='POST' class='form1'>
    <#if error??>
        <span class="error_text">Пользователь с таким логином уже существует</span>
    </#if>
        <input id="login" oninput="correctLogin()" type='text' name='user' class='loginform'
               placeholder='Придумайте логин' required>
        <p class="loginform" id="login_valid" style="margin-bottom: 0"></p><br/>
        <input id="email" oninput="correctEmail()" type='text' name='email' class='loginform' placeholder='Ваш e-mail'
               required>
        <p class="loginform" id="valid" style="margin-bottom: 0"></p><br/>
        <input type='text' name='name' class='loginform' placeholder='Имя' required><br/>
        <input type='text' name='surname' class='loginform' placeholder='Фамилия' required><br/>
        <input type='text' name='city' class='loginform' placeholder='Город' required><br/>
        <input id="pass" oninput="correctPass()" type='password' name='password1' class='loginform'
               placeholder='Придумайте пароль' required>
        <p class="loginform" id="correct" style="margin-bottom: 0"></p><br/>
        <input id="pass_repeat" oninput="correctRepeat()" type='password' name='password2' class='loginform'
               placeholder='Повторите пароль' required>
        <p class="loginform" id="info" style="margin-bottom: 0"></p><br/>
        <input type='submit' value='Регистрация' class='submit-button'>

    <#--<input type='text' name='user' class='loginform' placeholder='Придумайте логин' required><br />-->
    <#--<input type='text' name='email' class='loginform'  placeholder='Ваш e-mail' required><br />-->
    <#--<input type='text' name='name' class='loginform'  placeholder='Имя' required><br />-->
    <#--<input type='text' name='surname' class='loginform'  placeholder='Фамилия' required><br />-->
    <#--<input type='text' name='city' class='loginform'  placeholder='Город' required><br />-->
    <#--<input type='password' name='password1' class='loginform' id="pswrd" placeholder='Придумайте пароль' required><br />-->
    <#--<input type='password' name='password2' class='loginform'  placeholder='Повторите пароль' required><br />-->
    </form>
<#--<script type="text/javascript" src="/resources/js/validation.js"></script>-->
</div>

<!-- Footer -->
<div id="footer">
    <div class="container">

        <!-- Lists -->
        <div class="row">
            <div class="8u">
                <section>
                    <header class="major">
                        <h2>Партнеры</h2>
                    </header>
                    <div class="row">
                        <section class="6u">
                            <ul class="default">
                                <li><a href="http://kpfu.ru">Казанский (Приволжский) федеральный университет</a></li>
                                <li><a href="http://kpfu.ru/itis">Высшая школа информационных технологий и
                                    информационных систем</a></li>
                                <li><a href="http://www.fujitsu.com/global">Лаборатория Fujitsu Java</a></li>
                            </ul>
                        </section>
                    </div>
                </section>
            </div>
            <div class="4u">
                <section>
                    <header class="major">
                        <h2>Контакты</h2>
                    </header>
                    <ul class="contact">
                        <li>
                            <span class="address">Адрес</span>
                            <span>ул. Кремлевская 35, <br/>аудитория 1509</span>
                        </li>
                        <li>
                            <span class="mail">E-mail</span>
                            <span><a href="#">bookshelf@gmail.com</a></span>
                        </li>
                        <li>
                            <span class="phone">Телефон</span>
                            <span>(843) 123-456</span>
                        </li>
                    </ul>
                </section>
            </div>
        </div>

        <!-- Copyright -->
        <div class="copyright">
            Казань, 2016
        </div>

    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".username").focus(function () {
            $(".user-icon").css("left", "-48px");
        });
        $(".username").blur(function () {
            $(".user-icon").css("left", "0px");
        });

        $(".password").focus(function () {
            $(".pass-icon").css("left", "-48px");
        });
        $(".password").blur(function () {
            $(".pass-icon").css("left", "0px");
        });
    });
</script>

</body>
</html>