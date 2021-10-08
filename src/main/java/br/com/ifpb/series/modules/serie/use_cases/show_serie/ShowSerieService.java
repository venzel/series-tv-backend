package br.com.ifpb.series.modules.serie.use_cases.show_serie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.serie.dtos.SerieDTO;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.exceptions.SerieNotFoundException;
import br.com.ifpb.series.modules.serie.mappers.SerieMapper;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.serie.utils.SerieMessageUtils;

@Service
public class ShowSerieService {
    
    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SerieMapper serieMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SerieDTO execute(Long id) {
        Optional<Serie> optionalEntity = serieRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new SerieNotFoundException(SerieMessageUtils.SERIE_NOT_FOUND);
        }

        return serieMapper.toDTO(optionalEntity.get());
    }
}