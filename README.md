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
avec Spring l'on faisait beaucoup de configuration et surtout XML.
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
les dépendances sont injectées, ça veut dire la classe A utilise la classe B, Spring préparé le'objet B , le crée et l'injhecte dans la classe A,
destruction du bean quand le conteneur est arrêté.

Si l'on veut exécuter du code au moment de l'instanciation du bean et juste après l'arrêt du conteneur Spring, l'on peut écrire ce code dans la méthode personnalisée init() et la méthode destroy()

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

Gestionnaire de dépendance: maven (voir différence gradle)

Group: 
artefact: nom du projet, fille

Dépendances:
connexion DB: Spring Data JPA,
exposer API REST: Spring web (exposer ressources web),
sécuriser: Spring security,
postgreSql

### Comprendre la structure d'un projet Spring

idea: propre à l'IDE    
.mvn: version maven
pom.xml: fichier qui gère les dépendances du projet. parent, infos propres au projet, ...

src:
main et test
main =< tout code src de l'application et tests pour les tests unitaires ou intégration

static: ressources statiques, templates si on veut utiliser java mail, teamlife, ...

applications.properties: définit les informations, propriétés de l'application comme le port 8080, nouvelle application se connecte à un port différent ajout de la propriété server.port = 8090; spring.application.name = My first application;

YAML est beaucoup plus lisible. 
spring.datasource.driver-class-name=classname

Soit un fichier application.properties soit .yaml

ExempleApplication.java:
@SpringBootApplication

### Ajout d'une nouvelle dépendance Maven au projet

Load maven changes

### Première API REST 'Hello World'

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class


Echoue à configurer datasource:

starter data jpa n'a pas trouvé le minimum de configuration pour se connecter.

application-dev.yaml
If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).
, pour définir l'environnement qu'on veut utiliser:
edit configuration profiles démarre sur profil dev 
 environments variable: spring.profiles.active=dev

properties/yaml # commentaires

application puis application-dev 

suppression datajpa

dependance security:
Using generated security password: bcd75c27-a6c7-4b92-8ad8-54261e118e2b

This generated password is for development use only. Your security configuration must be updated before running your application in production.
autoconfiguration avec des valeurs par défaut

Spring va utiliser le starter avec le minimum de configuration.

controller.HelloWorldController pour par exemple package com.anneso.exemple.controller
Dès qu'il y a un point crée un sous-package 

Dans cette classe on indique que c'est un controller et qu'elle doit être gérée automatiquement par Spring => bean/@RestController

@RestController extend le body et le controller: dans cette annotation, l'on a déjà 

@Controller et @RestController
différence pour utiliser @Controller et envoyer la réponse sousforlmat json on doit ajouter @ResponseBody

Pour créer un controlleur d'une façon général: @RestController

2023-09-19T11:36:40.156+02:00  INFO 11212 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8090 (http)
tomcat serveur: 
applicationTomcat a démarré sur le port 8090 avec un contexte path vide, pour accèder à un controlleur: http://localhost:8090

On dit à Spring c'est un Rest Controller.

L'annotation controller étend déjà l'annotation component => RestController est aussi un compoinent, Spring au démarrage va trouver une classe HelloWorld avec une annotation qui étend la classe component, et il va gérer automatiaquement cette classe et la transformer en un Spring Bean.

L'annotation component est l'annotation parent de toutes les autres annotations.

Après l'annotation, l'on doit donner un chemin d'accès:
je veux accèder à cette ressource, exemple:
http://localhost:8090/hello
cette URL doit renvoyer une réponse.
=>
**@RequestMapping**, cette annotation prend un nom, path, value
Le mapping c'est /hello, l'URL va pointer vers le controller HelloWorldController

Création d'une **opération**: exemple http://localhost:8090/hello/say je veux renvoyer un résultat.

méthode sayHello, pour accèder à cette opération http://localhost:8090/hello/say, je dois donner le chemin pour cette méthode:
deux façons => types d'opération POST, GET, PUT, DELETE, PATCH
GetMapping récupération d'un message.

Création package services:

MessageService:
méthode qui va permettre d'afficher un message.

Utilisation d'une interface: contrat de service, on a des méthodes qui doivent être implémentées.
IMessageService, implémenter interface dans le service, il faut absolument implémenter les méthodes.

Injection du service dans le controller: @Autowired pour injecter automatiquement cette propriété.
Spring va chercher toutes classes qui implémentent le IMessageService pour l'implémenter

Création nouvel endpoint: @GetMapping("/say-service")

@Autowired Spring va chercher une implémentation pour l'interface, mais que se passe t'il si nous avons deux implémentations de cette interface?
Au démarrage, quand on veut injecter une dépendance, Spring va chercher l'objet interface, il va chercher un bea de type Spring pour injecter ou créer une instance du type.
Sans annotation service ou component @autowired => message erreur mais l'application peut démarrer.
Cas où l'on a l'annotation mais plusieurs implémentations de l'interface.
Erreur car on ne peut avoir qu'une implémentation.
Soit marquer l'un des deux en tant que bean primaire ou mettre à jour le consommateur pour accepter plusieurs beans, ou utiliser **@Qualifier**.

