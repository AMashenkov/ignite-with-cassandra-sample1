package com.gm.test_cassandra.model;

public class Test1Key {
    //Partition Key
// @QuerySqlField(name = "my_id", index = true)
    private String id;

    public Test1Key() {
    }

    public Test1Key(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Test1Key)) {
            return false;
        }

        final Test1Key other = (Test1Key)o;

        if (this.id != null ? !this.id.equals(other.id) : other.id != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(Test1Key.class.getSimpleName() + ": {");
        sb.append("id: ");
        sb.append(this.id);
        sb.append("}}");
        return sb.toString();
    }
}
