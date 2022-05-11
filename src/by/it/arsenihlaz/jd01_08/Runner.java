package by.it.arsenihlaz.jd01_08;

import java.util.Objects;

public class Runner {
    private static void print(Var var) {
        if (Objects.nonNull(var)){
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var v2 = new Vector(new double[]{6, 6, 6}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        Var m2 = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        /* Уровень сложности A (калькулятор) */
        print(s.add(s)); //выведет в консоль 6.0
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
        print(v.add(s)); //выведет в консоль {4.0, 5.0, 6.0}
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        print(v.sub(v2));//выведет в консоль {-5.0, -4.0, -3.0}
        print(v.mul(s)); //выведет в консоль 18.0
        print(v.mul(v)); //выведет в консоль 14.0
        print(v.div(s)); //{0.333, 0.666, 1.0}
        print(v.div(v)); //сообщит о невозможности операции
/* Уровень сложности C (матричные операции и умножение на вектор)
закомментируйте, если не реализовали */
        System.out.println("сложение матриц");
        print(m.add(m2)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(m.add(s)); //{{4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}, {10.0, 11.0, 12.0}}
        System.out.println("разница матриц");
        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        System.out.println("умножение матриц");
        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); //{14.0, 32.0, 50.0}
    }
}