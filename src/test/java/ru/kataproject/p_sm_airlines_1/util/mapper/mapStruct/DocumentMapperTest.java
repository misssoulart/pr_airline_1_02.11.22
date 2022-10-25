package ru.kataproject.p_sm_airlines_1.util.mapper.mapStruct;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kataproject.p_sm_airlines_1.entity.Document;
import ru.kataproject.p_sm_airlines_1.entity.DocumentType;
import ru.kataproject.p_sm_airlines_1.entity.Dto.DocumentDto;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class DocumentMapperTest.
 * Tests ru.kataproject.p_sm_airlines_1.util.mapper.mapStruct.DocumentMapper class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 19.10.2022
 */
@DisplayName("Tests DocumentMapper.class")
class DocumentMapperTest {
    private static DocumentDto documentDtoExpected;
    private static Document documentExpected;

    @BeforeAll
    static void setUp() {
        documentDtoExpected = new DocumentDto(
                1L,
                DocumentType.NATIONAL_PASSPORT,
                "A1B2",
                LocalDate.parse("2030-09-09"),
                1L);

        documentExpected = new Document()
                .setId(documentDtoExpected.getId())
                .setType(documentDtoExpected.getType())
                .setNumber(documentDtoExpected.getNumber())
                .setExpiryDate(documentDtoExpected.getExpiryDate())
                .setPassengerId(documentDtoExpected.getPassengerId());
    }

    /**
     * Tests mapToDocument() method.
     */
    @DisplayName("tests mapToDocument() method")
    @Test
    void shouldMapToDocument() {
        // given

        // when
        var documentActual = DocumentMapper.INSTANCE.mapToDocument(documentDtoExpected);

        // then
        assertThat(documentActual)
                .isNotNull()
                .isInstanceOf(Document.class)
                .hasFieldOrPropertyWithValue("type", documentDtoExpected.getType())
                .hasFieldOrPropertyWithValue("number", documentDtoExpected.getNumber())
                .hasFieldOrPropertyWithValue("expiryDate", documentDtoExpected.getExpiryDate())
                .hasFieldOrPropertyWithValue("passengerId", documentDtoExpected.getPassengerId());
        ;
    }

    /**
     * Tests mapToDocumentDto() method.
     */
    @DisplayName("tests mapToDocumentDto() method")
    @Test
    void shouldMapToDocumentDto() {
        // given

        // when
        var documentActual = DocumentMapper.INSTANCE.mapToDocumentDto(documentExpected);

        // then
        assertThat(documentActual)
                .isNotNull()
                .isInstanceOf(DocumentDto.class)
                .hasFieldOrPropertyWithValue("id", documentExpected.getId())
                .hasFieldOrPropertyWithValue("type", documentExpected.getType())
                .hasFieldOrPropertyWithValue("number", documentExpected.getNumber())
                .hasFieldOrPropertyWithValue("expiryDate", documentExpected.getExpiryDate())
                .hasFieldOrPropertyWithValue("passengerId", documentExpected.getPassengerId());
    }

    /**
     * Tests updateDocumentFromDto() method.
     */
    @DisplayName("tests updateDocumentFromDto() method")
    @Test
    void shouldUpdateDocumentFromDto() {
        // given
        var document = new Document()
                .setId(1L)
                .setType(DocumentType.NATIONAL_PASSPORT)
                .setNumber("Old")
                .setExpiryDate(LocalDate.parse("2030-09-09"))
                .setPassengerId(1L);

        var documentDto = new DocumentDto(
                document.getId(),
                DocumentType.INTERNATIONAL_PASSPORT,
                "New",
                LocalDate.parse("2031-09-09"),
                2L);

        // when
        DocumentMapper.INSTANCE.updateDocumentFromDto(documentDto, document);

        // then
        assertThat(document)
                .hasFieldOrPropertyWithValue("id", documentDto.getId())
                .hasFieldOrPropertyWithValue("type", documentDto.getType())
                .hasFieldOrPropertyWithValue("number", documentDto.getNumber())
                .hasFieldOrPropertyWithValue("expiryDate", documentDto.getExpiryDate())
                .hasFieldOrPropertyWithValue("passengerId", documentDto.getPassengerId());
    }
}
