# Rapport – oblig 1  
Group 2 - Gard's group session

### Team - A0
- Gruppenavn: Git Rekt
- Prosjektnavn: Moustache Mania
- Team roles:
Tobias With Thorsen vil være teamleder, Mina Tolfsen vil være grafisk designer og utvikler, og Emil vil være utvikler. 
Siden dette er et lite prosjekt (sammenlignet med virkeligheten), vil vi avstå fra å ha mange flere roller, som for eksempel kundeservice osv. 
Hvis nødvendig vil teamlederen fordele de nødvendige rollene. Tobias er valgt som teamleder fordi han tar ansvar og er strukturert. 
Mina er valgt som grafisk designer på grunn av hennes interesse og dermed bedre arbeidsglede og produkt. 
Mina vil også være sekretær på møtene. Emil og Tobias vil lese over etterpå.
Emil er utvikler på grunn av hans interesse for IT og interesse for videospill. 
Mina og Tobias vil selvfølgelig også jobbe som utviklere.

### <u>Spillkonsept</u> - A2
Spillet er basert på de originale Super Mario-spillene for Nintendo Entertainment System (NES). 
Spillet er en typisk "plattformspiller" der spilleren navigerer fra starten av kartet, mens de unngår monstre og andre hindringer, for å nå målet.
https://en.wikipedia.org/wiki/Mario_Bros.

## Progresjon - A2
Fullfør nivåene for å få tilbake moustachen din!
Det er forskjellige monstre som prøver å komme i veien din.
Monstrene har forskjellige angrep og egenskaper, så vær oppmerksom på dem!

## Detaljer/konsept - A2
Du vil spille som en tømrer/barteentusiast som kan styres med piltastene. 
Du beveger deg til venstre, høyre, opp og ned i en todimensjonal verden.
Nivåene vil bli designet ved hjelp av Tiled, og det vil være vegger, monstre og andre hindringer. 
Ved å hoppe med mellomromstasten, kan brukerne hoppe på plattformer for å unngå monstre og/eller hoppe oppå monstrene for å eliminere dem.
Utfordringen er å holde kursen og unngå monstre for å nå målet.
Det vil være en power-up for spilleren å samle inn. Ved å samle en power-up får han/hun evnen til å dobbelthoppe.

## <u>Utviklingsmetodologi</u> - A3
Teamet vil bruke smidig metodologi der vi vil lage en initiell plan, men videre gjennom prosjektet vil vi prøve å slippe mindre funksjoner etter hvert som vi går.
Vi vil bruke en kombinasjon av Scrum og Kanban, ofte referert til som "Scrumban". Scrum organiserer arbeidet i tidsbegrensede iterasjoner kalt sprinter. 
Sprintene vil vare fra 1-2 uker basert på tilgjengeligheten til gruppen og størrelsen på oppgavene.
For Kanban-delen av "Scrumban" vil vi bruke issues-funksjonen i GitLab som et Kanban-brett. Det vil være flere detaljer rundt funksjonen som skal implementeres der.

## Programmering - A3
Vi vil gjøre parprogrammering for A4 når vi setter opp prosjektet for å gjøre hvert teammedlem kjent med LibGDX og modell-visningskontrolleren i spillet.
Derfra vil vi splitte opp og fokusere på våre egne oppgaver som vil bli diskutert på de ukentlige møtene.
Teamet vil fokusere på sine egne funksjoner for å sikre effektivitet i programmeringen. Ved behov vil vi hjelpe hverandre hvis en av oss sitter fast med vår nåværende oppgave.

## Kommunikasjon - A3
Vi har en Discord-server teamet vil bruke til å kommunisere. Ellers sitter vi ofte sammen i Informatikk-lesesalen. Så vi er ofte tilgjengelige for hverandre hvis vi trenger hverandres hjelp.
Tilsvarende virkelighetens åpne arbeidsområder.

## Møter - A3
Vi vil holde møter hver fredag. Hvis noen av teammedlemmene er utilgjengelige den dagen på grunn av andre kurs eller livet kommer i veien, vil vi prøve vårt beste for å endre tidspunktet for møtet.
På hvert møte vil vi tildele oppgaver til hver person, og hvert teammedlem vil vise frem sin fremgang fra forrige møte.
Første møte vi handle om aller første arbeidsfordeling.

## Git-arbeidsflyt - A3
For hver funksjon/oppgave implementert av et teammedlem, vil han/hun opprette en git branch. Når funksjonen er ferdig, vil det bli opprettet en forespørsel om sammenslåing (merge request) for å legge grenen inn i hovedgrenen.
Vi vil prøve å følge den normale praksisen som nevnt ovenfor, men hvis vi begynner å oppleve mange merge conflicts ved å bruke den metoden, vil vi prøve å gjøre følgende tips vi har fått av medstudenter:
Sammenslå main branch inn i branchen før du sender inn forespørselen om sammenslåing som går inn i hovedgrenen. Dette er for å gjøre det enklere å håndtere sammenslåingskonflikter og sikre funksjonalitet før sammenslåing med hovedgrenen.

## <u>Minimum viable product (MVP) - A3 </u>
Vårt MVP vil være:
- Hovedmenyskjerm
- Pausemenyskjerm
- Visning av et nivå
- Spilleren kan bevege seg fra venstre til høyre på 2D-nivået.
- Spilleren kan samhandle med terrenget (plattformer, vegger)
- Monstre som kan elimineres og eliminere spilleren.
- Et mål for spilleren å nå og fullføre nivået.
- Bakgrunnsmusikk og lydeffekter når visse hendelser skjer.

# <u>Oppsummering</u> - A5
Målet var å omstrukturere koden fra skjelettkoden og til model-view-controller.
Vi opprettet ny packages (mapper) med model, view, controller, grid. Inni controller grid og view, lagde vi en interface og en klasse.
I model så lagde vi GameState for å kunne lage velkomstskjerm, pauseskjerm osv.
Emil delte opp selve koden fra helloWorld og inn i model-view-controller, og i main slik at vi kunne kompilere og kjøre koden.

Mina og Emil støtte på litt problemer med git. Da emil skulle laste ned programmet og begynne med omstruktureringen, så hadde han problem med maven og det ville ikke kompilere, så han reinstallerte IDE og maven for å fikse.
De pushet til main branch istedenfor å bruke den diskuterte git arbeidsflyten ved å lage egne branches.
De pushet hver for seg til main, istedenfor branches, men nå er gjennomgang av hvordan man lager branch og merging gjort.
I denne omgang var det ikke direkte nødvendig med branches fordi Emil og Mina satt sammen og parprogrammerte, samt de kunne "avtale" pushingen til main branch.

Vi har enda ikke brukt Kaban board ettersom vi ikke 100% har kommet i gang med arbeidsflyten, men git issue board blir et verktøy vi skal ta i bruk fra neste uke av.

Emil og Tobias fikk vendt seg litt til IntelliJ etter å ikke brukt det på 2 semestre, og vi føler vi er på god vei fram 
til nå og har en tydelig visjon på hvordan vi vil gå framover med utviklingen av spillet.

I startfasen har det vært litt krøll, men dette er jo vår første gang vi organiserer slikt gruppearbeid så har ikke forventet at vi skulle ha 100% kontroll.
Ellers føler vi at vi har hatt god struktur og diskutert oss fram til planlegging av prosjektet på en god måte.
Hver startfase av et prosjekt har jo gjerne en liten periode før ting faller på plass.

Vi har alle nå også fått prøvd git-arbeidsflyten.  
Så alle har fått laget en branch, gjort endringer på branchen, lagd merge request,
godkjent en annens merge request og pull-et andres endringer.
