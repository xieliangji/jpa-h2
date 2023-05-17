package xieliangji.springboot.jpah2.service;

import org.springframework.http.ResponseEntity;
import xieliangji.springboot.jpah2.dto.AlbumRequest;
import xieliangji.springboot.jpah2.dto.AlbumResponse;

import java.util.List;

public interface AlbumService {

    ResponseEntity<AlbumResponse> save(AlbumRequest.AlbumCreate albumCreate);

    ResponseEntity<AlbumResponse> update(AlbumRequest.AlbumUpdate albumUpdate);

    ResponseEntity<List<AlbumResponse>> queryAll();

    ResponseEntity<AlbumResponse> delete(Integer id);
}
