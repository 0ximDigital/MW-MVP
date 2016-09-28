package oxim.digital.mwmvp.data;

import oxim.digital.mwmvp.repository.LeWildRepository;
import oxim.digital.mwmvp.utils.LeWildUtils;

public class LeWildRepositoryImpl implements LeWildRepository {

    private final LeWildUtils leWildUtils;

    public LeWildRepositoryImpl(final LeWildUtils leWildUtils) {
        this.leWildUtils = leWildUtils;
    }

    @Override
    public boolean doSmth(final String parameter) {
        return leWildUtils.doSomethingUseful(parameter);
    }
}
