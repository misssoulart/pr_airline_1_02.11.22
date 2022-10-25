package ru.kataproject.p_sm_airlines_1.util.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDto;

/**
 * Class DocumentMapperImpl.
 * Implements DocumentMapper interface.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 12.10.2022
 */
@Component("documentMapperImplBasic")
public class DocumentMapperImpl implements ru.kataproject.p_sm_airlines_1.util.mapper.DocumentMapper {
    /**
     * Method maps DocumentDto to Document.
     *
     * @param documentDto DocumentDto
     * @return Document
     */
    @Override
    public Document mapToDocument(DocumentDto documentDto) {
        return new Document()
                .setType(documentDto.getType())
                .setNumber(documentDto.getNumber())
                .setExpiryDate(documentDto.getExpiryDate())
                .setPassengerId(documentDto.getPassengerId());
    }

    /**
     * Method maps Document to DocumentDto.
     *
     * @param document Document
     * @return DocumentDto
     */
    @Override
    public DocumentDto mapToDocumentDto(Document document) {
        // TODO: 12.10.2022 Добавить Passenger.Id из Passenger
        return new DocumentDto(
                document.getId(),
                document.getType(),
                document.getNumber(),
                document.getExpiryDate(),
                document.getPassengerId()
        );
    }

    /**
     * Method maps DocumentDto to Document.
     *
     * @param source      DocumentDto
     * @param destination Document
     * @return Document
     */
    @Override
    public Document map(DocumentDto source, Document destination) {
        destination
                .setType(source.getType())
                .setNumber(source.getNumber())
                .setExpiryDate(source.getExpiryDate())
                .setPassengerId(source.getPassengerId());
        return destination;
    }
}
