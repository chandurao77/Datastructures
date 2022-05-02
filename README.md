# ninja1
Simple hello world application

## Usage
```
~/ninja1$ java -jar target/ninja1-0.5.0-SNAPSHOT-jar-with-dependencies.jar -h
ninja1
Version: 0.5.0
usage: ninja1
 -h   Display this help text
 -v   Verbose mode
```

## Building
Apache Maven is the build tool of choice.  Simply issue `mvn install package` to install dependencies and build the jar.
Use `mvn clean install compile verify test package site` to clean up existing targets, install dependencies, verify, run unit tests, build a jar, and create the documentation and reports.

## Running
Issue a `java -jar target/helloworld-<VERSION>-SNAPSHOT-jar-with-dependencies.jar` to run the target directly.

## Docker Environment
1. Download and install Docker [https://docs.docker.com/desktop/](https://docs.docker.com/desktop/)
2. Build the mscs502 image by running 502 .`docker build -t mscs502 .` in a terminal
3. Then run the container based on the mscs502 image with `docker run -it --rm -v $PWD:/ninja1 mscs502` on Linux or an absolute path in Windows like `docker run -it --rm -v /c/Users/Nandakishore/Documents/GitHub/ninja1:/ninja1 mscs502`
4. Use VSCode or your IDE of choice to edit your code locally.  HINT: Run `code .` from the terminal when in the folder to easily open it
5. Build and run the code as you would locally from the Docker container bash prompt

## Tests
[JUnit](https://junit.org/junit5/) is used as the Test Framework. To execute unit tests run `mvn test`.
To skip tests, add `-Dmaven.test.skip=true` as an argument to your Maven command.

## Contributing
- All code (classes, files, global variables, members, and methods) must be thoroughly documented using JavaDoc accepted format.  HINT: Use `mvn site`
- All existing unit tests must pass. HINT: Use `mvn test`
- New unit tests are encouraged!
- README, help text, makefile, and other artifacts must be up to date.
- Program version number should be incremented.  HINT: In the *pom.xml* and *global variables*
- Use proper git ettiquete with frequent commits and [good commit messages](https://cbea.ms/git-commit/).
- All code must be formatted properly and verified with *clang-format*.  HINT: Use `mvn verify`
- Binary files and other metadata shall not be committed. HINT: Update the .gitignore, if necessary
- No warnings or errors shall be produced by Maven with `mvn verify test site compile` options.


## about the author
 I'm marru chandu , This is my 1st semester in Masters program majored in computer science.i'm excited about the masters program and looking forward for some great learning experience with you all in this semester.I would like to learn more programming knowledge and data structure is very good language to learn more technologies in future.
 marru chandu chandu.marru1@marist.edu

Below are the datastructures time taken for operations.
Arraylist -

| Elapsed Time (ns)  | empty | name   | small   | medium   | large   | xl    |
|--------------------|-------|--------|---------|----------|---------|-------|
| Create             | 8080   | 4300    | 4401     | 7100      | 9400     | 11900   | 287
| Insert (Fill)      | 18400   | 29500    | 8901     | 36069250      | 28937999     | 51343900   | 287
| Search - First     | 3601   | 5900    | 1999     | 21600      | 24581     | 23799   | 287
| Search - Last      | 400   | 1400    | 300     | 18300      | 4839000     | 4548250   | 287
| Search - Not Found | 8100   | 2251    | 4251     | 4257800      | 2225899     | 6457400   | 287
| Read               | 300   | 2100    | 600     | 10100      | 6900     | 11200   | 287
| Remove             | 800   | 600    | 300     | 1129080      | 317251     | 679000   | 287


linkedlist -

| Elapsed Time (ns)  | empty | name   | small   | medium   | large   | xl    |
|--------------------|-------|--------|---------|----------|---------|-------|
| Create             | 250   | 250    | 100     | 400      | 250     | 500   | 287
| Insert (Fill)      | 1000   | 8900    | 500     | 21482500      | 10119250     | 25537401   | 287
| Search - First     | 4401   | 14899    | 1899     | 24581      | 96000     | 34250   | 287
| Search - Last      | 400   | 2100    | 300     | 9400      | 2349500     | 805000   | 287
| Search - Not Found | 19000   | 1200    | 4581     | 3524600      | 1496250     | 4062601   | 287
| Read               | 300   | 1201    | 250     | 4000      | 2300     | 4580   | 287
| Remove             | 300   | 300    | 250     | 35500      | 18800     | 50900   | 287

SortedSet -

| Elapsed Time (ns)  | empty   | name   | small   | medium   | large   | xl    |
|--------------------|---------|--------|---------|----------|---------|-------|
| Create             | 1111800 | 1017801    | 887000     | 1470251      | 817600     | 1718600   | 287
| Insert (Fill)      | 580     | 145000    | 581     | 39558400      | 37959100     | 81188600   | 287
| Search - First     | 6600    | 26000    | 14800     | 80100      | 64801     | 52999   | 287
| Search - Last      | 600     | 11250    | 1880     | 18400      | 16580     | 19500   | 287
| Search - Not Found | 8000    | 3100    | 25900     | 5499      | 5401     | 5499   | 287
| Read               | 500     | 1200    | 500     | 3581      | 2251     | 3800   | 287
| Remove             | 300     | 500    | 500     | 83580      | 59300     | 81300   | 287


Stack -

| Elapsed Time (ns)  | empty | name   | small   | medium   | large   | xl    |
|--------------------|-------|--------|---------|----------|---------|-------|
| Create             | 182301   | 231199    | 255800     | 281799      | 382800     | 519900   | 287
| Insert (Fill)      | 400   | 12000    | 800     | 11609251      | 5823301     | 26090800   | 287
| Search - First     | 250   | 13100    | 3600     | 33600      | 23400     | 34800   | 287
| Search - Last      | 400   | 1001    | 399     | 18250      | 1370300     | 1304599   | 287
| Search - Not Found | 6000   | 1200    | 8000     | 4667899      | 1188801     | 9089299   | 287
| Read               | 300   | 900    | 300     | 2901      | 3499     | 3501   | 287
| Remove             | 300   | 400    | 300     | 580250      | 325100     | 671801   | 287


Treemap -

| Elapsed Time (ns)  | empty | name   | small   | medium   | large   | xl    |
|--------------------|-------|--------|---------|----------|---------|-------|
| Create             | 24801   | 32100    | 37299     | 64499      | 45800     | 58300   | 287
| Insert (Fill)      | 300   | 26099    | 300     | 81199000      | 48076699     | 218310000   | 287
| Search - First     | 3580   | 18401    | 2600     | 517799      | 26099     | 176100   | 287
| Search - Last      | 400   | 5800    | 250     | 58400      | 5395501     | 2979581   | 287
| Search - Not Found | 9000   | 2599    | 6401     | 8464899      | 4790800     | 11232250   | 287
| Read               | 300   | 1699    | 250     | 11601      | 5800     | 42300   | 287
| Remove             | 300   | 400    | 400     | 119000      | 49501     | 184900   | 287

Hashmap -

| Elapsed Time (ns)  | empty | name   | small   | medium   | large   | xl    |
|--------------------|-------|--------|---------|----------|---------|-------|
| Create             | 49299   | 37250    | 25199     | 60800      | 52400     | 73599   | 287
| Insert (Fill)      | 600   | 12000    | 400     | 22627400      | 10955300     | 46605801   | 287
| Search - First     | 4300   | 10100    | 3100     | 24251      | 18001     | 31200   | 287
| Search - Last      | 400   | 2399    | 250     | 38300      | 3960699     | 4505400   | 287
| Search - Not Found | 6099   | 1600    | 6000     | 5795100      | 1674000     | 10796799   | 287
| Read               | 300   | 1200    | 250     | 3999      | 3580     | 4400   | 287
| Remove             | 300   | 300    | 300     | 25899      | 18080     | 40250   | 287

PriorityQueue -

| Elapsed Time (ns)  | empty | name   | small   | medium   | large   | xl    |
|--------------------|-------|--------|---------|----------|---------|-------|
| Create             | 700699   | 410250    | 418400     | 946250      | 543100     | 1170000   | 287
| Insert (Fill)      | 900   | 17199    | 580     | 21958099      | 8773581     | 41832500   | 287
| Search - First     | 6250   | 5999    | 3250     | 30900      | 17000     | 114300   | 287
| Search - Last      | 400   | 4401    | 299     | 23800      | 2178900     | 9791399   | 287
| Search - Not Found | 7600   | 580    | 4401     | 5316400      | 2527800     | 3804000   | 287
| Read               | 401   | 400    | 300     | 1899      | 900     | 2250   | 287
| Remove             | 250   | 300    | 300     | 13539580      | 10176600     | 25807251   | 287
