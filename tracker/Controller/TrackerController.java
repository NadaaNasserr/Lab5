package com.example.tracker.Controller;

import com.example.tracker.APIResponse.APIResponse;

import com.example.tracker.Medol.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tracker")


public class TrackerController {

    ArrayList<Tracker> trackers = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Tracker> getTracker() {

        return trackers;
    }

    @PostMapping("/add")
    public APIResponse addTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
        return new APIResponse("tracker added", 200);

    }


    @PutMapping("/update/{index}")
    public APIResponse updateTracker(@PathVariable int index, @RequestBody Tracker tracker) {
        trackers.set(index, tracker);
        return new APIResponse("Tracker updated", 200);


    }

    @DeleteMapping("/delete/{index}")
    public APIResponse deleteTracker(@PathVariable int index) {
        trackers.remove(index);
        return new APIResponse("Tracker deleted", 200);

    }

    @PutMapping("/change/{index}")
    public APIResponse changeStatus(@PathVariable int index) {

        if (trackers.size() > index) {

            if (trackers.get(index).getStatus().equals("done")) {
                trackers.get(index).setStatus("not done");
            } else if (trackers.get(index).getStatus().equals("not done")) {
                trackers.get(index).setStatus("done");
            }

            return new APIResponse("Change the task status", 200);
        }
        return new APIResponse("Not found", 404);
    }


    @GetMapping("/search/{title}")
    public Tracker searchTitle(@PathVariable String title) {

        for (Tracker t : trackers) {
            if (t.getTitle().equals(title)) {
                return t;
            }

        }
        return null;
    }

    @GetMapping("/display/{company}")
    public ArrayList<Tracker> displayAllProject(@PathVariable String company) {
        ArrayList<Tracker> t1 = new ArrayList<>();

        for (Tracker t : trackers) {
            if (t.getCompanyName().equals(company)) {
                t1.add(t);

            }
        }

           return t1;
        }


    }




