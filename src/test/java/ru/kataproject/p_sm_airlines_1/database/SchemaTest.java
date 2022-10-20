package ru.kataproject.p_sm_airlines_1.database;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SchemaTest.
 * Tests database schema.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.10.2022
 */
@Slf4j
@DisplayName("Tests Database schema")
@SpringBootTest
class SchemaTest {
    @Autowired
    private DataSource dataSource;

    @DisplayName("tests database has essential tables")
    @Test
    void shouldTestSchema() throws Exception {
        // given
        Set<String> tablesExpected = Set.of(
                "documents"
        );

        // when
        Set<String> tablesActual = new HashSet<>();
        try (ResultSet rs = Objects.requireNonNull(dataSource.getConnection().getMetaData()
                .getTables(null, null, null, new String[]{"TABLE"}))) {
            while (rs.next()) {
                tablesActual.add(rs.getString("TABLE_NAME").toLowerCase());
            }
        }
        log.info("Database has tables: {}", tablesActual.toString());

        // then
        assertThat(tablesActual).containsAll(tablesExpected);
    }
}
