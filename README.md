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
```
## 📁 Structure du projet
<img width="556" alt="capture" src="https://github.com/user-attachments/assets/1087f134-15bf-461b-8d7a-d4815ef5e85a" />

## 📡 Endpoints API

| Méthode | Endpoint          | Description                          |
|---------|-------------------|--------------------------------------|
| `GET`   | `/products`       | Récupère la liste de tous les produits |
| `GET`   | `/products/{id}`  | Récupère un produit spécifique par son ID |

## 🔍 Fonctionnalités Spring Data JPA

1. Méthodes de requête dérivées

L'application utilise les conventions de nommage de Spring Data JPA pour générer automatiquement des requêtes :

- `List<Product> findByNameContains(String keyword)`  
  Recherche les produits dont le nom contient la chaîne donnée  
  **Exemple** : `findByNameContains("Comp")` → ["Computer"]

- `List<Product> findByPriceGreaterThan(double price)`  
  Filtre les produits dont le prix est supérieur à la valeur donnée  
  **Exemple** : `findByPriceGreaterThan(1000)` → ["Computer", "Smart Phone"]
  
2. Requêtes JPQL personnalisées
  ```properties
  @Query("select p from Product p where p.name like :x")
  List<Product> search(@Param("x") String keyword);
  
  @Query("select p from Product p where p.price > :x")
  List<Product> searchByPrice(@Param("x") double price);
  ```
