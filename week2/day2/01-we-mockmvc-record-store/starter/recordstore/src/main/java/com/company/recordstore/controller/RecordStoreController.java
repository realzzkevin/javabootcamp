package com.company.recordstore.controller;

import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RecordStoreController {
    private static int RecordId = 1;
    private List<Record> recordList = new ArrayList<>(Arrays.asList(
            new Record("The Beach Boys", "Pet Sounds", RecordId++),
            new Record("Billy Joel", "The Stranger", RecordId++),
            new Record("The Beatles", "Revolver", RecordId++),
            new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", RecordId++),
            new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", RecordId++)
    ));
    // TO DOR
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Record> getAllRecords() {
        return recordList;
    }

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Record createRecord(@RequestBody Record record) {
        record.setId(RecordId++);
        recordList.add(record);
        return record;
    }
}
