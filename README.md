# andmebaasid

Vajalik on Java RE (vähemalt 1.7), MySQL ja NodeJS.

Enne käivitamist tuleb luua koopia failist **persistence.default.xml** --> **persistence.xml** ning muuta seal ära
MySQL serverit puudutav info (IP, kasutaja, parool, andmebaas).

Seejärel navigeerida **src/main/resources/static/frontend** ning teha käsurealt **bower install** (boweri puudumisel eelneval **npm install bower -g** administraatorina)

Buildimiseks tuleks nüüd käivitada käsk (windowsi all .bat) **gradlew build**.

Rakenduse käivitamiseks **java -jar build/libs/garaazh-0.1.0.jar** ning seejärel avada brauseris 
**http://localhost:8080/frontend/index.html**

SQL lauseid näeb mysqldump käsuga, näiteks on ka fail garaazh_ex.sql
