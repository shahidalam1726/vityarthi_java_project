# Multi-Tenant Campus Hostel & Mess Allocation System

An Object-Oriented Java desktop application designed to streamline campus accommodation management, automate room allocation based on student priority metrics, and calculate itemized semester billing for mess subscriptions.

---

## Table of Contents
* [Overview](#overview)
* [Features](#features)
* [Technologies & Requirements](#technologies--requirements)
* [Project Architecture & Directory Structure](#project-architecture--directory-structure)
* [Compilation & Execution](#compilation--execution)
* [Testing & Sample Inputs](#testing--sample-inputs)
* [Conclusion](#conclusion)

---

## Overview
Managing student accommodations manually leads to administrative challenges such as double-booking rooms, opaque priority evaluation, and billing discrepancies when processing dining plan changes. 

This application provides a centralized desktop interface that:
1. Calculates student eligibility using academic performance (GPA and year of study).
2. Dynamically matches student preferences against real-time room availability.
3. Automatically computes combined room rent and monthly mess subscription fees.
4. Saves allocation records to local storage.

---

## Features
* **Student Priority Evaluation:** Captures student details and evaluates priority scores for room allocation.
* **Automated Room Allocation Engine:** Allocates single or double room preferences with fallback handling if primary choices are full.
* **Mess & Billing Tracker:** Supports distinct meal plans (`Regular Veg`, `Special Non-Veg`) and generates itemized billing receipts.
* **Data Persistence:** Uses local file I/O (`students.txt`) to maintain registration history across restarts.
* **Graphical User Interface:** Built with Java Swing for form validation and instant receipt rendering.

---

## Technologies & Requirements
* **Language:** Java (JDK 17 or higher recommended)
* **GUI Toolkit:** Java Swing
* **Tools:** `javac` / `java` CLI or any Java IDE (VS Code, IntelliJ IDEA, Eclipse)

---

## Project Architecture & Directory Structure

The application follows a 3-tier architecture separating Presentation (`ui`), Business Logic (`service` & `model`), and Data Access (`service`).

```text
HostelAllocationSystem/
├── src/
│   └── hostel/
│       ├── model/
│       │   ├── Student.java
│       │   ├── Room.java
│       │   └── MessPlan.java
│       ├── service/
│       │   ├── AllocationEngine.java
│       │   ├── BillingService.java
│       │   └── DatabaseManager.java
│       ├── ui/
│       │   └── MainGUI.java
│       └── Main.java
├── README.md
└── statement.md