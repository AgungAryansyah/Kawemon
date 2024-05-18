package pokemon1;

abstract class Element {
    public final String name;

    public Element(String name) {
        this.name = name;
    }

    public int cekEfektifitasSerangan(Element elementMusuh) {
        return 0;
    }
}

class ElementEs extends Element{
    public ElementEs() {
        super("Es");
    }

    @Override
    public int cekEfektifitasSerangan(Element elementMusuh){
        if (elementMusuh.name.equals("Angin")){
            return 1;
        } else if (elementMusuh.name.equals("Api")){
            return -1;
        } else {
            return 0;
        }
    }
}

class ElementAngin extends Element{
    public ElementAngin() {
        super("Angin");
    }

    @Override
    public int cekEfektifitasSerangan(Element elementMusuh){
        if (elementMusuh.name.equals("Tanah")){
            return 1;
        } else if (elementMusuh.name.equals("Angin")){
            return -1;
        } else {
            return 0;
        }
    }
}

class ElementTanah extends Element{
    public ElementTanah() {
        super("Tanah");
    }

    @Override
    public int cekEfektifitasSerangan(Element elementMusuh){
        if (elementMusuh.name.equals("Air")){
            return 1;
        } else if (elementMusuh.name.equals("Angin")){
            return -1;
        } else {
            return 0;
        }
    }
}

class ElementAir extends Element{
    public ElementAir() {
        super("Air");
    }

    @Override
    public int cekEfektifitasSerangan(Element elementMusuh){
        if (elementMusuh.name.equals("Api")){
            return 1;
        } else if (elementMusuh.name.equals("Tanah")){
            return -1;
        } else {
            return 0;
        }
    }
}

class ElementApi extends Element{
    public ElementApi() {
        super("Api");
    }

    @Override
    public int cekEfektifitasSerangan(Element elementMusuh){
        if (elementMusuh.name.equals("Es")){
            return 1;
        } else if (elementMusuh.name.equals("Air")){
            return -1;
        } else {
            return 0;
        }
    }
}

