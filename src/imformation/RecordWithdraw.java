package imformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 取款记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordWithdraw {
    private String account;//账号
    private double money;//金额
    private String time;//时间
    /*public RecordWithdraw(String account,double money,String time){
        this.account=account;
        this.money=money;
        this.time=time;
    }*/
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
