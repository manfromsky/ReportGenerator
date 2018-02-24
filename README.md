# ReportGenerator

## Настройки и данные для создания отчета

 Настройки для формы отчета задаются при помощи файла "settings.xml". Ширина и высота страницы задаются при помощи
 тегов:
 ```
 <page>
       		<width>...</width>
       		<height>...</height>
       </page>
 ```
  Ширина и название колонки:
  ```
  <columns>
  		<column>
  			<title>...</title>
  			<width>...</width>
  		</column>
  ```
  Файл с данными для отчета - "source-data.tsv", заполняется по строчно, например так:
  ```
  1	25/11	Павлов Дмитрий
  2	26/11	Павлов Константин
  3	27/11	Н/Д
  4	28/11	Ким Чен Ир
  5	29/11/2009	Юлианна-Оксана Сухово-Кобылина
  ```
  Файлы  "settings.xml" и "source-data.tsv" находятся в корневой папке - "ReportGenerator".
  
  На выходе программы получаем файл с готовым отчетом, который записывается в файл "report.txt".
  Файл "source-data.tsv" находится так же в корневой папке - "ReportGenerator".
  
  ## Сборка программы
  
  Сборка программы происходит при помощи команды:
   ```
   mvn package
   ```
  ## Запуск программы
  ```
  mvn exec:java -Dexec.mainClass="ru.texunatask.reportgenerator.Generator"
  ```
  
  
  ###Примеры строк отчета
 ```
 | 1        | 25/11   | Павлов  |
 |          |         | Дмитрий |  
 (смотрите файл "report.txt")
 ```
  Строка "Павлов Дмитрий" полностью не умещается размер колонки продиктованной настройками(settings.xml),
 поэтому принято решение разбить строку по ширине столбца, с переносом оставшегося текста на другую строку
 отчета.
 ```
 | 4        | 28/11   | Ким Чен |
 |          |         | Ир      |
 (смотрите файл "report.txt")
 ```
  Строка данных "Ким Чен Ир" не уместилась на первой странице целиком (потому что "Ир" был бы на 
 13й строке), поэтому она целиком перенесена на следующую страницу. 
 
 Отделяюшая строка "----" печатается  когда надо отделить данные и в конце страницы.
 ```
 | 5        | 29/11/  | Юлианна |
 |          | 2009    | -Оксана |
 |          |         | Сухово  |
 |          |         | -Кобыли |
 |          |         | на      |
 (смотрите файл "report.txt")
 ```
  Если дата полностью не помещается в колонку, принято решение переносить не поместившееся число полностью
 ну другую строку, при чем оставив разделитель "/" на предыдущей.
 