package Leet.Medium;

import java.util.Random;

public class LC_478 {

    double radius2, x_center, y_center;

    public LC_478(double radius, double x_center, double y_center) {
        this.radius2 = radius * radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {//直接在r上随机是一维上的随机，此处应该对应面积，所以应该成平方再开方，对应二维上的随机
        double r = Math.sqrt(new Random().nextDouble() * radius2);
        double angle = new Random().nextDouble() * 2 * Math.PI;
        double x = r * Math.cos(angle);
        double y = r * Math.sin(angle);
        return new double[]{x + x_center, y + y_center};
    }
}
