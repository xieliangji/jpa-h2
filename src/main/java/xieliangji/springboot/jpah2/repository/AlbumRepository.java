package xieliangji.springboot.jpah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xieliangji.springboot.jpah2.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
