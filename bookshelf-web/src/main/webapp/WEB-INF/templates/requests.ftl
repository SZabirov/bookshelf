<#ftl encoding='UTF-8'>

<!doctype html>
<html lang="en">
<head>
    <title>Bookshelf</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <script src="/resources/css/ie/html5shiv.js"></script>
    <![endif]-->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/jquery.dropotron.min.js"></script>
    <script src="/resources/js/skel.min.js"></script>
    <script src="/resources/js/skel-layers.min.js"></script>
    <script src="/resources/js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="/resources/css/skel.css"/>
        <link rel="stylesheet" href="/resources/css/style.css"/>
    </noscript>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/resources/css/ie/v8.css"/><![endif]-->
</head>
<body class="no-sidebar">


<div id="header">
    <div class="container">

        <h1><a href="#" id="logo">Bookshelf</a></h1>

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

<div id="main2" class="wrapper style1">
    <div class="profilepage">
        <img src="/resources/images/no_user_photo.png" class="profile_photo"/>
        <div class="profile_information">
            <b>Имя:</b> ${user.firstname} <br/>
            <b>Фамилия:</b> ${user.surname} <br/>
            <b>Логин:</b> ${user.nickname}
        <#if notCurrent??>
            <br/><br/><a href="/connect?id=${user.id}"><input type='submit' value='Связаться' class='submit-button'></a>
        </#if>
        </div>

        <div class="profilebooks">
            <h2>ПРЕДЛОЖЕНИЯ</h2>
            <#if user.messages?has_content>
            <table>
                <tr>
                    <th>ОТ КОГО</th>
                    <th>ПРЕДЛАГАЕТ</th>
                    <th>ХОЧЕТ ПОЛУЧИТЬ</th>
                </tr>
                <#list user.messages as m>
                    <tr>
                        <th>${m.sender.nickname}</th>
                        <th>${m.havingBook.authorBookname.bookname}</th>
                        <th>${m.wishBook.authorBookname.bookname}</th>
                    </tr>
                </#list>
            </table>
            <#else>
                <p>Нет предложений</p>
            </#if>
        </div>
    </div>


</div>

<div id="footer">
    <div class="container">

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