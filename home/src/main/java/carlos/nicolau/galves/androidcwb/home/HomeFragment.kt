package carlos.nicolau.galves.androidcwb.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import carlos.nicolau.galves.androidcwb.home.databinding.HomeFragmentBinding


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
//    private lateinit var bind: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        bind =
        return HomeFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            bindingViewModel = viewModel
            recyclerHome.adapter = HomeAdapter(DummyAndroid.ITEMS)
        }.root

//        bind.bindingViewModel = viewModel
//
//        return bind.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        bind.recyclerHome.adapter = HomeAdapter(DummyAndroid.ITEMS)
//    }
}
