# UNIVER RATE
---
The Univer Rate is an application that helps people to search for the good Ukrainian university.
## Documentation

To obtain Rest API - https://univer-rate.herokuapp.com/docs/index.html

Front-end develpment repository - https://github.com/Dream08/hacktonFrontend

## Getting Started

To start a project in Development mode, you should to take a few steps.
* ###  Step 1: Clone project from GitHub
    Use one of two methods.
    - First:
        1. Click "Clone or download" button
        2. Download ZIP archive
        3. Unzip archive to folder
    
    - Second:
        1. Install Git on the computer
        2. Open the folder via console
        3. Execute console command
    ```
    $ git clone https://github.com/VadymPolyanski/univer-rate.git
    ```

* ###  Step 2: Open with IDE
    
    Your IDE should work with:  
    - [Gradle](https://gradle.org/)
    - [JDK, JRE](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
    
* ###  Step 3: Set up the MariaDB Server 10.2
  [Tutorial](http://idroot.net/linux/install-mariadb-ubuntu-16-04/)
    
* ###  Step 4: Build a project
    In order to build a project, you have to execute the following command in the console:
    ```
    $ ./gradlew stage
    ```

    This command runs: `clean -> test -> asciidoctor -> build`

 ## Demo

You can view the Univer Rate in action by click the button:
[**`Univer Rate demo`**](https://univer-rate.herokuapp.com)

## Built With

**_Stack of technologies:_**
- **Spring boot** - building production-ready Spring application;
- **Open Data Ukraine** - getting informations about universities;
- **MariaDB** - project's DB;
- **Lombok** - annotation processing;
- **Asciidoctor** - creating docs from tests;
- **Angular4** - front-end development;
- **Bootstrap** - for CSS Grids and Flexbox;
- **Webpack** - module bundler;
- **Gradle** - dependency Management.

