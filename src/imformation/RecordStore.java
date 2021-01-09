package imformation;

import lombok.*;

/**
 * 存款记录
 */
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class RecordStore {
    private String account;//账号
    private double money;//金额
    private String time;//密码
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
