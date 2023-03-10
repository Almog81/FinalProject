
## **FinalProject - Full Stack Automation Corse**
This is the My Final Project of the course Full Stack Test Automation.

### _introduction_
#### Introduction overview

This project came to summarize all the knowledge and abilities I learned in the "Full Stack Automation" course of **Yoni Flanner** from the [AtidCollege](https://atidcollege.co.il/).

The purpose of the project is to present one automation infrastructure for several platforms:
 * Web based application
* Mobile application
* Web API
* Electron application
* Desktop application

#### Divide and Conquer
The approach to the project is a complete separation between the testing infrastructure and the tests themselves. This structure enables the creation of new tests easily, and also enables work with different applications on the same infrastructure.

### _Project Overview_

### **_Infrastructure project includes using of:_**
* Page Object Design Pattern
* Project Layers(Extensions/Work Flows/Test Cases...)
* Support of Different Clients/Browsers
* Failure Mechanism 
* Common Functionality
* External Files Support
* Reporting System (including video recording and screenshots)
* Visual Testing
* DB support
* CI support  

***

### _Demonstration:_
* **OrangeHRM webpage** - Web based application
[Video Demonstration](https://drive.google.com/file/d/1c4mzDzwvgR6WKGdq7hqnbV3bhOeUxr9p/view?usp=share_link)
![Demonstration](https://raw.githubusercontent.com/Almog81/FinalProject/master/Demonstration/Web%20Testing%20-%20OrangeHRM.gif)
* **Unit Convert** - Mobile application
[Video Demonstration](https://drive.google.com/file/d/1payi5kDQgPpupV6NcD_PeykjK3CNCj82/view)
![Demonstration](https://raw.githubusercontent.com/Almog81/FinalProject/master/Demonstration/Mobile%20Test%20-%20Unit%20Converter.gif)
* **Todo List** - Electron application
[Video Demonstration](https://drive.google.com/file/d/12XNH_-WPfnvJo6-QVMJ4ETqQy7-tXxdK/view?usp=share_link)
![Demonstration](https://raw.githubusercontent.com/Almog81/FinalProject/master/Demonstration/Electron%20Test%20-%20ToDo%20List.gif)
* **Windows calculator** - Desktop application
[Video Demonstration](https://drive.google.com/file/d/1B6CQNvPGde_9_7HPum9MfdUl5OVCJmd3/view?usp=share_link)
![Demonstration](https://raw.githubusercontent.com/Almog81/FinalProject/master/Demonstration/Desktop%20Test%20-%20Calculator.gif)

### _Tools & Frameworks used in the project:_
* TestNG - Testing Framework
* Selenium - For Web/Electron Testing
* Appium - For Mobile Testing
* Listeners - interface used to generate logs and customize the TestNG reports
* XAMPP Control Panel  - used for crate OrangeHRM system and DataBase
* [Jenkins](https://www.jenkins.io/)- for tests execution
* REST Assured - for API testing
* [Allure](http://allure.qatools.ru/) Reports - as the main reporting system
* Sikuli - for Visual Testing

### _Known Issues:_
 - Sometimes can be conflicts with some dependencies the applications are using. Hence, the project is for DEMO purpose only. In production it should be divided into several projects.
 - With different resolutions, Tests using images may fail (like Test 06 in OrangeHRMWeb.java)
