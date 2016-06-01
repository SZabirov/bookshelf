<!DOCTYPE HTML>
<html>
<head>
    <title>Bookshelf</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <script src="/resources/css/ie/html5shiv.js"></script>
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/jquery.dropotron.min.js"></script>
    <script src="/resources/js/skel.min.js"></script>
    <script src="/resources/js/skel-layers.min.js"></script>
    <script src="/resources/js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="/resources/css/skel.css" />
        <link rel="stylesheet" href="/resources/css/style.css" />
    </noscript>
    <link rel="stylesheet" href="/resources/css/ie/v8.css" />
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
            </ul>
        </nav>

    </div>
</div>

<!-- Main -->
<div id="main" class="wrapper style1">
    <form action='/j_spring_security_check' method='POST' class='form1'>
        <#if error??>
            <span class="error_text">Неверный логин или пароль</span>
        </#if>
        <input type='text' name='j_username' class='loginform' placeholder='Логин'><br />
        <input type='password' name='j_password' class='loginform'  placeholder='Пароль'><br />
        <div class='chb'><input type='checkbox' name='chb1'/><label for='chb1'><span></span>
            <small class='small-text'>Запомнить меня</small></label></div>
        <input type='submit' value='Войти' class='submit-button'>
    </form>
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
                                <li><a href="http://kpfu.ru/itis">Высшая школа информационных технологий и информационных систем</a></li>
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
                            <span>ул. Кремлевская 35, <br />аудитория 1509</span>
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
    $(document).ready(function() {
        $(".username").focus(function() {
            $(".user-icon").css("left","-48px");
        });
        $(".username").blur(function() {
            $(".user-icon").css("left","0px");
        });

        $(".password").focus(function() {
            $(".pass-icon").css("left","-48px");
        });
        $(".password").blur(function() {
            $(".pass-icon").css("left","0px");
        });
    });
</script>

</body>
</html>