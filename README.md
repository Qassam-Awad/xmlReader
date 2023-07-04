To include the commands in the README.md file, you can add the following content:

```
## Getting Started

### Prerequisites
- Docker

### Setting Up the Development Environment
1. Pull the MySQL Docker image:
   ```
   docker pull mysql
   ```

2. Create a Docker network for the Spring Boot application and MySQL container:
   ```
   docker network create springboot-mysql-net
   ```

3. Run the MySQL container:
   ```
   docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=order_management -d mysql
   ```

4. Build the project (skipping tests):
   ```
   mvn clean package -DskipTests
   ```

5. Build the Docker image for the Spring Boot application:
   ```
   docker build -t springboot-restful-webservices .
   ```

6. Run the Spring Boot application in a Docker container:
   ```
   docker run --network springboot-mysql-net --name springboot-mysql-container -p 8080:8080 springboot-restful-webservices
   ```

7. The application should now be accessible at [http://localhost:8080](http://localhost:8080).

### Cleaning Up
1. Stop and remove the running Docker containers:
   ```
   docker stop mysqldb springboot-mysql-container
   docker rm mysqldb springboot-mysql-container
   ```

2. Remove the Docker network:
   ```
   docker network rm springboot-mysql-net
   ```
```

Feel free to customize the formatting or add any additional instructions as needed.
