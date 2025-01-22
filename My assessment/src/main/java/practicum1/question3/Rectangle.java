package practicum1.question3;

class Rectangle extends Quadrilateral {

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override  
    public double getArea() {
        return width * height; 
    }

    @Override 
    public String toString() {
        return getName() + " [ Area=" + getArea() + " ]"; 
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) 
            return false;
        Rectangle r = (Rectangle)o;        
        return getWidth() == r.getWidth() && 
               getHeight() == r.getHeight();
    }

}