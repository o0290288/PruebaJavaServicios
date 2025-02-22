package mx.com.ots.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public interface MarvelCharactersService {
    String charter();
    String charterId(Long id);
}
