import java.io.IOException;

//supposedly here lambda scoping breaks the intuition that local variables can temporally exist as long
//as the JVM executes the block of code in which they are defined--since the objects to which lambdas are
//assigned with the implementation of the getValue() method actually store the value of the local variable
//after execution exits the scope on which that local variable is defined.

//But really, the lambda just stores the value of the local variable, not the variable itself, so local variable
//scoping is upheld here consistently. The value the lambda stores is just part of its implementation,
//stored in its own local variable. That said, the copying itself requires that during the execution of the block
//in which the lambda itself is defined, the names of the variable used in the lambda and the local variable
//in the enclosing method scope be the same, and that the "source" local variable be (effectively) final.
//field-level variables, both class and instance, can be used without the final modifier.
//when a lambda registers a local variable value in the method it's implementing, that's called VARIABLE
//CAPTURE. such lambdas are called CLOSURES. the variables are said to be CLOSED OVER.
// it is disputed if this is actual variable closure, since what's captured is a value, not the variable itself

interface IntHolder {
    int getValue();
}


public class Weird {

    public static void main(String[] args) throws IOException {
        IntHolder[] holders = new IntHolder[10];
        for (int i = 0; i < holders.length; i++) {
            final int fi = i;

            //using explicit scoping for clarity
            holders[i] = () -> {
                return fi;
            };
        }

        for (IntHolder holder : holders) {
            System.out.println(holder.getValue());
        }
    }

}




