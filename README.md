# helloworld
Simple hello world application template

## Usage
```
~/helloworld$ java -jar target/helloworld-0.0.1-SNAPSHOT-jar-with-dependencies.jar -h
helloworld
Version: 0.0.1
usage: helloworld
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
2. Build the mscs502 image by running 502 .``docker build -t mscs502 .' in a terminal
3. Then run the container based on the mscs502 image with `docker run -it --rm -v $PWD:/helloworld mscs502` on Linux or an absolute path in Windows like `docker run -it --rm -v /c/Users/MICHAELGILDEIN/frilly-chicken-bucket:/helloworld mscs502`
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
