package unit03.toys;

public class Robot extends toys {

    private int batteryLevel;
    private boolean voiceActivation; 
    
    public Robot(long productCode, String name, double msrp, int minimumAge, 
                 int batteryLevel, boolean voiceActivation) {
                 
      super(name, minimumAge, 1);
      
      this.batteryLevel = batteryLevel;
      this.voiceActivation = voiceActivation;
    }
    
    public int getBatteryLevel() {
      return batteryLevel;
    }
  
    public void setBatteryLevel(int batteryLevel) {
      this.batteryLevel = batteryLevel; 
    }
    
    public boolean hasVoiceActivation() {
      return voiceActivation;
    }
  
    public void setVoiceActivation(boolean voiceActivation) {
      this.voiceActivation = voiceActivation;
    }
  
    @Override
    public void play() {
      
      if(batteryLevel > 0) {
        System.out.println("Robot is walking and waving!");
        
        if(voiceActivation) {
          System.out.println("Hello human! Let's play!");  
        }
        
        batteryLevel -= 10; 
      } else {
        System.out.println("Battery empty, robot needs recharging.");
      }
    }
  }