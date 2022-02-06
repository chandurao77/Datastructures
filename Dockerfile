FROM maven:latest


WORKDIR /ninja1
COPY * ./

RUN mvn clean install

CMD ["bash"]
