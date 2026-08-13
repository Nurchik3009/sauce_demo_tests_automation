# Проект по автотестированию для SauceDemo UI Tests

> Проект содержит автоматизированные UI-тесты для веб-приложения [SauceDemo](https://www.saucedemo.com/).

---

## 🛠 Технологический стек

<p align="center">
  <img title="IntelliJ IDEA" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="40" height="40"/>
  <img title="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40"/>
  <img title="Gradle" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROycnWhGgGUtR1sS3Q7jItsna7tU1C9a5duz4JIKS6Gg&s=10" width="40" height="40"/>
  <img title="Selenide" src="https://automated-testing.info/uploads/default/optimized/2X/2/24077aab4d490df8fa6dda41761a3545272c29c4_2_700x366.jpeg" width="40" height="40"/>
  <img title="JUnit5" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/junit/junit-original.svg" width="40" height="40"/>
  <img title="Allure Report" src="https://conference.eurostarsoftwaretesting.com/wp-content/uploads/2023/08/Allure-Report-Logo.png" width="40" height="40"/>
  <img title="GitHub" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPyt9o2vV7qbUzPXo1bet8BsmumaYMNWALTk29xdsx5A&s=10" width="40" height="40"/>
  <img title="Jenkins" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg" width="40" height="40"/>
  <img title="Telegram" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Telegram_2019_Logo.svg/1280px-Telegram_2019_Logo.svg.png?utm_source=ru.wikipedia.org&utm_campaign=index&utm_content=thumbnail" width="40" height="40"/>
</p>

Тесты написаны на **Java** в среде **IntelliJ IDEA** с использованием фреймворка **Selenide** и тестового движка **JUnit 5**.

* Сборщик проектов — **Gradle**.
* Проект размещен и ведется в **GitHub**.
* Для удаленного запуска тестов используется **Selenoid** (Chrome).
* Отчетность о результатах тестирования формируется в **Allure Report**.
* Непрерывная интеграция (CI/CD) настроена в **Jenkins**.
* Автоматические уведомления о результатах сборки отправляются в **Telegram**.

---

## 📋 Покрытый функционал (Тест-кейсы)

В проекте автоматизированы ключевые пользовательские сценарии для приложения **SauceDemo**:

* 🔑 **1. Успешный вход в систему** — проверка авторизации под валидным пользователем (`standard_user`) и перехода в каталог товаров (`Products`).
* ❌ **2. Ошибка при входе с неверным паролем** — проверка отображения валидационной ошибки при вводе некорректных учетных данных.
* 🛒 **3. Добавление товара в корзину** — добавление рюкзака (`Sauce Labs Backpack`) и проверка обновления счетчика товаров на иконке корзины.
* 🏷️ **4. Сортировка товаров по цене (low to high)** — проверка фильтрации каталога от дешевых к дорогим (первая позиция — `$7.99`).
* 🚪 **5. Разлогин из системы** — открытие бокового бургер-меню, выход через `Logout` и проверка возврата на форму авторизации.

---

## 💻 Запуск тестов из терминала

### Локальный запуск всех тестов:
```
`./gradlew clean test`
```

### Удаленный запуск через Selenoid:
```
`gradle test -DremoteUrl=https://user1:1234@selenoid.qa.guru/wd/hub`
```
## 📊 Генерация и просмотр отчета Allure локально
### Запуск тестов
```
./gradlew clean test
```

### Сборка и открытие Allure-отчета в браузере
```
./gradlew allureServe
```


### Пояснение ключей:
* `-DremoteUrl` — параметр, передающий URL удаленного сервера Selenoid для запуска браузера в контейнере.

---

##  <img title="Jenkins" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg" width="40" height="40"/> Интеграция с Jenkins и Allure

Сборка тестов автоматически запускается в [Jenkins]([https://jenkins.qa.guru/job/Kaliakbarova_sauce_demo_tests_automation/](https://jenkins.qa.guru/view/java-students/job/Kaliakbarova_sauce_demo_tests_automation/)).

### Скриншот главной страницы джобы в Jenkins:
![Jenkins Job](images/jenkins_job.png)

### Общая статистика Allure-отчета:
![Allure Report Overview](images/allure_report.png)

### 🔍 Детализация тест-кейса в Allure

Для каждого теста подробно логируются все шаги выполнения (`@Step`), а также автоматически прикрепляются артефакты при упавших или пройденных тестах:
* **Page Source** — HTML-код страницы в момент завершения теста;
* **Console Logs** — логи консоли браузера;
* **Screenshot** — скриншот финального состояния;
* **Video** — видеозапись прохождения теста из Selenoid.

#### Шаги выполнения (@Step)
![Allure Test Steps](images/allure_steps.png)

#### Автоматические артефакты и логи
![Allure Attachments](images/allure_attachments.png)

---

## 🟢 Интеграция с Allure TestOps

Результаты выполнения автотестов в Jenkins и покрытие функционала полностью интегрированы в **Allure TestOps**.

### 📊 Статистика и дашборд
На главной странице дашборда отображается общая аналитика и соотношение автоматизированных и ручных тестов.

![Allure TestOps Dashboards](images/testops_dashboards.png)

---

### 🚀 Запуски (Launches)
В разделе запусков фиксируются результаты каждого прогона сборки из Jenkins.

![Allure TestOps Launches](images/testops_launches.png)

---

### 📋 Управление тест-кейсами
В системе ведется единый реестр тест-кейсов, включающий как автоматизированные UI-тесты, так и ручные сценарии.

![Allure TestOps Test Cases](images/testops_testcases.png)

---

## 🔹 Интеграция с Jira

Реализована двухсторонняя интеграция **Allure TestOps** с **Jira**. В задаче отображается список покрытых автотестами кейсов, результаты их прогона и привязанные тест-планы.

![Jira Integration](images/jira_integration.png)

## <img alt="Allure" height="25" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Telegram_2019_Logo.svg/1280px-Telegram_2019_Logo.svg.png?utm_source=ru.wikipedia.org&utm_campaign=index&utm_content=thumbnail" width="25"/></a>  Уведомления в Telegram

После завершения сборки бот автоматически отправляет сводку с графиком и статусом прохождения в Telegram-чат:

![Telegram Notification](images/telegram_notification.png)

---

## 🎥 Запись выполнения теста в Selenoid

Ниже продемонстрировано видео прохождения тест-кейса **«№5.Разлогин из системы»** (авторизация, открытие бокового меню и выход через Logout):

![Selenoid Video](images/test_execution.gif)
