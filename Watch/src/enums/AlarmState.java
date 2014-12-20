package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum AlarmState
{
    OFF,
    SET,
    ON;
    
    public AlarmState toggleAlarm()
    {
        if(this == OFF)
            return SET;
        else if(this == SET)
            return ON;
        else
            return OFF;
    }
    
    public static String toString(AlarmState state)
    {
        switch(state)
        {
            case OFF:   return "OFF";
            case SET:   return "SET";
            case ON:    return "ON";
            default:    return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }
}
