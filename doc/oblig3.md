# Prosjektrapport - oblig 3
**Team:** Git Rekt – Mina Tolfsen, Tobias With Thorsen, Emil Johannessen


## Team og roller
Ingen store endringer i situasjonen på hvordan rollene og teamet har funkert.

Det er fortsatt ikke hatt behov for mange andre roller ettersom vi er et lite team.
Team lead og grafikk ansvarlig og utvikler er mer enn plenti for oss. Tydelige rammer uten at man gir unødvendige roller for dette prosjektet.

**Team lead / utvikler (Tobias)** - Jeg har fortsatt følt på ansvar for å holde en god driv framover for gruppen. Siden forrige rapport har det vært litt av og på for min del. Rett etter fristen for oblig2 kjente jeg på stort driv og mye tid til å kunne jobbbe med prosjektet, men disse to ukene etter påsken har vært litt treigere.
Første uken tok det litt tid for meg å komme tilbake til rutinene etter påsken.
Andre uken satt jeg plutselig med 3 obliger på en gang. Den ene av dem har fått litt mer oppmerksomhet enn INF112 prosjektet denne siste uken før oblig3 fristen. 
Teamet har fortsatt fungert ganske bra sammen og vi har hatt god dialog om hvordan vi skal løse de siste resterende utfordringene før oblig4 (03. mai).

**Grafisk designer/utvikler (Mina)** - Jeg trives fortsatt i rollen som grafisk designer og utvikler, spesielt med å kunne leke meg med former og farger.
Etter å ha fullført oblig 2, har jeg vært mer aktiv i kodingsdelen. Jeg har taklet individuelle oppgaver godt og føler mer mestring i kodingen.
Etter oblig 2, fokuserte jeg mye på INF112, men dessverre har det blitt nedprioritert etter påsken på grunn av andre obligatoriske oppgaver.
Likevel mener jeg at gruppen har hatt god kommunikasjon, og vi har motivert hverandre til å nærme oss ferdigstillelse av prosjektet.
Vi står overfor noen utfordringer som må løses før den endelige innleveringen, oblig 4.

**Utvikler (Emil)** - Jeg har mesteparten av tiden jobbet med å implementere nye screens og håndtering av disse. Jeg synes dette har vært greit og det har vært lett å prate og jobbe dynamisk med de andre i teamet for å komme fram til løsinger.
Tydelige arbedisoppgaver og jevn arbeidsflyt, også tatt i betraktning at arbeidsmengden og flyten har latt seg lett og dynamisk justeres i teamet når andre ting, også krever oppmerksomhet og tid.


## Prosjektmetodikk
**Tobias** - Fra sist gang merker jeg at resten av gruppen har blitt betydelig bedre på å ta i bruk Kanban boardet. Både som et referansepunkt for hva som skal gjøres, men at de også legger inn egne ting de ønsker å gjøre/holde oversikt over.
Git flyten fungerer fortsatt veldig bra og vi har en ganske jevn fordeling av commits mellom gruppemedlemmene.

**Mina** - Jeg merker at gruppen har blitt flinkere til å bruke KanBan-boardet, og det har virkelig gitt oss en bedre oversikt over oppgavene og tidsplanen vår. Når det gjelder min egen praksis, har jeg lagt merke til at jeg er flinkere til å bruke JavaDocs i stedet for å legge inn // kommentarer.
Generelt sett er jeg veldig fornøyd med dynamikken og kommunikasjonen i gruppen vår.

**Emil** - Blitt glad i å bruke Kanban-boardet mer, synes det er et ryddig og nyttig verktøy for å holde oversikt over arbeidsoppgaver, samt se hva resten av teamet holder på med og har planer om.  


## Gruppedynamikk og kommunikasjon
**Tobias** - I uke 11 var jeg i Trondheim. Det gjorde at gruppen måtte kommunisere mer over Discord. Dette gikk overraskende bra.
Jeg fryktet at vi skulle slite mer med samarbeidet, men vi var flinke til å være innpå Discord og følge med på hva hverandre skrev.
Jeg og Mina hadde også voicechat en dag for å diskutere en oppgave.

