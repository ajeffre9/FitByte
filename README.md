# Welcome to CS 2212 - Winter 2016 - team04
FightByte was developed as a desktop application for Windows, Linux, and iOS platoforms to link your computer directly to your FitBit account so that you as a user may access and track your fitness data as you see 'fit'.

## Pre-Installation Notes 
### Git & BitBucket
This project uses [Git](https://git-scm.com/) for version control and our source code is hosted on [BitBucket](https://bitbucket.org/) to allow for team collaboration. If you are running a Windows system, you may want to install [Git Bash](https://git-for-windows.github.io/) as your terminal interface for communicating with Git.

### Maven Build Automation
Our project uses [Maven](https://maven.apache.org/) for build automation, so before your begin make sure that you have the latest version of Maven install on your system. Check for Maven by opening a terminal and typing `mvn --version`, and if it is not installed you may follow the installing instructions [HERE](http://books.sonatype.com/mvnref-book/reference/installation-sect-maven-install.html).

### Set JAVA_HOME
```
setenv JAVA_HOME /usr/lib/jvm/java-8-oracle/bin
```

## Initial Setup
To get started, you will need to open a terminal on your desktop and run the following commands.

### Set User Credentials
```
git config --global user.name "Your Name"
git config --global user.email "youremail@uwo.ca"
```
Make sure to replace the strings between the quotes with your information.

### Clone Repository

Clone your repository onto your local system:

```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team04.git
```

### Pull Recent Files

Now that you have cloned the repository to your local computer, perform a `git fetch` followed by a `git clone` command to ensure that you have all the updated branches for the project. Make sure you are in the DEV branch using `git branch`. If not, use `git checkout` to switch to the DEV branch. Pull all the files to your local system:
```
git fetch
git pull
```

### Compile & Build with Maven
The pom.xml file should be located in the FitByte folder in the main project directory. Navigate there usin `cd FitByte\` and perform the following Maven compilation commands to construct your project:
```
mvn compile
mvn package
```

### Run Program in Normal Mode
Upon build success with Maven you should have a functional program to run on your local system. To launch the application, run the following Java command from the FitByte folder in the terminal:
```
java -jar target/team4_FitByte-1.0-jar-with-dependencies.jar
```

### Run Program in Testing Mode (no API calls)
If you do not want to make API calls to the FitBit servers, or do not have a valid token for accessing data you can run the application in *test mode* for viewing the functionality of the interface only with fake data. Run the same Java command as before but add "test" as a sytem input. 
```
java -jar target/team4_FitByte-1.0-jar-with-dependencies.jar test
```

### Exit the Program
To exit the application either navigate to File > Exit or close the window from the exit in the top right corner.

## Use & Functionality
For a guide on using FightByte you can view our program video demostration at the link provided below which demonstrate how to sign up, track daily goals and life time progress, and view your activity on a time series graph. We hope you enjoy our application!

[![Team04 Video Demo](http://img.youtube.com/vi/6XiildqTSL4/0.jpg)](https://www.youtube.com/watch?v=6XiildqTSL4)

