package codegenerator;

/**
 * Created by mohammad hosein on 6/28/2015.
 */
public class Address {
    public int num;
    public TypeAddress type;
    public VarType varType;
    private AddressMode addressMode;

    public Address(int num, VarType varType, TypeAddress Type) {
        this.num = num;
        this.type = Type;
        assignAddressMode(num);
        this.varType = varType;
    }


    public Address(int num, VarType varType) {
        this.num = num;
        this.type = TypeAddress.Direct;
        assignAddressMode(num);
        this.varType = varType;
    }
    public String toString(){
        return addressMode.toString();
    }
    
    private void assignAddressMode(int num) {
        switch (type){
            case Direct:
                this.addressMode = new Direct(num);
            case Indirect:
                this.addressMode = new InDirect(num);
            case Imidiate:
                this.addressMode = new Imidiate(num);
            default:
                this.addressMode = new Normal(num);
        }
    }

}

abstract class AddressMode{
    public int num;
    public AddressMode(int num){
        this.num = num;
    }

    public abstract String toString();
}

class Direct extends AddressMode{

    public Direct(int num) {
        super(num);
    }

    @Override
    public String toString() {
        return num+"";
    }
}

class InDirect extends AddressMode{

    public InDirect(int num) {
        super(num);
    }

    @Override
    public String toString() {
        return "@"+num;
    }
}

class Imidiate extends AddressMode{

    public Imidiate(int num) {
        super(num);
    }

    @Override
    public String toString() {
        return "#"+num;
    }
}

class Normal extends AddressMode{

    public Normal(int num) {
        super(num);
    }

    @Override
    public String toString() {
        return num+"";
    }
}