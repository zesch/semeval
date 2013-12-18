package semeval2013.task7.util;

public class OSUtil
{

    public enum OSTypes {
        Windows,
        Linux
    }
    
    /**
     * Determines the tpye of OS the application is running on.
     * At the moment only Windows and Linux are supported.
     * @return The type of OS the application is running on. Or "unknown" if the system is unknown.
     */
    public static String getOsType() {
        String osType = "unknown";
        String osName = System.getProperty("os.name");
    
        if (osName.contains("Windows")) {
            osType = OSTypes.Windows.name();
        }
        else if (osName.contains("Linux")) {
            osType = OSTypes.Linux.name();
        }
        else if(osName.contains("Mac OS X")||osName.contains("Darwin")){
            osType = OSTypes.Linux.name();
        }
        return osType;
    }
}
