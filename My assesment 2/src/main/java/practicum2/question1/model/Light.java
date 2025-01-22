package practicum2.question1.model;

/**
 * A simple class representing a light that can be switched on and off.
 * 
 * @author GCCIS Faculty
 */
public class Light {
    /**
     * The current state of the light; either ON or OFF.
     */
    private boolean on;

    /**
     * An observer that will be notified if the light state changes.
     */
    private LightObserver observer;

    /**
     * Creates a new light in the off state.
     */
    public Light() {
        on = false;
        observer = null;
    }

    /**
     * Registers an observer to be notified when the state of the light changes.
     * 
     * @param observer The observer that will be notified when the state of the
     * light changes.
     */
    public void setOnChange(LightObserver observer) {
        this.observer = observer;
    }

    /**
     * A private helper method that notifies an observer that the state of the
     * light has changed (if the observer is not null).
     */
    private void notifyObserver() {
        if (observer != null) {
            observer.stateChanged(this);
        }
    }

    /**
     * Returns true if the light is on, and false if the light is off.
     * 
     * @return True if the light is on, false if the light is off.
     */
    public boolean isOn() { 
        return on; 
    }

    /**
     * Flips the switch on the light, toggling it from OFF to ON, or from ON
     * to OFF.
     */
    public void flipSwitch() {
        on = !on;
        notifyObserver();
    }
}