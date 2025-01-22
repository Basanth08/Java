package practicum1.question3;

class Circle implements Shape {
    
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override 
    public double getArea() { 
        return Math.PI * radius * radius;
    }
}
