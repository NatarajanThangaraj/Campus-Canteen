# Bug-Fixing Assignment 2: The MVC Pattern - Campus Canteen

Welcome to your second bug-fixing assignment! This time the program is built
with the **Model-View-Controller (MVC)** pattern. It has **6 intentional
bugs**. Your job: find them, fix them, and submit a pull request.

---

## 1. What is MVC?

MVC splits a program into three parts, each with ONE job:

* **Model** - holds the data and the business logic (the maths). It knows
  nothing about how the data is displayed or who changes it.
* **View** - everything the user sees. It only *displays* data. It must
  never change the Model.
* **Controller** - the middleman. It reads the user's input, updates the
  Model, and asks the View to display the result.

Why bother? Because mixing these jobs into one big class makes programs hard
to fix and impossible to grow. With MVC you can change the menu maths without
touching the printing code, or change the display without touching the data.

### Class diagram

```
                 user types a choice
                        |
                        v
        +-------------------------------+
        |           CONTROLLER          |
        |        OrderController        |
        |  reads input, updates Model,  |
        |  tells the View what to show  |
        +-------------------------------+
           |                        ^
   updates |                        | asks for data
            v                        |
        +-------------------------------+
        |             MODEL             |
        |       MenuItem,  Order        |
        |  holds menu items, orders,    |
        |  and all the calculations     |
        +-------------------------------+
                        ^
                        | reads data to display
                        |
        +-------------------------------+
        |              VIEW             |
        |           OrderView           |
        |  prints the menu and receipt. |
        |  NEVER changes the Model.     |
        +-------------------------------+
```

**The golden rules:**
1. The Model never talks to the View or reads input.
2. The View never changes the Model.
3. The Controller is the only one who talks to both.

---

## 2. The app

`CanteenApp` is a console billing app for a campus canteen. It shows a menu
(Masala Dosa Rs.40, Idli Rs.20, Filter Coffee Rs.15), lets the user add items
with quantities, and prints a receipt with a grand total when the user picks
option 4.

### Files

| File | Role |
| --- | --- |
| `MenuItem.java` | Model - one menu item (name, price) |
| `Order.java` | Model - one ordered line (item + quantity) |
| `OrderView.java` | View - prints the menu and the receipt |
| `OrderController.java` | Controller - input, updates, wiring |
| `CanteenApp.java` | Main - builds the parts and runs the loop |

### How to run

```
javac *.java
java CanteenApp
```

---

## 3. The bugs

There are **6 bugs**. One stops the program from compiling; the other five
make it behave wrongly. Every bug has a `HINT (Bug N)` comment near it -
but the hint only points at the area, the fix is yours to work out.

| # | Type | Symptom |
| --- | --- | --- |
| 1 | Compile error | `javac` fails in `CanteenApp.java` when the Controller is created. |
| 2 | Logic | The receipt is always empty - orders keep disappearing. |
| 3 | Logic | The receipt total for 2 Dosas shows Rs.40 instead of Rs.80. |
| 4 | Logic | The receipt prints the items, but the Grand Total is always Rs.0. |
| 5 | Logic | Ordering item 1 adds the wrong item, and one menu choice crashes the app. |
| 6 | Logic | The app quits after the first item instead of running until option 4. |

Tip: some bugs hide others. Fix them in order (1, then 2, ...) and re-run the
app after each fix.

---

## 4. Expected correct output

After all 6 fixes, a session looks like this:

```
Welcome to Campus Canteen!
----- CAMPUS CANTEEN MENU -----
1. Masala Dosa - Rs.40
2. Idli - Rs.20
3. Filter Coffee - Rs.15
4. Finish and print receipt
Enter your choice: 1
Enter quantity: 2
Added: Masala Dosa x 2
----- CAMPUS CANTEEN MENU -----
1. Masala Dosa - Rs.40
2. Idli - Rs.20
3. Filter Coffee - Rs.15
4. Finish and print receipt
Enter your choice: 3
Enter quantity: 1
Added: Filter Coffee x 1
----- CAMPUS CANTEEN MENU -----
1. Masala Dosa - Rs.40
2. Idli - Rs.20
3. Filter Coffee - Rs.15
4. Finish and print receipt
Enter your choice: 4
----- RECEIPT -----
Masala Dosa x 2 = Rs.80
Filter Coffee x 1 = Rs.15
Grand Total: Rs.95
Thank you! Visit again.
```

---

## 5. How to submit (fork, fix, pull request)

1. **Fork** this repository on GitHub (top-right "Fork" button), or `git clone`
   it if your teacher asks you to work directly.
2. Create a branch: `git checkout -b fix-mvc-bugs`
3. Fix the 6 bugs. Fix them one at a time and re-run `javac *.java &&
   java CanteenApp` after each fix.
4. Commit your work: `git add . && git commit -m "Fix all 6 MVC bugs"`
5. Push: `git push origin fix-mvc-bugs`
6. Open a **Pull Request** on GitHub.

### Rules

* **One PR per student.**
* Your PR description must **list all 6 fixes** - one line each: what was
  wrong and how you fixed it.
* Do not rewrite the app. The structure (Model / View / Controller classes)
  must stay. Only fix what is broken.
* Bonus question (answer in your PR): Bug 4 breaks one of the golden rules
  of MVC. Which rule, and why does it matter?

Good luck, and happy debugging!
