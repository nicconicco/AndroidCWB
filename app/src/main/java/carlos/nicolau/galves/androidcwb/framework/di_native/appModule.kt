package carlos.nicolau.galves.androidcwb.framework.di_native

import androidx.room.Room
import carlos.nicolau.galves.androidcwb.framework.Interactors
import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.provider.AppDispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.provider.DispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModelImpl
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.data.IGetUserDataSource
import carlos.nicolau.galves.core.data.IGetUserRepository
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import carlos.nicolau.galves.core.interators.IGetUserUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(override = true) {

    //region DataSource
    factory<IGetUserDataSource> { GetUserDataSource(get()) }
    //endregion

    //region AppProvider
    single<DispatcherProvider> { AppDispatcherProvider() }
    //endregion

    //region UseCase
    factory<IGetUserUseCase> { GetUserUseCaseImpl(GetUserRepositoryImpl(GetUserDataSource(get()))) }
    //endregion

    //region Repository
    factory<IGetUserRepository> { GetUserRepositoryImpl(GetUserDataSource(get())) }
    //endregion

    //region database
    single {
        Room.databaseBuilder(
            get(),
            AndroidCWBRoom::class.java,
            "database"
        )
            .build()
    }

    single { get<AndroidCWBRoom>().getUserDAO() }
    //endregion

    //region ViewModel
    viewModel {
        LoginViewModelImpl(
            get(),
            get(),
            GetUserUseCaseImpl(
                GetUserRepositoryImpl(GetUserDataSource(get()))),
                AppDispatcherProvider().ui(),
                AppDispatcherProvider().io()
            )
    }
    //endregion
}