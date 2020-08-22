1. Поменять местами два числа без использования дополнительных

https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/main/java/proj/First.java
https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/test/java/basetest/FirstTests.java

две переменные, у каждой из которых валидный класс эквивалентности от минус бесконечности до плюс бесконечностb

программа примитивная, никаких эмпирических предпочтений я не обнаружил, потому написал 6 тестов:

1) меняет местами 0 и 0 
2) меняет местами 0 и -1 | 0 и 1 
3) меняет местами 999723999 и -999009999 
4) меняет местами 999997999 и 993499999 
5) меняет местами -999999999 и -999989999 
6) меняет местами 999999999999999999 и 999999999999999999999

еще была идея написать тест, который генерирует 2_000 рандомных чисел и меняет между собой, но не вижу в этом смысла



2. Программа получает три входных параметра (кол-во этажей, кол-во квартир на этаже, номер квартиры) и должна вернуть подьезд и этаж.

https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/main/java/proj/Second.java
https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/test/java/basetest/SecondTests.java

три переменные

у кол-ва этажей класс эквивалентности от 1 до 46_340
у кол-ва квартир на этаже класс эквивалентности от 1 до 46_340
у номера квартиры класс эквивалентности от 1 до Integer.MAX_VALUE

ограничения снизу были вызваны бизнес-логикой (нет нулевого или отрицательного этажа, на этаже должна быть хотя-бы одна квартира, номер квартиры начинается с 1)

ограничения сверху были вызваны операцией умножения кол-ва этажей на кол-во квартир на этаже. Результат не должен превышать размеры интежера

я написал 7 тестов, которые проверяют результат на сложных моментах, границы параметров и немношк посередине:

1) проверяет входные данные с листа, а также проверяет результат программы в сложных моментах (первая квартира подьезда, последняя квартира подьезда и т.д.)

2) тестирует 100 значений 3го параметра от 0 до -99_000, все должны возвращаться ошибку

3) тестирует 2_000_000 значений 3го параметра от 1 до 1_999_999_000, программа должна не сломаться

4) тестирует 100 значений 2го параметра от 0 до -99_000, все должны возвращаться ошибку

5) тестирует 46 значений 2го параметра от 1 до 45_000, программа должна не сломаться


6) тестирует 100 значений 1го параметра от 0 до -99_000, все должны возвращаться ошибку

7) тестирует 46 значений 1го параметра от 1 до 45_000, программа должна не сломаться

8) входные параметры 46_340, 46_340, Integer.MAX_VALUE. Программа должна вернуть 2 подьезд и 2 этаж

еще была идея добавить комбинаторные тесты или просто больше проверок значений, но для этого пришлось бы считать немного вручную, но я полагаю, что это неэффективно, учитывая покрытие первого теста




3. ищет максимальный делитель для  4х чисел

https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/main/java/proj/Third.java
https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/test/java/basetest/ThirdTest.java

валидный класс эквивалентности для каждого числа от 1 до Integer.MAX_VALUE, так как было бы странно искать делитель для 0 и я не уверен, надо ли было искать для отрицательных

4 теста:

1) передает различные данные и проверяет результат (в том числе максимальную границу)

2) отрицательное значение

3) минимальное значение интежера

4) проверяет 0 как входной параметр

имело бы смысл проверить каждый входной параметр на 0 и отрицательное значение, но это было бы 11 тестов, и я их все же написал




4. фибоначчи, один входной параметр

https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/main/java/proj/Fourth.java
https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/test/java/basetest/Tests.java

валидный класс эквивалентности - от 0 до бесконечности

4 теста

1) проверяет значения от 0 до 500

2) проверяет значение для миллиона

3) проверяет 100 значений от -1 до -99_000

4) проверяет тысячу значений от 0 до 9_999_000

не вижу смысла проверять на еще что-либо, пытался вызвать heap space, но не вышло






5. найти день недели по трем параметрам: день недели нового года, искомый день и месяц искомого дня

https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/main/java/proj/Fifth.java
https://github.com/TarasTarghanskiy/TestMaven/blob/master/src/test/java/basetest/FifthTest.java

валидный класс эквивалентности для первого параметра 1-7
для второго 1-28/31 (в зависимости от месяца)
для третьего 1-12

4 теста:

1) просчитывает все варианты для 2018 и 2019 годов

2) просчитывает от -1000 до 0 и от 8 до 1000, по сути границы валидного класса эквивалентности и дополнительно несколько значений

3) от -1000 до 0 и от 13 до 1000

4) прочитывает границы класса эквивалентности параметра "день месяца" для всех месяцев

не знаю, что еще можно сюда добавить