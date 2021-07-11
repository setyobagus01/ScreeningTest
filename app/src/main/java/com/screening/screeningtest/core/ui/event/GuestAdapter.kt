package com.screening.screeningtest.core.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.screening.screeningtest.R
import com.screening.screeningtest.core.domain.model.Guest
import com.screening.screeningtest.databinding.GuestItemBinding

class GuestAdapter: RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    private val guestList = ArrayList<Guest>()
    var onItemClick: ((Guest) -> Unit)? = null

    fun setGuest(guests: List<Guest>?) {
        if (guests == null) return
        guestList.clear()
        guestList.addAll(guests)
        notifyDataSetChanged()
    }

    inner class GuestViewHolder(private val binding: GuestItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(guest: Guest) {
            with(binding) {
                Glide.with(itemView.context)
                    .asBitmap()
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .load(guest.image)
                    .into(imgGuest)
                guestName.text = guest.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(guestList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val binding = GuestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val guest = guestList[position]
        holder.bind(guest)

    }

    override fun getItemCount(): Int = guestList.size
}