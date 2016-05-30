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
    <!--[if lte IE 8]><script src="/resources/css/ie/html5shiv.js"></script><![endif]-->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/jquery.dropotron.min.js"></script>
    <script src="/resources/js/skel.min.js"></script>
    <script src="/resources/js/skel-layers.min.js"></script>
    <script src="/resources/js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="/resources/css/skel.css" />
        <link rel="stylesheet" href="/resources/css/style.css" />
    </noscript>
    <!--[if lte IE 8]><link rel="stylesheet" href="/resources/css/ie/v8.css" /><![endif]-->
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
                <li><a href="#">Главная</a></li>
                <li><a href="/profile">Мой профиль</a></li>
                <li><a href="mybookshelf.html">Моя книжная полка</a></li>
                <li><a href="settings.html">Настройки</a></li>
                <li><a href="search.html">Поиск</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </nav>

    </div>
</div>

<!-- Main -->
<div id="main2" class="wrapper style1">
    <div class="profilepage">
        <img src="/resources/images/no_user_photo.png" class="profile_photo" />
        <div class="profile_information">
            <b>Имя:</b> Алексей <br/>
            <b>Фамилия:</b> Бархатов <br/>
            <b>Логин:</b> ${nickname}
        </div>
    </div>
    <div class="profilebooks">
        <div class="offerings">
            <h3>Могу предложить: </h3>
            <a href="book.html"><img src="/resources/images/book.jpg"/></a>
            <div class="book_name">Л.Н. Толстой "Война и мир"</div>
            <a href="book.html"><img src="/resources/images/book.jpg"/></a>
            <div class="book_name">Харпер Ли "Убить пересмешника"</div>
            <a href="book.html"><img src="/resources/images/book.jpg"/></a>
            <div class="book_name">А.С. Пушкин "Евгений Онегин"</div>
        </div>
        <div class="wishes">
            <h3>Хочу почитать: </h3>
            <img src="/resources/images/book.jpg"/>
            <div class="book_name">Гюстав Флобер "Госпожа Бовари"</div>
            <img src="/resources/images/book.jpg"/>
            <div class="book_name">Фрэнсис Скотт Фицджеральд "Великий Гэтсби"</div>
        </div>
    </div>
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