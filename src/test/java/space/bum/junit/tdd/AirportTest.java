package space.bum.junit.tdd;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import space.bum.junit.tdd.model.BusinessFlight;
import space.bum.junit.tdd.model.EconomyFlight;
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

    @Nested
    @DisplayName("보통 승객이 한명 있다.")
    class RegularPassenger {
      @Test
      @DisplayName("일반 항공편에 승객을 가감할 수 있다.")
      public void testRegularOnEconomy() {
        assertAll("일반 승객이 보통 항공편 이용에 관한 검증",
            () -> assertEquals("1", economyFlight.getId()),
            () -> assertEquals(true, economyFlight.addPassenger(min)),
            () -> assertEquals(1, economyFlight.getPassengers().size()),
            () -> assertEquals("민영철",
                economyFlight.getPassengers().get(0).getName()),
            () -> assertEquals(true, economyFlight.removePassenger(min)),
            () -> assertEquals(0, economyFlight.getPassengers().size()));
      }
    }

    @Nested
    @DisplayName("VIP 승객이 한명 있다.")
    class VipPassenger {
      @Test
      @DisplayName("일반 항공편에 탑승되나 제거는 불가하다.")
      public void testVipOnEconomy() {
        assertAll("VIP 승객이 보통 항공편 이용에 관한 검증",
            () -> assertEquals("1", economyFlight.getId()),
            () -> assertEquals(true, economyFlight.addPassenger(jung)),
            () -> assertEquals(1, economyFlight.getPassengers().size()),
            () -> assertEquals("정성국",
                economyFlight.getPassengers().get(0).getName()),
            () -> assertEquals(false, economyFlight.removePassenger(jung)),
            () -> assertEquals(1, economyFlight.getPassengers().size()));
      }
    }
  }

  @DisplayName("비즈니스 항공편 1 대가 있다")
  @Nested
  class BusinessFlightTest {
    private Flight businessFlight;
    private Passenger min;
    private Passenger jung;

    @BeforeEach
    void setUp() {
      businessFlight = new BusinessFlight("2");
      min = new Passenger("민영철", false);
      jung = new Passenger("정성국", true);
    }

    @Nested
    @DisplayName("보통 승객이 한명 있다.")
    class RegularPassenger {
      @Test
      @DisplayName("비즈니스 항공편에 승객을 가감할 수 없다.")
      public void testRegularOnBusiness() {
        assertAll("일반 승객은 비즈니 항공편 이용에 관한 검증",
            () -> assertEquals(false, businessFlight.addPassenger(min)),
            () -> assertEquals(0, businessFlight.getPassengers().size()),
            () -> assertEquals(false, businessFlight.removePassenger(min)),
            () -> assertEquals(0, businessFlight.getPassengers().size()));
      }
    }

    @Nested
    @DisplayName("VIP 승객이 한명 있다.")
    class VipPassenger {
      @Test
      @DisplayName("비즈니스 항공편에 탑승되나 제거는 불가하다.")
      public void testVipOnBusiness() {
        assertAll("VIP 승객이 비즈니스 항공편 이용에 관한 검증",
            () -> assertEquals(true, businessFlight.addPassenger(jung)),
            () -> assertEquals(1, businessFlight.getPassengers().size()),
            () -> assertEquals(false, businessFlight.removePassenger(jung)),
            () -> assertEquals(1, businessFlight.getPassengers().size()));
      }
    }
  }

}
