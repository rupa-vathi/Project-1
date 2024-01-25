In this exercise, you will be automating the process of testing the Click Counter Application using BDD.

### Prerequisites

- Install IntelliJ IDEA Community IDE  Version 2018.3.6.
- Install OpenJDK 11 and complete the configuration.
- Install a Browser Driver(Chrome Driver).
- Setup a Selenium project with the name `ClickCounterTest`.

You can refer to this [Reading Material](https://learning.ccbp.in/qa-automation-testing/course?c_id=cf952b35-27ab-4b1e-a6de-44227f22806c&s_id=f5c19277-3889-4e63-b631-c06c088d612c&t_id=6a935df7-2c93-477c-b505-3ae0aabcf9a2#31-installing-ide) to complete the above prerequisites.

### Steps to Automate

- Create a driver instance using WebDriver interface.
- Navigate to the url `https://qaclickcounter.ccbp.tech/`
- Find the "Click Me!" button - _use contains() method with text() method_.

    - use the text content as `Click Me!`.
- Find the `<span>` element whose class attribute value contains `counter`- _use contains() method_.
- Repeat the following steps for **100** iterations(_use a for loop_),
    - Click the "Click Me!" button.
    - Get the text from the `<span>` element.
    - verify whether the text matches with the iteration count. 
        - if the text does not match, print "Mismatch in count" and break the loop.
- Print "Click Counter App: Working as expected", if all the 100 iterations are successfully executed.
- Close the browser window.

<br>
<br>

**Note: Set up the project and practice this exercise in your local IDE(IntelliJ).**