# 💬 JavaFX Multithreaded Chat Application

This is a simple real-time chat application that involves the concepts of  **JavaFX**, **Sockets**, **JDBC**, and **Multithreading** in Java.  
The project demonstrates a basic client-server architecture where multiple users can communicate in real time.


## 🚀 Features

- Real-time messaging between multiple clients
- JavaFX-based graphical user interface
- Multithreaded server handling multiple connections
- User list panel (UI foundation for online users)
- Enter key support for sending messages
- Clean separation between client, server, and UI layers

## 🏗️ Project Structure

````

chatApp/
│
├── client/
│   └── Client.java          # Handles socket connection and messaging
│
├── server/
│   ├── Server.java          # Main server accepting clients
│   └── ClientHandler.java   # Handles each connected client in a thread
│
├── UI/
│   ├── LoginView.java       # Login interface
│   └── ChatView.java        # Chat interface
│
└── Main.java                # Entry point (JavaFX application)
│
└── ServerMain.java           # Entry point of the server
````

## ⚙️ How It Works

### 1. Server
- Starts on a fixed port (e.g., `5000`)
- Waits for client connections
- Creates a new thread (`ClientHandler`) for each client
- Broadcasts messages to all connected clients

### 2. Client
- Connects to the server using sockets
- Sends user messages to the server
- Listens for incoming messages in a background thread

### 3. UI (JavaFX)
- Login screen for username input
- Chat screen for messaging
- Displays messages in real time
- Shows list of users (static for now)



## 🧵 Technologies Used

- Java
- JavaFX (UI)
- Java Sockets (TCP)
- Multithreading (Server concurrency)

## ▶️ How to Run

### 1. Start the Server
Run the server first:

```

Server.java

```

Or create a main launcher:

```

ServerMain.java

```

### 2. Start Clients
Run the JavaFX application:

```

Main.java

```

You can open multiple instances to simulate multiple users.

---

## 💡 Example Flow

```

Alice: Hello
Bob: Hi Alice
Alice: How are you?
Bob: I'm good 👍

```

All messages are broadcast in real-time to every connected client.

---

## ⚠️ Notes

- Server must be started before clients connect
- Each client runs in a separate JVM instance
- UI updates must be handled using `Platform.runLater()`
- This is a learning project (not production-ready)

---

## 🧠 Learning Goals

This project helps you understand:

- Client-server architecture
- Socket programming in Java
- Thread management for concurrent clients
- JavaFX UI integration with backend logic
- Real-time communication systems

---

## 🚀 Future Improvements

- User authentication (login system)
- Private messaging
- Online user tracking (dynamic list)
- Message timestamps
- Persistent chat history
- Better UI with message bubbles

---

## 👨‍💻 Author

Built as a learning project to explore **network programming and GUI development in Java**.
# By @NEGUNEGA

```