package Imformation;

import lombok.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class RecordStore {
    private String account;
    private double money;
    private String time;
    public RecordStore(String account,double money,String time){
        this.account=account;
        this.money=money;
        this.time=time;
    }

    public double getMoney() {
        return money;
    }

    public String getAccount() {
        return account;
    }

    public String getTime() {
        return time;
    }
}
