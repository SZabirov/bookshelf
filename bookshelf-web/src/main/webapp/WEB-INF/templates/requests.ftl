<#ftl encoding='UTF-8'>

<!doctype html>
<html lang="en">
<head>
    <title>Bookshelf</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <script type="text/javascript" src="/resources/css/ie/html5shiv.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.dropotron.min.js"></script>
    <script type="text/javascript" src="/resources/js/skel.min.js"></script>
    <script type="text/javascript" src="/resources/js/skel-layers.min.js"></script>
    <script type="text/javascript" src="/resources/js/init.js"></script>

    <noscript>
        <link rel="stylesheet" href="/resources/css/skel.css"/>
        <link rel="stylesheet" href="/resources/css/style.css"/>
    </noscript>
    <style>
        .th1 {
            width: 20%;
        }
        .th2 {
            width: 30%;
        }
    </style>
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
                <li><a href="/client/requests">Предложения</a></li>
                <li><a href="/client/settings">Настройки</a></li>
                <li><a href="/search">Поиск</a></li>
                <li><a href="/logout">Выход</a></li>
            </ul>
        </nav>
    </div>
</div>

<div id="main2" class="wrapper style1">
    <div class="profilepage">
        <img src="/resources/images/no_client_photo.png" class="profile_photo"/>
        <div class="profile_information">
            <b>Имя:</b> ${client.firstname} <br/>
            <b>Фамилия:</b> ${client.surname} <br/>
            <b>Логин:</b> ${client.nickname}
        <#if notCurrent??>
            <br/><br/><a href="/connect?id=${client.id}"><input type='submit' value='Связаться' class='submit-button'></a>
        </#if>
        </div>

        <div class="profilebooks" style="width: 100%; border-width: 0">
            <h2 class="requests_h2" style="text-align: center">ПРЕДЛОЖЕНИЯ</h2>
            <p style="text-align: center; font-weight: bold">Входящие предложения</p>
            <#if client.message?has_content>
            <table>
                <tr>
                    <th class="th1">ОТ КОГО</th>
                    <th class="th2">ПРЕДЛОЖЕНИЕ</th>
                    <th class="th2">ПОЖЕЛАНИЕ</th>
                    <th class="th1">КОНТАКТЫ</th>
                    <th></th>
                </tr>
                <#list client.message as m>
                    <tr>
                        <th class="th1">${m.sender.nickname}</th>
                        <th class="th2">${m.havingBook.authorBookname.bookname}</th>
                        <th class="th2">${m.wishBook.authorBookname.bookname}</th>
                        <th class="th2">${m.sender.phone}</th>
                        <th>
                            <div class="book_name">
                                <form action="/deleteMessage?id=${m.id}" method="post">
                                    <input type="submit" class="del2" value="Удалить" />
                                </form>
                            </div>
                        </th>
                    </tr>
                </#list>
            </table>
            <#else>
                <p>Вы еще не получили ни одного предложения</p>
            </#if>
            <hr width="1px"/>
            <p style="text-align: center; font-weight: bold">Исходящие предложения</p>
        <#if client.sentMessage?has_content>
            <table>
                <tr>
                    <th class="th1"> КОМУ  </th>
                    <th class="th2">ПРЕДЛОЖЕНИЕ</th>
                    <th class="th2">ПОЖЕЛАНИЕ</th>
                    <th class="th1">КОНТАКТЫ</th>
                </tr>
                <#list client.sentMessage as sm>
                    <tr>
                        <th class="th1">${sm.receiver.nickname}</th>
                        <th class="th2">${sm.havingBook.authorBookname.bookname}</th>
                        <th class="th2">${sm.wishBook.authorBookname.bookname}</th>
                        <th class="th2">${sm.receiver.phone}</th>
                        <th>
                            <div class="book_name">
                                <form action="/deleteMessage?id=${sm.id}" method="post">
                                    <input type="submit" class="del2" value="Удалить" />
                                </form>
                            </div>
                        </th>
                    </tr>
                </#list>
            </table>
        <#else>
            <p>Вы еще не отправили ни одного предложения</p>
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
        $(".clientname").focus(function () {
            $(".client-icon").css("left", "-48px");
        });
        $(".clientname").blur(function () {
            $(".client-icon").css("left", "0px");
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