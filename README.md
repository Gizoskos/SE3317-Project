SE3317 Project - Reminder Task Planner
This project is a Reminder Task Planner application developed in Java using three key design patterns: Strategy, Observer, and MVC. It allows users to manage their tasks and set reminders. The application utilizes different strategies for reminder notifications and organizes the tasks efficiently.

Features
Task Management: Users can add, edit, remove, and sort tasks based on categories or deadlines.
Reminder System: Tasks have reminders that notify users of upcoming deadlines or birthdays.
Design Patterns:
Strategy Pattern: Different sorting strategies (e.g., by category, by deadline) are implemented.
Observer Pattern: Users receive notifications when a task’s reminder is triggered.
MVC Pattern: Separates the application into three components (Model, View, Controller) for better code organization and maintainability.
Technologies Used
Java: Main programming language.
Design Patterns: Strategy, Observer, and MVC.
IDE: Any Java-supported IDE (e.g., IntelliJ IDEA, Eclipse).
How to Run the Project
Clone the repository:

bash
Copy
git clone https://github.com/Gizoskos/SE3317-Project.git
Navigate to the project directory:

bash
Copy
cd SE3317-Project
Compile and run the project:

bash
Copy
javac Main.java
java Main
Project Structure
bash
Copy
SE3317-Project/
│
├── src/

│   ├── model/     
# Contains the business logic
│   ├── view/       
# Handles the user interface
│   └── controller/  
# Manages user input and interaction with the model
│
├── Main.java             
# Entry point for the application
├── README.md       
# This file
└── .gitignore          
# Git ignore file
Design Patterns Used
1. Strategy Pattern
The Strategy pattern is used for implementing different sorting strategies for tasks. For example, tasks can be sorted by category or by deadline, allowing users to select the most appropriate sorting method dynamically.

2. Observer Pattern
The Observer pattern notifies users when a task’s reminder is triggered. When a task’s due time arrives, the system sends alerts to users through the notification system.

3. MVC Pattern
The Model-View-Controller (MVC) pattern separates the application into three components:

Model: Represents the application's data and business logic (e.g., tasks, reminders).
View: Displays the tasks and updates the view based on the controller’s instructions.
Controller: Handles user interactions (e.g., adding/editing tasks) and updates both the model and the view.
Contributing
If you would like to contribute, feel free to fork the repository and submit a pull request. We welcome suggestions for improvements, bug fixes, and new features.

License
This project is licensed under the MIT License - see the LICENSE file for details.
