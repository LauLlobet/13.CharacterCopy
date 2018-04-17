package laullobet.org;

public class Copier {
    private ISource source;
    private IDestination destination;

    public Copier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {

        char inputChar;
        while (true) {
            inputChar = source.GetChar();
            if (inputChar != '\n') {
                destination.PutChar(inputChar);
            } else {
                return;
            }
        }
    }
}
