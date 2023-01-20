# SDE Program
#### Authors: Levi-Jesse

Dit programma helpt bij het ontwerpen en bouwen van auto's.

Een klein stappenplan:
Men start in fase van het ontwerpen van de auto. Dit wordt bepaald door vragen te stellen aan de gebruiker.
Daarna worden er een paar vragen over het design van de auto gesteld. 
Als alles goed is wordt de auto gebouwd en wordt er een handleiding opgesteld voor deze specifieke auto.
Uiteraard wordt na elke fase een controle uitgevoerd of de auto nog aan de wensen en verlangens van de gebruiker voldoet.

_Builder_ (creational pattern)
Wij hebben de builder gebruikt om complexe objecten stap bij stap te maken. Hierdoor kunnen wij makkelijk dit object maken op basis van de keuzes van de gebruiker.
In ons programma is het mogelijk om 3 type auto's te maken met een unieke blueprint en design, geselecteerd door de gebruiker.
Files:
- Builder
- Car
- CarBuilder
- Director

_Facade_ (Structural pattern)
Wij hebben een facade gemaakt voor het versimpelen van de interactie tussen de classes en interfaces.
Files:
- CarFacade

_State_ (behavioral pattern)
Wij hebben een state gebruikt om de houding van de auto te veranderen. Deze houding wordt beinvloed door de antwoorden van de gebruiker. Na een aantal vragen wordt de volgende state aangeroepen.
Files:
- CarState
- BlueprintState
- DesignState
- ShowcaseState

_Template Method_ (behavioral pattern)
Wij hebben de template method toegepast in onze manual. Deze manual is de superclass met daaronder 3 verschillende subclasses. 
Deze houden de manual template aan, maar overriden verschillende stappen om de manual aan te passen aan het type auto en de geselecteerde keuzes.
Files:
- ManualTemplate
- SportscarManual
- SUVManual
- LimousineManual

Here you can see amazing progress