**Mina** - Jeg opplever at gruppen fortsatt har et godt samarbeid og kommuniserer effektivt. Vi tar hensyn til hverandres tidsplaner og forpliktelser, og selv når noen av oss er borte eller utilgjengelige, har vi klart å opprettholde kommunikasjonen på en god måte. Dette har fungert svært bra for oss.

**Emil** - Jeg synes gruppedynamikken fortsetter å fungere bra. Lett og god stemning i teamet og det er lett å komme i kontakt med og kommunisere med de andre. Regelmessige møter og oppdateringer samt lav-terskel kommunikajson over discord. Discord fungerer spesielt bra løsing når deler av teamet er bortreist, men er osgå en bra løsning når vi sender filer eller merge requests. Fortsatt bra fysisk oppmøte og tilstedeværelse.


## Retrospektiv

Vi hadde en uke der Tobias var i Trondheim og jobbet. Det funket ganske bra. Vi holdt dialogen over Discord, og meldte ifra til hverandre når vi trengte approval på en merge request. Dette viser at vi har gode rutiner på Git og Kanban slik at vi klarer å holde flyten tross kanskje mindre kommunikasjon.
Ellers har vi fortsatt sitte mye på bachelor-lesesalen for informatikk og har kunnet snakke direkte til hverandre ganske fritt gjennom ukene.
Kanban board blir hyppig brukt til å fordele oppgaver og holde oversikt over hva som skal gjøres frem til neste frist.
Vi er ganske lik i antall commits, noe som vi føler er en bra indikasjon på at det er en grei fordeling av arbeid i gruppen.

Vi ligger ganske bra an. MVP er i bunn og grunn dekket, men kravet om objektfabrikk sliter vi litt med.
Vi har en foreløpig plan om å lage flere monstre og ha en MonsterFactory som da velger tilfeldige monstre i det du velger en bane man ønsker å spille.

Møtereferater finnes under `doc/møte_referat`. Gjelder uke 11 til uke 15.
Påske uke 13 er det ingen møtereferat fra grunnet ferie.


# Krav og spesifikasjon
## MVP
Vi har oppnådd MVP.
- Hovedmenyskjerm - ✅ StartScreen.java
- Pausemenyskjerm - ✅ PauseScreen.java
- Visning av et nivå - ✅ Vi har flere nivåer.
- Spilleren kan bevege seg fra venstre til høyre på 2D-nivået. - ✅ 
- Spilleren kan samhandle med terrenget (plattformer, vegger) - ✅ Tidligere var det en bug hvor rekkefølgen på det som bestemte bevegelse for spilleren var i feil rekkefølge. Nå er det i korrekt rekkefølge hvor man forsøker å gjøre en input og gå i en retning, men før man flytter spilleren, så sjekker man kollisjon og til slutt tyngdekraft. Dette sørger for korrekt funksjonalitet.
- Monstre som kan elimineres og eliminere spilleren. - ✅ Den er litt buggy, men det funker.
- Et mål for spilleren å nå fram til og fullføre nivået. - ✅ 
- Bakgrunnsmusikk - ✅  
- Lydeffekt når visse hendelser skjer - ✅
- Spilleren kan få en power-up som gir spilleren en ekstra egenskap (dobbelthopp eller lignende) - ✅

## BRUKERHISTORIER
Vi fikk trekk fra oblig1 for at vi manglet brukerhistorier, så vi fikk mulighet til å inkludere det i oblig2.
Fullførte akseptansekriterier markeres mer ✅.
1. **Som en spiller ønsker jeg å kunne se og navigere gjennom en bane for å kunne gjøre fremgang i spillet.** ✅
   - Akseptansekriterier:
        Banen vises gjennom å implementere Model-View-Controller (MVC) hvor View viser banen og Model håndterer logikken og Controller håndterere bruker input. ✅
        - Arbeidsoppgaver:    
            - Implementere klassene Model.java, View.java, Controller.java. ✅
            - Abstrahere bort detaljer ved å implementere interfacene IModel.java, IView.java, IController.java  
              Model.java håndterer logikken til spillet, slik at den flytter på spilleren dersom Controller gir beskjed om at spilleren har forsøkt å flytte på seg. ✅
            - Controller.java skal lytte etter brukerinput og kalle på metoder basert på dette. ✅
            - I View.java skal man ha tilgang på et model og game objekt. ✅
            - I View.java skal man lese inn Tiled banen med LibGDX metoder som vil gjøre banen synlig for spilleren. ✅
            - View.java må også håndtere animasjonen til spilleren gjennom å lese en PNG-fil. View har tilgang på player-objektet gjennom model-objektet ettersom model skal styre logikken og har dermed tilgang til player.✅


