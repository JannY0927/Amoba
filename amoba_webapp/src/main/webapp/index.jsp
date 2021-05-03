<%@ page import="com.sun.javafx.geom.AreaOp" %><!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"  href="styleweb.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
        <button type="button" class="btn btn-primary" onclick="setBoard()">Új játék</button>
        <br>
        <br>
     <!--   <label for="gameid">Játék azonosító</label>
        <label  > -->
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
        <td id="pl1t" class="time2">0</td>
        <td class="time">Game time</td>
        <td id="gt" class="time2">0</td>
        <td class="time">Player2 Time</td>
        <td id="pl2t" class="time2">0</td>
    </tr>
</table>
<br>
<input type="hidden" id="actSign" value="X">
<table class = "board">
    <tr>
        <td><button id = "00" class="gamecell" type="button" x="0" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "01" class="gamecell" type="button" x="0" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "02" class="gamecell" type="button" x="0" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "03" class="gamecell" type="button" x="0" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "04" class="gamecell" type="button" x="0" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "05" class="gamecell" type="button" x="0" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "06" class="gamecell" type="button" x="0" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "07" class="gamecell" type="button" x="0" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "08" class="gamecell" type="button" x="0" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "09" class="gamecell" type="button" x="0" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "10" class="gamecell" type="button" x="1" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "11" class="gamecell" type="button" x="1" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "12" class="gamecell" type="button" x="1" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "13" class="gamecell" type="button" x="1" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "14" class="gamecell" type="button" x="1" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "15" class="gamecell" type="button" x="1" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "16" class="gamecell" type="button" x="1" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "17" class="gamecell" type="button" x="1" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "18" class="gamecell" type="button" x="1" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "19" class="gamecell" type="button" x="1" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "20" class="gamecell" type="button" x="2" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "21" class="gamecell" type="button" x="2" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "22" class="gamecell" type="button" x="2" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "23" class="gamecell" type="button" x="2" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "24" class="gamecell" type="button" x="2" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "25" class="gamecell" type="button" x="2" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "26" class="gamecell" type="button" x="2" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "27" class="gamecell" type="button" x="2" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "28" class="gamecell" type="button" x="2" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "29" class="gamecell" type="button" x="2" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "30" class="gamecell" type="button" x="3" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "31" class="gamecell" type="button" x="3" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "32" class="gamecell" type="button" x="3" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "33" class="gamecell" type="button" x="3" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "34" class="gamecell" type="button" x="3" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "35" class="gamecell" type="button" x="3" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "36" class="gamecell" type="button" x="3" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "37" class="gamecell" type="button" x="3" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "38" class="gamecell" type="button" x="3" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "39" class="gamecell" type="button" x="3" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "40" class="gamecell" type="button" x="4" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "41" class="gamecell" type="button" x="4" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "42" class="gamecell" type="button" x="4" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "43" class="gamecell" type="button" x="4" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "44" class="gamecell" type="button" x="4" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "45" class="gamecell" type="button" x="4" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "46" class="gamecell" type="button" x="4" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "47" class="gamecell" type="button" x="4" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "48" class="gamecell" type="button" x="4" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "49" class="gamecell" type="button" x="4" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "50" class="gamecell" type="button" x="5" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "51" class="gamecell" type="button" x="5" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "52" class="gamecell" type="button" x="5" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "53" class="gamecell" type="button" x="5" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "54" class="gamecell" type="button" x="5" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "55" class="gamecell" type="button" x="5" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "56" class="gamecell" type="button" x="5" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "57" class="gamecell" type="button" x="5" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "58" class="gamecell" type="button" x="5" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "59" class="gamecell" type="button" x="5" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "60" class="gamecell" type="button" x="6" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "61" class="gamecell" type="button" x="6" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "62" class="gamecell" type="button" x="6" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "63" class="gamecell" type="button" x="6" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "64" class="gamecell" type="button" x="6" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "65" class="gamecell" type="button" x="6" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "66" class="gamecell" type="button" x="6" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "67" class="gamecell" type="button" x="6" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "68" class="gamecell" type="button" x="6" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "69" class="gamecell" type="button" x="6" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "70" class="gamecell" type="button" x="7" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "71" class="gamecell" type="button" x="7" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "72" class="gamecell" type="button" x="7" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "73" class="gamecell" type="button" x="7" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "74" class="gamecell" type="button" x="7" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "75" class="gamecell" type="button" x="7" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "76" class="gamecell" type="button" x="7" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "77" class="gamecell" type="button" x="7" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "78" class="gamecell" type="button" x="7" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "79" class="gamecell" type="button" x="7" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "80" class="gamecell" type="button" x="8" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "81" class="gamecell" type="button" x="8" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "82" class="gamecell" type="button" x="8" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "83" class="gamecell" type="button" x="8" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "84" class="gamecell" type="button" x="8" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "85" class="gamecell" type="button" x="8" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "86" class="gamecell" type="button" x="8" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "87" class="gamecell" type="button" x="8" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "88" class="gamecell" type="button" x="8" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "89" class="gamecell" type="button" x="8" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
    <tr>
        <td><button id = "90" class="gamecell" type="button" x="9" y="0" onclick="takeMysign(id)"></button></td>
        <td><button id = "91" class="gamecell" type="button" x="9" y="1" onclick="takeMysign(id)"></button></td>
        <td><button id = "92" class="gamecell" type="button" x="9" y="2" onclick="takeMysign(id)"></button></td>
        <td><button id = "93" class="gamecell" type="button" x="9" y="3" onclick="takeMysign(id)"></button></td>
        <td><button id = "94" class="gamecell" type="button" x="9" y="4" onclick="takeMysign(id)"></button></td>
        <td><button id = "95" class="gamecell" type="button" x="9" y="5" onclick="takeMysign(id)"></button></td>
        <td><button id = "96" class="gamecell" type="button" x="9" y="6" onclick="takeMysign(id)"></button></td>
        <td><button id = "97" class="gamecell" type="button" x="9" y="7" onclick="takeMysign(id)"></button></td>
        <td><button id = "98" class="gamecell" type="button" x="9" y="8" onclick="takeMysign(id)"></button></td>
        <td><button id = "99" class="gamecell" type="button" x="9" y="9" onclick="takeMysign(id)"></button></td>
    </tr>
