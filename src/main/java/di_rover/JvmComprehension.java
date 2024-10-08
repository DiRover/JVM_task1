package di_rover;

public class JvmComprehension { // произошла работа classloader, класс загрузился в Metaspace

    public static void main(String[] args) { // метод попал в stack memory, создался frame
        int i = 1;                      // 1 переменная с примитивным типом int попала во frame
        Object o = new Object();        // 2 в heap создался экземпляр класса Object, во frame попала переменная о содержащая ссылку на созданный экземпляр
        Integer ii = 2;                 // 3 в heap создался экземпляр класса Integer, во frame попала переменная ii содержащая ссылку на созданный экземпляр
        printAll(o, i, ii);             // 4 создался frame метода printAll, внутрь которого попали переменные o, i, ii, содержащие ссылки на объекты и приметивный тип int
        System.out.println("finished"); // 7 создаётся frame метода println, в него попадает ссылка на строку "finished", экземпляр которой будет хранится в heap
    }

    private static void printAll(Object o, int i, Integer ii) { // метод попал в stack memory, создался frame
        Integer uselessVar = 700;                   // 5 кандидат для сборщика мусора, в heap создался экземпляр класса Integer, во frame попала переменная uselessVar содержащая ссылку на созданный экземпляр
        System.out.println(o.toString() + i + ii);  // 6 создаётся frame метода println, в него попадает ссылка на строку, созданую из нескольких подстрок, у экземпляра класса Integer будет вызов метода toString и произойдёт конкотенация, экземпляр которой будет хранится в heap
    }
}
