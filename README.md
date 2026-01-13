# TecNimbus ApiTestKit

A lightweight **REST API testing wrapper library** implemented in Java with support for BDD/Gherkin‑style tests.  
This project provides reusable components and helpers to simplify writing, organizing, and executing REST API tests.

🎯 The goal of this library is to reduce boilerplate for API tests and support readable, maintainable test suites.

---

## 🚀 Overview

`TecNimbus-ApiTestKit` is designed to help you:

- Easily define and send HTTP requests to RESTful APIs
- Validate responses with expressive, reusable assertions
- Organize tests in a BDD/Gherkin style
- Integrate with popular test runners (JUnit, Cucumber, TestNG)

---

## 🧠 Key Features

- ⚙️ HTTP request builder utilities
- 📊 Response validation helpers
- 🤝 BDD-friendly structure
- 💡 Reusable API client abstractions

---

## 📦 Prerequisites

- Java 11+
- Maven or Gradle
- Target REST API

---

## 📥 Installation

```bash
git clone https://github.com/BathiyaL/TecNimbus-ApiTestKit.git
cd TecNimbus-ApiTestKit
mvn clean install
```

---

## 🧪 Usage

### API Client Example

```java
public class SampleApi extends ApiClient {

    public Response getAllItems() {
        return get("/items")
                .header("Accept", "application/json")
                .call();
    }
}
```

### Test Example

```java
@Test
public void shouldReturn200() {
    SampleApi api = new SampleApi();
    api.getAllItems().then().statusCode(200);
}
```

---

## 🏗 Project Structure

```
src
├── main/java        # Core wrapper library
├── test/java        # API tests
├── test/resources   # Config and test data
```

---

## 🤝 Contributing

Contributions are welcome via pull requests.

---

## 📄 License

MIT License

