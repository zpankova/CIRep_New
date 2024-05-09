# Testing and CI integration
## Техническое задание 2 
![Java CI with Maven](https://github.com/zpankova/CIRep_New/actions/workflows/maven.yml/badge.svg)
### Описание проекта: 
#### Задачи: 
1. Написать программу на Java, которая будет считывать из файла числа, а далее отдельными функциями искать среди этих чисел минимальное число, максимальное число, считать их общую сумму и произведение.
Функции называются, соответственно _min (минимальное число), _max (максимальное число), _sum (сумма всех чисел), _mult (произведение всех чисел).
2. Реализовать тесты для проверки корректной работы функций программы.

### 1. Реализация функции чтения из файла, поиска минимального, максимального числа, сложения и умножения всех чисел из файла
*NumberProcessor* - программа считывающая из файла числа, записанные через пробел, и вычисляет минимальное число, максимальное, сумму и произведение. Файл передается как строка в методы min, max, sum, mult, которые возвращают соответсвующие результаты. Метод main читает файл с указанным названием (в примере "Check.txt") и минимум, максимум, сумму и произведение.

### 2. Реализация тестов для проверки корректности функций поиска минимума, максимума, сложения и умножения
Реализованы 4 unit теста для проверки кооректной работы функций min, max, sum, mult. Тесты написаны в файле *NumbersProcessorTest*. Для тестов берутся заранее подготовленные файлы из папки *test_files* с номерами 1-4. 

### 3. Реализация тестов для проверки скорости работы программы при увеличении размера входного файла
В файле *NPBenchmarks* написан код для нагрузочного тестирования. Были созданы файлы с количеством чисел от 100_000 до 1_000_000 с шагом в 100_000, они лежат в папке *test_files* с номерами 1-10. Для каждого из файлов запускалось нагрузочное тестирование, результатом которого было среднее время работы программы на всех тестах. Среднее время записано в файле с кодом для графика *plot.ipynb*. Затем был построен график.

### 4. Реализация теста на мой выбор
В файл с тестами *NumbersProcessorTest* был добавлен сценарный тест *sum_script*, в котором тестируется сценарий поиска минимума, максимума и как результат их суммы на тестах 1-3.

### 5. Построить график зависимости времени выполнения от кол-ва чисел в файле
График построен в пункте 3 (*graph.png*). Он был построен с помощью библеотек seaborn, matplotlib, pandas . В файле graph.png отражена искомая зависимость (линейная). По оси x расположено количество чисел в файле в тысячах, по оси y секунды.
