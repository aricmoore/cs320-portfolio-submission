# Summary and Reflections

## How can I ensure that my code, program, or software is functional and secure?
To ensure my code is functional, I uses unit tests to validate that each method behaves as expected across a wide range of valid and invalid inputs. I relied on JUnit testing to automate checks for exceptions, constraints, and edge cases. For security, I enforced strict input validation rules in the constructors and service classes to prevent invalid data or unwanted behavior from compromising the system.

## How do I interpret user needs and incorporate them into a program?
I began by analyzing the project requirements and identifying the core features needed by the user. These requirements are broken into business rules, such as enforcing maximum field lengths or prohibiting null values. I designed my classes and services to reflect these constraints, then I created corresponding unit tests to mirror expected user behaviours. This ensures that the application aligns with the user’s expectations.

## How do I approach designing software?
I took a modular, test-driven approach to the software design. Each entity class (e.g., `Contact`, `Task`, `Appointment`) has a corresponding service class that manages the lifecycle and logic of those objects. I began with class design, enforced the business rules in constructors and methods, and then built unit tests in concert with the project code. This process helped me design clean, maintainable code that'll be easy to extend and verify with automated tests.
