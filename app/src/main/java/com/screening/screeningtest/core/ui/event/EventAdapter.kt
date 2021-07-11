package com.screening.screeningtest.core.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.screening.screeningtest.core.domain.model.Event
import com.screening.screeningtest.databinding.EventItemBinding

class EventAdapter: RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private val eventList = ArrayList<Event>()

    fun setEvents(events: List<Event>?) {
        if(events == null) return
        eventList.clear()
        eventList.addAll(events)
        notifyDataSetChanged()
    }
    var onItemClick:((Event) -> Unit)? = null
    inner class EventViewHolder(private val binding: EventItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) {
            with(binding) {
                Glide.with(itemView.context)
                    .asBitmap()
                    .load(event.image)
                    .into(imgEvent)
                eventName.text = event.name
                eventDate.text = event.date
                eventDescription.text = event.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(eventList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = EventItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size
}