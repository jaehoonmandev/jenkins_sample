
# 1. 베이스 이미지 설정
FROM openjdk:17-jdk-slim

# (Option) 파일 작성자 정보를 기입한다.
LABEL authors="jaehoonman"

# 2. JAR 파일을 애플리케이션으로 복사
ARG JAR_FILE=build/libs/jaehoonman_jenkins-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# 3. 컨테이너 내에서 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]