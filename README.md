# Testing and CI integration
## Техническое задание 2 
![Java CI with Maven](https://github.com/zpankova/CIRep_New/actions/workflows/maven.yml/badge.svg)
### Описание проекта: 
#### Задачи: 
1. Написать программу на Java, которая будет считывать из файла числа, а далее отдельными функциями искать среди этих чисел минимальное число, максимальное число, считать их общую сумму и произведение.
Функции называются, соответственно _min (минимальное число), _max (максимальное число), _sum (сумма всех чисел), _mult (произведение всех чисел).
2. Реализовать тесты для проверки корректной работы функций программы.

### 1. Реализация функции чтения из файла, поиска минимального, максимального числа, сложения и умножения всех чисел из файла
*NumberProcessor* - программа считывающая из файла числа, записанные через пробел, и вычисляет минимальное число, максимальное, сумму и произведение. Файл передается как строка в методы min, max, sum, mult, которые возвращают соответсвующие результаты. 
Метод main читает файл с указанным названием (в примере "Check.txt") и вычисляет минимум, максимум, сумму и произведение. 

![image](https://github.com/zpankova/CIRep_New/assets/167033338/a2b099f1-04b1-4d02-819b-b8e90579ac93)

Код представлен в файле *CIRep_New/src/main/java/org/example/NumberProcessor*  
[NumberProcessor.java](https://github.com/zpankova/CIRep_New/blob/dc00423f53a656c824dd1025f8f0a07621f2ea31/src/main/java/org/example/NumbersProcessor.java) 


### 2. Реализация тестов для проверки корректности функций поиска минимума, максимума, сложения и умножения
Реализованы 4 unit теста для проверки кооректной работы функций min, max, sum, mult. Тесты написаны в файле *CIRep_New/src/test/java/org/example/NumbersProcessorTest* [NumberProcessorTest.java](https://github.com/zpankova/CIRep_New/blob/cba1d50c62426b1cdbcd9997e34a54ed7b3e6c3c/src/test/java/org/example/NumbersProcessorTest.java). Для тестов берутся заранее подготовленные файлы *test<Number>* с номерами 1-4. 

### 3. Реализация тестов для проверки скорости работы программы при увеличении размера входного файла
В файле *CIRep_New/src/main/java/org/example/NPBenchmarks* [NPBenchmarks.java](https://github.com/zpankova/CIRep_New/blob/2f2c28197bbc23e8e19722d2fc5eddc7e487f240/src/main/java/org/example/NPBenchmarks.java) написан код для нагрузочного тестирования. Были созданы файлы с количеством чисел от 100_000 до 1_000_000 с шагом в 100_000, они назвываются в формате *Speed_check<Number>* с номерами 1-10. Для каждого из файлов запускалось нагрузочное тестирование, результатом которого было среднее время работы программы на всех тестах. Среднее время записано в файле с кодом для графика [plot.ipynb](https://github.com/zpankova/CIRep_New/blob/d1c2b8d7129c837dc40c0a9ea96975b87abc52aa/plot.ipynb). Затем был построен график.

### 4. Реализация теста на мой выбор
В файл с тестами *CIRep_New/src/test/java/org/example/NumbersProcessorTest* был добавлен сценарный тест *sum_script*, в котором тестируется сценарий поиска минимума, максимума и как результат их суммы на тестах *test<Number>* с номерами 1-3.

### 5. Построить график зависимости времени выполнения от кол-ва чисел в файле
График построен в пункте 3 [chart.png](https://github.com/zpankova/CIRep_New/blob/d1c2b8d7129c837dc40c0a9ea96975b87abc52aa/chart.png). Он был построен с помощью библеотек seaborn, matplotlib, pandas. В файле graph.png отражена искомая зависимость (практически линейная). По оси x расположено количество чисел в файле в тысячах, по оси y - секунды.

### 6. Загрузить в репозиторий файлы проекта 
Файлы проекта (код, тесты,  README.md и тд) были загружены в данный репозиторий с помощью функций git commit, git push примененных для проекта, созданного в Intellij IDEA.

### 7. Подключить к проекту CI систему, обеспечить возможность проведения ручного тестирования 
CI система была реализована с помощью инструментов github actions. Реализована возможность ручного прогона тестов для выбранного коммита на основе Maven архитектуры. Для этого:

1. Перейти во вкладку Actions
2. Выбрать интересующий коммит и кликнуть на него
3. Навести курсор на нужную сборку в левой части экрана, перезапустить сборку (re-run jobs)
4. Сборка будет пересобрана и запустится прогон тестов
5. Лог сборки можно посмотреть, кликнув на сборку (Находится в списке jobs)

Например, в разделе Run tests каждой сборки можно увидеть прошла ли программа все тесты или были какие-то ошибки
![image](https://github.com/zpankova/CIRep_New/assets/167033338/524062c6-1a85-46b3-9dd7-3c3e268ebf3e)

### 8. Настроить автоматический прогон тестов при каждом коммите
В файле *maven.yml*, где написан код для запуска тестов, указано условие (on: push), что обеспечивает прогон тестов при каждом pushе из Intellij IDEA или при каждом коммите внутри гитхаба.
Чтобы увидеть статус после нового коммита или пул реквеста нужно:

1. Нажать на значок вверху страницы рядом с именем владельца репозитория и последнем коммитом
2. Значок может значить следующее:
   
Зеленая галочка - сборка прошла успешно, все тесты пройдены

Желтый кружочек - тестирование происходит в данный момент

Красный крестик - ошибка при сборке

### 9. Сделать бейдж, отражающий текущий статус тестов
(Бейдж представлен вначале README)

### 10. Интеграция CI в telegram 
Был создан чатбот в телеграмме, который с помощью соответствующего кода в файле *maven.yml*, отправляет сообщение в группу в телеграмме (https://t.me/+Xphb7gf9t981YzUy) о статусе проуденных тестов: "Все ОК", если тысты прошли успешно или "Проект завершился с ошибкой. Лог тестирования:..."
![image](https://github.com/zpankova/CIRep_New/assets/167033338/cbe37b50-503e-42e6-b25a-9c53c399d2b2)
