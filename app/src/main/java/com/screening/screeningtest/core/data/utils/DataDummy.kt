package com.screening.screeningtest.core.data.utils

import com.screening.screeningtest.core.domain.model.Event

object DataDummy {

    fun getEvents(): List<Event> {
        val events = ArrayList<Event>()

        events.add(Event(
            1,
            "Tomorrowland",
            "15 Nov 2021",
            "https://pbs.twimg.com/media/E4k_ojtXMAIHYbs.jpg"
        ))

        events.add(Event(
            2,
            "Woodstock",
            "16 Nov 2021",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Tomorrowland-2017-2.jpg/1200px-Tomorrowland-2017-2.jpg"
        ))

        events.add(Event(
            3,
            "JAVA JAZZ",
            "17 Nov 2021",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Tomorrowland-2017-2.jpg/1200px-Tomorrowland-2017-2.jpg"
        ))

        events.add(Event(
            4,
            "Grammy",
            "18 Nov 2021",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Tomorrowland-2017-2.jpg/1200px-Tomorrowland-2017-2.jpg"
        ))

        return events
    }
}