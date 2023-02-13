Feature: Weather forecast

  Scenario: Weather forecast for specific city
    Given city ID is: 52347
    When we are requesting weather forecast

    Then coordinates are:
      | latitude   | 39.31 |
      | longitude | -74.5 |

    And timezone infofmation is:
      | timezone | America/New_York |
      | offset   | -18000           |

    And current weather data is:
      | current_time | 1646318698 |
      | sunrise      | 1646306882 |
      | sunset       | 1646347929 |
      | temperature  | 282.21     |

    And alert Nr. 1 reicived:
      | sender      | NWS Philadelphia - Mount Holly (New ...   |
      | event       | Small Craft Advisory                      |
      | start       | 1646344800                                |
      | end         | 1646380800                                |
      | description | SMALL CRAFT ADVISORY REMAINS IN EFFECT... |

    And alert Nr.1 reicived:
      | Sunny  |
      | Clouds |

    And alert Nr. 2 recived:
      | sender      | NWS Philadelphia - Mount Holly (New ...   |
      | event       | Small Craft Advisory                      |
      | start       | 1646344800                                |
      | end         | 1646380800                                |
      | description | SMALL CRAFT ADVISORY REMAINS IN EFFECT... |

#    Then latitude is 39.31
#    And longtitude is -74.5
#    And timezone is "America/New_York"
#    And timezone offset is -18000
#    And current time is 1646318698
#    And current sunrise is at 1646306882
#    And current sunset is at 1646347929
#    And current temperature is 282.21 K
#    ...


