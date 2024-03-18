# <u>INF112 Project - Moustache Mania</u>
- Team: Git Rekt 2024 (Group 2): Tobias With Thorsen, Mina Tolfsen, Emil Johannessen

# <u>Om spillet</u>
"Du er en tømmerhogger som har blitt teleportert til en annen verden. 
Kjemp deg gjennom farlig terreng og monstre for å komme deg hjem igjen!"

Hvordan spille:
- Bevegelse: piltastene
- Hopp: Mellomromtasten
- Pause spillet: ESC-knappen
- I startskjermen og pausemenyen, bruk musen til å trykke på knappene.

# <u>Kompilering, kjøring og testing</u>
- Kompiler med `mvn package` i terminalen.
- Kjør ved å gå til main funksjonen i MoustacheMania.java. 
  - Kjøring med jar-fil: Vær i /git-rekt mappen i CLI og skriv "java -jar target\MoustacheMania-1.0-SNAPSHOT-fat.jar"
- Java 17 eller senere versjoner.
- Kjør tester ved å skrive `mvn test` i terminalen eller høyreklikk på `test/java` og trykk `run`

# <u>Kjente feil</u>
- Bug: spillet fortsetter selv om spilleren har detti ut av banen.
  - Fikset.
- Bug: Spilleren kan gå inn i klosser som egentlig er en del av kollisjon-layer. Dette er gjennom x-aksen. På grunn av dette kan spilleren kjapt gå av en plattform, falle litt ned og så gå tilbake slik at spilleren blir flyttet opp på plattformen igjen. Selv om spilleren treffer midt på boksen.
Det kan også skje at spilleren løper mot boksen med fart og blir automatisk flytte oppå boksen.
- Bug: Banen ligger ikke helt kant i kant med skjermen/spillvinduet. Så det er svarte bokser helt til venstre når man laster inn banen og over himmelen i banen.
  - Fikset. Kamera er nå innstilt til å ikke gå forbi kanten av banen samt at vi har økt himmelen i Tiled.


# <u>Credits</u>
Musikk:
- Bakgrunnsmusikk for spillingen - Music by Maksym Dudchyk from Pixabay
  - https://pixabay.com/users/white_records-32584949/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=164704
  - https://pixabay.com//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=164704
- Power-up-lyd
  - https://pixabay.com/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=6768
- Startskjermmusikk
  - https://pixabay.com/users/jimgor33-5579676/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=145077
  - https://pixabay.com//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=145077
- Game over lyd og level completed lyd
  - https://mixkit.co/free-sound-effects/game-over/
- Power Up lyd
  - Sound Effect from Pixabay 
  - https://pixabay.com/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=88510
Bilder/sprites:
- Mynter
  - https://opengameart.org/content/16x16-spinning-coin-pickup-animation
