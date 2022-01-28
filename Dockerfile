FROM maven:latest


WORKDIR /helloworld
COPY * ./

RUN mvn clean install

CMD ["bash"]
