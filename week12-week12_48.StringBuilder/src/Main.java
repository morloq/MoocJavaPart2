public class Main {

    
    
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4};
        
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for(int i = 0; i < t.length; i++)
        {
            if(i % 4 == 0)
            {
                builder.append("\n" + " ");
            }
            builder.append(t[i]);
            
            if(i != t.length-1)
            {
                builder.append(", ");
            }
        }
        return builder.append("\n}").toString();
    }
}