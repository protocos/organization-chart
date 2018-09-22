# OrganizationChart

This project is a proof of concept for organizing a company hierarchy using the concept of a Node and parent/child relationships. You can create Nodes, add children to them, or add a parent, and then for any arbitrary node, you can use node.getChildren(N) to find all nodes N levels below the given node. So for instance, if you wanted to find everyone 3 levels below a CEO, as long as you set up you hierarchy correctly, you should be able to count them.

# How does it work?

It uses recursion and a simple Depth First Search algorithm, keeping track of ancestors in the hierarchy, and counts every node at the specified level.

# How to set up the project:

1. Make sure you have Java v1.7+ installed on your machine
1. Clone the project
1. Pick your favorite Java IDE and import the project (I used IntelliJ Idea Community Edition)
1. Make sure JUnit 4+ is in the classpath for the project, otherwise NodeTest will not build
1. Run the unit tests in NodeTest and make sure they all pass
1. Open the hierarchy.txt and set up your company hierarchy as you see fit
    - The first line should be the root node in the format of (Full Name, Position), where Position can be one of the following: CEO, SVP, VP, Director, Manager, IndividualContributor
    - The subsequent lines should be the same thing as the first except with an arrow (i.e. " -> ") designating a superior in the hierarchy (The other person has to already exist in the hierarchy first)
    - Finally, once you are done creating your hierarchy, add a new line between the hierarchy and the last line of the file which should be in the format of (Full Name, LevelsDeep)
1. Now once you run Main.java's main method, it should parse the hierarchy.txt file and print the names of everyone N levels down from the name of the person you specified

# Clarifications:

Q: Does this code support multiple parents for a single child?
> A: Yes, you can add multiple parents to a child and it

Q: Does this code account for cycles?
> A: Yes, if you make a hierarchy like: Julie -> Mark -> Ashlee -> Julie, then it will be able to detect that it's already visited Julie and thus it won't count Julie at 3 levels below Julie

Q: Does this code account for if you add the same child twice?
> A: Yes, by nature of using a HashSet, where you can't add the same object twice without a hash collision, you cannot add the same child or the same parent twice

Q: Is there any logic to verify that a CEO cannot report to an IndividualContributor?
> A: No, but feel free to clone the project and challenge yourself to that logic!
