package carlos.nicolau.galves.androidcwb.framework.di

import androidx.room.Room
import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSourceImpl
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtilsImpl
import carlos.nicolau.galves.androidcwb.framework.provider.AppDispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.provider.DispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModelImpl
import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.data.GetUserRepository
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import carlos.nicolau.galves.core.interators.GetUserUseCase
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val appModule = module(override = true) {

    //region DataSource
    factory<GetUserDataSource> { GetUserDataSourceImpl(get(), get()) }
    //endregion

    //region AppProvider
    single<DispatcherProvider> { AppDispatcherProvider() }
    //endregion

    //region UseCase
    factory<GetUserUseCase> {
        GetUserUseCaseImpl(
            GetUserRepositoryImpl(
                GetUserDataSourceImpl(
                    get(),
                    get()
                )
            )
        )
    }
    //endregion

    //region Repository
    factory<GetUserRepository> { GetUserRepositoryImpl(GetUserDataSourceImpl(get(), get())) }
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

    //region FirebaseFirestoreUtils
    single<FirebaseFirestoreUtils> { FirebaseFirestoreUtilsImpl(FirebaseFirestore.getInstance()) }
    //endregion

    //region ViewModel
    viewModel {
        LoginViewModelImpl(
            get(),
            get(),
            GetUserUseCaseImpl(
                GetUserRepositoryImpl(GetUserDataSourceImpl(get(), get()))
            ),
            AppDispatcherProvider().ui(),
            AppDispatcherProvider().io()
        )
    }
    //endregion
}

private val loadModules by lazy { loadKoinModules(appModule) }

internal fun injectInvoiceModulesDependencies() = loadModules