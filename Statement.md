# Project Statement: Multi-Tenant Campus Hostel & Mess Allocation System

## 1. Problem Statement
Managing campus accommodations and dining services manually or through legacy systems creates significant administrative friction in higher educational institutions. Common operational challenges include:
* Risk of double-booking hostel rooms due to non-real-time updates.
* Lack of an automated, transparent priority evaluation mechanism incorporating student academic performance (GPA and year of study).
* Financial calculation errors when aggregating semester room rent with dynamic monthly mess subscription plans.
* Inefficient record-keeping without structured, lightweight audit trails.

This application resolves these issues by offering an integrated Java desktop solution that automates room assignments, manages dining plans, and generates instant itemized billing receipts.

---

## 2. Project Scope
The scope of the project encompasses:
* **Student Registration:** Capturing student profiles, academic metrics, and preferences.
* **Priority Evaluation:** Computing internal priority scores to rank room allotment eligibility.
* **Room Allotment Engine:** Dynamically matching student preferences (`Single`, `Double`) against live inventory with fallback logic.
* **Mess & Billing Management:** Calculating combined semester fees based on selected dining plans (`Regular Veg`, `Special Non-Veg`).
* **Data Persistence:** Automatically saving student records to local persistent storage (`students.txt`).

---

## 3. Target Users
* **Hostel Administrators / Wardens:** To manage room availability, execute automated allocations, and track student billing summaries.
* **University Students:** To select room preferences and enroll in designated mess subscription plans.

---

## 4. Key High-Level Features
* **Automated Priority Allocation:** Algorithmic assignment of rooms using student GPA and academic year weightage.
* **Dynamic Invoice Generation:** Real-time billing calculations providing breakdown receipts for tuition/hostel records.
* **Thread-Safe Processing:** Synchronized allocation operations to prevent race conditions and double-booking during concurrent requests.
* **Graphical User Interface:** Form input validation and receipt display built with Java Swing.
* **Local Flat-File Storage:** Audit trail logging to local disk without requiring external database engines.