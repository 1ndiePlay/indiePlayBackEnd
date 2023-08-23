## IndiePlay 백엔드 서버 입니다.

### 서버 실행 법 (m1 기준)
프로 젝트 루트로 이동 합니다.
1. `./gradlew build` (빌드시 에러가 난다면 jdk17 버전의 JAVA_HOME 환경변수 셋팅)
2. `docker buildx build -t indie-play --platform linux/amd64 -o type=docker .`
3. 2번에서 오류가 난다면 `docker buildx create --use` 후 다시 2번
4. `docker run -d -p 8080:8080 indie-play` (백그라운드 -d 옵션)

### 서버 실행 법 (m1 이 아닐 경우)
프로 젝트 루트로 이동 합니다.
1. `./gradlew build` (빌드시 에러가 난다면 jdk17 버전의 JAVA_HOME 환경변수 셋팅)
2. `docker build -t indie-play .`
3. `docker run -d -p 8080:8080 indie-play` (백그라운드 -d 옵션)
