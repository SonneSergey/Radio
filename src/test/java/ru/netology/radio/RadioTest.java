package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void shouldSetDefaultStationCount() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetCustomStationCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        assertEquals(19, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapToZeroWhenNextStationOnMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapToMaxWhenPrevStationOnZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotIncreaseVolumeBeyondMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetCurrentStationToValidValue() {
        Radio radio = new Radio(10); // 10 станций
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetCurrentStationToNegativeValue() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation()); // Ожидаем, что станция не изменится
    }

    @Test
    public void shouldNotSetCurrentStationAboveMaxValue() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(10); // Значение вне диапазона
        assertEquals(0, radio.getCurrentStation()); // Ожидаем, что станция не изменится
    }

    @Test
    public void shouldWrapAroundToFirstStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9); // Последняя станция
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // Ожидаем, что станет первой
    }

    @Test
    public void shouldGoToNextStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapAroundToLastStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0); // Первая станция
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation()); // Ожидаем, что станет последней
    }

    @Test
    public void shouldGoToPreviousStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolumeIfNotMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // Установим громкость в середине диапазона
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeBeyondMax2() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100); // Установим громкость на максимум
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume()); // Ожидаем, что громкость останется максимальной
    }

    @Test
    public void shouldDecreaseVolumeIfNotMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // Установим громкость в середине диапазона
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowMin2() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0); // Установим громкость на минимум
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume()); // Ожидаем, что громкость останется минимальной
    }

    @Test
    public void shouldSetVolumeWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50); // значение внутри диапазона
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1); // значение ниже минимального
        assertEquals(0, radio.getCurrentVolume()); // громкость не изменится
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101); // значение выше максимального
        assertEquals(0, radio.getCurrentVolume()); // громкость не изменится
    }
}