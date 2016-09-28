package oxim.digital.mwmvp.utils;

public class LeWildUtilsImpl implements LeWildUtils {

    @Override
    public boolean doSomethingUseful(final String someHappyParameter) {
        return someHappyParameter != null && !someHappyParameter.isEmpty();
    }
}
