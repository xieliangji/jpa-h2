package xieliangji.springboot.jpah2.service;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xieliangji.springboot.jpah2.dto.AlbumRequest;
import xieliangji.springboot.jpah2.dto.AlbumResponse;
import xieliangji.springboot.jpah2.model.Album;
import xieliangji.springboot.jpah2.repository.AlbumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository repository;

    public AlbumServiceImpl(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<AlbumResponse> save(AlbumRequest.AlbumCreate albumCreate) {
        // TODO - validate arguments of request
        Album album = Album.builder().build();
        BeanUtils.copyProperties(albumCreate, album);
        repository.save(album);
        AlbumResponse albumResponse = AlbumResponse.builder().build();
        BeanUtils.copyProperties(album, albumResponse);
        return ResponseEntity.ok(albumResponse);
    }

    @Override
    public ResponseEntity<AlbumResponse> update(AlbumRequest.AlbumUpdate albumUpdate) {
        // TODO - validate arguments of request
        Optional<Album> albumWrapper = repository.findById(albumUpdate.getId());
        if (albumWrapper.isPresent()) {
            Album album = albumWrapper.get();
            BeanUtils.copyProperties(albumUpdate, album);
            repository.save(album);
            AlbumResponse albumResponse = AlbumResponse.builder().build();
            BeanUtils.copyProperties(album, albumResponse);
            return ResponseEntity.ok(albumResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<AlbumResponse>> queryAll() {
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .map(album -> {
                            AlbumResponse albumResponse = AlbumResponse.builder().build();
                            BeanUtils.copyProperties(album, albumResponse);
                            return albumResponse;
                        })
                        .toList());
    }

    @Override
    public ResponseEntity<AlbumResponse> delete(Integer id) {
        Optional<Album> albumWrapper = repository.findById(id);
        if (albumWrapper.isPresent()) {
            repository.delete(albumWrapper.get());
            AlbumResponse albumResponse = AlbumResponse.builder().build();
            BeanUtils.copyProperties(albumWrapper.get(), albumResponse);
            return ResponseEntity.ok(albumResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