</table>
<script>
    var gameTimer;
    var stepTimer;

    function setBoard() {
        var gamecells = document.querySelectorAll(".gamecell");
        for (var i = 0 ;i < gamecells.length;i++) {
            gamecells[i].innerHTML = "";
        }
        document.getElementById("pl1t").innerHTML = document.getElementById("steptime").value;
        document.getElementById("pl2t").innerHTML = document.getElementById("steptime").value;
        document.getElementById("gt").innerHTML = document.getElementById("playtime").value;

        callJqueryAjaxStep("00","");
        clearInterval(gameTimer);
        clearInterval(stepTimer);
        startTimer();
        stepTime("pl1t");
    }


    function startTimer() {
        var countdown = new Date().getTime()+document.getElementById("gt").innerHTML*1000;
        var helper;
        gameTimer = setInterval(function() {
            var now = new Date().getTime();
            var distance = countdown - now;
            console.log(distance);

            var seconds = Math.ceil(distance / 1000 );

            document.getElementById("gt").innerHTML = seconds;

            if (distance < 0) {
                clearInterval(gameTimer);
                clearInterval(stepTimer);
                document.getElementById("gt").innerHTML = "TO";
                alert('A játékidőnek vége. A ' + document.getElementById('actSign').value + ' játékos nyert');
            }
        }, 1000);

        console.log(gameTimer);
    }


    function stepTime(id) {
        var countdown = new Date().getTime()+document.getElementById(id).innerHTML*1000;
        var helper;
        stepTimer = setInterval(function() {
            var now = new Date().getTime();
            var distance = countdown - now;
            console.log(distance);

            var seconds = Math.ceil(distance / 1000 );

            document.getElementById(id).innerHTML = seconds;

            if (distance < 0) {
                clearInterval(stepTimer);
                clearInterval(gameTimer);
                document.getElementById(id).innerHTML = "TO";
                alert('A játékidőnek vége. A ' + document.getElementById('actSign').value + ' játékos nyert');
            }
        }, 1000);

        console.log(stepTimer);
    }

    function addStepDb(x,y) {
    }

    function isWin(sign) {
        var gamecells = document.querySelectorAll(".gamecell");
        var meWin = false;
        for (var i = 0; i < gamecells.length; i++) {
            if (gamecells[i].innerHTML===sign) {
                console.log('inner '+ ' ' + gamecells[i].innerHTML )
                if (!meWin) {
                    for (var down = 1 ;down < 5;down++) {
                        console.log("d_false_side " +gamecells[i].getAttribute("y"))
                        if ((gamecells[i].getAttribute("x")>5)||
                            (gamecells[i+(down*10)].innerHTML!=sign)){
                            console.log("d_false_side " +gamecells[i].getAttribute("id"))
                            meWin=false;
                            break;
                        }
                        console.log('down '+ ' ' + gamecells[i+(down*10)].innerHTML );
                        meWin= true;
                    }

                }
                if (!meWin) {
                    for (var right = 1 ;right < 5;right++) {
                        if ((gamecells[i].getAttribute("y")>5)||
                            (gamecells[i+(right*1)].innerHTML!=sign)){
                            console.log("r_false_side " +gamecells[i].getAttribute("id"))
                            meWin=false;
                            break;
                        }
                        console.log('right '+ ' ' + gamecells[i].innerHTML );
                        meWin= true;
                    }

                }
                if (!meWin) {
                    for (var dl = 1 ;dl < 5;dl++) {
                        if ((gamecells[i].getAttribute("y")<5)||
                            (gamecells[i].getAttribute("x")>5)||
                            (gamecells[i+(dl*9)].innerHTML!=sign)){
                            console.log("dl_false_side " +gamecells[i].getAttribute("id"))
                            meWin=false;
                            break;
                        }
                        console.log('dl '+ ' ' + gamecells[i].innerHTML );
                        meWin= true;
                    }
                }
                if (!meWin) {
                    for (var dr = 1 ;dr < 5;dr++) {
                        if ((gamecells[i].getAttribute("x")>5)||
                            (gamecells[i].getAttribute("y")>5)||
                            (gamecells[i+(dr*11)].innerHTML!=sign)){
                            console.log("dr_false_side " +gamecells[i].getAttribute("id"))
                            meWin=false;
                            break;
                        }
                        meWin= true;
                    }
                }
            }

        }
        return meWin;
    }

    function  takeMysign(p1) {
        if (isWin("O")||isWin("X")
            ||document.getElementById("gt").innerHTML == "TO"
            ||document.getElementById("gt").innerHTML == "0"
            ||document.getElementById("pl1t").innerHTML == "TO"
            ||document.getElementById("pl2t").innerHTML == "TO") {
            alert('Új játékot kell kezdeni');
        }
        else {
            console.log("gamemode" + document.getElementById("gamemode").value)
            console.log(document.getElementById('actSign') + p1);
            let sign = document.getElementById('actSign').value;
            if (document.getElementById(p1).innerHTML == "") {
                document.getElementById(p1).innerHTML = sign;
                callJqueryAjaxStep(p1,sign);
                clearInterval(stepTimer);
                //  addStepDb(document.getElementById(p1).getAttribute('x'),document.getElementById(p1).getAttribute('y')))
                if (isWin(sign)) {
                    alert('Nyert a ' + sign + ' játkos. Kattins az új játékra');
                    clearInterval(gameTimer);
                    clearInterval(stepTimer);
                }
                else {
                    clearInterval(stepTimer);
                    if (document.getElementById("gamemode").value == 2)
                        if (sign === "X") {
                            document.getElementById('actSign').value = 'O';
                            document.getElementById("pl1t").innerHTML = document.getElementById("steptime").value;
                            stepTime("pl2t");
                        } else {
                            document.getElementById('actSign').value = "X"
                            document.getElementById("pl2t").innerHTML = document.getElementById("steptime").value;
                            stepTime("pl1t");
                        }
                    else {
                        var CpuStepIsfalse = true;
                        while (CpuStepIsfalse) {
                            var x = Math.floor(Math.random() * 10);
                            var y = Math.floor(Math.random() * 10);
                            if (document.getElementById(x.toString() + y.toString()).innerHTML == "") {
                                document.getElementById(x.toString() + y.toString()).innerHTML = "O"
                                callJqueryAjaxStep(x.toString() + y.toString(),"O");
                                if (isWin("O")) {
                                    clearInterval(gameTimer);
                                    clearInterval(stepTimer);
                                    alert('Nyert a O játkos. Kattins az új játékra');
                                }
                                CpuStepIsfalse = false;
                            }
                        }
                        document.getElementById("pl1t").innerHTML = document.getElementById("steptime").value;
                        stepTime("pl1t");
                    }
                }
            }
        }
    }
</script>
<script>
function callJqueryAjaxStep (id,sign){
    console.log("id: " + id);
    var x = $("#" + id).attr("x");
    var y = $("#" + id).attr("y");
    console.log("X: " + x + "Y: " + y);
    $.ajax({
        url     : 'webjava',
        method     : 'POST',
        data      : {x    : x,
                     y    : y,
                     sign : sign},
});
}


function callJqueryAjaxLoadGame (id,sign){
    console.log("id: " + id);
    var x = $("#" + id).attr("x");
    var y = $("#" + id).attr("y");
    console.log("X: " + x + "Y: " + y);
    $.ajax({
        url     : 'webjava',
        method     : 'POST',
        data      : {
            x    : x,
            y    : y,
            sign : sign,
            gameid:gameid}
    });
}
</script>
</body>
</html>