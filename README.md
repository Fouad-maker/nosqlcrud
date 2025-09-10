# nosqlcrud

# Spring Boot Application

This project is a Spring Boot application that requires MongoDB as its data store.  
You can run MongoDB locally using Docker Compose.

---

## 🚀 Requirements

- **Spring Boot:** 3.x
- **Java:** 17
- **Maven:** 3.6+
- **Docker:** Installed and running

---

## 📦 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-org/your-repo.git
   cd your-repo

2. **Start MongoDB with Docker Compose**

   Run the following command in the project root folder:
   ```bash
   docker compose up -d

This will spin up a MongoDB container in the background.
The default connection URL will be:

mongodb://localhost:27017

3. **Run the application**

Use your preferred IDE (IntelliJ, Eclipse, VS Code, etc.)
   or run with Maven:
  ```bash
  mvn spring-boot:run
