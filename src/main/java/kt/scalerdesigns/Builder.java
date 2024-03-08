package kt.scalerdesigns;

public class Builder {
    public static void main(String[] args) {
        Student student = Student.getBuilder().setName("la")
                .setAge("45")
                .build();
    }
}

class Student {
    private String name;
    private String age;
    private Student(Builder builder) {
        name = builder.name;
        age = builder.age;
    }

    static Builder getBuilder() {
        return new Builder();
    }
    static class Builder {
        private Builder() {}
        private String name;
        private String age;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setAge(String age) {
            this.age = age;
            return this;
        }

        Student build() {
            return new Student(this);
        }
    }
}
