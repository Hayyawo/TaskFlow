# TaskFlow - Team Task Management

## 📋 Description
TaskFlow is a web application for managing tasks in small teams. It allows users to create, assign, and track task statuses. The application is built using a microservices architecture with Spring Boot, AWS integration, and CI/CD automation using GitHub Actions.

---

## 🚀 Features
1. **User Management**:
   - Registration, login, and JWT-based authentication.
2. **Task Management**:
   - Create, edit, delete, and assign tasks.
   - Task statuses: "To Do," "In Progress," "Done."
3. **Email Notifications**:
   - Send notifications using Amazon SES.
4. **Change History**:
   - Track task status changes stored in Amazon DynamoDB.
5. **Public API**:
   - REST API for external integrations.

---

## 🛠️ Tech Stack
- **Backend**: Java, Spring Boot, Spring Data JPA, Spring Security (JWT)
- **Database**: PostgreSQL (Amazon RDS), Amazon DynamoDB
- **Cloud**: AWS (RDS, SES, S3, ECS/Elastic Beanstalk)
- **CI/CD**: GitHub Actions
- **Containerization**: Docker
- **Testing**: JUnit, Mockito

---

## ⚙️ Getting Started

### Prerequisites
Make sure you have the following installed:
- **Java 17+**
- **Maven**
- **Docker**
- **AWS CLI** (configured with appropriate permissions)

### Clone the Repository
```bash
git clone https://github.com/your-username/taskflow.git
cd taskflow
