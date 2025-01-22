package practicum1.question3;

interface Shape {
    String getName();
    double getArea();  

    @Override
    public String toString();
    
    @Override
    public boolean equals(Object o);
}