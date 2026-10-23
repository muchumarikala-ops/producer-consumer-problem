Producer Consumer Problem in Java

Aim

To implement the Producer-Consumer Problem using multithreading in Java.

Description

The Producer-Consumer Problem is a synchronization problem in which the producer generates data and the consumer consumes the data from a shared buffer.

This program uses:

- Threads: Producer and Consumer
- synchronized: To control access to the shared buffer
- wait(): To wait until the buffer becomes available
- notifyAll(): To notify waiting threads

Algorithm

1. Create a shared buffer.
2. Create Producer and Consumer threads.
3. The Producer generates five values.
4. The Consumer consumes the produced values.
5. Use wait() and notifyAll() for synchronization.
6. Display the output.

Language

Java

Output

The program displays the values produced by the Producer and consumed by the Consumer.

Conclusion

The Producer-Consumer Problem was implemented successfully using Java multithreading and synchronization.
