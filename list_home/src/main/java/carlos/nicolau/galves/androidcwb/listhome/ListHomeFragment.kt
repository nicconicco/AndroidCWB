package carlos.nicolau.galves.androidcwb.listhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import carlos.nicolau.galves.androidcwb.listhome.databinding.ListHomeFragmentBinding


class ListHomeFragment : Fragment() {

    companion object {
        fun newInstance() = ListHomeFragment()
    }

    private lateinit var viewModel: ListHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ListHomeFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            bindingViewModel = viewModel
//            recyclerHome.adapter
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListHomeViewModel::class.java)
    }
}
