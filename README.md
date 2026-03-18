# 🎬 Video Library System (Java CLI Application)

## 📌 Overview

The **Video Library System** is a command-line Java application developed as part of the *Programming Proficiency* unit. It is designed to efficiently manage a collection of videos by allowing users to add, update, delete, borrow, and search video records.

The system improves organization and tracking of video availability using **Object-Oriented Programming (OOP)** principles and file handling.

---

## 🎯 Objectives

* Build a **menu-driven CLI application**
* Implement core video management features:

  * Add videos
  * Borrow videos
  * Update records
  * Delete videos
  * Search videos
* Store and persist data using external files
* Handle invalid inputs and runtime errors
* Apply OOP concepts effectively

---

## ⚙️ Features

### 📁 Video Management

* Add new videos with unique ID and title
* Update video details (ID & title)
* Delete videos (if not on loan)

### 📦 Borrowing System

* Borrow videos with:

  * Borrower name
  * Borrower number
* Track availability of each video

### 🔍 Search & Navigation

* Search videos by ID
* Navigate through:

  * Next video
  * Previous video

### 📊 Reporting

* View all available videos
* Display total count of available videos

### 💾 Persistence

* Load video data from file (`videolibrary.txt`)
* Save updated data to file (`videoLibraryAdded.txt`)

---

## 🛠️ Technologies Used

* **Java (Core Java, OOP)**
* **Collections Framework (ArrayList)**
* **File Handling (I/O)**
* **Exception Handling**

---

## 🧱 System Architecture

### Classes Overview

#### 📌 `Video`

Represents a video object.

**Key Methods:**

* Constructor (initialize ID & title)
* Getters & Setters
* `isAvailable()` – checks availability
* `toString()` – string representation
* `compareTo()` – sorts videos by ID

---

#### 📌 `VideoLibrary`

Manages all video operations.

**Key Functionalities:**

* Load data from file
* Add / Update / Delete videos
* Borrow video
* Search video
* Display menu & submenu
* Sort video list

---

#### 📌 `Main`

* Entry point of the application
* Handles user interaction
* Controls menu loop

---

## ▶️ How to Run

### Step 1: Open Terminal

### Step 2: Navigate to Project Folder

```bash
cd path/to/VideoLibrary
```

### Step 3: Compile & Run

```bash
chmod +x build.sh
./build.sh
```

---

## 🖥️ User Interface

The system is **menu-driven** and supports:

* Input validation:

  * Invalid options
  * Negative numbers
  * String inputs
* Error handling with user-friendly messages

---

## 🔁 Core Functionalities

### ➕ Add Video

* Requires unique ID and title
* Prevents duplicates and invalid input

### 📥 Borrow Video

* Requires valid video ID
* Captures borrower details
* Prevents borrowing unavailable videos

### ✏️ Update Video

* Modify ID and title
* Handles cases where video is on loan

### ❌ Delete Video

* Only allowed if video is not borrowed

### 🔍 Search Video

* Displays full video details
* Includes navigation submenu

### 📋 View Available Videos

* Lists all available videos
* Shows total count

---

## 🧠 OOP Concepts Applied

* **Encapsulation** – private variables with getters/setters
* **Abstraction** – clean separation of logic
* **Classes & Objects** – Video as core entity
* **Polymorphism** – method overriding (`toString`, `compareTo`)

---

## ⚡ Advanced Java Concepts

* **Collections Framework** (ArrayList)
* **Generics**
* **Exception Handling (try-catch)**
* **File I/O operations**

---

## 📄 Project Report

📎 [Aarya22151169-Chuyun22100464.pdf](https://github.com/user-attachments/files/26076321/Aarya22151169-Chuyun22100464.pdf)


---

## 🚀 Future Improvements

* Add GUI (JavaFX / Swing)
* Database integration (MySQL)
* User authentication system
* Web-based version

---

## 👥 Contributors

* Aarya Rajbhandari
* Chuyun Liang (Cherry)

---

This project is for academic purposes.

---