**@Primary**:
bean prioritaire, lorsque Spring veut injecter un objet, il trouver plusieurs implémentations.
Il va chosir selon la priorité 

 package com.anneso.exemple.services;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Primary;
 import org.springframework.stereotype.Service;
 
 @Service
 @Primary
 public class MessageServiceImpl2 implements IMessageService {
 
         @Override
         public  String sayHello() {
             return "Hello rom the second";
         }
 
 }

Deuxième solution:

lorsque l'on ajoute l'annotation, on peut donner un nom ou valeur.

(retrait @primary)

 package com.anneso.exemple.services;
 
 import org.springframework.stereotype.Component;
 import org.springframework.stereotype.Service;
 
 @Service("MessageService")
 public class MessageService implements IMessageService{
 
     @Override
     public String sayHello() {
         return "Hello from the implemented source";
     }
 }

**@Qualifier**:

package com.anneso.exemple.controller;

import com.anneso.exemple.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 // http://localhost:8090/hello/say
 @RestController
 @RequestMapping("/hello")
 public class HelloWorldController {
 
     @Autowired
     @Qualifier("MessageService")
     private IMessageService service;
 
     @GetMapping("/say-service")
     public String sayFromService() {
         return service.sayHello();
     }
 
     @GetMapping("/say")
     //@RequestMapping(method = RequestMethod.GET)
     public String sayHello() {
         // Methode sayHello qui renvoie une chaîne de caractère
         return "Hello from the other side";
     }
 
 }

Règle: pas de modification existant mais création de nouvelle classe.

## Lombok

### Installation et configuration

Lombok:
Projet/bibliothèque qui permet de générer du code.

Installation du pluggin.

Offre des annotations.

### Les annotations Lombok

lombok.MyData

Dépendances dans POM

Fournit des annotations pour générer du code pour nous.

class MyData (entités) avec des attributs.

Générer des getters et setters, generate clic droit générer avec IntelliJ.

>Le code que vous avez posté est une implémentation des méthodes equals et hashCode dans une classe Java, probablement utilisée pour définir comment les objets de la classe doivent être comparés pour l'égalité et comment ils doivent générer des codes de hachage pour une utilisation dans des structures de données telles que des HashSets ou des HashMaps.
Voici ce que font chacune de ces méthodes :
Méthode equals(Object o) :
Cette méthode est utilisée pour comparer deux objets en termes d'égalité.
Elle commence par vérifier si les deux objets comparés sont la même instance en mémoire (c'est-à-dire this == o). Si c'est le cas, elle renvoie true, indiquant qu'ils sont égaux.
Ensuite, elle vérifie si o est null ou s'il appartient à une classe différente de la classe actuelle (o.getClass() != getClass()). Si l'une de ces conditions est vraie, elle renvoie false, indiquant qu'ils ne sont pas égaux.
Enfin, elle compare les champs individuels (id, firstname et lastname) de l'objet courant (this) avec les champs correspondants de l'objet o en utilisant Objects.equals. Si tous les champs sont égaux, elle renvoie true, sinon elle renvoie false.
Méthode hashCode() :
Cette méthode est utilisée pour générer un code de hachage pour un objet. Les codes de hachage sont utilisés dans les structures de données basées sur le hachage pour localiser rapidement les objets.
Elle calcule le code de hachage en appelant Objects.hash avec les champs qui sont utilisés pour déterminer l'égalité (id, firstname et lastname). Cela garantit que les objets considérés comme égaux selon la méthode equals auront le même code de hachage.
Ce code suit les meilleures pratiques pour implémenter les méthodes equals et hashCode en Java, en veillant à ce que la méthode hashCode soit cohérente avec la méthode equals. C'est important car les objets qui sont égaux doivent avoir le même code de hachage.

 @Override
 public boolean equals(Object o) {
 if (this == o) return true;
 if (o == null || getClass() != o.getClass()) return false;
 MyData myData = (MyData) o;
 return id == myData.id && Objects.equals(firstname, myData.firstname) && Objects.equals(lastname, myData.lastname);
 }
 
  @Override
  public int hashCode() {
      return Objects.hash(id, firstname, lastname);
  }

On peut avoir beaucoup de codes pour quelques attributs d'où Lombok.

  @Getter
  @Setter
  // Constructeur avec paramètres
  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString

// Constructeur avec un seul paramètre
@RequiredArgsConstructor => 

    /*
    public MyData(String firstname) {

        this.firstname = firstname;

    }
     */

=> ajout du mot clef **final** pour empêcher la création d'un objet vide ou de type MyData sans paramètre

compilation fichier

target pour voir ce qui est compilé

@Builder:
design pattern qui permet de construire des objets

@data regroupe différentes annotations comme getter setter ...

Suite dossier banking SpringBoot







## Sources

[Udemy](https://www.udemy.com/course/devenir-fullstack-spring-boot-angular-par-la-pratique/learn/lecture/33845924#overview)