package oxim.digital.mwmvp.interactor;

import javax.inject.Inject;

import oxim.digital.mwmvp.repository.LeWildRepository;

public class LeWildUseCase {

    private final LeWildRepository leWildRepository;

    @Inject
    public LeWildUseCase(final LeWildRepository leWildRepository) {
        this.leWildRepository = leWildRepository;
    }

    public boolean execute(final String parameter) {
        return leWildRepository.doSmth(parameter);
    }
}
