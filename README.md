# Spring [![wakatime](https://wakatime.com/badge/github/josue-lubaki/SpringBoot-Pratices.svg)](https://wakatime.com/badge/github/josue-lubaki/SpringBoot-Pratices)
 Pratique sur les principes de base de Spring et Spring Boot

Démarrage project : https://start.spring.io/ <br>
console : <br>
-- $ set JAVA_HOME=C:\Program Files\Java\jdk-11.0.11 <br>
-- $ mvnw spring-boot:run <br>
Demander à Maven de rebuilder l'appplication <br>
-- $ mvnw clean install

# Patterns Utilisés
    - Repository
    - controller
    - Service
    - Contrat

* L'inversion de contrôle est le fait d'avoir une classe Centralisée qui se charge d'instancier et de mettre en relation les differents composants du logiciel
grâce à l'injection de dépendance.

* Le contenuer leger de Spring : est un mecanisme qui consiste à stocker les informations de la configuration dans un système de fichier, lire les fichiers en instanciant les classes, faire les new Insatances et mettre en relation les composants en invoquant les setters pour l'injection de dépendance. Il effectue l'inversion de contrôle et garde en mémoire tous les composants instanciés durant la toute la vie de l'application, ceci sous forme de graphe pour materialiser les dépendances qui existent entre ces composants.
