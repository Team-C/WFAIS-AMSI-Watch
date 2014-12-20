package enums;

/*______________________________________________________________________________

WARNING: Zmień ktoś formatowanie to uduszę :)

Author: Wit
 _____________________________________________________________________________*/

public enum AlarmConfigState
{
    DEFAULT,
    MINUTES,
    HOURS,
    SOUND;
    
    public AlarmConfigState nextState()
    {
        if(this == DEFAULT)
            return MINUTES;
        else if(this == MINUTES)
            return HOURS;
        else if(this == HOURS)
            return SOUND;
        else
            return DEFAULT;
    }
    
    public static String toString(AlarmConfigState state)
    {
        switch(state)
        {
            case DEFAULT:   return "DEFAULT";
            case MINUTES:   return "MINUTES";
            case HOURS:     return "HOURS";
            case SOUND:     return "SOUND";
            default:        return "UNKNOWN";      
        }
    }
    
    @Override
    public String toString()
    {
        return toString(this);
    }
}
