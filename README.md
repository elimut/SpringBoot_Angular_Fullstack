# Devenir FullStack (Spring Boot / Angular) par la pratique

- Projet de gestion de stock from scratch; 
- API et son Application Web (Angular)  qui est riche en services et similaire aux applications développées dans le monde professionnel
- Technologies Spring Boot, Spring Security, Hibernate, OpenApi, Postman, Angular, TypeScript, Chart, .... 
- Conception UML, application des bonnes pratiques de programmation (Design patterns), tests unitaires.

## Installation 

IntelliJ:

[IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

Postgresql:

[Postgresql](https://www.postgresql.org/download/)

## Introduction au framework Spring Boot

**Spring** est un framework open source pour développer des applications entreprise.
Vise à simplifier le process complet de développement d'applications Java Entreprises en offrant un cadre qui inclus les technologies telles que l'**injection de dépendances** (corps du framework Spring).
Léger, qui peut être utilisé pour créer des applications web d'entreprises évolutives, sécurisées, et robustes.
Collection de sous frameworks tels que Spring Boot, Spring MVC, ...

**Spring boot** approche pour développer des applications basées sur Spring, avec très peu ou pas de configurations:
avec Spring l'on faisait beaucoup de configurationet surtout XML.
Il exploite les projets Spring Boot existant ainsi que des projets tiers pour développer des applications prêtes pour la production:
il utilise des **starters** => projets Spring boot existants et qui font quelque chose pour nous (exemple se connecter à une BDD).
Il fournit un ensemble de starters: gradle, Maven, POM, ... de fichiers de configurations que l'on peut utilier pour ajouter les dépendances requises et faciliter la configuration automatique ou gestion des dépendances.
En fonction des bibliothèques sur son **classpath**, il configure automatiquement les classes requises: informations minimales forunit dans le fichier applicatiopn.property ou YAML, comme URL, chemin BDD, nom user, ...

Pour intéragir avec une DB, s'il existe une bibliothèque Spring Data(dépendances), elle définira automatiquement la connexion à la DB avec un minimum de configuration.

Spring simplifie le développement d'applications web, et Spring boot a été créé pour faciliter le développement d'applications Spring.

Permet de créer des applications **standalone**: on développe une application et après on a directement une application qui tourne de façon automatique.

Il intègre le **Tomcat** Gadget / Jetty: plus besoin de déployer des fichiers War. 

Fournit des starters pour simplifier la configuration. 

Configure automatiquement quand c'est possible. Intégration starter ou autre dans l'application => il va essayer de configurer automatiquement cette dépendance.

Aucune génération de code, aucune exigence pour la configuration XML.

### Inversion de conrôle(IoC)

**IoC** (Inversion of Control) Container:
ce principe est une des prinicpales fonctionnalités de Spring qui offre un moyen simplifié de configurer et gérer des objets Java.
Ce container est responsable du cycle de vie d'un objet Java défini augmentant considérablement la configurabilité d'une application basée sur Spring.
Utilise le modèle d'injection de dépendances ou de recherche de dépendancces pour fournir la référence d'objet pendant l'exécution => déléguer toute la partie  de gestion du cycle de vie d'un objet Java, ou objet Spring à ce conteneur.
C'est l'injection des dépendances => si une classe A a besoin d'une classe B où il ne faut pas instacier B dans A, mais il faut injecter B dans A (injecter =  déleguer cette opération au framework Spring pour qu'il puisse gérer tout le cycle de vie de cet objet): mot clef **Autowired**.


### Spring Bean?

Mot clef **Bean**:
concept clé du framework Spring.

C'est un objet (classe Java) dont le cycle de vie est géré par le conteneur Spring (Ioc). Donc toute classe ou tout objet qui dans le cycle de vie est géré par le framework Spring est un Spring Bean. 

### Le cycle de vie d'un Spring bean

Le cycle de vie de tout objet signifie quand et comment il est créé, comment il se comporte tout au long de son instanciation, et quand et comment il est détruit .
De même, le cycle de vie du bean fait référence au moment et la manière dont le bean est instancié, à l'action qu'il effectue jusqu'à ce qu'il vive et au moment et à la manière dont il est détruit.

C'est la création tout au long de sa vie et la destruction ou bien la mort d'un objet.

Cycle de vie d'un bean géré par le conteneur Spring:

exécution programme, le conteneur Spring démarre, scanne les composants,
le conteneur crée l'instance d'un bean conformèment à la demande, je crée ou développe une application , j'au uncontroller ou endpoint qui permet d'afficher Hello World lorsque j'en fais l'appel, Srping sait qu'il doit injecter ou doit créer un objet ou bean qui permet ou contient le code nécessaire.
les dépendances sont injectées, ça veut dire la calsse A utilise la classe B, Spring préparé le'objet B , le crée et l'injhecte dans la classe A,
destruction du bean quand le conteneur est arrêté.

Si l'on veut exécuter du code au moement de l'instanciation du bean et juste après l'arrêt du conteneur Spring, l'on peut écrire ce code dans la méthode personnalisée init() et la méthode destroy()

### L'annotation @Component

Une des annotations les plus importantes de Spring.
Cela indique à Spring  de savoir quels sont les classes à gérer (**managed bean**).

Classe utils avec des méthodes somme a et b, et a * b.
Dans une autre classe main, utils class new utils et après utils.add,...
pour utiliser cette classe.
Je veux déléguer l'instanciation de cette classe utils au framework ou au conteneur Spring.
Transformation en un objet ou Spring bean => ajout @component au niveau de la classe utils.
Automatiquement, cette classe deviendra un managed bean.
Et sera automatiquement injecté et le cycle de vie géré pas Spring.

Cela permet de marquer les beans comme managed bean, Spring les détectera automatiquement pour l'injhestion des dépendances.

### Différence entre @Component, @Service, et  @Repository

Il n'y a pas de différence, la notation service est la même chose que la notation component et la notation repository.

class animal, class chat et class chien.
le chat extends animal et chien également.

Service et repository sont des components.

Objectif de ces annotations:
distinction métier.

**@Service** dans classe: classe de service qui implémente les règles de gestion de l'application, ou une partie de l'application.
**@reporistory**: cette classe permet de faire la persistance des données => n'implique pas forcèment une DB, stockage dans la mémoire, ...

### @Autowired

Elle indique à Spring comment gérer l'instanciation de la classe, il commence donc à rechercher cette dépendance parmi les composants/classe pour trouver une correspondance.

private B class B @autowired => Spring cherche une correspondance, une classe qui implemente la classe b si c'est une interface, ou une classe B pour pouvoir l'injecter.

Elle permet automatiquement d'injecter un objet, Spring va chercher une implémentation.

interface A qui contient 3 méthodes class A implements class A
private A interface A; @autowired => Spring sait qu'il a un objet interface A, et va la chercher pour l'injecter, il va démarrer et chercher cette classe, et va créer une instance de type classe A dans le controller.

## Créer et comprendre un projet Spring Boot

### Comment créer un projet Spring Boot

Deux méthodes:

- sur le web,
- soit directement sur l'IDE.

**Spring initializr**:

[spring initilizr](https://start.spring.io/)
permet de créer un projet Spring.

Gestionnaire de dépendances: maven (voir différence gradle)

Group: 
artefact: nom du projet, fille

Dépendances:
connexion DB: Spring Data JPA,
exposer API REST: Spring web (exposer ressources web),
sécuriser: Spring security,
postgreSql







 





## Sources

[Udemy](https://www.udemy.com/course/devenir-fullstack-spring-boot-angular-par-la-pratique/learn/lecture/33845924#overview)