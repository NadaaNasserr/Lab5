package com.example.eventsystem.Controller;


import com.example.eventsystem.Medol.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("api/v1/event")
public class EventController {


    ArrayList<Event> events = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Event> getEvents() {

        return events;
    }


    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        events.add(event);
        return "event added";

    }


    @PutMapping("/update/{index}")
    public String updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return "Event updated";


    }

    @DeleteMapping("/delete/{index}")
    public String deleteEvent(@PathVariable int index) {
        events.remove(index);
        return "Event deleted";


    }

    @PutMapping("change/{index}/{capacity}")
    public String changeCapacity(@PathVariable int index, @PathVariable int capacity ) {

        if (events.size() > index) {


            events.get(index).setCapacity(capacity);

            return "Capacity changed";
        }
        else return "array Index Out Of Bounds";
    }


@GetMapping("search/{id}")
    public Event search(@PathVariable String id) {
        for (Event e : events)
            if (e.getId().equals(id)) {
                return e ;
            }

      return null;
    }
}
