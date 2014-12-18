package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum DeviceState
{
    TIME_A,
    DATE,
    STOPPER,
    ALARM,
    TIME_B;
    
    public DeviceState nextState()
    {
        if(this == TIME_A)
            return DATE;
        else if(this == DATE)
            return STOPPER;
        else if(this == STOPPER)
            return ALARM;
        else if(this == ALARM)
            return TIME_B;
        else
            return TIME_A;
    }
    
    public static String toString(DeviceState state)
    {
        switch(state)
        {
            case TIME_A:    return "TIME_A";
            case DATE:      return "SECONDS";
            case STOPPER:   return "STOPPER";
            case ALARM:     return "ALARM";
            case TIME_B:    return "TIME_B";
            default:        return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }
}
