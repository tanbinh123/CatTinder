# Cat Tinder

MakeApp is a responsive website created with Spring Boot and Thymeleaf that where user can find new cat friends. 

## What does it do?

Login is required. The basic users can view the existing cat listing. Users with Admin role can also:

- Add a new cat and upload an image for the cat
- Modify cat's information
- Delete cat

## How does it work?

### Database and DB server
- Cat Tinder uses MariaDB as database. The DB server is located on Haaga-Helia server

### Security
- Cat Tinder users Spring Boot Starter Security and Thymeleaf Spring Security 5 for security, authentication and authorization

## Who will use this project?

This application is a course project for the Server Programming course (SWD4TA020). In the future the project may be extended to include further functionalities.

## What is the goal of this project?

See above.

## Used technologies and components

- Framework: Spring Boot 2.3.3, Thymeleaf
- Components:
  - Authentication: Spring Boot Starter Security, Thymeleaf Spring Security 5
  - Database: MariaDB
  - Styling: [Bootstrap](https://www.getbootstrap.com/), internal CSS
  - Image upload: Spring starter dependency, with the help of Nam Ha Minh's tutorial](https://www.codejava.net/frameworks/spring-boot/spring-boot-file-upload-tutorial#)