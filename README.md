Automatic Testing of TodoMVC website 


This repository contains automated tests for the TodoMVC website. Our goal was to identify the most valuable features to automate and implement these using best practices, such as the Page Object Model.


--Test Coverage Planning--

Below is a table outlining the test cases we planned. These were categorized based on whether they should be automated immediately or deferred for later.

<img width="1440" alt="Screenshot 2025-05-22 at 13 47 34" src="https://github.com/user-attachments/assets/88f3841e-2121-4fa7-a679-f9bd7cfc6f98" />


--Project Approach--

We began by conducting manual testing on the TodoMVC site to understand its core features and user flows. This helped us determine which tests would provide the most value if automated early.

In a follow-up planning session, we prioritized test cases and discussed our automation strategy. Our initial decision was to implement the Page Object Model (POM) to avoid code duplication and improve maintainability. This structure made writing tests cleaner and easier to manage.

Throughout development, we collaborated over video calls to review code, design test methods, and use tools like Selenium IDE to identify element locators (e.g., IDs and CSS selectors).

--Code Readability--

* Each test includes clear comments to guide anyone who wants to:

* Understand the purpose of a test,

* Modify existing tests, or

* Create new ones.

We aimed to make the test suite as accessible as possible for both new and experienced contributors.

