package guru.qa.photocatalog.service;

import guru.qa.photocatalog.data.PhotoRepository;
import guru.qa.photocatalog.domain.Photo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbPhotoService implements PhotoService {

    private final PhotoRepository photoRepository;

    public DbPhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> allPhotos() {
        return photoRepository.findAll().stream()
                .map(fe -> {
                    return new Photo(
                            fe.getDescription(),
                            fe.getLastModifyDate(),
                            fe.getContent() != null ? new String(fe.getContent()) : ""
                    );
                }).toList();
    }

    @Override
    public Photo photoByDescription() {
        return null;
    }
}