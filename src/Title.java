import java.util.ArrayList;

public enum Title {
    CEO,
    SVP,
    VP,
    Director,
    Manager,
    IndividualContributor;

    public static String allValues() {
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        for(Title title : Title.values())
        {
            if (index > 0)
            {
                buffer.append(", ");
            }
            buffer.append(title.toString());
            index++;
        }
        return buffer.toString();
    }
}
