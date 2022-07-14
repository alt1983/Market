public class RussianCitizen implements Client {
    private int passport;
    private String name;
    private String phone;
    private String address;

    public RussianCitizen(int passport, String name, String phone, String address) {
        this.passport = passport;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public int getPassportNumber() {
        return this.passport;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getName() {
        return this.address;
    }

}
