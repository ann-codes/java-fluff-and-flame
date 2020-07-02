Individual Project converting the original React & Node/Express [Fluff and Flame](https://github.com/ann-codes/fluff-and-flame) group project to a Java Spring backend.

This project meets all core and non-core user stories. 

It includes a non-authenticated, direct link "user portal" and "admin portal" to edit submitted applications and make adoption decisions as an admin, respectively. 

Tech stack: 
- yarn
- React.js
- Foundation/CSS
- Java SDK 11.0.6, Spring, SpringBoot
- Postgres (must be installed)

## Java 11:

If using IntelliJ, ensure it is running the correct version JDK 11: 

- File -> Project Structure -> Platform Settings -> SDKs -> add JDK version
- File -> Project Structure -> Project Settings -> Project, change both Project SDK and Project language level
- File -> Project Structure -> Project Settings -> Modules, change the language level
- File -> Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler -> Change to version

Commands: 

```
## create the database
createdb adopt_a_pet

## running spring w/ maven wrapper

##on mac:
./mvnw spring-boot:run

## on windows (on gitbash, don't run in intelliJ terminal):
mvn spring-boot:run

## to exit
ctrl+c
```

After starting the server, it will seed 1-2 file in each table.

It is also recommended to run the below commands in the terminal to seed additional data.

```
psql adopt_a_pet

\i src/main/resources/seed.sql
```

Visit http://localhost:8080/creatures to view the site.

To run the webpack dev server for refresh of changes to the frontend, cd into `java-fluff-and-flame/src/main/frontend` and run `npm run dev:client`
