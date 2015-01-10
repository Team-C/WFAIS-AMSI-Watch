package core;
import enums.DateConfigState;

/**
 *
 * @author Konrad Welc
 */
public class DateConfig implements Config{
    
    DateConfigState configState;
    
    @Override
    public void increaseTimeValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cycleConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DateConfigState getConfigState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
