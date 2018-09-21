import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, Node<Employee>> employeeDirectory = new HashMap<String, Node<Employee>>();
        File file = new File("hierarchy.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int textFileSectionCounter = 0;
        while ((st = br.readLine()) != null)
        {
            if (st.equals(""))
            {
                textFileSectionCounter++;
                continue;
            }
            if (textFileSectionCounter == 0) {
                try {
                    String[] split = st.split(" -> ");
                    if (split.length >= 1) {
                        String[] namePosition = split[0].split(", ");
                        String name = namePosition[0];
                        Title position = Title.valueOf(namePosition[1]);
                        Node<Employee> employee = new Node<Employee>(new Employee(position, name));
                        employeeDirectory.put(name, employee);
                        if (split.length == 2) {
                            String superiorName = split[1];
                            if (!employeeDirectory.containsKey(superiorName)) {
                                System.out.println("Error adding subordinate to superior that doesn't exist yet: " + superiorName);
                            } else {
                                Node<Employee> superior = employeeDirectory.get(superiorName);
                                superior.addChild(employee);
                                //employee.addParent(superior);
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error processing line: \"" + st + "\" (Format is \"Full Name, Title -> Superior Name\", Possible Titles: " + Title.allValues() + ")");
                }
            }
            else if (textFileSectionCounter == 1)
            {
                try {
                    String[] split = st.split(", ");
                    if (split.length != 2)
                    {
                        System.out.println("Incorrect input: \"" + st + "\" (Format is \"Full Name, Levels\")");
                        return;
                    }
                    String name = split[0];
                    int levelsDeep = Integer.parseInt(split[1]);
                    if (!employeeDirectory.containsKey(name))
                    {
                        System.out.println("Employee not found in input: \"" + st + "\")");
                        return;
                    }
                    Node<Employee> employee = employeeDirectory.get(name);
                    List<Node<Employee>> children = employee.getChildren(levelsDeep);

                    System.out.println("\nThere are "+children.size()+" employees "+levelsDeep+" levels below "+employee.getNode().getFullName()+":");
                    for(Node<Employee> child : children)
                    {
                        Employee node = child.getNode();
                        System.out.println("\t"+node.getFullName()+", "+node.getTitle());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
