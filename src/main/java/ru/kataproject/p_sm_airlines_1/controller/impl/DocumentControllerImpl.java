package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.DocumentController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDto;
import ru.kataproject.p_sm_airlines_1.service.DocumentService;

import java.util.List;

/**
 * Сlass DocumentControllerImpl.
 * Implements DocumentController interface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.10.2022
 */
@RestController
@RequiredArgsConstructor
public class DocumentControllerImpl implements DocumentController {
    /**
     * Document Service.
     */
    private final DocumentService documentService;

    /**
     * Method gets all documents.
     *
     * @return All Documents
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentDto> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    /**
     * Method gets document by id.
     *
     * @param id Id
     * @return DocumentDto
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    public DocumentDto getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    /**
     * Method creates document.
     *
     * @param documentDto DocumentDto
     */
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(DocumentDto documentDto) {
        documentService.createDocument(documentDto);
    }

    /**
     * Method updates document.
     *
     * @param documentDto DocumentDto
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    public void updateDocument(DocumentDto documentDto) {
        documentService.updateDocument(documentDto);
    }

    /**
     * Method deletes document by id.
     *
     * @param id Id
     */
    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocumentById(Long id) {
        documentService.deleteDocumentById(id);
    }
}
