# Based Andmebaasid I

## Nõuded
MySQL või PostgreSQL.

## Konfigureerimine
Kopeeri `config/config.sample.json` -> `config/config.json` ja muuda selle sisu vastavalt (host, kasutajanimi, parool, andmebaas, andmebaasi tüüp).

```
{
  "development": {
    "username": "root",
    "password": "parool",
    "database": "andmebaas",
    "host": "127.0.0.1",
    "dialect": "mysql"
  }
}
```

## Kuidas installida
```
cd kaust_kuhu_repo_kloonisid
npm install
```

## Kuidas käivitada
```
node server.js
```