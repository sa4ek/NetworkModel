NetworkModel
============
Модель сети:

                    роутер
                      |
                     хаб     ----------> свитч
                 /    |                 /     \
               /      |                /        pc3
            pc1       |              /
                      |            /
                      |          /
                      |        /
                      |      /
                      |    /
                      |  /
                    pc2
                    

Реализация поиска пути через алгоритм Дейкстры. У каждого активного элемента уникальный IP. 

--------------------------------------------------------------------------------------------
Осталось реализовать поиск по IP среди активных элементов сети.


--------------------------------------------------------------------------------------------

Исходники алгоритма Дейкстры http://www.algolist.com/code/java/Dijkstra%27s_algorithm
Описание алгоритма Дейкстры http://habrahabr.ru/post/202314/
