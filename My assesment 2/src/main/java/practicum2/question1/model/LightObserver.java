package practicum2.question1.model;

/**
 * An interface that must be implemented by a class that observes a Light for
 * changes in state.
 * 
 * @author GCCIS Faculty
 */
public interface LightObserver {
    /**
     * This method will be called on a registered observer whenever the state
     * of a light being observed changes.
     */
    public void stateChanged(Light light);
}
