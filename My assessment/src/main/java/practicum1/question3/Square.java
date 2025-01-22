package practicum1.question3;

class Square extends Quadrilateral {
    
    public Square(double width) {
        this.width = width;
        
    }

    @Override
    public String getName() {
        return "Square"; 
    }

    @Override
    public double getArea() {
        return width * width;
    }
}

