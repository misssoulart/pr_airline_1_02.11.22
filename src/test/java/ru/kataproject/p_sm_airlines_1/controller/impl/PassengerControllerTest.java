package ru.kataproject.p_sm_airlines_1.controller.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import ru.kataproject.p_sm_airlines_1.BaseIntegrationTest;

@DisplayName("Интеграционные тесты проверки PassengerController")
public class PassengerControllerTest extends BaseIntegrationTest {

    @Value("classpath:/api/passenger/response/get-all-passengers.json")
    private Resource getAllPassengersExpectedResponse;

    @Value("classpath:/api/passenger/response/get-passenger-by-id.json")
    private Resource getByIdPassengerExpectedResponse;

    @Value("classpath:/api/passenger/request/create-passenger.json")
    private Resource createPassengerExpectedRequest;

    @Value("classpath:/api/passenger/response/create-passenger.json")
    private Resource createPassengerExpectedResponse;

    @Value("classpath:/api/passenger/request/update-passenger.json")
    private Resource updatePassengerExpectedRequest;

    @Value("classpath:/api/passenger/response/update-passenger.json")
    private Resource updatePassengerExpectedResponse;

    private final static String BASE_URL = "/v1/passengers";
    private final static int TEST_PASSENGER_ID_1 = 1;
    private final static int TEST_PASSENGER_ID_2 = 2;

    @Test
    @DisplayName("Получение списка пассажиров")
    void getAllTest() {
        getTest(BASE_URL, getAllPassengersExpectedResponse, 200);
    }

    @Test
    @DisplayName("Получение пассажира по идентификатору")
    void getByIdТest() {
        getTest(BASE_URL + "/" + TEST_PASSENGER_ID_1, getByIdPassengerExpectedResponse, 200);
    }

    @Test
    @DisplayName("Создание пассажира")
    void createTest() {
        postTest(BASE_URL, createPassengerExpectedRequest, createPassengerExpectedResponse, 201);
    }

    @Test
    @DisplayName("Редактирование пассажира")
    void updateTest() {
        patchTest(BASE_URL, updatePassengerExpectedRequest, updatePassengerExpectedResponse,200);
    }

    @Test
    @DisplayName("Удаление пассажира")
    void deleteTest() {
        deleteTest(BASE_URL + "/" + TEST_PASSENGER_ID_2, null, 204);
    }
}
