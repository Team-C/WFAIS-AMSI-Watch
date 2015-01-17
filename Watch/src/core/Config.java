package core;

/**
 *
 * @author Michał Szura
 */
public interface Config<T> {

    public void increaseTimeValue();

    public void cycleConfigState();
    
    public T getConfigState();
}
