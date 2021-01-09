package Imformation;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RecordDilever {
    private String accountA;
    private String accountB;
    private double money;
    private String time;
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
