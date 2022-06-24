<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
<h3 align="center">Wasecom</h3>

  <p align="center">
    By Wasim Ramzan
  </p>
</div>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#project-description">Project Description</a>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#application-images">Application Images</a></li>
    <li><a href="#to-do">To Do</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>


<!-- PROJECT DESCRIPTION -->
## Project Description

Wasecom is a simple ecommerce website using Spring Boot, Thymeleaf, Tailwind and more!

<br>

<!-- Technologies Used -->
### Technologies Used

Here are some of the frameworks, libraries and kits used which I made efficient use of whilst creating the website.

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Thymeleaf](https://www.thymeleaf.org/)
* [TailwindCSS](https://tailwindcss.com/)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

May have to run pom.xml if errors occur.

### Installation

1. Clone the repo
   ```sh
   git clone git@github.com:Wasim27/Wasecom.git
   ```
   
2. Create MySQL Database
   ```
   CREATE DATABASE wasecom
   ```

3. Run Spring Boot App
   ```
   mvn spring-boot:run
   ```
   
4. Insert Database Data (Admin User)
   ```
   INSERT INTO roles (id, name) VALUES
   (1, 'ADMIN'),
   (2, 'USER');
   ```
   ```
   INSERT INTO users (id, email, password, first_name, last_name) VALUES
   (1, 'admin@gmail.com', *BcryptedPasswordHere*, 'Admin', 'Name');
   ```
   ```
   INSERT INTO user_role(user_id, role_id) VALUES
   (1,1);
   ```

6. Go to the web server \
   http://localhost:8088/

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- Application Images -->
## Application Images
<br>

<div align="center">
  <img src="readme_images/1.png" alt="Homepage" width="700" height="">
</div>
<div align="center">
  <img src="readme_images/2.png" alt="Homepage" width="700" height="">
</div>
<div align="center">
  <img src="readme_images/3.png" alt="Homepage" width="700" height="">
</div>
<div align="center">
  <img src="readme_images/4.png" alt="Homepage" width="700" height="">
</div>
<div align="center">
  <img src="readme_images/5.png" alt="Homepage" width="700" height="">
</div>
<div align="center">
  <img src="readme_images/6.png" alt="Homepage" width="700" height="">
</div>
<div align="center">
  <img src="readme_images/7.png" alt="Homepage" width="700" height="">
</div>

<br>
<br>
<br>


<!-- To-Do -->
## To Do
[] Write some tests (important) \
[] Payment Method \
[] Add to wish list, forgotten password and other features that require implementing \
[] UI Improvements \
[] Bug fixes and suitable error messages on incorrect sign-in etc \
[] Image bug fix have to restart after uploading images (done locally) \
[] Improve categorisation (sub-sub categories)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Name: Wasim Ramzan
<p align="right">(<a href="#top">back to top</a>)</p>

