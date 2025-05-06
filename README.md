
# 📚 Bookstore API Automation Framework with GitHub Actions CI/CD

## ✅ Overview

This repository contains end-to-end automated API tests for the **Bookstore application**, built using **Java**, **Rest Assured**, and **Cucumber BDD**. It includes **TestNG** for parallel execution and **Allure** for reporting. CI/CD is handled through **GitHub Actions** for seamless automation on every push.

---

## 💻 Tech Stack

| Component       | Technology / Tool                                                                 |
|------------------|-----------------------------------------------------------------------------------|
| 🧠 IDE           | IntelliJ IDEA                                                                     |
| ☕ Language       | Java 11+                                                                          |
| 🔄 Framework     | Cucumber BDD + Rest Assured for readable and maintainable API test scenarios     |
| ✅ Test Runner   | TestNG for retries, parallel execution, and configuration flexibility             |
| 🛠 Build Tool    | Maven for project and dependency management                                       |
| 📊 Reporting     | Allure Reports for rich test result visualization                                 |
| 🔁 CI/CD         | GitHub Actions for continuous integration & execution                             |

---

## 📁 Project Structure

```
bookstore-api-tests/
├── features/                  # Feature files in Gherkin
├── stepdefinitions/           # Step definitions for scenarios
├── runners/                   # TestNG + Cucumber runner class
├── data/                      # JSON test data
├── utils/                     # Helper and environment utilities
├── .github/workflows/ci.yml  # GitHub Actions CI pipeline
├── .env                       # Environment configs (BASE_URL, ENV)
├── pom.xml                    # Maven dependencies and plugins
└── README.md
```

---

## 🧪 API Endpoints Automated

| Method | Endpoint            | Description                  |
|--------|---------------------|------------------------------|
| POST   | `/signup`           | Sign up to the bookstore     |
| POST   | `/login`            | Log in and generate token    |
| POST   | `/books`            | Create a new book            |
| PUT    | `/books/{id}`       | Update existing book         |
| GET    | `/books/{id}`       | Fetch book by ID             |
| GET    | `/books`            | Fetch all books              |
| DELETE | `/books/{id}`       | Delete a book                |

---

## 🔧 Setup Instructions

### Prerequisites
- Java 11+
- Maven 3.6.3+
- Allure CLI (optional for local reports)

### Run Tests Locally

```bash
# Clone repo
git clone https://github.com/<your-username>/bookstore-api-tests.git
cd bookstore-api-tests

# Set environment variables
cp .env.example .env   # Then edit BASE_URL as needed

# Run tests
mvn clean test

# Generate and view Allure report
mvn allure:report
allure serve target/allure-results
```

---

## 🚀 CI/CD with GitHub Actions

### 🔄 Workflow Trigger

- On every push or pull request to `main` or `master` branch.
- Automatically installs dependencies, runs tests, and generates Allure report.

### 📄 `.github/workflows/ci.yml`

```yaml
name: API Automation CI

on:
  push:
    branches: [ "main", "master" ]
  pull_request:
    branches: [ "main", "master" ]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Code
        uses: actions/checkout@v3

      - name: Set up Java
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '11'

      - name: Set up Maven
        uses: stCarolas/setup-maven@v4.5
        with:
          maven-version: '3.8.5'

      - name: Run Tests
        run: mvn clean test

      - name: Generate Allure Report
        run: mvn allure:report

      - name: Upload Allure Results
        uses: actions/upload-artifact@v3
        with:
          name: allure-results
          path: target/allure-results
```

> You can later integrate this with [Allure GitHub Pages](https://docs.qameta.io/allure/#_github_pages) for publishing reports.

---

## 📊 Test Reporting with Allure

To generate and serve reports locally:
```bash
mvn allure:report
allure serve target/allure-results
```

To publish via GitHub Actions, consider:
- `allure-commandline` in workflow
- `allure-results` as an artifact
- Deploying reports via Pages or third-party actions

---

## 🤝 Contribution

1. Fork this repo
2. Create a feature branch
3. Write/update tests
4. Submit a pull request 🚀

---

## 👨‍💻 Author

- **Surya Parthiban**
- GitHub: [@suryaparthiban-qa](https://github.com/suryaparthiban-qa)

---

## 📄 License

MIT License — feel free to use and modify.
