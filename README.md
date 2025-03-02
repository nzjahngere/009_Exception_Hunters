# 🛍️ 009-Exception-Hunters  

## 📌 Introduction 🚀  
The project aims to conduct a comprehensive testing of the Online Shopping Platform **Sauce Demo**. The testing encompasses multiple methodologies to ensure robustness and efficiency. The goal is to ensure the platform's functionality across all layers—UI, API, and backend—is fully automated and tested with clear reporting, providing confidence in its readiness for production use.

### **🔹 Project Overview**
✅ End-to-end **testing automation** using **Selenium, Cucumber, Rest Assured**  
✅ Covers **UI Testing, API Testing, Functional Testing, and Negative Scenarios**  
✅ Uses **Page Object Model (POM)** for maintainable code  
✅ Generates **Cucumber HTML reports** for execution results  

---

## **📂 Project Structure**
```plaintext
SauceDemoTest/
│── src/
│   ├── main/java/com/saucedemo/   # Page Objects (POM)
│   ├── test/java/com/saucedemo/   # Step Definitions & Test Runner
│── resources/
│   ├── features/                  # Cucumber Feature Files
│── target/                         # Test Execution Reports (Ignored in Git)
│── pom.xml                         # Maven Project Configuration
│── README.md                       # Project Documentation
│── .gitignore                      # Ignored Files List
```

---

## **🛠️ Tech Stack Used**
| Technology    | Purpose |
|--------------|---------|
| **Java** | Core programming language for automation |
| **Selenium WebDriver** | UI automation testing |
| **Cucumber** | BDD framework for writing tests |
| **Rest Assured** | API testing |
| **JUnit** | Test assertions and execution |
| **Maven** | Build & dependency management |

---

## **⚙️ Setup & Installation**
### **🔹 Prerequisites**
- Install **Java (JDK 17 or higher)**
- Install **Maven** (`mvn -version` to verify)
- Install **Git** (`git --version` to verify)
- **Google Chrome** / **Firefox** for browser testing

### **🔹 Clone the Repository**
```sh
git clone https://github.com/nzjahngere/009_Exception_Hunters.git
cd SauceDemoTest
```

### **🔹 Install Dependencies**
```sh
mvn clean install
```

---

## **🚀 Running the Tests**
### **1️⃣ Execute All Tests**
```sh
mvn test
```

### **2️⃣ Run Specific Feature File**
```sh
mvn test -Dcucumber.features=src/test/resources/features/ShoppingCart.feature
```

### **3️⃣ Generate Cucumber Reports**
```sh
mvn verify
```

---

## **📊 Test Reports**
🔹 **Cucumber HTML Report**  
📍 **Path:** `target/cucumber-reports/cucumber-html-reports.html`  
To view the report:  
- Open `target/cucumber-reports/cucumber-html-reports.html` in any browser.

---

## **📝 A Brief Overview of Test Cases Covered**
✅ **UI Automation:** Login, Add to Cart, Remove Items, Checkout  
✅ **API Testing:** GET/POST requests for Order & Cart APIs  
✅ **Functional Tests:** Edge cases & validation checks  
✅ **Negative Testing:** Invalid login, empty cart checkout, missing fields  

---

## **🤝 Contributors**
- **Nazish Jehangir** ([@nzjahngere](https://github.com/nzjahngere))  
- Special thanks to **Masai School** for guidance  

---
