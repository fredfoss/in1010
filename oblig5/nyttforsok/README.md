## Lete etter og behandle mønstre i immunrepertoarer

Program som ved å analysere blodprøver finner sekvensmønstre som indikerer en
infeksjon av et bestemt virus.

## Metode

Analysere immunrepertoarene – DNA-sekvenser av immunceller i blodet – til
personer som vi vet er blitt smittet eller ikke er  blitt smittet av et bestemt
virus.

## Oppsett

* **Immunrepertoar**
 - Mange immunreseptorer, én per linje
 - Én fil per person

* **Immunreseptor**
  - Protein som kjennkjenner viruset
  - Sekvens av (store) bokstaver

* **Subsekvens (substreng)**
  - Mønstre i immunreseptorer
  - String med lengde 3

## Steg 1 i algoritmen

Lese N filer og lage N HashMaps, der en HashMap inneholder alle subsekvensene
til en person.

## Steg 2 i algoritmen

Slå sammen eller flette HashMaps for å finne subsekvensene som forekommer hos
mange personer.
