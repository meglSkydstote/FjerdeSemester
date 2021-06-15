Dette projekt indeholder an løsning af opgaven

Assignment:

Implement a class component Name with:
State in the form {firstName:,lastName:}

A function  getName(user) that takes a user(type string) as parameter and returns first and last name in an object {firstName:””,lastName:””}
implement this function with say two users.
This method is supposed to simulate an external call

Implement componentDidMount to call this getName function depending on the prop supplied to the component by the parent
Implement a parent that serves the prop to the child Name component
Implement componentDidUpdate(prevprops,prevState) such that it populates the Name depending on updates in user prop
The parent should serve its state at the prop to its child and the parent should be able to alter state in order to change the childs props. 

