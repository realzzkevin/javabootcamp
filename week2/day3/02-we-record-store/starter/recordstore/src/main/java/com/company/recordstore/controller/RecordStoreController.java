package com.company.recordstore.controller;


import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class RecordStoreController {

    private static int idCounter = 1;

    private static List<Record> recordList = new ArrayList<>(Arrays.asList(
            new Record("The Beach Boys", "Pet Sounds", idCounter++, "2000"),
            new Record("Billy Joel", "The Stranger", idCounter++, "2001"),
            new Record("The Beatles", "Revolver", idCounter++, "2001"),
            new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", idCounter++, "2002"),
            new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", idCounter++, "2003")
    ));

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Record createRecord(@RequestBody @Valid Record record) {

        record.setId(idCounter++);
        recordList.add(record);

        return record;
    }

//    @RequestMapping(value = "/records", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Record> getAllRecords(@RequestParam(required = false) String artist) {
//        System.out.println(artist);
//        return recordList;
//    }
        @RequestMapping(value = "/record", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public List<Record> getRecords(@RequestParam(required = false) String artist,@RequestParam(required = false) String year ) {
            System.out.println("Parameter on getRecords is " + artist + year);
            List<Record> returnVal = new ArrayList<>();
            List<Record> returnVal2 = new ArrayList<>();

            if (artist != null) {
                returnVal = recordList.stream()
                        .filter(record -> record.getArtist().toLowerCase().contains(artist.toLowerCase()))
                        .collect(Collectors.toList());
            }

            if (year != null) {
                returnVal2 = recordList.stream()
                        .filter(record -> record.getYear().equals(year))
                        .collect(Collectors.toList());
            }

//            Set<Record> result = new HashSet<>();
//            result.addAll(returnVal);
//            result.addAll(returnVal2);
            returnVal.addAll(returnVal2);
            return returnVal;
            //return returnVal;
        }

//    @RequestMapping(value = "/records", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<Record> getRecordsByYear(@RequestParam(required = false) String year) {
//        System.out.println("Parameter on getRecords is " + year);
//        List<Record> returnVal = recordList;
//
//        if (year != null) {
//            returnVal = recordList.stream()
//                    .filter(record -> record.getYear().equals(year))
//                    .collect(Collectors.toList());
//        }
//        return returnVal;
//    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Record getRecordById(@PathVariable int id) {
        Record foundRecord = null;

        for(Record record : recordList) {
            if(record.getId() == id) {
                foundRecord = record;
                break;
            }
        }

        return foundRecord;
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateRecordById(@PathVariable int id, @RequestBody @Valid Record record) {
        int index = -1;

        for(int i = 0; i < recordList.size(); i++) {
            if(recordList.get(i).getId() == id) {
                index = i;

                record.setId(id);

                break;
            }
        }

        if (index >= 0) {
            recordList.set(index, record);
        }
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRecordById(@PathVariable int id) {
        int index = -1;

        for(int i = 0; i < recordList.size(); i++) {
            if(recordList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            recordList.remove(index);
        }
    }
}
