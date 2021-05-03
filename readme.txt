Az amoba programot választottam.
A programhoz javafx telepítésre és környezeti változó  beállítására van szükség.
A web alkalmazás Tomcat 9.0.45-ön fut.

A DT alkalamzás a parancsokkal érhető el a javafx és mavan alkalmazásopk

mvn package -f pom.xml
mvn javafx:run -f amoba_dt/pom.xml

Tomcat indítását követően a web alkalmazás a 

http://localhost:8080/amoba_webapp_war/ linken érhető el.

A játékban az egyedi táblateret a minimálisan előírt 10x10-es méretben határoztam meg.
Desktop:
A játék indítása a NewGame menü alól kezdeményezhető, egy vagy két játékos módon.
A Settings menüben beállítható az időmérés típusa, a beállított select menü alapján indul a játék.
A játék visszatöltésére a load menüben van lehetőség. Mindig az utolsó játék tölthető vissza.

Web:
A játék idők és a játékmód legördülő listából érhető el.
Az új játék indítása során a tábla leürül a számlázók nullázódnak.

A játék végét és az időzítők végét hibaüzenet jelzi.


Megvalósítási eltérések a specifikációhoz képest
Az időszámítást a Desktop megvalósításánál kicsit félre értelmeztem és nem lépésidőt határoztam meg hanem játékos időt, de ezt a webes alkalmazásnál javítottam a követelménynek megfelelően.
A webes oldalon a játék visszatöltés elmaradt, de a db-be mentem az adatokat.(ezt ma vettem észre)