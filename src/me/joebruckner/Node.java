package me.joebruckner;

public class Node {
    int id;
    Object val;

    public Node(int id, Object val) {
        this.id = id;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && id == ((Node) obj).getId();
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
