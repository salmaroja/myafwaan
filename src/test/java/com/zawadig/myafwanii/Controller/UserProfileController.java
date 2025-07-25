//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.UserProfile;
//import com.zawadig.myafwanii.Repository.UserProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/api/v1/profile")
//public class UserProfileController {
//
//    @Autowired
//    private UserProfileRepository repository;
//
//    // GET profile by user email
//    @GetMapping("/{email}")
//    public ResponseEntity<?> getProfile(@PathVariable String email) {
//        return repository.findByUserEmail(email)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // PUT update profile
//    @PutMapping("/update")
//    public ResponseEntity<?> updateProfile(@RequestBody UserProfile incoming) {
//        return repository.findByUserEmail(incoming.getUser().getEmail())
//                .map(existing -> {
//                    existing.setName(incoming.getName());
//                    existing.setPhone(incoming.getPhone());
//                    existing.setLocation(incoming.getLocation());
//                    // ignore incoming.imagePath here if not updating
//                    repository.save(existing);
//                    return ResponseEntity.ok(existing);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // POST upload image
//    @PostMapping("/upload-image")
//    public ResponseEntity<?> uploadImage(@RequestParam String email,
//                                         @RequestParam("image") MultipartFile file) {
//        return repository.findByUserEmail(email)
//                .map(profile -> {
//                    // logic to store file and set profile.setImagePath(...)
//                    // e.g. String path = storageService.store(file);
//                    // profile.setImagePath(path);
//                    repository.save(profile);
//                    return ResponseEntity.ok(profile);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//}muimu izo za juu
package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.UserProfile;
import com.zawadig.myafwanii.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/profile")
public class UserProfileController {

    @Autowired
    private UserProfileRepository repository;

    // GET profile by user email
    @GetMapping("/{email}")
    public ResponseEntity<?> getProfile(@PathVariable String email) {
        return repository.findByUserEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT update profile
    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestBody UserProfile incoming) {
        return repository.findByUserEmail(incoming.getUser().getEmail())
                .map(existing -> {
                    existing.setName(incoming.getName());
                    existing.setPhone(incoming.getPhone());
                    existing.setLocation(incoming.getLocation());
                    // imagePath updating not handled here
                    repository.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // POST upload image
    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@RequestParam String email,
                                         @RequestParam("image") MultipartFile file) {
        return repository.findByUserEmail(email)
                .map(profile -> {
                    // TODO: logic to save file and set imagePath
                    // e.g., String path = storageService.store(file);
                    // profile.setImagePath(path);
                    repository.save(profile);
                    return ResponseEntity.ok(profile);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

