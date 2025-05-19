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
  ```

## 🚀 Lancement de l'application

### Prérequis
- Java installé
- Maven installé
- MySQL ou H2 Database (selon configuration)

### Installation
1. Cloner le dépôt :
```bash
git clone https://github.com/Safae26/spring-data-jpa-products-management-app.git
  ```
2. Lancer l'application :
   ``` mvn spring-boot:run```

L'application sera disponible sur : http://localhost:8086

## Tests initiaux
Des données de test sont automatiquement insérées au démarrage via la méthode run() dans la classe principale. Les opérations suivantes sont effectuées et affichées dans la console :

1. Insertion de 3 produits :
   - Computer (4300€, quantité: 3)
   - Smart Phone (1200€, quantité: 10)
   - Printer (1000€, quantité: 9)
2. Affichage console des opérations :

  ```properties
  // 1. Affichage de tous les produits
  Product(id=1, name=Computer, price=4300.0, quantity=3)
  Product(id=2, name=Smart Phone, price=1200.0, quantity=10)
  Product(id=3, name=Printer, price=1000.0, quantity=9)
  
  // 2. Recherche par ID (ex: ID=1)
  ************************
  1
  Computer
  4300.0
  3
  ************************
  
  // 3. Tests des méthodes de requête
  ------------------------
  FIND BY NAME
  Method 1: findByNameContains("n")
  Product(id=3, name=Printer, ...)
  ------------------------
  Method 2: search("%C%")
  Product(id=1, name=Computer, ...)
  ```
Exemple de sortie console :

```bash
Product(id=1, name=Computer, price=4300.0, quantity=3)
Product(id=2, name=Smart Phone, price=1200.0, quantity=10)
```
