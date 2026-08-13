# Проект по автотестированию для SauceDemo UI Tests

> Проект содержит автоматизированные UI-тесты для веб-приложения [SauceDemo](https://www.saucedemo.com/).

---

## 🛠 Технологический стек

<p align="center">
  <img title="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40"/>
  <img title="Gradle" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/gradle/gradle-original.svg" width="40" height="40"/>
  <img title="Selenide" src="https://selenide.org/assets/images/selenide-logo-big.png" width="40" height="40"/>
  <img title="JUnit5" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/junit/junit-original.svg" width="40" height="40"/>
  <img title="Allure" src="https://allurereport.org/images/allure-report-logo.png" width="40" height="40"/>
  <img title="Jenkins" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg" width="40" height="40"/>
</p>

Тесты написаны на **Java** с использованием фреймворка **Selenide** и тестового движка **JUnit 5**.
* Для удаленного запуска используется **Selenoid** (Chrome).
* Сборщик проектов — **Gradle**.
* Отчетность формируется с помощью **Allure Report**.
* Непрерывная интеграция настроена в **Jenkins**.
* Уведомления о результатах отправляются в **Telegram**.

---

## 💻 Запуск тестов из терминала

### Локальный запуск:
`gradle test`

### Удаленный запуск через Selenoid:
`gradle test -DremoteUrl=https://user1:1234@selenoid.qa.guru/wd/hub`

**Пояснение ключей:**
* `-DremoteUrl` — параметр, передающий URL удаленного сервера Selenoid для запуска браузера в контейнере.

---

## 📊 Интеграция с Jenkins и Allure

Сборка тестов запускается в [Jenkins](https://jenkins.qa.guru/job/Kaliakbarova_sauce_demo_tests_automation/).

### Скриншот главной страницы джобы в Jenkins:
![Jenkins Job](images/jenkins_job.png)

### Скриншот Allure-отчета:
![Allure Report](images/allure_report.png)

---

## 📱 Уведомления в Telegram

После завершения сборки бот отправляет краткую сводку с графиком результатов в Telegram-чат:

![Telegram Notification](images/telegram_notification.png)

---

## 🎥 Запись выполнения теста в Selenoid

![Selenoid Video](images/test_execution.gif)
