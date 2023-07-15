# explorerFolders
Программа дает возможность сёрфить по папкам/дирректориям вашей системы.
Алгоритм программы довольно сложный для чтения, есть 2 ArrayList, в которые добавлены
массив с файлами и массив с индексами к массиву с файлами. Далее при запуске
программа проверяет Ваш запрос, и после вывода папки сохраняет массив в ArrayList.
Если мы хотим перейти назад, используя ключевое слово "back", последние добавленные 
массивы удаляются из 2ух ArrayList. Для повторного поиска используется рекурсия 
в методе loopFolderSearch().

Инструкция к программе:
Вводим в строку нужное нам число, и жмем кнопку "enter". Для возврата используем
команду "back".
![Image alt](https://github.com/pkhramov11/explorerFolders/raw/master/pic2.JPG)

Инструкция к по запуску программы:
В корне проекта по адресу "explorerFolders\out\artifacts\explorerFolders_jar\" находится файл с расширением ".jar".
Для запуска jar файла в командной строке используйте следующий синтаксис:
java -jar "***абсолюный путь к папке с проектом***\explorerFolders\out\artifacts\explorerFolders_jar\explorerFolders.jar".
