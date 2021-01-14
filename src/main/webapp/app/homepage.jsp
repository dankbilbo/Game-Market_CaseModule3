<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/7/2021
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body style="background: url(https://wallpapercave.com/wp/wp5705473.png) no-repeat;background-size: 100%">
<div style="display: flex; justify-content: flex-end">
    <a href="/app" >HOMEPAGE</a>
</div>
<div >
    <a href="/account?action=view">${sessionScope["account"].getUsername()}</a>
    <a href="/logout">Logout</a>
</div>
<div>
    <a href="/app?action=viewgamesowned">Game Owned</a>
</div>
<div>
    <form action="/app?action=search" method="post">
    <input type="text" name="namesearch">
    Search app by name: <input type="submit">
    </form>
</div>
<div class="row col-md-12">
    <div class="col-md-6" align="center">
        <table class="table table-striped table-dark" width="100%">
            <caption>Hot Games</caption>
            <colgroup>
                <col width="15%">
                <col width="55%">
                <col width="15%">
                <col width="15%">
            </colgroup>
            <tbody>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Bought</th>
                <th>Price</th>
            </tr>
            <c:forEach items='${requestScope["tenTopSellers"]}' var="topSellerGame">
                <tr>
                    <td><a href="/app?action=view&id=${topSellerGame.getId()}"><img src="${topSellerGame.getLogoURL()}" ></a></td>
                    <td style="white-space: nowrap; text-overflow:ellipsis; overflow: hidden; max-width:1px;"><a href="/app?action=view&id=${topSellerGame.getId()}" >${topSellerGame.getName()}</a></td>
                    <td>${topSellerGame.getNumberUserOwned()}</td>
                    <td align="center">${topSellerGame.getPrice() - topSellerGame.getPrice() * topSellerGame.getDiscount()}$</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="col-md-6" align="center">
        <table class="table table-striped table-dark" width="100%" class="">
            <caption>Hot New Released</caption>
            <tr>
                <th></th>
                <th>Name</th>
                <th>ReleasedDate</th>
                <th>Price</th>
            </tr>
            <c:forEach items='${requestScope["tenHotReleasedGames"]}' var="hotReleasedGame">
                <tr>
                    <td><a href="/app?action=view&id=${hotReleasedGame.getId()}"><img src="${hotReleasedGame.getLogoURL()}" ></a></td>
                    <td style="white-space: nowrap; text-overflow:ellipsis; overflow: hidden; max-width:1px;"><a href="/app?action=view&id=${hotReleasedGame.getId()}">${hotReleasedGame.getName()}</a></td>
                    <td>${hotReleasedGame.getReleasedDate()}</td>
                    <td align="center">${topSellerGame.getPrice() - topSellerGame.getPrice() * topSellerGame.getDiscount()}$</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="col-md-12">
    <div class="col-md-6" align="center">
        <table class="table table-striped table-dark">
            <caption>Top Upcoming</caption>
            <tr class="">
                <th></th>
                <th>Name</th>
                <th>Preordered</th>
                <th>ReleasedDate</th>
            </tr>
            <c:forEach items='${requestScope["tenTopUpcomingGames"]}' var="topUpcomingGame">
                <tr>
                    <td><a href="/app?action=view&id=${topUpcomingGame.getId()}"><img src="${topUpcomingGame.getLogoURL()}" ></a></td>
                    <td style="white-space: nowrap; text-overflow:ellipsis; overflow: hidden; max-width:1px;"><a href="/app?action=view&id=${topUpcomingGame.getId()}">${topUpcomingGame.getName()}</a></td>
                    <td>${topUpcomingGame.getNumberUserOwned()}</td>
                    <td align="center">${topUpcomingGame.getReleasedDate()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
