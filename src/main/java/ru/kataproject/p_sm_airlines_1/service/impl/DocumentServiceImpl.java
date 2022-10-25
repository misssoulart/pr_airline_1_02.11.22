package ru.kataproject.p_sm_airlines_1.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDto;
import ru.kataproject.p_sm_airlines_1.repository.DocumentRepository;
import ru.kataproject.p_sm_airlines_1.service.DocumentService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.DocumentNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.mapper.DocumentMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class DocumentServiceImpl.
 * Implements DocumentService interface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.10.2022
 */
@Service
public class DocumentServiceImpl implements DocumentService {
    /**
     * Document Repository.
     */
    private final DocumentRepository documentRepository;

    /**
     * Document Mapper.
     */
    private final DocumentMapper mapper;

    public DocumentServiceImpl(
            DocumentRepository documentRepository,
            @Qualifier("documentMapperImplBasic") DocumentMapper mapper
    ) {
        this.documentRepository = documentRepository;
        this.mapper = mapper;
    }

    /**
     * Method gets all documents.
     *
     * @return All Documents
     */
    @Override
    public List<DocumentDto> getAllDocuments() {
        return documentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream().map(mapper::mapToDocumentDto)
                .collect(Collectors.toList());
    }

    /**
     * Method gets document by id.
     *
     * @param id Id
     * @return DocumentDto
     */
    @Override
    public DocumentDto getDocumentById(Long id) {
        return mapper.mapToDocumentDto(findDocumentById(id));
    }

    /**
     * Method finds document by id.
     *
     * @param id Id
     * @return Document
     */
    private Document findDocumentById(Long id) {
        return documentRepository
                .findById(id)
                .orElseThrow(DocumentNotFoundException::new);
    }

    /**
     * Method creates document.
     *
     * @param documentDto DocumentDto
     */
    @Transactional
    @Override
    public void createDocument(DocumentDto documentDto) {
        documentRepository.saveAndFlush(mapper.mapToDocument(documentDto));
    }

    /**
     * Method updates document.
     */
    @Transactional
    @Override
    public void updateDocument(DocumentDto documentDto) {
        var documentFound = findDocumentById(documentDto.getId());
        var documentToUpdate = mapper.map(documentDto, documentFound);
        documentRepository.saveAndFlush(documentToUpdate);
    }

    /**
     * Method deletes document by id.
     *
     * @param id Id
     */
    @Transactional
    @Override
    public void deleteDocumentById(Long id) {
        if (findDocumentById(id) != null) {
            documentRepository.deleteById(id);
        }
    }
}
