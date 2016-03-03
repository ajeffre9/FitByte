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

## Build the maven package
Then pull all the files to your local repository:
```
mvn package
```

## Run the program in normal
Make sure you run the program in the  "~/team04/" directory
```
java -jar FitByte/target/FitByte-1.0-jar-with-dependencies.jar
```

## Run the program in testing mode
```
java -jar FitByte/target/FitByte-1.0-jar-with-dependencies.jar test
```


