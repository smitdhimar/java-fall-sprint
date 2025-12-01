package core.ShapeCalculator;

abstract class Shape {
    abstract float area();
}

class Circle extends Shape{
    final double PIE = 3.14;
    private float radius;

    Circle(float radius){
        this.radius = radius;
    }

    float area(){
        return (float) PIE * this.radius * this.radius;
    }
}
class Square extends Shape{
    private float length ;
    private float width ;
    Square(float l, float w){
        this.length = l;
        this.width = w;
    }
    float area(){
        return (float) this.length * this.width;
    }
}
public class ShapeCalculator {
    public static void main(String[] args){
        Shape sq = new Square(32.4f, 32.4f);
        System.out.println("The area of square is : "+ sq.area());
    }
}
