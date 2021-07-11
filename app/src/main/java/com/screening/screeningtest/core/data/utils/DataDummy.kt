package com.screening.screeningtest.core.data.utils

import com.screening.screeningtest.core.domain.model.Event

object DataDummy {

    fun getEvents(): List<Event> {
        val events = ArrayList<Event>()

        events.add(Event(
            1,
            "Tomorrowland",
            "15 Nov 2021",
            "https://pbs.twimg.com/media/E4k_ojtXMAIHYbs.jpg",
            "-6.923119942193061",
            "107.61516560912933",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                    "the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"
        ))

        events.add(Event(
            2,
            "Woodstock",
            "16 Nov 2021",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Tomorrowland-2017-2.jpg/1200px-Tomorrowland-2017-2.jpg",
            "-6.922013597322479",
            "107.61594292239086",
            "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been \" +\n" +
                    "\"the industry\\\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book\""
        ))

        events.add(Event(
            3,
            "JAVA JAZZ",
            "17 Nov 2021",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Tomorrowland-2017-2.jpg/1200px-Tomorrowland-2017-2.jpg",
            "-6.9218325365002835",
            "107.61254188152724",
            "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been \" +\n" +
                    "\"the industry\\\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book\""
        ))

        events.add(Event(
            4,
            "Grammy",
            "18 Nov 2021",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Tomorrowland-2017-2.jpg/1200px-Tomorrowland-2017-2.jpg",
            "-6.925496341969707",
            "107.61330362885",
            "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been \" +\n" +
                    "\"the industry\\\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book\""
        ))

        return events
    }
}