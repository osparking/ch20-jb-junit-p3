package space.bum.junit.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import space.bum.junit.tdd.model.Flight;
import space.bum.junit.tdd.model.Passenger;

class AirportTest {

  @DisplayName("일반 항공편 1 대가 있다")
  @Nested
  class EconomyFlightTest {
    private Flight economyFlight;
    private Passenger min;
    private Passenger jung;

    @BeforeEach
    void setUp() {
      economyFlight = new EconomyFlight("1");
      min = new Passenger("민영철", false);
      jung = new Passenger("정성국", true);
    }
  }

}
