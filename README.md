# TODO Rails 📝

**A Personalized Full Stack Task Management Application**

---

## 📖 About The Project

TODO Rails is a comprehensive web-based task management application designed to help users organize their daily tasks efficiently. Built with modern web technologies and following the MVC architecture pattern, this application provides a secure, personalized environment where users can add, prioritize, edit, and track their tasks seamlessly.

### 🎯 Mission Statement
*"Simplifying Task Management Through Technology"* - Our application bridges the gap between conceptual knowledge and practical implementation, providing hands-on experience in full-stack development while creating a functional productivity tool.

### ✨ Key Features
- 🔐 **Secure Authentication** - User registration and login system with protected routes
- 📋 **Personalized Task Lists** - Individual task management for each user
- 🎯 **Task Prioritization** - Set priority levels for better task organization
- 📅 **Due Date Management** - Track deadlines and manage time effectively
- 🏷️ **Task Categories** - Organize tasks by type (Personal, Official, etc.)
- ✏️ **CRUD Operations** - Create, Read, Update, and Delete tasks
- 📱 **Responsive Design** - Optimized for both desktop and mobile devices
- ⚡ **Interactive UI** - Client-side validations and smooth user interactions

---

## 🛠️ Built With

### Frontend Technologies
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)

### Backend Technologies
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

### Database & Build Tools
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-1021FF?style=for-the-badge&logo=h2&logoColor=white)

---

## 🚀 Getting Started

### Prerequisites
Before you begin, ensure you have the following installed:
- Java 11 or higher
- Maven 3.6 or higher
- IDE (IntelliJ IDEA, Eclipse, or VS Code)
- Modern web browser

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/todo-rails.git
   cd todo-rails
   
2. Build the project
```bash
mvn clean install
```
3. Run the application
```bash
mvn spring-boot:run
```
4. Access the application
   
- Open your browser and navigate to http://localhost:8080
- Register a new account or use existing credentials

## 📁 Project Structure
```bash
TODO-Rails/
├── src/
│   ├── main/
│   │   ├── java/org/todo/todorails/
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── CustomErrorController.java
│   │   │   │   ├── PageController.java
│   │   │   │   ├── ProfileController.java
│   │   │   │   └── TaskController.java
│   │   │   ├── model/
│   │   │   │   ├── Task.java
│   │   │   │   └── User.java
│   │   │   ├── repository/
│   │   │   │   ├── TaskRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   ├── service/
│   │   │   │   ├── TaskService.java
│   │   │   │   └── UserService.java
│   │   │   └── TodoRailsApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── target/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```
## 🔄 Application Flow
1. Landing Page
- Welcome interface with project overview
- Navigation to registration/login
2. User Authentication
- Registration: New users create accounts with secure password handling
- Login: Existing users authenticate with Spring Security
- Session Management: Secure session handling with proper logout
3. Dashboard
- Task Overview: Display all user tasks with filtering options
- Quick Actions: Add, edit, delete tasks directly from dashboard
- Statistics: Task completion rates and productivity insights
4. Task Management
- Create Tasks: Add new tasks with title, description, priority, category, and due date
- Edit Tasks: Update existing task details
- Delete Tasks: Remove completed or unnecessary tasks
- Priority Management: Set and modify task priorities
5. User Profile
- Profile Management: Update user information
- Settings: Customize application preferences
- Security: Change passwords and manage account security

## 🏗️ Architecture Overview
### MVC Pattern Implementation
- Model: Entity classes (Task, User) with JPA annotations
- View: Thymeleaf templates with responsive CSS
- Controller: Spring Boot controllers handling HTTP requests

### Security Implementation
- Spring Security: Authentication and authorization
- Password Encryption: BCrypt for secure password storage
- CSRF Protection: Built-in protection against cross-site request forgery
- Session Management: Secure session handling
### Database Design
- User Entity: Stores user credentials and profile information
- Task Entity: Stores task details with user relationships
- JPA Repositories: Data access layer with custom queries

## 💻 Usage
### For Users
1. Register: Create a new account with email and password
2. Login: Access your personalized dashboard
3. Add Tasks: Create new tasks with details and priorities
4. Manage Tasks: Edit, complete, or delete existing tasks
5. Track Progress: Monitor your productivity and task completion

Key Functionalities
- ✅ Task Creation: Add tasks with priority, category, and due dates
- 📝 Task Editing: Modify task details as requirements change
- 🗑️ Task Deletion: Remove completed or unnecessary tasks
- 🔍 Task Filtering: Sort and filter tasks by various criteria
- 📊 Progress Tracking: Monitor task completion and productivity

## 🎨 Technical Highlights
### Frontend Features
- Responsive Design: Mobile-first approach with CSS Grid and Flexbox
- Interactive UI: JavaScript-powered dynamic interactions
- Form Validations: Client-side validation for better user experience
- Thymeleaf Integration: Server-side templating with dynamic content

### Backend Features
- RESTful APIs: Clean API design following REST principles
- Data Persistence: JPA/Hibernate for database operations
- Security: Comprehensive authentication and authorization
- Error Handling: Custom error pages and exception handling

## 🧪 Testing
```bash
# Run unit tests
mvn test

# Run integration tests
mvn integration-test

# Generate test coverage report
mvn jacoco:report
```

## 🚀 Deployment
Local Deployment
```bash
mvn spring-boot:run
```
Production Deployment
```bash
mvn clean package
java -jar target/todo-rails-1.0.0.jar --spring.profiles.active=prod
```
## 🤝 Contributing
1. Fork the project
2. Create your feature branch (git checkout -b feature/AmazingFeature)
3. Commit your changes (git commit -m 'Add some AmazingFeature')
4. Push to the branch (git push origin feature/AmazingFeature)
5. Open a Pull Request

##📚 Learning Outcomes
This project demonstrates proficiency in:

- Full-Stack Development: Integration of frontend and backend technologies
- MVC Architecture: Proper separation of concerns
- Spring Boot Framework: Enterprise-level Java development
- Database Design: Relational database modeling with JPA
- Web Security: Authentication and authorization implementation
- Responsive Design: Cross-device compatibility
- Version Control: Git workflow and collaboration

## 📞 Contact
Project Developer

Email: [aditya.dhakane22@vit.edu]
LinkedIn: [www.linkedin.com/in/aditya-dhakane-45b295260]
GitHub: [https://www.github.com/adidhdakane]

## 📄 License
- This project is licensed under the MIT License - see the LICENSE.md file for details.

## 🙏 Acknowledgments
- Spring Boot Documentation and Community
- Thymeleaf Template Engine
- Bootstrap CSS Framework
- Maven Build Tool
- Java Development Community

Built with ☕ and Spring Boot for efficient task management
