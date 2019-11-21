package receipt;

public class StoreHeader {
    private String street_addr;
    private String zip_code;
    private String state_code;
    private String phone_num;
    private String store_num; // e.g., #1004

    public StoreHeader(String street_addr, String zip_code, String state_code, String phone_num, String store_num) {
        this.street_addr = street_addr;
        this.zip_code = zip_code;
        this.state_code = state_code;
        this.phone_num = phone_num;
        this.store_num = store_num;
    }

    public String getStreetAddr() {
        return street_addr;
    }

    public void setStreetAddr(String street_addr) {
        this.street_addr = street_addr;
    }

    public String getZipCode() {
        return zip_code;
    }

    public void setZipCode(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getStateCode() {
        return state_code;
    }

    public void setStateCode(String state_code) {
        this.state_code = state_code;
    }

    public String getPhoneNum() {
        return phone_num;
    }

    public void setPhoneNum(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getStoreNum() {
        return store_num;
    }

    public void setStoreNum(String store_num) {
        this.store_num = store_num;
    }

    public String toString() {
        return "BEST BUY              Store # " + store_num + "\n" + street_addr + ", " + state_code + " " + zip_code + "          " + phone_num;
    }
}