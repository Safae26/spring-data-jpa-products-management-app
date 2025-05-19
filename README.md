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

L'application est configurée pour utiliser MySQL par défaut. La configuration se trouve dans `application.properties` dans le dossier 'repositories' :

```properties
# Configuration MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/PRODUCTS_DB?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=

# Configuration Hibernate
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```
### A ajouter dans le fichier 'pom.xml' :
```
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

## 📁 Structure du projet
<img width="556" alt="capture" src="https://github.com/user-attachments/assets/1087f134-15bf-461b-8d7a-d4815ef5e85a" />

## Package entities 
### Classe 'Product' :
<img width="594" alt="prod" src="https://github.com/user-attachments/assets/6c70340b-f9ef-481e-8e2c-cc3f101ce6e5" />

## Package repositories
### Classe 'ProductRepository'
<img width="659" alt="repo" src="https://github.com/user-attachments/assets/d729b5be-a509-4f11-a780-2b82cd4291f6" />

## Package web
### Classe 'ProductRestService' :
<img width="761" alt="rest" src="https://github.com/user-attachments/assets/f89abe80-ef5a-4a40-ba51-bc997827379e" />

## 'SpringDataJpaProductsManagementAppApplication' :
<img width="775" alt="test1" src="https://github.com/user-attachments/assets/1dd457a3-736d-48f4-ac9c-3f5bca826fff" />
<img width="773" alt="test2" src="https://github.com/user-attachments/assets/7ea72ec4-4b58-47a2-888a-dd5b9b9d6e99" />


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
- XAMP

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
Donc, on lance XAMP :

<img width="497" alt="xamp" src="https://github.com/user-attachments/assets/2e720751-9d8c-41be-802e-87d2fed6bfad" />

Et on clique sur 'admin' de la ligne de 'MySQL'.
On remarque que notre base de données 'products_db' a été créée avec succès :

<img width="223" alt="db" src="https://github.com/user-attachments/assets/242e07d2-b492-4077-845d-897b5d064cbf" />

- Table Products :
  
  <img width="424" alt="products" src="https://github.com/user-attachments/assets/a96287eb-8db8-4820-8f38-e8fc2b8c466c" />

- Résultats dans la console :
  
  <img width="749" alt="console" src="https://github.com/user-attachments/assets/f316ccd5-6c4f-4ee3-9377-45a09eba53df" />

## 📡 Endpoints API

| Méthode | Endpoint          | Description                          |
|---------|-------------------|--------------------------------------|
| `GET`   | `/products`       | Récupère la liste de tous les produits |
| `GET`   | `/products/{id}`  | Récupère un produit spécifique par son ID |

- '/products' :
  
  <img width="478" alt="prods" src="https://github.com/user-attachments/assets/d846a6bf-58dc-4b30-b7e0-22ba7154f110" />

- '/products/{id}' :
  
  <img width="478" alt="prod2" src="https://github.com/user-attachments/assets/730cc487-e267-47dd-ae62-08a30b41e07c" />


## Auteur
**Safae ERAJI**
