package imformation;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * 转账记录
 */
public class RecordDilever {
    private String accountA;//本卡账号
    private String accountB;//转账账号
    private double money;//金额
    private String time;//时间
    /*public RecordDilever(String accountA,String accountB,double money,String time){
        this.accountA=accountA;
        this.accountB=accountB;
        this.money=money;
        this.time=time;
    }*/

    public String getTime() {
        return time;
    }

    public double getMoney() {
        return money;
    }

    public String getAccountA() {
        return accountA;
    }

    public String getAccountB() {
        return accountB;
    }
}
