package unit02.Election;
import java.util.Arrays;

public class Election{
    private String name;
    private position position;
    private Politicalparty[] party;

    public Election(String name, position position, Politicalparty[] party){
        this.name = name;
        this.position = position;
        this.party = party;
    }
    public void print(){
        System.out.println(name + "-" + position);
    }
    public Politicalparty[] getparty(){
        return party;
    }
    @Override
    public String toString(){
        return name + Arrays.toString(party) + position;
    }
    public String getname(){
        return name;
    }
    public position getposition(){
        return position;
    }
    @Override
    public boolean equals(Object o) {
    if (o instanceof Election) {
        Election candidate = (Election)o;
        return (name == candidate.name && position == candidate.position);
    }   
    else{
        return false;
    }
}
}
