# Spring Boot - Friends Management

[![Java CI with Gradle](https://github.com/hendisantika/friends-management/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/friends-management/actions/workflows/gradle.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-6DB33F?logo=springboot)
![Kotlin](https://img.shields.io/badge/Kotlin-2.4-7F52FF?logo=kotlin)

#### A Simple Spring Boot Application to manage friends using Kotlin.

## Tech Stack

| Component       | Version / Tool                          |
|-----------------|-----------------------------------------|
| Java            | 25 (Gradle toolchain)                   |
| Kotlin          | 2.4.x                                   |
| Spring Boot     | 4.1.x (Web MVC, Data JPA, Security)     |
| Build tool      | Gradle 9 (wrapper included)             |
| Database        | H2 in-memory (with H2 web console)      |
| Tests           | JUnit 5 + Spring Boot Test              |

## Prerequisites

- JDK 25 installed (Gradle toolchain will pick it up automatically)
- No need to install Gradle — use the bundled `./gradlew`

## Getting Started

```bash
git clone https://github.com/hendisantika/friends-management.git
cd friends-management

# build & run tests
./gradlew build

# run the application
./gradlew bootRun
```

The application starts on <http://localhost:8080> and seeds sample data
(`user1@example.com` … `user5@example.com`, each with one friend).

## API Endpoints

| Method | Endpoint                 | Description                         |
|--------|--------------------------|-------------------------------------|
| GET    | `/api/v1/friends`        | List all friends                    |
| POST   | `/api/v1/friends`        | Create a friend                     |
| POST   | `/api/v1/friends/find`   | Get the friend list of a user email |

### Examples

List all friends:

```bash
curl http://localhost:8080/api/v1/friends
```

Create a friend for user with id `1`:

```bash
curl -X POST http://localhost:8080/api/v1/friends \
  -H 'Content-Type: application/json' \
  -d '{"name":"new@example.com","user":{"id":1}}'
```

```json
{ "success": true }
```

Find friends by user email:

```bash
curl -X POST http://localhost:8080/api/v1/friends/find \
  -H 'Content-Type: application/json' \
  -d '{"email":"user1@example.com"}'
```

```json
{ "success": true, "friends": ["friend1@example.com", "new@example.com"], "count": 2 }
```

## H2 Console

Open <http://localhost:8080/h2/console> and use:

- JDBC URL: `jdbc:h2:mem:friendsDB`
- Username: `sa`
- Password: *(empty)*

## Security

`/`, `/api/**` and `/h2/console/**` are public. Any other endpoint requires HTTP Basic
authentication with the user configured in `application.yml` (`admin` / `admin`).

## CI/CD & Dependency Updates

- **GitHub Actions** (`.github/workflows/gradle.yml`) builds and tests the project with JDK 25 on every push
  and pull request to `master`, and submits the dependency graph on push.
- **Dependabot** (`.github/dependabot.yml`) checks Gradle dependencies and GitHub Actions daily
  (05:00 Asia/Jakarta), grouping Spring Boot, Kotlin, other minor/patch updates and GitHub Actions into
  separate pull requests.

## Author

**Hendi Santika** — [s.id/hendisantika](https://s.id/hendisantika) · Telegram [@hendisantika34](https://t.me/hendisantika34)
