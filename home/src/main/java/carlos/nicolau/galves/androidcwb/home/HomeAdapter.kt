package carlos.nicolau.galves.androidcwb.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import carlos.nicolau.galves.core.domain.Android
import kotlinx.android.synthetic.main.android_layout_item.view.*


class HomeAdapter(private val items: MutableList<Android>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.android_layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        with(holder.itemView) {
            number_api.text = item.apiLevel.toString()
            version.text = item.version
            title_android.text = item.name
            sub_description.text = item.subDescription
        }
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView)
}
