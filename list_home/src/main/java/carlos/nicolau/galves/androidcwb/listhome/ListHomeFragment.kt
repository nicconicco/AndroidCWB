package carlos.nicolau.galves.androidcwb.listhome

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListHomeFragment : Fragment() {

    companion object {
        fun newInstance() = ListHomeFragment()
    }

    private lateinit var viewModel: ListHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListHomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
