# Spring Data JPA - Gestion de Produits

Une application de gestion de produits développée avec Spring Boot et Spring Data JPA, supportant à la fois MySQL et H2 Database.

## 🛠 Technologies utilisées

- **Java 17**
- **Spring Boot 3.4.5**
- **Spring Data JPA**
- **MySQL** (base de données principale)
- **H2 Database** (pour le développement)
- **Lombok** (pour la réduction de code boilerplate)
- **Maven** (gestion des dépendances)

## ⚙ Configuration

### Prérequis

- JDK 17 installé
- MySQL installé (optionnel pour le développement)
- Maven installé

### Configuration de la base de données

L'application est configurée pour utiliser MySQL par défaut. La configuration se trouve dans `application.properties` :

```properties
# Configuration MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/PRODUCTS_DB?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=

# Configuration Hibernate
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
