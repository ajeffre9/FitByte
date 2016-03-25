# Welcome to CS 2212 - Winter 2016 - team04

To get started, you will need to run these commands in your terminal.

## Configure Git for the first time

```
git config --global user.name "Your Name"
git config --global user.email "youremail@uwo.ca"
```

## Clone your repository

Clone your repository onto your local system:

```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team04.git
```

## Build the prototype

Make sure you are in the dev branch using "git branch". If not, use git checkout to switch to the dev branch.
Then pull all the files to your local repository:
```
git pull
```
## Set JAVA_HOME
```
setenv JAVA_HOME /usr/lib/jvm/java-8-oracle/bin
```

## Build the maven package
Then pull all the files to your local repository:
```
mvn package
```

## Run the program in normal
Make sure you run the program in the  "~/team04/FitByte" directory# Welcome to CS 2212 - Winter 2016 - team04

FightByte was developed as a Windows application to link your computer directly to your FitBit accound so that you as a user may access and track your fitness data as you see 'fit'. 

To get started, you will need to open a GitBash terminal on your desktop and run the following commands.

## Configure Git for the first time

```
git config --global user.name "Your Name"
git config --global user.email "youremail@uwo.ca"
```

## Clone your repository

Clone your repository onto your local system:

```
git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team04.git
```

## Build the prototype

Make sure you are in the DEV branch using "git branch". If not, use git checkout to switch to the dev branch.
Then pull all the files to your local repository:
```
git fetch
git pull
```

## Set JAVA_HOME
```
setenv JAVA_HOME /usr/lib/jvm/java-8-oracle/bin
```

## Compile and build the maven package
Then pull all the files to your local repository:
```
mvn compile
mvn package
```

## Run the program in normal
Make sure you run the program in the  "~/team04/FitByte" directory
```
java -jar target/FitByte/target/FitByte-1.0-jar-with-dependencies.jar
```

## Run the program in testing mode
```
java -jar target/FitByte-1.0-jar-with-dependencies.jar test
```

## Exit the Program
To exit the application either navigate to File > Exit or close the window from the exit in the top right corner.


```
java -jar target/FitByte/target/FitByte-1.0-jar-with-dependencies.jar
```

## Run the program in testing mode
```
java -jar target/FitByte/target/FitByte-1.0-jar-with-dependencies.jar test
```


