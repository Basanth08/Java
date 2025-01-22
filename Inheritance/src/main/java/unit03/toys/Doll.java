package unit03.toys;

public class Doll extends toys {

    private String hairColor;
    private String eyeColor;
    private String[] phrases;
    
    public Doll(long productCode, String name, double msrp, int minimumAge, 
                String hairColor, String eyeColor, String[] phrases) {
                
      super(name, productCode, 1);
      
      this.hairColor = hairColor;
      this.eyeColor = eyeColor;
      this.phrases = phrases;
    }
    
    public String getHairColor() {
      return hairColor;
    }
  
    public void setHairColor(String hairColor) {
      this.hairColor = hairColor;
    }
    
    public String getEyeColor() {
      return eyeColor;
    }
    public String[] getPhrases() {
      return phrases;
    }
    
    public void setPhrases(String[] phrases) {
      this.phrases = phrases;
    }
}

