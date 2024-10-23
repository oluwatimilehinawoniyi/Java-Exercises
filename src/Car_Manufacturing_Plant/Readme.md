# 🚗 Car Plant System - Multi-threaded Java Application

This project simulates a `multi-threaded` car production plant where
cars are manufactured, parked, and retrieved in a concurrent system.
The system demonstrates the use of `threads`, `synchronization`, and
`inter-thread communication` using Java's multithreading features.

## 🌟 Features

- **Manufacturer System**: A car is produced by a
  thread and passed to a storage (an array `Queue`). Multiple
  threads for such functionality can be created which will then
  concurrently manufacture cars.

- **Parking System**: After a car is produced, it's parked by a
  dedicated thread responsible for handling parking logic.

- **Retrieval System**: A retriever thread retrieves cars once
  they are parked. This frees the Parking Lot, which is also a
  `Queue`. Also, multiple threads can be configured to retrieve/free
  cars from the parking lot.
- **Thread Communication**: The project uses Java's `wait()`,
  `notify()`,
  and `synchronized blocks` to manage `inter-thread communication` and
  coordination.
- **Real-world Simulation**: Models a real-life car production
  pipeline where different actors (manufacturers, parkers, retrievers)
  operate
  independently but need to coordinate.

## 📖 Project Structure

- **Manufacturer.java**: Responsible for producing cars. Each
  manufacturer runs in its own thread.
- **Parker.java**: Waits for a car to be produced, takes it, and
  parks it in the system.
- **Retriever.java**: Waits for a car to be parked, retrieves it, and
  simulates the car being delivered.

## 💻 Technologies Used

- **Java**: Core language used for building the system.
- **Multithreading**: Key concept used to handle the concurrent
  production, parking, and retrieval of cars.
- **Object-Oriented Programming (OOP)**: Used to design different
  actors (Manufacturer, Parker, Retriever) in the system.
- **Thread Synchronization**: Managed using Java's `synchronized`
  keyword, `wait()`, and `notify()` methods.

## 🚀 How to Run

- Clone the repository:

```shell
git clone https://github.com/oluwatimilehinawoniyi/Java-Practice.git
```

- Navigate to the project directory:

```shell
cd Java-Practice/src/Car_Manufacturing_Plant
```

- Compile the Java files:

```shell
javac *.java
```

- Run the main class:

```shell
java CarPlantDemo
```

## 🛠️ Future Improvements

-[ ] Use 2D Array as parking lot.
- [ ] Change `Queue` storages to better data structures.
- [ ] An Algorithm that stores freed spaces by the `Retrieval 
System` and provide them as options to the `Parking System` for
  quicker parking.
-[ ] Add a graphical user interface (GUI) to visually represent the
 car manufacturing and parking system.
-[ ] Implement a logging system to keep track of events in a more
 detailed manner.
-[ ] Add more manufacturers, parkers, and retrievers to simulate a
 larger-scale system.

## 📬 Contact

Feel free to reach out to me at awoniyitimi@gmail.com or connect with
me on [LinkedIn](https://www.linkedin.com/in/oluwatimilehin-awoniyi/)
for any questions or collaboration opportunities.

