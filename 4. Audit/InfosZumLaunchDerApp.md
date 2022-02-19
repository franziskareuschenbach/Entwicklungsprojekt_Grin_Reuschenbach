# Start in Android Studio
Es kann sein, dass Android Studio nicht mit der neusten Gradle Version (7.1.1) läuft. Dies lässt sich meistens dadurch beheben, dass Android Studio selbst eine
Benachrichtigung einer neuen Gradle Version erscheinen lässt. Einfach dieser Nachricht folgen und dann sollte alles klappen.
Das gleiche gilt auch dafür, wenn die Kotlin PlugIns nicht mehr aktuell sind.

# Starten der App mittels Emulator
Sollten Sie noch keinen Emulator in Android Studio eingerichtet haben, klicken Sie in dem geöffneten Projekt oben Rechts auf den Device Manager und wählen sie den Reiter 
"Create Device".
Nun Können Sie aus einer Vielzahl von Geräten aussuchen, wir Empfehlen das Pixel 2 mit der Größe 5,0", da wir bei der Entwicklung auch mit diesem Gerät gearbeitet haben.
Nachdem Sie auf "Next" geklickt haben müssen Sie ein System Image aussuchen. Wählen Sie dort "R" aus und Downloaden Sie es wenn Nötig. Wir benutzen R, weil es auf Android 11 basiert und stabil läuft.
Nun können Sie dem Gerät einen eigenen Namen geben, oder bei der Default Bezeichnung bleiben. Die Startup Orientation sollte bei Portrait sein.
Nachdem Sie auf "Finish" geklickt haben, wird sich ihr neuer Emulator einrichten und Sie können die App starten.

Bedenken Sie, dass es etwas dauern kann, wenn Sie den Emulator das erste mal starten, weil sich das Gerät erstmal einrichten muss.

# Starten der App mittels USB- Debugging und Android Smartphone
Um die App auf Ihrem Android Gerät laufen lassen zu können, müssen Sie erstmal die Entwickleroptionen/ Developer Options auf dem Gerät freischalten.
Dies machen Sie, indem Sie in den Informationen über Ihr Gerät 7-10 mal auf die Build Nummer klicken. 
Nun sollten Sie in den Systemeinstellungen den Unterpunkt Entwickleroptionen aussuchen.
In diesen Einstellungen scrollen sie dann runter, bis Sie die Option "USB-Debugging" sehen. Die Funktion togglen Sie auf An.
Jetzt müssen Sie das Gerät mit Ihrem PC oder Laptop mittels USB verbinden. Android Studio sollte Ihr gerät direkt erkennen und auf dem Smartphone sollte die Nachricht 
"USB-Debugging zulassen?" aufploppen. Diese müssen Sie bestätigen und dann wird die App auf Ihrem Gerät geladen.
