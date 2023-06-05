# DongDong2

As part of the team project for the Mobile Programming course of Gachon University, this application was developed with the aim of supporting student clubs.

While there is a club promotion board within Everytime (a university community platform), to view detailed information about the club, users had to click and read lengthy posts.

We identified this as an area for improvement and implemented a feature that allows users to quickly understand what the club is about at a glance.

Through this application, we hope to successfully support students' club activities.

## Team composition 
* 201935008 권민우
* 201935113 이한슬
* 201935114 이현석
* 201935125 정규원

## Progress
* Set the role for each member
* Development planning
* UI Design
* Functionality Implementation

## Member Role 
* 201935008 권민우 : Find tab & Club Apply, Search
* 201935113 이한슬 : Main tab & Ariticle, Caleander
* 201935114 이현석 : Login & Signup & Server
* 201935125 정규원 : Alarm tab & Setting tab & Bottom navigation

## Client-Server Based Application
![Firebase](https://github.com/FindMatPlace/DongDong2/assets/118448112/d7b4e56c-47df-48cd-913d-af349062f51b)
Our team has used Firebase as the database for our project.
Firebase is a real-time database, making it easy to use and highly compatible with the Android platform.
We have chosen this database for its advantages in real-time data updates and seamless integration with Android applications.

## UI Design
* Login & Signup Tab
![Login   signup](https://github.com/FindMatPlace/DongDong2/assets/118448112/aa1f40b9-6603-410a-bf6d-30147c9c143b)
* Main Tab
![Home](https://github.com/FindMatPlace/DongDong2/assets/118448112/db6cb479-7c8b-4ed4-9ed1-558935bad4ef)
* Find Tab
![Club](https://github.com/FindMatPlace/DongDong2/assets/118448112/55406616-87c9-495a-be1d-f181e0ee178a)
* Alarm & Setting Tab
![Setting and Notification](https://github.com/FindMatPlace/DongDong2/assets/118448112/4494bb90-8b5f-4b04-979c-aeaf54d6e4a8)

## Function
### Signup

* Check for duplicate UserID

It is a feature that verifies if an ID exists or not. If an existing ID is found, it prevents its usage, making it unavailable.
* School Authentication

Upon selecting a student ID photo from the gallery and uploading it, the system will analyze the image to verify if the individual is a student of Gachon University. If the person is indeed a student of Gachon University, the authentication process will be considered complete.

The feature allows users to capture and upload their mobile student ID, through the Gachon University Smart Campus mobile application. The system then determines whether the user is a student of Gachon University or not.

Once all the input information is provided and the user is successfully authenticated as a Gachon University student, the account registration process is completed.

### Main Tab
* At the top of the main home screen, there is a banner displaying announcements. Clicking on the announcements shows a calendar and the members participating.
* Below, there is a section where users can view posts uploaded by club members. Clicking on a post allows users to view the post in detail.

### Find Tab
* Users can search for existing clubs by entering keywords or desired content.
* Upon selecting a club, users can access promotional posts and ask questions. There is also a feature to fill out an application form.

### Alarm Tab
* Users receive notifications when new announcements or posts are made within a club. (feature to be implemented)

### Setting Tab
* The user's name is displayed in the settings.
* Users have the option to change their password.
* Users can log out.
