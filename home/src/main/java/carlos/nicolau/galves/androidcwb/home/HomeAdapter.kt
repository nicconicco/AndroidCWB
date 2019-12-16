package carlos.nicolau.galves.androidcwb.home

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import carlos.nicolau.galves.core.domain.Android
import kotlinx.android.synthetic.main.android_layout_item.view.*
import timber.log.Timber

class HomeAdapter(private val items: MutableList<Android>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.android_layout_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        with(holder.itemView) {
            number_api.text = item.apiLevel.toString()
            version.text = item.version
            title_android.text = item.name
            sub_description.text = item.subDescription
            setImageResource(holder, item)
        }
    }

    private fun View.setImageResource(
        holder: RecyclerView.ViewHolder,
        item: Android
    ) {
        try {
            val context = holder.itemView.context
            val id = context.resources.getIdentifier(item.icon, "drawable", context.packageName)
            img_android.setImageResource(id)
        } catch (e: Resources.NotFoundException) {
            Timber.e(e)
        }
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView)
}