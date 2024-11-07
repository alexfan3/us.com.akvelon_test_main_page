# Verification of button links on the main page of the website [akvelon.com.ua](https://akvelon.com.ua).
_____________________________________________________________________________
##Technology Stack
IDEA, Java, Gradle, Junit5, Selenide, Allure Reports, Allure TestOps.
____________________________________________________________________________
UI tests have been implemented to check the links on all buttons on the main page of the website, including the opening of modal content. Allure Reports were used to generate the report.
![image](https://github.com/user-attachments/assets/617a4da6-82f7-4586-a482-51f579982ce1)
____________________________________________________________________________
As we can observe, in the current run, 2 tests were skipped, and 2 tests did not execute.
Let's take a closer look at one of the tests that did not execute.
Here we can see its name, author, and the parameters used for the execution. In addition, we can immediately identify the cause of the failure. Also, if needed, we can open a screenshot of the page taken at the moment the test was executed. If necessary, a video recording can also be added.

![image](https://github.com/user-attachments/assets/39ae7678-b768-4a02-a58a-40fc9b0f1e1b)

____________________________________________________________________________
If we apply lambda programming, the body of the test can be hidden behind more concise names. However, in this case, the code for the test must be written separately, and we lose the ability to leverage the benefits of OOP.

![image](https://github.com/user-attachments/assets/0b6e9b6b-9f59-4826-8e20-6ede3e8488a5)

____________________________________________________________________________
Separately, we can check additional details about the status and execution time of the tests
![image](https://github.com/user-attachments/assets/7a09dcc1-dfb4-4a05-abd0-6a5e916137d0)

____________________________________________________________________________

Some of the identical tests were moved to parameterized tests

![image](https://github.com/user-attachments/assets/fdebeb85-f1d7-40ad-8791-08d33e87a136)
____________________________________________________________________________

As a result, we run a single test with different input data and expected outcomes.

![image](https://github.com/user-attachments/assets/d646b2b9-7b18-4251-a9aa-059ce4a3d371)

![image](https://github.com/user-attachments/assets/ba9239b3-edef-4b56-aa11-2a94d7b15d86)