2. **Som en spiller ønsker jeg å kunne styre karakteren min med piltastene slik at jeg kan navigere gjennom nivåene.** ✅
   Akseptansekriterier:
   - Karakteren beveger seg i ønsket retning når piltastene trykkes. ✅
        - Arbeidsoppgaver:    
            - Implementer type event listeners i Controller.java slik at når en spiller trykker på piltast mot venstre så vil controller kalle på en metode hos model som da vil flytte på spilleren. View må da tolke posisjonen slik at den leser den nye posisjonen til spilleren. ✅
   - Karakteren stopper når piltasten slippes.✅
        - Arbeidsoppgaver:
            - Det finnes en egen type metode i libGDX bilblioteket som sjekker om spilleren holder inne knappen eller ikke. Den heter `Gdx.input.isKeyPressed()` ✅
   - Karakteren kan ikke gå gjennom vegger eller andre uoverstigelige hindringer.✅
        - Arbeidsoppgaver:
          - Implementere en funksjon i model som sjekker om spilleren kolliderer med banen. ✅


3. **Som en spiller ønsker jeg å kunne hoppe med min karakter ved å trykke på en knapp slik at jeg kan unngå hindringer og nå høyere plattformer.  ** ✅
     - Akseptansekriterier:
       - Karakteren hopper når hoppeknappen trykkes. ✅ 
         - Arbeidsoppgaver:
           - Det finnes en egen type metode i libGDX biblioteket som skjekker om spilleren holder inne knappen eller ikke. Den heter `Gdx.input.isKeyPressed()` ✅
       - Karakteren lander trygt på plattformen og ikke faller gjennom den. ✅
          - Arbeidsoppgaver:
            - Definere en konstant variabel som er tyngekraften og bestemmer hvor mye spilleren skal trekkes ned i y-aksen for hver gang update-metoden blir kalt i Model.java. ✅


4. **Som en spiller ønsker jeg å kunne samle mynter i løpet av spillet for å øke poengsummen min.** ✅
   - Akseptansekriterier:
        - Mynter er plassert på forskjellige steder i hvert nivå. ✅
            - Arbeidsoppgaver:
                - Implementere en metode i Model.java som leser av et layer fra Tiled banen hvor man har markert hvor myntene befinner seg på banen. ✅
                - View.java må ha en metode som leser av layeret fra model og tegner disse på banen. ✅
            - Arbeidsoppgaver:
                - I model.java implementerer vi en metode som sjekker om spilleren er borti mynten, og vil deretter fjerne den og øke spillerens sum. ✅
                - Etter at model.java har fjernet myntent, vil update-metoden i View.java da se at myntene er borte og vise tilsvarende. ✅
                - En lydeffekt spilles av når en mynt samles inn for å indikere suksess. ✅
            - Arbeidsoppgaver:
                - Legge til lyden i SoundController.java klassaen. ✅
                - I model.java vil man registrere at spilleren har plukket opp en mynt, som sender signal til klassen SoundController.java klassen som vil spille av lyden. ✅


5. **Som en spiller ønsker jeg å kunne samle power-ups som gir meg midlertidige evner, for eksempel høyere hopp eller usynlighet.** ✅
   - Akseptansekriterier:
        - Power-ups er plassert på spesielle steder i nivåene. ✅
            - Arbeidsoppgaver:
                - Legge til et layer i Tiled banen for hvor power-ups skal være plassert. ✅
                - Implementere en metode Model.java som leser dette layeret og lagrer det i en variabel. ✅
                - View.java vil lese dette layer-et og vise power-ups. ✅
        - Når karakteren samler en power-up, får de den tilhørende evnen i en begrenset periode.✅
            - Arbeidsoppgaver:
                - Implementere en metode i Player som endrer på feltvariabler til Player klassen som indikerer at spilleren har power-up. ✅
                - Når en spiller forsøker å gjøre noe gjennom Controller som lytter på brukerinput, så kan controller kalle på model som skal flytte på spilleren. Metoden i model kan gjøre en kjapp sjekk om spilleren har power-up eller ikke, ettersom det vil ha betydning for hvordan spilleren kan bevege seg. ✅
        - Effekten av power-upen er synlig på skjermen (for eksempel større sprite for høyere hopp). ✅
            - Arbeidsoppgaver:
                - Må tegne karakteren på nytt i Asprite så det blir synlig for spiller at de har fått power-upen.✅
                - Vi kan bruke metoden render() i View.java, til å sjekke om spilleren har fått en power-up. Har spiller fått en power-up vil utseende til karakteren endres, med den nye Aspirte filen. ✅
         
