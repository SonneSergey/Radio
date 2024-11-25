package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void testNextStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(8); // Станция 8
        radio.nextStation(); // Следующая станция
        assertEquals(9, radio.getCurrentStation()); // Ожидаем станцию 9

        radio.nextStation(); // Следующая станция (должна вернуться на 0)
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(0); // Станция 0
        radio.prevStation(); // Предыдущая станция (должна вернуться на 9)
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(5); // Станция 5
        radio.prevStation(); // Предыдущая станция
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // Громкость 50
        radio.increaseVolume(); // Увеличиваем громкость
        assertEquals(51, radio.getCurrentVolume());

        radio.setCurrentVolume(100); // Максимальная громкость
        radio.increaseVolume(); // Не увеличится, т.к. уже на максимуме
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // Громкость 50
        radio.decreaseVolume(); // Уменьшаем громкость
        assertEquals(49, radio.getCurrentVolume());

        radio.setCurrentVolume(0); // Минимальная громкость
        radio.decreaseVolume(); // Не уменьшится, т.к. уже на минимуме
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetCurrentStation() {
        Radio radio = new Radio();

        // Проверка, что станция устанавливается в допустимом диапазоне
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());

        // Проверка, что станция не устанавливается ниже минимальной
        radio.setCurrentStation(-1);
        assertNotEquals(-1, radio.getCurrentStation()); // Ожидаем, что значение не изменится

        // Проверка, что станция не устанавливается выше максимальной
        radio.setCurrentStation(10);
        assertNotEquals(10, radio.getCurrentStation()); // Ожидаем, что значение не изменится
    }

    @Test
    public void testSetCurrentVolume() {
        Radio radio = new Radio();

        // Проверка, что громкость устанавливается в допустимом диапазоне
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());

        // Проверка, что громкость не устанавливается ниже 0
        radio.setCurrentVolume(-1);
        assertNotEquals(-1, radio.getCurrentVolume()); // Ожидаем, что значение не изменится

        // Проверка, что громкость не устанавливается выше 100
        radio.setCurrentVolume(101);
        assertNotEquals(101, radio.getCurrentVolume()); // Ожидаем, что значение не изменится
    }
}