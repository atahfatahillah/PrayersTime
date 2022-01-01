package id.umma.prayertimes.fatahillah.di;

import javax.inject.Singleton;

import dagger.Component;
import id.umma.prayertimes.fatahillah.viewmodel.MainActivityViewModel;

@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(MainActivityViewModel mainActivityViewModel);

}
