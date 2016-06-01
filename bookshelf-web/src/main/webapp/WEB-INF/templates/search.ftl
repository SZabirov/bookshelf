<!DOCTYPE HTML>
<!--
	Horizons by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
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
                <li><a href="/profile">Мой профиль</a></li>
                <li><a href="/user/requests">Предложения</a></li>
                <li><a href="/user/settings">Настройки</a></li>
                <li><a href="/search">Поиск</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </nav>

    </div>
</div>

<!-- Main -->
<div id="main" class="wrapper style1">
    <form action="/search_results" method="GET" class="searchform">
        <input type='text' name='author_name' class='searchfield' placeholder='Имя автора' required><br />
        <input type='text' name='author_surname' class='searchfield' placeholder='Фамилия автора' required><br />
        <input type='text' name='bookname' class='searchfield' placeholder='Название книги' required><br />
        <input type='submit' value='Поиск' class='submit-button search-button'>
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
                        <!-- <span class="byline">Quisque semper augue mattis wisi maecenas ligula</span> -->
                    </header>
                    <div class="row">
                        <section class="6u">
                            <ul class="default">
                                <li><a href="http://kpfu.ru">Казанский (Приволжский) федеральный университет</a></li>
                                <li><a href="http://kpfu.ru/itis">Высшая школа информационных технологий и информационных систем</a></li>
                                <li><a href="http://www.fujitsu.com/global">Лаборатория Fujitsu Java</a></li>
                                <!-- <li><a href="#">Cras vitae metus aliquam  pharetra.</a></li> -->
                            </ul>
                        </section>
                    </div>
                </section>
            </div>
            <div class="4u">
                <section>
                    <header class="major">
                        <h2>Контакты</h2>
                        <!-- <span class="byline">Mattis wisi maecenas ligula</span> -->
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
            <!-- Design: <a href="http://templated.co">TEMPLATED</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>) -->
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