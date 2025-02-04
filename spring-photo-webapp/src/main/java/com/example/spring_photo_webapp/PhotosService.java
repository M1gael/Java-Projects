package com.example.spring_photo_webapp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component works same as Service just not as readable
@Service
public class PhotosService { // For the simple purpose of handling our database

    private Map<String , Photo> db = new HashMap<>(){{
        put("1" , new Photo("1" , "hello.jpg"));
    }};

    public Collection<Photo> get(){
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName , byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId() , photo);
        return photo;
    }
}