6. Som en spiller ønsker jeg å kunne bekjempe fiender ved å hoppe på dem eller bruke power-ups slik at jeg kan overvinne hindringer og utfordringer.** ✅
   - Akseptansekriterier:
        - Fiender beveger seg innenfor visse områder og kan skade karakteren ved kontakt.✅
          - Arbeidsoppgaver:    
            - Implementere en metode i Model.java som flytter rundt på fiendene. ✅
            - Må ta i bruk checkCollision-metode fra Model.java slik at fiendene beveger seg etter samme betingelser som spilleren. ✅
          - Arbeidsoppgaver
            - Implementere en metode i Model.java som sjekker om spilleren hopper på fienden og treffer den ovenfra. ✅
            - Når spilleren treffer fienden ovenfra, så må model.java fjerne denne fienden fra en arraylist eller lignende slik at View.java kan oppdatere det spilleren ser. ✅
            - Når en fiende blir beseiret, forsvinner den fra skjermen med en passende animasjon. ✅
          - Arbeidsoppgaver:
            - I View.java sin render-metode må vi lage en renderMonster() metode som da vil oppdatere spriten til monsteret. ✅ Ser at monsteret ikke lever og fjerner det fra Viewet. 


7. **Som en spiller ønsker jeg å kunne nå slutten av hvert nivå for å gå videre til neste nivå eller utfordring.** ✅
   - Akseptansekriterier:
        - Hvert nivå har en tydelig definert avslutning, for eksempel en dør eller en portal. ✅
            - Arbeidsoppgaver:
                - Implementere en GAME_WON screen og håndtere i model-klassen når spilleren er i mål slik at man kan bytte skjermen til GAME_WON skjermen. ✅
        - Når karakteren når avslutningen av et nivå, blir de overført til neste nivå. Spilleren får da opp en skjerm om å spille banen på nytt eller fortsette til neste nivå. ✅
            - Arbeidsoppgaver:
                - Implementere alternativer i GAME_WON klassen der spilleren kan navigere/trykke seg til StartScreen eller tilbake til skjermen som viser valg av bane.✅


Denne brukerhistorien ønsker gruppen å fjerne. Ettersom dette ikke er et direkte krav, så ønsker vi å fokusere på objektfabrikk, bugs, og kræsjkurs med hverandre slik at vi er klare til fremføring.
I tillegg det blir innspurt i andre emner også, så vi ønsker ikke ta oss vann over hodet.
8. **Som en spiller ønsker jeg å kunne lagre spillet mitt slik at jeg kan fortsette fra der jeg slapp senere.** 
   - Akseptansekriterier:
        - Etter spilleren har fullført en bane, så vil progresjonen lagres. Altså om spilleren har fullført gitt bane eller ei.
            - Arbeidsoppgaver
                - Etter en spiller fullfører et level, så lager man en fil som inneholder detaljer om spilleren har fullført banen eller ikke.
                - Denne filtypen tar vi med i .gitignore slik at vi ikke pusher dem til gitlab.
                - Når en spiller kommer til skjermen hvor man velger banen, så leser man av denne lagringsfilen for å se hvilke baner spilleren har tilgang på.

Disse akseptansekriteriene vil bidra til å veilede utviklingen av spillet ved å definere klare krav som må oppfylles for at hver brukerhistorie skal anses som fullført og akseptabel.
Vi har holdt oss til å kun legge inn arbeidsoppgavene i Kanban board istedenfor å inkludere i milestones. Blir for mange holdepunkter og mer rot dersom vi inkluderer milestones.
   
