# Get Passengers


## **App Description**
***Get Passengers*** is a simple application designed to collect and display information for the passengers of a given flight.

***Get Passengers***  has two main screens that work together to collect and display passenger information. When you open the app, you'll see the first screen, ***MainActivity***, with a button that says *"GET PASSENGER LIST"*. When you click this button, it takes you to the second screen, ***GetPassengers***, where you can enter details like the first name, last name, and phone number of each passenger.

On the ***GetPassengers*** screen, you can add as many passengers as you need. After you fill in the information and click the *"ADD PASSENGER"* button, their details will appear underneath the *Accumulating Passenger List*. When you're done adding passengers, you can press the *"RETURN LIST"* button. This will send all the passenger information back to the first screen, ***MainActivity***, where you can see the full list of passengers you entered.

## **Challenges and Solutions**
**Challenge**: I ran into some difficulties opening the second activity screen after pressing the *"GET PASSENGER LIST"* button.

**Solution**: The errors came from the following: **private lateinit var backButton: EditText** and the lack of **finish()** after **setResult**. I corrected the errors by changing **private lateinit var backButton: EditText** to **private lateinit var backButton: Button** and calling **finish()** to close the activity after **setResult**.

## **Key Learnings**
Throughout this project, I picked up a lot about Kotlin and working with XML layouts. I really enjoyed using IDs in the layouts because it made coding feel a lot more organized and easier to follow. The concept of passing data between activities using Intents was new and pretty interesting for me. It also gave me a better sense of how activities work together and how to handle data flow in an app.

## **Future Improvements**
**Edit Button** - When entering information for multiple passengers, mistakes are bound to happen. Adding an **Edit Button** to correct the mistakes will help enhance the user's experience.

**Delete Button** - When managing a list of passengers, there may be a need to remove incorrect or unnecessary entries. Adding a **Delete Button** next to each passenger's details will allow users to easily remove any unwanted entries, making the list easier to manage.

**Sort Function** - As the passenger list grows, it can become harder to find specific entries. Adding a **Sort Function** will allow users to organize the list by name or phone number, making it easier to navigate and find the information they need quickly.

**Search Function** - When dealing with a long list of passengers, finding a specific entry can be time-consuming. Adding a **Search Function** would enable users to quickly locate a passenger by their first name, last name, or phone number, improving the overall efficiency of the app.
