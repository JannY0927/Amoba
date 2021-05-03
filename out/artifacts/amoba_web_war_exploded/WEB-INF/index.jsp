<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"  href="styleweb.css">
</head>
<body>
<br>
<form>
    <fieldset >
        <legend>Beállítások</legend>
        <label for="gamemode">Játékmód</label>
        <select  id="gamemode" placeholder="Játékmód kiválasztása">
            <option value="1">Human VS CPU</option>
            <option value="2">Human VS Human</option>
        </select>
        <label for="playtime">Játékidő</label>
        <select id="playtime" placeholder="Játékidő másodpercben">
            <option value="30">30</option>
            <option value="60">60</option>
            <option value="90">90</option>
            <option value="120">120</option>
        </select>
        <label for="steptime">Lépésidő</label>
        <select id="steptime" placeholder="Lépésidő másodpercben">
            <option value="5">5</option>
            <option value="7">7</option>
            <option value="9">9</option>
            <option value="11">11</option>
        </select>
        <br>
        <br>
        <button type="submit" class="btn btn-primary">Új játék</button>
        <br>
        <br>
        <label for="gameid">Játék azonosító</label>
        <select id="gameid">
            <option value="1">1</option>
        </select>
        <br>
        <br>
        <button type="submit" class="btn btn-primary">Játék betöltés</button>

    </fieldset>
</form>
</div>
<br>
<table class = "datasdatas">
    <tr>
        <td class="time">Player1 Time</td>
        <td class="time2">15</td>
        <td class="time">Game time</td>
        <td class="time2">100</td>
        <td class="time">Player2 Time</td>
        <td class="time2">15</td>
    </tr>
</table>
<br>
<table class = "board">
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    <tr/>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
    <tr>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
        <td><button class="gamecell" type="button"></button></td>
    </tr>
</table>
</body>
</html>