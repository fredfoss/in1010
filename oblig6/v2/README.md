# Game of Life m/ GUI

For å lage et GUI-grensesnitt for dette spillet, bruker jeg Java Swing og
AWT-bibliotekene. Lager en Model-View-Controller (MVC) arkitektur for å
organisere koden og separere logikken fra presentasjonen.

**MVC-arkitekturen for dette spillet:**
- Model: `Celle`, `Rutenett` og `Verden` klassene som representerer selve spillet og dens elementer.
- View: `View` klassen som viser spillet og dens elementer i et grafisk brukergrensesnitt.
- Controller: `Controller` klassen som håndterer brukerinteraksjoner og oppdaterer modellen og visningen deretter.

- Hovedprogram kjører alt


