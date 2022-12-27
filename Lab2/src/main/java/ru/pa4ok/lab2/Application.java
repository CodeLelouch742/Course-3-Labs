package ru.pa4ok.lab2;

import java.util.*;

/**
 * Для удобства расчетов расстояние считается в см
 * Тогда, если скорость 1см/сек, дистанция будет равна времени прохождения
 * n - количество улиток
 *
 * количество вычислений расстояния между улитками достигается меньше чем n^2
 * улитки, которые запутались или идут навстречу, пропускаются при дальнейших поисках ближайших
 *
 * когда улитка e1 нашла ближайшую улитку e2
 * если у e2 еще не найдена ближайшая улитка
 * и она сама не запуталась, вызывается ее поиск
 * после этого, если e1 и e2 нашли друг друга
 * они исключаются из дальнейших сравнений
 */
public class Application
{
    public static final Random RAND = new Random();
    public static final int BORDER = 100_000;
    public static final int ENTITY_COUNT = 10000 + RAND.nextInt(25);
    public static final int ENTITY_COUNT_SQ = ENTITY_COUNT * ENTITY_COUNT;

    public static int entityComparingCount = 0;

    public static void main(String[] args)
    {
        Entity[] entities = new Entity[ENTITY_COUNT];
        for(int i=0; i<entities.length; i++) {
            entities[i] = new Entity(RAND.nextInt(BORDER), RAND.nextInt(BORDER));
        }

        double minDistance = Double.MAX_VALUE;
        for(Entity e : entities) {
            if(e.findClosest(entities)) {
                Entity closest = e.getClosest();
                if(closest.getClosest() == null && !closest.isBlocked()) {
                    closest.findClosest(entities);
                }
                if(e == closest.getClosest()) {
                    e.setDoubleFound(true);
                    closest.getClosest().setDoubleFound(true);
                    minDistance = Math.min(minDistance, e.getClosestDistance() / 2);
                } else {
                    minDistance = Math.min(minDistance, e.getClosestDistance());
                }
            }
        }

        if(minDistance != Double.MAX_VALUE) {
            System.out.println("Минимальное время: " + (int)Math.ceil(minDistance) + " сек");
            System.out.println("Количество сравнений: " + entityComparingCount + " / " + ENTITY_COUNT_SQ);
        } else {
            System.out.println("Все улитки запутались в своей бинарности <clown>");
        }
    }
}
