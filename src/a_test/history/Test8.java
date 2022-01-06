package a_test.history;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


public class Test8 {

    private static final Integer TIED_SALE_ACCEPT_STATUS = 12;

    public static void main(String[] args) {
        List<Demo> demoList = new ArrayList<>();
        Demo demo = new Demo();
        demo.setSettleStatus(12);
        demo.setFusion(true);
        demo.setTransSettleNo("1");
        demo.setTransTradeNo("3");
        demoList.add(demo);

        Demo demo2 = new Demo();
        demo2.setSettleStatus(12);
        demo2.setFusion(true);
        demo2.setTransSettleNo("2");
        demo2.setTransTradeNo("3");
        demoList.add(demo2);

        List<Demo> result = demoList.stream().filter(transSettle -> TIED_SALE_ACCEPT_STATUS.equals(transSettle.getSettleStatus()))
                .filter(Demo::getFusion)
                .collect(collectingAndThen(
                        toCollection(() -> new TreeSet<>(Comparator.comparing(Demo::getTransTradeNo))), ArrayList::new));


        System.out.println(result.toString());

    }


    public static class Demo {
        /**
         * 结算流水号
         */
        private String transSettleNo;
        /**
         * 交易流水号
         */
        private String transTradeNo;
        /**
         * 结算单状态
         */
        private Integer settleStatus;

        /**
         * 是否是融合后订单
         */
        private Boolean fusion;

        public String getTransSettleNo() {
            return transSettleNo;
        }

        public void setTransSettleNo(String transSettleNo) {
            this.transSettleNo = transSettleNo;
        }

        public String getTransTradeNo() {
            return transTradeNo;
        }

        public void setTransTradeNo(String transTradeNo) {
            this.transTradeNo = transTradeNo;
        }

        public Integer getSettleStatus() {
            return settleStatus;
        }

        public void setSettleStatus(Integer settleStatus) {
            this.settleStatus = settleStatus;
        }

        public Boolean getFusion() {
            return fusion;
        }

        public void setFusion(Boolean fusion) {
            this.fusion = fusion;
        }
    }
}
