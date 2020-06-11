package ua.patterns.behavior.builder;

public class Account {

    private String name;
    private String surname;
    private String story;
    private String gender;
    private int age;

    public Account(AccountBuilder accountBuilder) {
        this.name    =  accountBuilder.name;
        this.surname =  accountBuilder.sername;
        this.story   =  accountBuilder.someThingAboutHimSelf;
        this.gender  =  accountBuilder.gender;
        this.age     =  accountBuilder.age;
    }

    public static class AccountBuilder {
        private String name;
        private String sername;
        private int age;
        private String gender;
        private String someThingAboutHimSelf;

        public AccountBuilder(String name, String sername, int age) {
            this.name = name;
            this.sername = sername;
            this.age = age;
        }

        public AccountBuilder age(int age) {
            this.age = age;
            return this;
        }

        public AccountBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public AccountBuilder aboutPerson(String story) {
            this.someThingAboutHimSelf = story;
            return this;
        }

        public Account build() {
            Account acc = new Account(this);
            return acc;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", story='" + story + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
