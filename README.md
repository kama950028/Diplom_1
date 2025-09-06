# Diplom_1 — Автотесты (JUnit4, REST Assured, JaCoCo)

Этот проект реализует автотесты на **Java 11** с использованием **JUnit4**, **REST Assured**.  
Сборка и управление зависимостями — **Maven**.

## Что сделано
- ✅ Создан отдельный Maven‑проект для тестов API.  
- ✅ Подключены JUnit 4, REST Assured, JaCoCo.  
- ✅ Написаны автотесты (позитивные и негативные сценарии).  
- ✅ Реализована генерация отчётов в JaCoCo.  

## Технологический стек
- Java 11  
- Maven 3.8+  
- JUnit 4.13.2  
- REST Assured 5.x
- JaCoCo (анализ покрытия тестами)  


### Быстрый старт

1. Установите **JDK 11** и **Maven**.  
2. Запустите тесты:  
```bash
mvn clean test
```
Отчёты JUnit будут сохранены в `target/surefire-reports/`.


### JaCoCo Coverage
Для просмотра покрытия тестами выполните:  
```bash
mvn clean test jacoco:report
```
Откройте файл `target/site/jacoco/index.html` в браузере.
