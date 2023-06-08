# oblig0-in1010
Obligatorisk oppgave 0 i IN1010

## Oppgavetekst
Innleveringen består av 7 klasser og én tegning (syv .java-filer og en bilde-fil): De tre
hovedklassene BilBruk1.java, BilBruk2. java og BilBruk3.java , de fire klassene Bil1.java,
Bil2.java, Bil3.java og Person.java samt et bilde av svaret på oppgave 3d. De tre BilBruk-
klassene skal kunne kompileres og kjøres som java-programmer med hver sine main-metoder.

### Oppgave 1.

Skriv klassen Bil1 med en metode som skriver ut “Jeg er en bil”. Skriv en klasse som du
kaller BilBruk1 med en main-metode som oppretter et bilobjekt. La til slutt main-metoden
kalle skriv-metoden i dette bilobjektet.


### Oppgave 2.

Kopier innholdet i klassen Bil1 til en ny klasse Bil2. Utvid deretter klassen Bil2 slik at alle
biler får et bilnummer (en String). Når programmet oppretter et bil-objekt skal bilnummeret
få verdi ved hjelp av konstruktøren til klassen. Modifiser skriv-metoden slik at den skriver ut
nummeret på bilen. Lag et program (en klasse med en main-metode) som du kaller
BilBruk2, som oppretter en bil med et bilnummer og som til slutt kaller skriv-metoden i dette
bil-objektet.


### Oppgave 3.

3a) Kopier innholdet i klassen Bil2 til en ny klasse Bil3. Utvid deretter klassen Bil3 slik at
alle biler nå får en metode hentNummer().

3b) Lag en klasse Person. Alle personer skal eie en bil, og når programmet oppretter et
person-objekt skal en referanse til personens bil (av klassen Bil3) være parameter til
konstruktøren. Alle Person-objekter skal inneholde en skriv-metode som skriver ut
bilnummeret til bilen som personen eier.

3c) Lag et program BilBruk3 der main-metoden først oppretter en bil og deretter en person
som eier denne bilen. Til slutt skal programmet kalle skriv-metoden i dette Person-objektet.

3d) Tegn datastrukturen slik den er etter at main-metoden har opprettet et person-objekt. Du
kan for eksempel lage en tegning som du tar bilde av med mobilen.
