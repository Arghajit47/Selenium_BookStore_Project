FROM maven
COPY src /src
WORKDIR /src
RUN mvn clean test
RUN allure generate
RUN allure open