## Prioriteringer for videre arbeid:
Ting vi skal jobbe med videre:
- Objektfabrikk for fiender som tilfeldig velger monstre som skal plasseres på banen.
- Mer dokumentasjon av public-metoder
- Rydding av koden
- Skrive så mange tester vi klarer så vi er godt over kravet om 75% test coverage.

Ting vi satt oss som mål å jobbe videre med forrige gang:
- Fikse kollisjon i x-aksen. ✅ Fullført.
- Når spilleren detter ut, så “dør” spilleren og gamestate setter til GAME_OVER. ✅ Fullført.
- Lage GAME_OVER screen og håndtere når spilleren dør. ✅ Fullført.
- Lage GAME_WON screen og håndtere når spilleren er i mål. ✅ Fullført.
- Få spilleren til å starte på riktig posisjon. ✅ Fullført.
- Fikse slik at banen dekker hele skjermen/spillvinduet, slik at det ikke lenger er svarte bokser på skjermen øverst og til venstre. ✅ Fullført.
- Power-Up ✅ Fullført.
- I LevelScreen skal vi legge til en “back to main menu”-knapp. ✅

## Bugs som skal prioriteres for videre arbeid:
Nye bugs:
- Av og til kan spilleren være flere tiles over monsteret, men likevel bli elimenert og skjermen går til Game Over.
- Monstrenes bevegelser overskriver effekten av tyngdekraft av og til. 

Eldre bugs:
- Bug: spillet fortsetter selv om spilleren har detti ut av banen. ✅ Fikset.
- Bug: Spilleren kan gå inn i klosser som egentlig er en del av kollisjon-layer. Dette er gjennom x-aksen. På grunn av dette kan spilleren kjapt gå av en plattform, falle litt ned og så gå tilbake slik at spilleren blir flyttet opp på plattformen igjen. Selv om spilleren treffer midt på boksen. ✅ Fikset.
- Bug: Banen ligger ikke helt kant i kant med skjermen/spillvinduet. Så det er svarte bokser helt til venstre når man laster inn banen og over himmelen i banen. ✅ Fikset.
   
# Kode
Utbedring av feil: Vi fikk påpekelse om at vi manglet objektfabrikk og abstrakt objektfabrikk. 
Grunnet mye tid krevd av oss fra andre emner, så har dette blitt litt nedprioritert frem mot oblig3. Det er en slags objektfabrikk med at monstre får tilfeldig posisjon på banen og tilfeldig antall monstre.
Objektfabrikk er noe av det vi skal jobbe videre med mot siste oblig.
Vi fikk også beskjed om at public-metoder trengte dokumentasjon. Dette er nå forbedret.
Vi fikk påpekt at det manglet lyd ved en hendelse. Nå er det lyd når man plukker opp mynter og power-up.

## Kontroll av OS kompatibilitet:
På gruppen har vi macOS og Windows, som kjører spillet helt fint.
Vi har testet med Linux også, noe som også fungerer helt fint.
Vi fikk påpekt en feil i kompileringen ved at det var for mange parametre i PauseScreenTest. Dette oppleves ikke fra oss lengre, så skal være i orden.

### Klassediagram:
Klassediagram finnes i ‘/doc/diagram-oblig3’.
Siden oblig2 har det ikke skjedd altfor store endringer som gjør at vi ønsker å endre for mye på klassediagrammet, men vi har lagt inn de ekstra Screens-ene vi har laget siden oblig2.

### Tester
Vi har dekket kravet om 75% test coverage med at vi har 75-76% foreløpig.
For MVC strever vi litt med å lage tester. Det er ikke alt som naturlig la seg teste da de tre klassene henger en del sammen og er ganske avhengig av LibGDX og TiledMap. Dette skaper kluss når man prøver å feks lese map-et fra "assets/maps/map_1.tmx" i feks ModelTest.java. LibGDX klarer ikke finne filen / i feilmeldingen sier den at objektet er `null`. Vi har forsøkt noe med HeadlessApplication osv. men sliter litt.
Tar gjerne imot tilbakemelding for hvordan man skal løse det. 

Det er også en rar ting med MoustacheManiaTest.java hvor den kjører helt fint alene og klarer testene, men om du kjører alle tester samtidig, så feiler den. Vi har foreløpig forsøkt å lage mock objekter for game slik at vi kan teste create(), render() og dispose() ettersom de samhandler med andre klasser.


