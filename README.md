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

## 📋 Покрытый функционал (Тест-кейсы)

В проекте автоматизированы ключевые пользовательские сценарии для приложения **SauceDemo**:

* 🔑 **1. Успешный вход в систему** — проверка авторизации под валидным пользователем (`standard_user`) и перехода в каталог товаров (`Products`).
* ❌ **2. Ошибка при входе с неверным паролем** — проверка отображения валидационной ошибки при вводе некорректных учетных данных.
* 🛒 **3. Добавление товара в корзину** — добавление рюкзака (`Sauce Labs Backpack`) и проверка обновления счетчика товаров на иконке корзины.
* 🏷️ **4. Сортировка товаров по цене (low to high)** — проверка фильтрации каталога от дешевых к дорогим (первая позиция — `$7.99`).
* 🚪 **5. Разлогин из системы** — открытие бокового бургер-меню, выход через `Logout` и проверка возврата на форму авторизации.

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

Сборка тестов автоматически запускается в [Jenkins](https://jenkins.qa.guru/job/Kaliakbarova_sauce_demo_tests_automation/).

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
![Allure Test Steps](doc/img/allure_steps.png)

#### Автоматические артефакты и логи
![Allure Attachments](doc/img/allure_attachments.png)

---

## 📱 Уведомления в Telegram

После завершения сборки бот автоматически отправляет сводку с графиком и статусом прохождения в Telegram-чат:

![Telegram Notification](images/telegram_notification.png)

---

## 🎥 Запись выполнения теста в Selenoid

Ниже продемонстрировано видео прохождения тест-кейса **«№5.Разлогин из системы»** (авторизация, открытие бокового меню и выход через Logout):

![Selenoid Video](images/test_execution.gif)
