package oxim.digital.mwmvp.application;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.data.LeWildRepositoryImpl;
import oxim.digital.mwmvp.repository.LeWildRepository;
import oxim.digital.mwmvp.utils.LeWildUtils;
import oxim.digital.mwmvp.utils.LeWildUtilsImpl;

@Module
public final class ApplicationModule {

    private final MwMvpApplication mwMvpApplication;

    public ApplicationModule(MwMvpApplication mwMvpApplication) {
        this.mwMvpApplication = mwMvpApplication;
    }

    @Provides
    @Singleton
    MwMvpApplication provideRosettaApplication() {
        return this.mwMvpApplication;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return this.mwMvpApplication;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return mwMvpApplication.getResources();
    }

    @Provides
    @Singleton
    LeWildUtils provideLeWildUtils() {
        return new LeWildUtilsImpl();
    }

    @Provides
    @Singleton
    LeWildRepository provideLeWildRepository(final LeWildUtils leWildUtils) {
        return new LeWildRepositoryImpl(leWildUtils);
    }

    interface Exposes {

        MwMvpApplication rosettaApplication();

        @ForApplication
        Context context();

        Resources resources();

        LeWildUtils leWildUtils();

        LeWildRepository leWildRepository();
    }
}
