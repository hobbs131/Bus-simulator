# Bus-simulator

  Minneapolis Metro bus simulator -- finds optimal number of express and normal buses to be deployed around the clock.

# Instructions
  - run Main.java, # of buses/starting positions/ of buses can be varied in Main. Run-time of simulation is 
    also varied in Main. Inter-arrival rate can be varied in RiderEvent.java

# Overview:
  - Using data involving the frequency of passengers boarding/deboarding Minneapolis metro bus stops at
    certain times, finds an efficient combination of express (buses that only go to high density stops) and regular buses (buses that do full rounds)
    to be deployed in times of low demand and high demand (e.g. at night and during rush hour).
  - Events simulated bus/rider actions, and were rescheduled and ran through the agenda until the simulated time was up.

# Data structures:
  - queue and stack // complicated algorithms are explained through comments in each class.
  - queue: A queue was a good idea to use because it simulates any kind of line. (FIFO)
  - Stack: I used a stack in RiderEvent because it is automatically resized with convenient push/pop methods.
           It's also easy to add to and remove from therefore it was a good idea to use this for temporary storage.

# Bugs/known issues: 
  - None known

# Other:
  - Bus simulator.pdf details the findings of this project
