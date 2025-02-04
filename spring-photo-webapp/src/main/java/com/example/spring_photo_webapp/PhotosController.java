package com.example.spring_photo_webapp;

import java.io.IOException;
import java.util.*;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController // Tells spring that this class is the RestController
public class PhotosController {

    private final PhotosService photosService; // This is known as constructor injection

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService; // Constructor to recieve a photos service and set it to the class.
    }

    @GetMapping("/") // Tells spring what to do with this method , we want to map it. We could also have @PostMapping @DeleteMapping , etc.
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return photosService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        Photo photo = photosService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(), file.getBytes());
    }
}
