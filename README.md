# Bus-simulator

  Minneapolis Metro bus simulator -- finds optimal number of express and normal buses to be deployed around the clock.

# Instructions
  - run Main.java
  - Number of buses/starting positions of buses and run-time of simulation can be varied in Main.
  - Inter-arrival rate can be varied in RiderEvent.java

# Overview
  - Using data involving the frequency of passengers boarding/deboarding Minneapolis metro bus stops at
    certain times, finds an efficient combination of express (buses that only go to high density stops) and regular buses (buses that do full rounds)
    to be deployed in times of low demand and high demand (e.g. at night and during rush hour).
  - Events simulated bus/rider actions, and were rescheduled and ran through the agenda until the simulated time was up.
           
# Other
  - Bus simulator.pdf details the findings of this project
