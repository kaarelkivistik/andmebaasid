# andmebaasid

Vajalik on Java RE (vähemalt 1.7) ja MySQL.

Enne käivitamist tuleb luua koopia failist **persistence.default.xml** --> **persistence.xml** ning muuta seal ära
MySQL serverit puudutav info (IP, kasutaja, parool, andmebaas).

Pärast kloonimist tuleb käima panna gradlew (windowsi all .bat) **gradlew build**.

Rakenduse käivitamiseks **java -jar build/libs/garaazh-0.1.0.jar** ning seejärel avada brauseris 
**http://localhost:8080/frontend/index.html**
