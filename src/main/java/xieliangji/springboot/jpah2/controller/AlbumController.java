package xieliangji.springboot.jpah2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xieliangji.springboot.jpah2.dto.AlbumRequest;
import xieliangji.springboot.jpah2.dto.AlbumResponse;
import xieliangji.springboot.jpah2.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> fetchAll() {
        return albumService.queryAll();
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> createAlbum(@RequestBody AlbumRequest.AlbumCreate albumCreate) {
        return albumService.save(albumCreate);
    }

    @PutMapping
    public ResponseEntity<AlbumResponse> updateAlbum(@RequestBody AlbumRequest.AlbumUpdate albumUpdate) {
        return albumService.update(albumUpdate);
    }

    @DeleteMapping
    public ResponseEntity<AlbumResponse> deleteAlbumById(@RequestParam("id") Integer id) {
        return albumService.delete(id);
    }
}
