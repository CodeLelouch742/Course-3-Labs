package ru.pa4ok.lab2;

import lombok.Data;

@Data
public class Entity
{
    protected double x;
    protected double z;

    protected transient Entity closest = null;
    protected transient double closestDistance = -1;
    protected transient boolean blocked = false;
    protected transient boolean doubleFound = false;

    public Entity(double x, double z) {
        this.x = x;
        this.z = z;
    }

    public boolean findClosest(Entity[] entities)
    {
        if(this.blocked || this.doubleFound) {
            return false;
        }

        if(this.closest != null) {
            return true;
        }

        Entity closest = null;
        double closestDistance = Double.MAX_VALUE;
        double closestCount = 0;

        for(Entity e : entities) {
            if(e != this && !e.blocked && !e.doubleFound) {
                double distance = this.getDistance(e);
                Application.entityComparingCount++;
                if(distance < closestDistance) {
                    closest = e;
                    closestDistance = distance;
                    closestCount = 1;
                } else if(distance == closestDistance) {
                    closestCount++;
                }
            }
        }

        if(closest != null) {
            if(closestCount == 1) {
                this.closest = closest;
                this.closestDistance = closestDistance;
                return true;
            }
            this.blocked = true;
        }

        return false;
    }

    public double getDistance(Entity other) {
        double d0 = other.x - x;
        double d1 = other.z - z;
        return Math.sqrt(d0 * d0 + d1 * d1);
    }
}
