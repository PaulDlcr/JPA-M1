# University Management System

This project is a University Management System implemented using Spring Boot, JPA, and MySQL. It allows for the management of universities, departments, students, teams, and contracts.

## Table of Contents

- [Technologies](#technologies)
- [Setup](#setup)
- [API Endpoints](#api-endpoints)
  - [University Endpoints](#university-endpoints)
  - [Department Endpoints](#department-endpoints)
  - [Student Endpoints](#student-endpoints)
  - [Team Endpoints](#team-endpoints)
  - [Contract Endpoints](#contract-endpoints)
- [Example Requests](#example-requests)

## Technologies

- Java 11
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Jackson (for JSON processing)

## Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/university-management-system.git
   cd university-management-system
   ```

2. **Configure the database:**
   Update the `src/main/resources/application.properties` file with your MySQL database configuration:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Build the project:**
   ```sh
   mvn clean install
   ```

4. **Run the project:**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

### University Endpoints

- **Create a University**
  ```http
  POST /api/universites
  ```
  ```json
  {
      "nomUniv": "Harvard University"
  }
  ```

- **List all Departments of a University**
  ```http
  GET /api/universites/{id}/departements
  ```

- **Assign a Department to a University**
  ```http
  POST /api/universites/{id}/departements
  ```
  ```json
  {
      "nomDepart": "Computer Science"
  }
  ```

### Department Endpoints

- **Create a Department**
  ```http
  POST /api/departements
  ```
  ```json
  {
      "nomDepart": "Computer Science",
      "universite": {
          "idUniv": 1  // Replace with actual university ID
      }
  }
  ```

- **Get a Department by ID**
  ```http
  GET /api/departements/{id}
  ```

- **Update a Department**
  ```http
  PUT /api/departements/{id}
  ```
  ```json
  {
      "nomDepart": "Computer Science Updated",
      "universite": {
          "idUniv": 1  // Replace with actual university ID
      }
  }
  ```

- **Delete a Department**
  ```http
  DELETE /api/departements/{id}
  ```

### Student Endpoints

- **Create a Student**
  ```http
  POST /api/etudiants
  ```
  ```json
  {
      "prenomE": "Alice",
      "nomE": "Smith",
      "option": "GAMIX",
      "departement": {
          "idDepart": 1  // Replace with actual department ID
      }
  }
  ```

- **List all Students**
  ```http
  GET /api/etudiants
  ```

- **Get a Student by ID**
  ```http
  GET /api/etudiants/{id}
  ```

- **Update a Student**
  ```http
  PUT /api/etudiants/{id}
  ```
  ```json
  {
      "prenomE": "Alice Updated",
      "nomE": "Smith Updated",
      "option": "SE",
      "departement": {
          "idDepart": 1  // Replace with actual department ID
      }
  }
  ```

- **Delete a Student**
  ```http
  DELETE /api/etudiants/{id}
  ```

- **Assign a Contract to a Student**
  ```http
  POST /api/etudiants/{id}/contrats
  ```
  ```json
  {
      "dateDebutContrat": "2024-01-01",
      "dateFinContrat": "2024-12-31",
      "specialite": "CLOUD",
      "archive": false,
      "montantContrat": 1000
  }
  ```

- **List all Teams of a Student**
  ```http
  GET /api/etudiants/{id}/equipes
  ```

### Team Endpoints

- **Create a Team**
  ```http
  POST /api/equipes
  ```
  ```json
  {
      "nomEquipe": "Team Alpha",
      "niveau": "SENIOR",
      "detailEquipe": {
          "salle": 101,
          "thematique": "Artificial Intelligence"
      }
  }
  ```

- **List all Teams**
  ```http
  GET /api/equipes
  ```

- **Get a Team by ID**
  ```http
  GET /api/equipes/{id}
  ```

- **Update a Team**
  ```http
  PUT /api/equipes/{id}
  ```
  ```json
  {
      "nomEquipe": "Team Alpha Updated",
      "niveau": "EXPERT",
      "detailEquipe": {
          "idDetailEquipe": 1,  // Replace with actual detail team ID
          "salle": 102,
          "thematique": "Advanced AI Research"
      }
  }
  ```

- **Delete a Team**
  ```http
  DELETE /api/equipes/{id}
  ```

- **List all Contracts of a Team**
  ```http
  GET /api/equipes/{id}/contrats
  ```

### Contract Endpoints

- **Assign a Contract to a Student**
  ```http
  POST /api/etudiants/{id}/contrats
  ```
  ```json
  {
      "dateDebutContrat": "2024-01-01",
      "dateFinContrat": "2024-12-31",
      "specialite": "CLOUD",
      "archive": false,
      "montantContrat": 1000
  }
  ```

## Example Requests

Here are some example requests you can use to test the API using Postman or any other API testing tool:

### Creating a University

**Request:**
```http
POST /api/universites
```

**Body:**
```json
{
    "nomUniv": "Harvard University"
}
```

### Creating a Department

**Request:**
```http
POST /api/departements
```

**Body:**
```json
{
    "nomDepart": "Computer Science",
    "universite": {
        "idUniv": 1
    }
}
```

### Creating a Student

**Request:**
```http
POST /api/etudiants
```

**Body:**
```json
{
    "prenomE": "Alice",
    "nomE": "Smith",
    "option": "GAMIX",
    "departement": {
        "idDepart": 1
    }
}
```

### Creating a Team

**Request:**
```http
POST /api/equipes
```

**Body:**
```json
{
    "nomEquipe": "Team Alpha",
    "niveau": "SENIOR",
    "detailEquipe": {
        "salle": 101,
        "thematique": "Artificial Intelligence"
    }
}
```

### Assigning a Contract to a Student

**Request:**
```http
POST /api/etudiants/{id}/contrats
```

**Body:**
```json
{
    "dateDebutContrat": "2024-01-01",
    "dateFinContrat": "2024-12-31",
    "specialite": "CLOUD",
    "archive": false,
    "montantContrat": 1000
}
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```
