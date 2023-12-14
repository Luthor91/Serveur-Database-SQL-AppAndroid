# Ces actions doivent être faites une fois lancé sur IntelliJ Ultimate 

## Tout à droite, cliquer sur Database
- New - Data Source - MySQL
- User : root  - Password : admin
- database : shop_online

## Ensuite, installer GlassFish 6.2.5

### Sur IntelliJ 
- Sélectionner la JRE par défaut
- Server Domain : domain1
- Username admin  - aucun password

### Sur le PC
- Télécharger le driver mysql "mysql connector 8.0.3"
- Placer le driver dans le dossier GlassFish C:\glassfish\glassfish6\glassfish\domains\domain1\lib
- Installer MySQL et placer le dump shop_online.sql dans une Base de Données "shop_online"

## Derniers réglages sur IntelliJ
### Installer les librairie suivantes :
- hibernate.org
- hibernate c3p0
- mysql-connector-8.0.2
  
### Installer les plugins suivants :
- GlassFish par JetBrains
- JPA Buddy par JetBrains

### Reglages :
- File - Projet Settings - Application Servers - GlassFish 6.2.5
- 
